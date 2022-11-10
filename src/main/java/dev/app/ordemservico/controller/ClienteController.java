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

    @PostMapping
    public ResponseEntity<ClienteDetailDto> create(@Valid @RequestBody ClienteInsertDto clienteInsertDto,
                                                   UriComponentsBuilder uriComponentsBuilder) {

        Cliente cliente = clienteService.save(clienteMapper.toEntity(clienteInsertDto));
        ClienteDetailDto clienteDetalheDto = clienteMapper.toDetailDto(cliente);

        URI uri = uriComponentsBuilder.path("/api/v1/clientes/{id}").buildAndExpand(clienteDetalheDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDetalheDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDetailDto> update(@Valid @RequestBody ClienteUpdateDto dto,
                                                   @PathVariable Integer id) {
        if (!dto.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Cliente clienteEncontrado = clienteService.findById(id);
        Cliente cliente = clienteMapper.toUpdateEntity(clienteEncontrado, dto);

        return ResponseEntity.ok(clienteMapper.toDetailDto(clienteService.save(cliente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        clienteService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDetailDto>> findAll() {
        List<ClienteDetailDto> listaClienteDto = clienteMapper.toListDto(clienteService.findAll());

        return ResponseEntity.ok(listaClienteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetailDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteMapper.toDetailDto(clienteService.findById(id)));
    }

    //api/v1/clientes/?documento=1020071217630
    @GetMapping("/")
    public ResponseEntity<ClienteDetailDto> findByDocumento(@RequestParam String documento) {
        return ResponseEntity.ok(clienteMapper.toDetailDto(clienteService.findByDocumento(documento)));
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<ClienteDetailDto>> findByFilter(@RequestBody ClienteConsultaDto clienteConsultaDto) {
        List<Cliente> listaCliente = clienteService.findByFilter(clienteConsultaDto);

        return ResponseEntity.ok(clienteMapper.toListDto(listaCliente));
    }

    @PutMapping("/{id}/enderecos")
    public ResponseEntity<ClienteDetailDto> addEndereco(@PathVariable Integer id,
                                                        @RequestBody EnderecoDto enderecoDto) {
        Cliente cliente = clienteService.addEndereco(id, enderecoMapper.toEntity(enderecoDto));

        return ResponseEntity.ok(clienteMapper.toDetailDto(cliente));
    }

    @PutMapping("/{clienteId}/enderecos/{enderecoId}")
    public ResponseEntity<?> removeEndereco(@PathVariable Integer clienteId, @PathVariable Integer enderecoId) {

        clienteService.removeEndereco(clienteId, enderecoId);
        return ResponseEntity.ok().build();
    }
}
