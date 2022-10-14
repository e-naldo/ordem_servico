package dev.app.ordemservico.controller;

import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteDetalheDto detalhar(@PathVariable Integer id) {
        return clienteService.detalhar(id);
    }

    @PostMapping
    public ClienteDetalheDto cadastrar(@RequestBody @Valid ClienteInsertDto clienteFormDto) {
        return clienteService.cadastrar(clienteFormDto);
    }

    @PutMapping("/{id}")
    public ClienteDetalheDto atualizar(@RequestBody @Valid ClienteUpdateDto clienteFormAtualizacaoDto, @PathVariable Integer id){
        return clienteService.atualizar(clienteFormAtualizacaoDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id){
        clienteService.remover(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ClienteDetalheDto consultarPorDocumento(@RequestParam String documento){
        return clienteService.consultarPorDocumento(documento);
    }

    @PostMapping("/consultar")
    public List<ClienteDto> consultarPorFiltro(@RequestBody ClienteConsultaDto clienteFormDto){
        return clienteService.consultarPorFiltro(clienteFormDto);
    }

    @PostMapping("/{id}/enderecos")
    public ClienteDetalheDto adicionarEndereco(@PathVariable Integer id, @RequestBody EnderecoDto enderecoDto){
        return clienteService.adicionarEndereco(id, enderecoDto);
    }

}
