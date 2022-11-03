package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.GrupoProduto;
import dev.app.ordemservico.dto.GrupoProdutoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoProdutoMapper {

    public GrupoProduto toEntity(GrupoProdutoDto dto){
        GrupoProduto grupoProduto = new GrupoProduto();
        grupoProduto.setNome(dto.getNome());
        return grupoProduto;
    }

    public GrupoProdutoDto toDto(GrupoProduto grupoProduto){
        GrupoProdutoDto dto = new GrupoProdutoDto();
        dto.setId(grupoProduto.getId());
        dto.setNome(grupoProduto.getNome());
        return dto;
    }

    public GrupoProduto toUpdateEntity(GrupoProduto grupoProduto, GrupoProdutoDto dto){
        grupoProduto.setNome(dto.getNome());
        return grupoProduto;
    }

    public List<GrupoProdutoDto> toListDto(List<GrupoProduto> grupos){
        return grupos.stream().map(new GrupoProdutoMapper()::toDto).collect(Collectors.toList());
    }
}
