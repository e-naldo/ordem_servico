package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Produto;
import dev.app.ordemservico.dto.ProdutoDetalhesDto;
import dev.app.ordemservico.dto.ProdutoDto;
import dev.app.ordemservico.dto.ProdutoInsertDto;
import dev.app.ordemservico.dto.ProdutoUpdateDto;
import dev.app.ordemservico.service.GrupoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoMapper {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    public Produto toInsertEntity(ProdutoInsertDto dto){
        Produto produto = new Produto();
        produto.setGrupoProduto(grupoProdutoService.findById(dto.getGrupoProduto()));
        produto.setReferencia(dto.getReferencia());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setUnidade(dto.getUnidade());
        produto.setPrecoCompra(dto.getPrecoCompra());

        return produto;
    }

    public Produto toEntity(ProdutoDetalhesDto dto){
        Produto produto = new Produto();
        produto.setGrupoProduto(new GrupoProdutoMapper().toEntity(dto.getGrupoProduto()));
        produto.setReferencia(dto.getReferencia());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setUnidade(dto.getUnidade());
        produto.setPrecoCompra(dto.getPrecoCompra());

        return produto;
    }

    public Produto toEntity(ProdutoDto dto){
        Produto produto = new Produto();
        produto.setReferencia(dto.getReferencia());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setUnidade(dto.getUnidade());

        return produto;
    }


    public Produto toUpdateEntity(Produto produto, ProdutoUpdateDto dto){
        produto.setGrupoProduto(grupoProdutoService.findById(dto.getGrupoProduto()));
        produto.setReferencia(dto.getReferencia());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setUnidade(dto.getUnidade());
        produto.setPrecoCompra(dto.getPrecoCompra());

        return produto;
    }

    public ProdutoDetalhesDto toDetalhesDto(Produto produto){
        ProdutoDetalhesDto dto = new ProdutoDetalhesDto();
        dto.setId(produto.getId());
        dto.setGrupoProduto(new GrupoProdutoMapper().toDto(produto.getGrupoProduto()));
        dto.setReferencia(produto.getReferencia());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setUnidade(produto.getUnidade());
        dto.setPrecoCompra(produto.getPrecoCompra());
        dto.setPrecoVenda(produto.getPrecoVenda());
        dto.setPrecoMaximo(produto.getPrecoMaximo());
        dto.setPrecoMinimo(produto.getPrecoMinimo());
        return dto;
    }

    public ProdutoDto toDto(Produto produto){
        ProdutoDto dto = new ProdutoDto();
        dto.setId(produto.getId());
        dto.setReferencia(produto.getReferencia());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setUnidade(produto.getUnidade());
        return dto;
    }

    public List<ProdutoDetalhesDto> toListDetalhesDto(List<Produto> produtos){
        return produtos.stream()
                .map(new ProdutoMapper()::toDetalhesDto)
                .collect(Collectors.toList());
    }

    public List<ProdutoDto> toListDto(List<Produto> produtos){
        return produtos.stream()
                .map(new ProdutoMapper()::toDto)
                .collect(Collectors.toList());
    }
}
