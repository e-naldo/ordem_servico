package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Produto;
import dev.app.ordemservico.dto.ProdutoConsultaDto;
import dev.app.ordemservico.dto.ProdutoDto;
import dev.app.ordemservico.dto.ProdutoInsertDto;
import dev.app.ordemservico.dto.ProdutoUpdateDto;
import dev.app.ordemservico.mapper.ProdutoMapper;
import dev.app.ordemservico.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtoMapper.toListDto(produtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Integer id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok(produtoMapper.toDto(produto));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<ProdutoDto>> findByFilter(@RequestBody ProdutoConsultaDto dto){
        List<Produto> produtos = produtoService.findByFilter(dto);
        return ResponseEntity.ok(produtoMapper.toListDto(produtos));
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> create(@Valid @RequestBody ProdutoInsertDto dto, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = produtoService.save(produtoMapper.toEntity(dto));
        ProdutoDto produtoDto = produtoMapper.toDto(produto);

        URI uri = uriComponentsBuilder.path("/api/v1/produtos/{id}").buildAndExpand(produtoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> update(@Valid @RequestBody ProdutoUpdateDto dto,
                                             @PathVariable Integer id){
        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Produto produtoEncontrado = produtoService.findById(id);
        Produto produto = produtoMapper.toUpdateEntity(produtoEncontrado, dto);

        return ResponseEntity.ok(produtoMapper.toDto(produtoService.save(produto)));
    }

}
