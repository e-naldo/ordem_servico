package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.dto.ClienteDetalheDto;
import dev.app.ordemservico.dto.ClienteDto;
import dev.app.ordemservico.dto.ClienteFormAtualizacaoDto;
import dev.app.ordemservico.dto.ClienteFormDto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> listarClientes(){
        List<Cliente> cliente = clienteRepository.findAll();
        return ClienteDto.converter(cliente);
    }

    public ClienteDetalheDto detalhar(Integer id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto cadastrar(ClienteFormDto clienteFormDto) {
        Cliente cliente = clienteFormDto.converter();
        clienteRepository.save(cliente);
        return new ClienteDetalheDto(cliente);
    }

    public ClienteDetalheDto atualizar(ClienteFormAtualizacaoDto clienteFormAtualizacaoDto, Integer id) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        Cliente cliente = clienteFormAtualizacaoDto.atualizar(clienteEncontrado);


        clienteRepository.save(cliente);
        return new ClienteDetalheDto(clienteEncontrado);
    }

    public void remover(Integer id){
        clienteRepository.deleteById(id);
    }

}
