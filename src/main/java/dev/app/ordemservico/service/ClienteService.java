package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.domain.Endereco;
import dev.app.ordemservico.dto.ClienteConsultaDto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ClienteRepository;
import dev.app.ordemservico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        clienteRepository.deleteById(cliente.getId());
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Cliente findByDocumento(String documento) {
     return clienteRepository.findByDocumento(documento)
             .orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public List<Cliente> findByFilter(ClienteConsultaDto dto) {
        List<Cliente> clientes = clienteRepository.findByFilter(
                dto.getNome(),
                dto.getDocumento(),
                dto.getEmail(),
                dto.getTelefone()
        );
        return clientes;
    }

    public Cliente addEndereco(Integer id, Endereco endereco) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        cliente.adicionarEndereco(endereco);

        return clienteRepository.save(cliente);
    }

    public void removeEndereco(Integer clienteId, Integer enderecoId) {
        Endereco endereco = enderecoRepository.findByClienteIdAndEnderecoId(clienteId, enderecoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
           enderecoRepository.deleteById(enderecoId);
    }
}
