package dev.app.ordemservico.controller;

import dev.app.ordemservico.dto.cliente.*;
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

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {
        List<ClienteDto> listaClienteDto = clienteService.listarClientes();

        return ResponseEntity.ok(listaClienteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalheDto> detalhar(@PathVariable Integer id) {

        ClienteDetalheDto clienteDetalheDto = clienteService.detalhar(id);
        if(clienteDetalheDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDetalheDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDetalheDto> cadastrar(@Valid @RequestBody ClienteInsertDto clienteInsertDto,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        ClienteDetalheDto clienteDetalheDto = clienteService.cadastrar(clienteInsertDto);

        URI uri = uriComponentsBuilder.path("/api/v1/clientes/{id}").buildAndExpand(clienteDetalheDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDetalheDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDetalheDto> atualizar(@Valid @RequestBody ClienteUpdateDto clienteUpdateDto,
                                                       @PathVariable Integer id) {
        ClienteDetalheDto clienteDetalheDto = clienteService.buscarPorId(id);
        if (clienteDetalheDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clienteService.atualizar(clienteUpdateDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        ClienteDto clienteDto = clienteService.buscarPorId(id);
        if (clienteDto == null) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.remover(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<ClienteDetalheDto> consultarPorDocumento(@RequestParam String documento) {
        ClienteDetalheDto clienteDetalheDto = clienteService.consultarPorDocumento(documento);
        if (clienteDetalheDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDetalheDto);
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<ClienteDto>> consultarPorFiltro(@RequestBody ClienteConsultaDto clienteConsultaDto) {
        List<ClienteDto> listaClienteDto = clienteService.consultarPorFiltro(clienteConsultaDto);
        if (listaClienteDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaClienteDto);
    }

    @PutMapping("/{id}/enderecos")
    public ResponseEntity<ClienteDetalheDto> adicionarEndereco(@PathVariable Integer id,
                                                               @RequestBody EnderecoDto enderecoDto) {
        ClienteDetalheDto clienteDetalheDto = clienteService.adicionarEndereco(id, enderecoDto);

        return ResponseEntity.ok(clienteDetalheDto);
    }

    @PutMapping("/{id}/enderecos/{enderecoId}")
    public ResponseEntity<?> removerEndereco(@PathVariable Integer id, @PathVariable Integer enderecoId) {
        try {
            clienteService.removerEndereco(id, enderecoId);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
