package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.domain.Endereco;
import dev.app.ordemservico.dto.cliente.*;
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

    public ClienteDetalheDto cadastrar(ClienteInsertDto clienteFormDto) {
        Cliente cliente = clienteFormDto.converter();
        clienteRepository.save(cliente);

        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto atualizar(ClienteUpdateDto clienteUpdateDto, Integer id) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        Cliente cliente = clienteUpdateDto.atualizar(clienteEncontrado);
        clienteRepository.save(cliente);

        return new ClienteDetalheDto(clienteEncontrado);
    }

    public void remover(Integer id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDetalheDto buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return new ClienteDetalheDto(cliente.get());
        }
        return null;
    }

    public List<ClienteDto> listarClientes() {
        List<Cliente> cliente = clienteRepository.findAll();

        return ClienteDto.converter(cliente);
    }

    public ClienteDetalheDto detalhar(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            return null;
        }
        return new ClienteDetalheDto(cliente.get());
    }

    public List<ClienteDto> consultarPorFiltro(ClienteConsultaDto form) {
        List<Cliente> clientes = clienteRepository.consultaPorFiltro(
                form.getNome(),
                form.getDocumento(),
                form.getEmail(),
                form.getTelefone()
        );
        return ClienteDto.converter(clientes);
    }

    public ClienteDetalheDto adicionarEndereco(Integer id, EnderecoDto enderecoDto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        cliente.adicionarEndereco(enderecoDto.converter());
        clienteRepository.save(cliente);

        return new ClienteDetalheDto(cliente);
    }

    public void removerEndereco(Integer id, Integer enderecoId) {
        Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
        if (endereco.isPresent() && endereco.get().getCliente().getId() == id) {
            enderecoRepository.deleteById(enderecoId);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ClienteDetalheDto consultarPorDocumento(String documento) {
        Optional<Cliente> cliente = clienteRepository.findByDocumento(documento);
        if (!cliente.isPresent()) {
            return null;
        }
        return new ClienteDetalheDto(cliente.get());
    }
}
