package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.domain.Endereco;
import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ClienteRepository;
import dev.app.ordemservico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Cliente insert(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente, Integer id) {
        return clienteRepository.save(cliente);
    }

    public void remove(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByFilter(ClienteConsultaDto form) {
        List<Cliente> clientes = clienteRepository.findByFilter(
                form.getNome(),
                form.getDocumento(),
                form.getEmail(),
                form.getTelefone()
        );
        return clientes;
    }

    public Cliente addEndereco(Integer id, Endereco endereco) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        cliente.adicionarEndereco(endereco);

        return clienteRepository.save(cliente);
    }

    public void removeEndereco(Integer id, Integer enderecoId) {
        Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
        if (endereco.isPresent() && endereco.get().getCliente().getId() == id) {
            enderecoRepository.deleteById(enderecoId);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Cliente findByDocumento(String documento) {
        Optional<Cliente> cliente = clienteRepository.findByDocumento(documento);
        if (!cliente.isPresent()) {
            return null;
        }
        return cliente.get();
    }
}
