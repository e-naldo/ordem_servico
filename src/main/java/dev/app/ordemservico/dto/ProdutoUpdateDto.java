package dev.app.ordemservico.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutoUpdateDto {

    private Integer id;

    @NotNull
    @Positive
    private Integer grupoProduto;
    @NotEmpty
    private String referencia;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;

    @NotEmpty
    private String unidade;
    @NotNull
    private BigDecimal precoCompra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(Integer grupoProduto) {
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

}
