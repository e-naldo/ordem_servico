package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.dto.TipoEquipamentoDto;
import dev.app.ordemservico.mapper.TipoEquipamentoMapper;
import dev.app.ordemservico.service.TipoEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tipoEquipamentos")
public class TipoEquipamentoController {

    @Autowired
    private TipoEquipamentoService service;

    @Autowired
    private TipoEquipamentoMapper mapper;


    @PostMapping
    public ResponseEntity<TipoEquipamentoDto> create(@Valid @RequestBody TipoEquipamentoDto dto,
                                                     UriComponentsBuilder uriComponentsBuilder) {
        TipoEquipamento tipoEquipamento = service.save(mapper.toEntity(dto));
        TipoEquipamentoDto tipoEquipamentoDto = mapper.toDto(tipoEquipamento);

        URI uri = uriComponentsBuilder.path("/api/v1/tipoEquipamentos/{id}").buildAndExpand(tipoEquipamentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoEquipamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEquipamentoDto> update(@Valid @RequestBody TipoEquipamentoDto dto,
                                                     @PathVariable Integer id) {

        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        TipoEquipamento tipoEquipamentoEncontrato = service.findById(id);
        TipoEquipamento tipoEquipamento = mapper.toUpdateEntity(tipoEquipamentoEncontrato, dto);

        return ResponseEntity.ok().body(mapper.toDto(service.save(tipoEquipamento)));
    }

    //api/v1/tipoEquipamentos
    //api/v1/tipoEquipamentos?nome=fer
    @GetMapping
    public ResponseEntity<List<TipoEquipamentoDto>> findByNome(@RequestParam(defaultValue = "") String nome) {
        List<TipoEquipamentoDto> listaTipoEquipamentoDto = mapper.toListDto(service.findByNome(nome));

        return ResponseEntity.ok().body(listaTipoEquipamentoDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoEquipamentoDto> findById(@PathVariable Integer id) {
        TipoEquipamentoDto tipoEquipamentoDto = mapper.toDto(service.findById(id));

        return ResponseEntity.ok().body(tipoEquipamentoDto);
    }
}
