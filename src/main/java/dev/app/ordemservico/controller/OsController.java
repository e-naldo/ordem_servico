package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.domain.Os;
import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.mapper.ItemProdutoOsMapper;
import dev.app.ordemservico.mapper.OsMapper;
import dev.app.ordemservico.service.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/oss")
public class OsController {

    @Autowired
    private OsService osService;

    @Autowired
    private OsMapper osMapper;

    @Autowired
    private ItemProdutoOsMapper itemMapper;


    @PostMapping
    public ResponseEntity<OsDto> create(@Valid @RequestBody OsInsertDto dto,
                                                 UriComponentsBuilder uriComponentsBuilder){

        Os os = osService.save(osMapper.toInsertEntity(dto));
        OsDto osDto = osMapper.toDto(os);

        URI uri = uriComponentsBuilder.path("/api/v1/oss/{id}").buildAndExpand(osDto.getId()).toUri();
        return ResponseEntity.created(uri).body(osDto);
    }


/*    @GetMapping
    public ResponseEntity<List<OsDto>> findAll(){
        List<Os> listaOss = osService.findAll();

        return ResponseEntity.ok(osMapper.toDto(listaOss));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<OsDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(osMapper.toDto(osService.findById(id)));
    }

    @PutMapping("/{osId}/itemProdutos")
    public ResponseEntity<OsDto> addItemProdutoOs(@PathVariable Integer osId,
                                                  @RequestBody ItemProdutoOsInsertDto itemDto){
        Os os = osService.addItemProdutoOs(osId, itemMapper.toInsertEntity(itemDto));

        return ResponseEntity.ok(osMapper.toDto(os));
    }
    
}
