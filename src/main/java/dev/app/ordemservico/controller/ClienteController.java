package dev.app.ordemservico.controller;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.mapper.ClienteMapper;
import dev.app.ordemservico.mapper.EnderecoMapper;
import dev.app.ordemservico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDetalhesDto>> findAll() {
        List<ClienteDetalhesDto> listaClienteDto = clienteMapper.toListDto(clienteService.findAll());

        return ResponseEntity.ok(listaClienteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalhesDto> findById(@PathVariable Integer id) {

        ClienteDetalhesDto clienteDetalheDto = clienteMapper.toDto(clienteService.findById(id));
        if (clienteDetalheDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDetalheDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDetalhesDto> insert(@Valid @RequestBody ClienteInsertDto clienteInsertDto,
                                                     UriComponentsBuilder uriComponentsBuilder) {

        Cliente cliente = clienteService.insert(clienteMapper.toEntity(clienteInsertDto));
        ClienteDetalhesDto clienteDetalheDto = clienteMapper.toDto(cliente);

        URI uri = uriComponentsBuilder.path("/api/v1/clientes/{id}").buildAndExpand(clienteDetalheDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDetalheDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDetalhesDto> update(@Valid @RequestBody ClienteUpdateDto clienteUpdateDto,
                                                     @PathVariable Integer id) {
        Cliente clienteEncontrado = clienteService.findById(id);
        if (clienteEncontrado == null) {
            return ResponseEntity.badRequest().build();
        }

        Cliente cliente = clienteMapper.toUpdateEntity(clienteEncontrado, clienteUpdateDto);
        return ResponseEntity.ok(clienteMapper.toDto(clienteService.update(cliente, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.remove(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<ClienteDetalhesDto> findByDocumento(@RequestParam String documento) {
        Cliente cliente = clienteService.findByDocumento(documento);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteMapper.toDto(cliente));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<ClienteDetalhesDto>> findByFilter(@RequestBody ClienteConsultaDto clienteConsultaDto) {
        List<Cliente> listaCliente = clienteService.findByFilter(clienteConsultaDto);

        return ResponseEntity.ok(clienteMapper.toListDto(listaCliente));
    }

    @PutMapping("/{id}/enderecos")
    public ResponseEntity<ClienteDetalhesDto> addEndereco(@PathVariable Integer id,
                                                          @RequestBody EnderecoDto enderecoDto) {
        Cliente cliente = clienteService.addEndereco(id, enderecoMapper.converterParaEntidade(enderecoDto));

        return ResponseEntity.ok(clienteMapper.toDto(cliente));
    }

    @PutMapping("/{id}/enderecos/{enderecoId}")
    public ResponseEntity<?> removeEndereco(@PathVariable Integer id, @PathVariable Integer enderecoId) {
        try {
            clienteService.removeEndereco(id, enderecoId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
