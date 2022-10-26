package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteInsertDto dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setTipo(dto.getTipo());
        cliente.setDocumento(dto.getDocumento());
        cliente.setEmail(dto.getEmail());
        cliente.setSite(dto.getSite());
        cliente.setTelefone(dto.getTelefone());
        cliente.setDataCadastro(dto.getDataCadastro());

        cliente.setEnderecos(dto.getEnderecos().stream().map(new EnderecoMapper()::converterParaEntidade).collect(Collectors.toList()));

        return cliente;
    }

    public Cliente toUpdateEntity(Cliente cliente, ClienteUpdateDto dto){
        cliente.setNome(dto.getNome());
        cliente.setDocumento(dto.getDocumento());
        cliente.setEmail(dto.getEmail());
        cliente.setSite(dto.getSite());
        cliente.setTelefone(dto.getTelefone());

        cliente.setEnderecos(dto.getEnderecos().stream().map(new EnderecoMapper()::converterParaEntidade).collect(Collectors.toList()));

        return cliente;
    }

    public ClienteDetalhesDto toDto(Cliente cliente){
        ClienteDetalhesDto dto = new ClienteDetalhesDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTipo(cliente.getTipo());
        dto.setDocumento(cliente.getDocumento());
        dto.setEmail(cliente.getEmail());
        dto.setSite(cliente.getSite());
        dto.setTelefone(cliente.getTelefone());
        dto.setDataCadastro(cliente.getDataCadastro());

        dto.setEnderecos(cliente.getEnderecos().stream().map(new EnderecoMapper()::converterParaDto).collect(Collectors.toList()));

        return dto;
    }

    public ClienteDto toBasicDto(Cliente cliente){
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setDocumento(cliente.getDocumento());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());

        return dto;
    }

    public ClienteEnderecoCobrancaDto toClienteEnderecoCobrancaDto(Cliente cliente){
        ClienteEnderecoCobrancaDto dto = new ClienteEnderecoCobrancaDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setDocumento(cliente.getDocumento());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());

        dto.setEnderecos(cliente.getEnderecos().stream()
                .filter(x -> x.getEnderecoCobranca())
                .map(new EnderecoMapper()::converterParaDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public List<ClienteDetalhesDto> toListDto(List<Cliente> clientes){
        return clientes.stream().map(new ClienteMapper()::toDto).collect(Collectors.toList());
    }
}
