package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.ModeloEquipamento;
import dev.app.ordemservico.dto.ModeloEquipamentoDto;
import dev.app.ordemservico.dto.ModeloEquipamentoInsertDto;
import dev.app.ordemservico.mapper.ModeloEquipamentoMapper;
import dev.app.ordemservico.service.ModeloEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/modeloEquipamentos")
public class ModeloEquipamentoController {

    @Autowired
    private ModeloEquipamentoService service;

    @Autowired
    private ModeloEquipamentoMapper mapper;


    @PostMapping
    public ResponseEntity<ModeloEquipamentoDto> create(@Valid @RequestBody ModeloEquipamentoInsertDto dto,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        ModeloEquipamento modeloEquipamento = service.save(mapper.toEntity(dto));
        ModeloEquipamentoDto modeloEquipamentoDto = mapper.toDto(modeloEquipamento);

        URI uri = uriComponentsBuilder.path("/api/v1/modeloEquipamentos/{id}").buildAndExpand(modeloEquipamento.getId()).toUri();
        return ResponseEntity.created(uri).body(modeloEquipamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloEquipamentoDto> update(@Valid @RequestBody ModeloEquipamentoDto dto,
                                                     @PathVariable Integer id) {

        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        ModeloEquipamento modeloEquipamentoEncontrato = service.findById(id);
        ModeloEquipamento modeloEquipamento = mapper.toUpdateEntity(modeloEquipamentoEncontrato, dto);
        return ResponseEntity.ok().body(mapper.toDto(service.save(modeloEquipamento)));
    }

    //api/v1/modeloEquipamentos
    //api/v1/modeloEquipamentos?nome=fer
    @GetMapping
    public ResponseEntity<List<ModeloEquipamentoDto>> findByNome(@RequestParam(defaultValue = "") String nome) {
        List<ModeloEquipamentoDto> listaModeloEquipamentoDto = mapper.toListDto(service.findByNome(nome));
        return ResponseEntity.ok().body(listaModeloEquipamentoDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ModeloEquipamentoDto> findById(@PathVariable Integer id) {
        ModeloEquipamentoDto modeloEquipamentoDto = mapper.toDto(service.findById(id));
        return ResponseEntity.ok().body(modeloEquipamentoDto);
    }
}
