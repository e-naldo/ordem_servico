package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.dto.EquipamentoDto;
import dev.app.ordemservico.dto.EquipamentoInsertDto;
import dev.app.ordemservico.mapper.EquipamentoMapper;
import dev.app.ordemservico.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private EquipamentoMapper equipamentoMapper;

    @GetMapping
    public ResponseEntity<List<EquipamentoDto>> findAll(){
        List<Equipamento> listaEquipamentos = equipamentoService.findAll();
        equipamentoMapper.toListDto(listaEquipamentos);

        return ResponseEntity.ok(equipamentoMapper.toListDto(listaEquipamentos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDto> findById(@PathVariable Integer id) {
        Equipamento equipamento = equipamentoService.findById(id);
        if(equipamento == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamentoMapper.toDto(equipamento));
    }

    //api/v1/equipamentos/?numeroSerie=1020071217630
    @GetMapping("/")
    public ResponseEntity<EquipamentoDto> findByNumeroSerie(@RequestParam String numeroSerie){
        Equipamento equipamento = equipamentoService.findByNumeroSerie(numeroSerie);
        if(equipamento == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamentoMapper.toDto(equipamento));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<EquipamentoDto>> findByFilter(@RequestBody EquipamentoConsultaDto consultaDto){
        List<Equipamento> equipamentos = equipamentoService.findByFilter(consultaDto);

        return ResponseEntity.ok(equipamentoMapper.toListDto(equipamentos));
    }

    @PostMapping
    public ResponseEntity<EquipamentoDto> insert(@Valid @RequestBody EquipamentoInsertDto equipamentoInsertDto){
        Equipamento equipamento = equipamentoMapper.toEntity(equipamentoInsertDto);

        return ResponseEntity.ok(equipamentoMapper.toDto(equipamentoService.insert(equipamento)));
    }
}
