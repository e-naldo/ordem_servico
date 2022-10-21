package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteInsertDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.getNome());
        cliente.setTipo(clienteDto.getTipo());
        cliente.setDocumento(clienteDto.getDocumento());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setSite(clienteDto.getSite());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setDataCadastro(clienteDto.getDataCadastro());

        cliente.setEnderecos(clienteDto.getEnderecos().stream().map(new EnderecoMapper()::converterParaEntidade).collect(Collectors.toList()));

        return cliente;
    }

    public Cliente toUpdateEntity(Cliente cliente, ClienteUpdateDto clienteDto){
        cliente.setNome(clienteDto.getNome());
        cliente.setDocumento(clienteDto.getDocumento());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setSite(clienteDto.getSite());
        cliente.setTelefone(clienteDto.getTelefone());

        cliente.setEnderecos(clienteDto.getEnderecos().stream().map(new EnderecoMapper()::converterParaEntidade).collect(Collectors.toList()));

        return cliente;
    }


    public ClienteDetalhesDto toDto(Cliente cliente){
        ClienteDetalhesDto clienteDto = new ClienteDetalhesDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setTipo(cliente.getTipo());
        clienteDto.setDocumento(cliente.getDocumento());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setSite(cliente.getSite());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setDataCadastro(cliente.getDataCadastro());

        clienteDto.setEnderecos(cliente.getEnderecos().stream().map(new EnderecoMapper()::converterParaDto).collect(Collectors.toList()));

        return clienteDto;
    }


    public ClienteDto toBasicDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setDocumento(cliente.getDocumento());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setTelefone(cliente.getTelefone());

        return clienteDto;
    }

    public ClienteEnderecoCobrancaDto toClienteEnderecoCobrancaDto(Cliente cliente){
        ClienteEnderecoCobrancaDto clienteDto = new ClienteEnderecoCobrancaDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setDocumento(cliente.getDocumento());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setTelefone(cliente.getTelefone());

        clienteDto.setEnderecos(cliente.getEnderecos().stream()
                .filter(x -> x.getEnderecoCobranca())
                .map(new EnderecoMapper()::converterParaDto)
                .collect(Collectors.toList()));

        return clienteDto;
    }

    public List<ClienteDetalhesDto> toListDto(List<Cliente> clientes){
        return clientes.stream().map(new ClienteMapper()::toDto).collect(Collectors.toList());
    }

}
