package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.dto.EquipamentoDetailDto;
import dev.app.ordemservico.dto.EquipamentoInsertDto;
import dev.app.ordemservico.dto.EquipamentoUpdateDto;
import dev.app.ordemservico.mapper.EquipamentoMapper;
import dev.app.ordemservico.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private EquipamentoMapper equipamentoMapper;


    @PostMapping
    public ResponseEntity<EquipamentoDetailDto> create(@Valid @RequestBody EquipamentoInsertDto dto,
                                                       UriComponentsBuilder uriComponentsBuilder){

        Equipamento equipamento = equipamentoService.save(equipamentoMapper.toEntity(dto));
        EquipamentoDetailDto equipamentoDto = equipamentoMapper.toDetailDto(equipamento);

        URI uri = uriComponentsBuilder.path("/api/v1/equipamentos/{id}").buildAndExpand(equipamentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(equipamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDetailDto> update(@Valid @RequestBody EquipamentoUpdateDto dto,
                                                       @PathVariable Integer id){
        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Equipamento equipamentoEncontrado = equipamentoService.findById(id);
        Equipamento equipamento = equipamentoMapper.toUpdateEntity(equipamentoEncontrado, dto);

        return ResponseEntity.ok(equipamentoMapper.toDetailDto(equipamentoService.save(equipamento)));
    }
    @GetMapping
    public ResponseEntity<List<EquipamentoDetailDto>> findAll(){
        List<Equipamento> listaEquipamentos = equipamentoService.findAll();

        return ResponseEntity.ok(equipamentoMapper.toListDetailDto(listaEquipamentos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDetailDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(equipamentoMapper.toDetailDto(equipamentoService.findById(id)));
    }

    //api/v1/equipamentos/?numeroSerie=1020071217630
    @GetMapping("/")
    public ResponseEntity<EquipamentoDetailDto> findByNumeroSerie(@RequestParam String numeroSerie){
        return ResponseEntity.ok(equipamentoMapper.toDetailDto(equipamentoService.findByNumeroSerie(numeroSerie)));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<EquipamentoDetailDto>> findByFilter(@RequestBody EquipamentoConsultaDto dto){
        List<Equipamento> equipamentos = equipamentoService.findByFilter(dto);

        return ResponseEntity.ok(equipamentoMapper.toListDetailDto(equipamentos));
    }
}
