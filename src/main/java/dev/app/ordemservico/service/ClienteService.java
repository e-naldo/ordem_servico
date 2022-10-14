package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> listarClientes() {
        List<Cliente> cliente = clienteRepository.findAll();
        return ClienteDto.converter(cliente);
    }

    public ClienteDetalheDto detalhar(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto cadastrar(ClienteInsertDto clienteFormDto) {
        Cliente cliente = clienteFormDto.converter();
        clienteRepository.save(cliente);
        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto atualizar(ClienteUpdateDto clienteFormAtualizacaoDto, Integer id) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        Cliente cliente = clienteFormAtualizacaoDto.atualizar(clienteEncontrado);


        clienteRepository.save(cliente);
        return new ClienteDetalheDto(clienteEncontrado);
    }

    public void remover(Integer id) {
        clienteRepository.deleteById(id);
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

    public ClienteDetalheDto adicionarEndereco(Integer id, EnderecoDto enderecoDto){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        cliente.adicionarEndereco(enderecoDto.converter());
        clienteRepository.save(cliente);
        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto consultarPorDocumento(String documento){
        Cliente cliente = clienteRepository.findByDocumento(documento)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        return new ClienteDetalheDto(cliente);
    }

}
