package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.dto.MarcaEquipamentoDto;
import dev.app.ordemservico.dto.MarcaEquipamentoDto;
import dev.app.ordemservico.mapper.MarcaEquipamentoMapper;
import dev.app.ordemservico.mapper.MarcaEquipamentoMapper;
import dev.app.ordemservico.service.MarcaEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/marcaEquipamentos")
public class MarcaEquipamentoController {

    @Autowired
    private MarcaEquipamentoService service;

    @Autowired
    private MarcaEquipamentoMapper mapper;


    @PostMapping
    public ResponseEntity<MarcaEquipamentoDto> create(@Valid @RequestBody MarcaEquipamentoDto dto,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        MarcaEquipamento marcaEquipamento = service.save(mapper.toEntity(dto));
        MarcaEquipamentoDto marcaEquipamentoDto = mapper.toDto(marcaEquipamento);

        URI uri = uriComponentsBuilder.path("/api/v1/marcaEquipamentos/{id}").buildAndExpand(marcaEquipamento.getId()).toUri();
        return ResponseEntity.created(uri).body(marcaEquipamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaEquipamentoDto> update(@Valid @RequestBody MarcaEquipamentoDto dto,
                                                     @PathVariable Integer id) {

        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        MarcaEquipamento marcaEquipamentoEncontrato = service.findById(id);
        MarcaEquipamento marcaEquipamento = mapper.toUpdateEntity(marcaEquipamentoEncontrato, dto);
        return ResponseEntity.ok().body(mapper.toDto(service.save(marcaEquipamento)));
    }

    //api/v1/marcaEquipamentos
    //api/v1/marcaEquipamentos?nome=fer
    @GetMapping
    public ResponseEntity<List<MarcaEquipamentoDto>> findByNome(@RequestParam(defaultValue = "") String nome) {
        List<MarcaEquipamentoDto> listaMarcaEquipamentoDto = mapper.toListDto(service.findByNome(nome));
        return ResponseEntity.ok().body(listaMarcaEquipamentoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaEquipamentoDto> findById(@PathVariable Integer id) {
        MarcaEquipamentoDto marcaEquipamentoDto = mapper.toDto(service.findById(id));
        return ResponseEntity.ok().body(marcaEquipamentoDto);
    }
}
