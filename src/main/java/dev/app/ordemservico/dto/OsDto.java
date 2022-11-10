package dev.app.ordemservico.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OsDto {

    private Integer id;

    private ClienteDto cliente;

    private EquipamentoDto equipamento;

    private BigDecimal valorTotal;

    private String formaPagamento;

    private String observacao;

    private Set<ItemProdutoOsDto> produtos = new HashSet<>();

    private Set<ItemServicoOsDto> servicos = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public EquipamentoDto getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoDto equipamento) {
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
