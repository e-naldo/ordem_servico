package dev.app.ordemservico.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class OsInsertDto {

    private Integer cliente;

    private Integer equipamento;

    private BigDecimal valorTotal;

    private String formaPagamento;

    private String observacao;

    private Set<ItemProdutoOsDto> produtos = new HashSet<>();

    private Set<ItemServicoOsDto> servicos = new HashSet<>();

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Integer equipamento) {
        this.equipamento = equipamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<ItemProdutoOsDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ItemProdutoOsDto> produtos) {
        this.produtos = produtos;
    }

    public Set<ItemServicoOsDto> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ItemServicoOsDto> servicos) {
        this.servicos = servicos;
    }
}
