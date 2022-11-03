package dev.app.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.app.ordemservico.domain.GrupoProduto;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public class ProdutoDto {
    private Integer id;
    private GrupoProdutoDto grupoProduto;
    private String referencia;
    private String nome;
    private String descricao;
    private String unidade;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;
    private BigDecimal precoMaximo;

    private BigDecimal precoMinimo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrupoProdutoDto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProdutoDto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getPrecoMaximo() {
        return precoMaximo;
    }

    public void setPrecoMaximo(BigDecimal precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    public BigDecimal getPrecoMinimo() {
        return precoMinimo;
    }

    public void setPrecoMinimo(BigDecimal precoMinimo) {
        this.precoMinimo = precoMinimo;
    }
}
