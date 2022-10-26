package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.dto.EquipamentoDto;
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
    public ResponseEntity<EquipamentoDto> create(@Valid @RequestBody EquipamentoInsertDto dto,
                                                 UriComponentsBuilder uriComponentsBuilder){

        Equipamento equipamento = equipamentoService.save(equipamentoMapper.toEntity(dto));
        EquipamentoDto equipamentoDto = equipamentoMapper.toDto(equipamento);

        URI uri = uriComponentsBuilder.path("/api/v1/equipamentos/{id}").buildAndExpand(equipamentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(equipamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDto> update(@Valid @RequestBody EquipamentoUpdateDto dto,
                                                 @PathVariable Integer id){
        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Equipamento equipamentoEncontrado = equipamentoService.findById(id);
        Equipamento equipamento = equipamentoMapper.toUpdateEntity(equipamentoEncontrado, dto);

        return ResponseEntity.ok(equipamentoMapper.toDto(equipamentoService.save(equipamento)));
    }
    @GetMapping
    public ResponseEntity<List<EquipamentoDto>> findAll(){
        List<Equipamento> listaEquipamentos = equipamentoService.findAll();

        return ResponseEntity.ok(equipamentoMapper.toListDto(listaEquipamentos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(equipamentoMapper.toDto(equipamentoService.findById(id)));
    }

    //api/v1/equipamentos/?numeroSerie=1020071217630
    @GetMapping("/")
    public ResponseEntity<EquipamentoDto> findByNumeroSerie(@RequestParam String numeroSerie){
        return ResponseEntity.ok(equipamentoMapper.toDto(equipamentoService.findByNumeroSerie(numeroSerie)));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<EquipamentoDto>> findByFilter(@RequestBody EquipamentoConsultaDto dto){
        List<Equipamento> equipamentos = equipamentoService.findByFilter(dto);

        return ResponseEntity.ok(equipamentoMapper.toListDto(equipamentos));
    }
}
