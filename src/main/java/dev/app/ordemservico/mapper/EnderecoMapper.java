package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Endereco;
import dev.app.ordemservico.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoMapper {

    public Endereco toEntity(EnderecoDto enderecoDto){
        Endereco endereco = new Endereco();
        endereco.setDescricao(enderecoDto.getDescricao());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setMunicipio(enderecoDto.getMunicipio());
        endereco.setUf(enderecoDto.getUf());
        endereco.setCep(enderecoDto.getCep());
        endereco.setEnderecoCobranca(enderecoDto.getEnderecoCobranca());
        endereco.setEnderecoEntrega(enderecoDto.getEnderecoEntrega());
        endereco.setEnderecoServico(enderecoDto.getEnderecoServico());

        return endereco;
    }

    public EnderecoDto toDto(Endereco endereco){
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setId(endereco.getId());
        enderecoDto.setDescricao(endereco.getDescricao());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setMunicipio(endereco.getMunicipio());
        enderecoDto.setUf(endereco.getUf());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setEnderecoCobranca(endereco.getEnderecoCobranca());
        enderecoDto.setEnderecoEntrega(endereco.getEnderecoEntrega());
        enderecoDto.setEnderecoServico(endereco.getEnderecoServico());

        return enderecoDto;
    }

    public List<EnderecoDto> converterListaDto(List<Endereco> enderecos){
        //return equipamentos.stream().map(x -> new EquipamentoMapper().converterParaDto(x)).collect(Collectors.toList());
        return enderecos.stream().map(new EnderecoMapper()::toDto).collect(Collectors.toList());
    }

    public List<Endereco> converterListaEntidade(List<EnderecoDto> enderecos){
        //return equipamentos.stream().map(x -> new EquipamentoMapper().converterParaDto(x)).collect(Collectors.toList());
        return enderecos.stream().map(new EnderecoMapper()::toEntity).collect(Collectors.toList());
    }


}
