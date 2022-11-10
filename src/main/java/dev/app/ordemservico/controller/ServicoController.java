package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Servico;
import dev.app.ordemservico.dto.ServicoDto;
import dev.app.ordemservico.dto.ServicoInsertDto;
import dev.app.ordemservico.dto.ServicoUpdateDto;
import dev.app.ordemservico.mapper.ServicoMapper;
import dev.app.ordemservico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ServicoMapper servicoMapper;

    @GetMapping
    public ResponseEntity<List<ServicoDto>> findAll(){
        List<Servico> servicos = servicoService.findAll();
        return ResponseEntity.ok(servicoMapper.toListDto(servicos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> findById(@PathVariable Integer id){
        Servico servico = servicoService.findById(id);
        return ResponseEntity.ok(servicoMapper.toDto(servico));
    }

/*    @PostMapping("/consultar")
    public ResponseEntity<List<ServicoDto>> findByFilter(@RequestBody ServicoConsultaDto dto){
        List<Servico> servicos = servicoService.findByFilter(dto);
        return ResponseEntity.ok(servicoMapper.toListDto(servicos));
    }*/

    @PostMapping
    public ResponseEntity<ServicoDto> create(@Valid @RequestBody ServicoInsertDto dto, UriComponentsBuilder uriComponentsBuilder){
        Servico servico = servicoService.save(servicoMapper.toInsertEntity(dto));
        ServicoDto servicoDto = servicoMapper.toDto(servico);

        URI uri = uriComponentsBuilder.path("/api/v1/servicos/{id}").buildAndExpand(servicoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(servicoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDto> update(@Valid @RequestBody ServicoUpdateDto dto,
                                             @PathVariable Integer id){
        if(!dto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Servico servicoEncontrado = servicoService.findById(id);
        Servico servico = servicoMapper.toUpdateEntity(servicoEncontrado, dto);

        return ResponseEntity.ok(servicoMapper.toDto(servicoService.save(servico)));
    }

}
