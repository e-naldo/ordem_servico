package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.GrupoProduto;
import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.dto.GrupoProdutoDto;
import dev.app.ordemservico.dto.TipoEquipamentoDto;
import dev.app.ordemservico.mapper.GrupoProdutoMapper;
import dev.app.ordemservico.mapper.TipoEquipamentoMapper;
import dev.app.ordemservico.service.GrupoProdutoService;
import dev.app.ordemservico.service.TipoEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/grupoProduto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoService service;

    @Autowired
    private GrupoProdutoMapper mapper;


    @PostMapping
    public ResponseEntity<GrupoProdutoDto> create(@Valid @RequestBody GrupoProdutoDto dto,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        GrupoProduto grupoProduto = service.save(mapper.toEntity(dto));
        GrupoProdutoDto grupoProdutoDto = mapper.toDto(grupoProduto);

        URI uri = uriComponentsBuilder.path("/api/v1/grupoProdutoDto/{id}").buildAndExpand(grupoProdutoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(grupoProdutoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoProdutoDto> update(@Valid @RequestBody GrupoProdutoDto dto,
                                                     @PathVariable Integer id) {

        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        GrupoProduto  grupoProdutoEncontrato = service.findById(id);
        GrupoProduto grupoProduto = mapper.toUpdateEntity(grupoProdutoEncontrato, dto);

        return ResponseEntity.ok().body(mapper.toDto(service.save(grupoProduto)));
    }


    @GetMapping
    public ResponseEntity<List<GrupoProdutoDto>> findByAll() {
        List<GrupoProdutoDto> listaGrupoProdutoDto = mapper.toListDto(service.findAll());

        return ResponseEntity.ok().body(listaGrupoProdutoDto);
    }
}
