package dev.app.ordemservico.domain;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "os")
public class Os extends EntidadeBase {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @Column(name = "valor_total")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorTotal;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    private String observacao;

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemProdutoOs> produtos = new HashSet<>();

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemServicoOs> servicos = new HashSet<>();

    public Os() {
    }

    public Os(Cliente cliente, Equipamento equipamento, String status) {
        this.cliente = cliente;
        this.equipamento = equipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
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

    public Set<ItemProdutoOs> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ItemProdutoOs> produtos) {
        this.produtos = produtos;
        for (ItemProdutoOs item : produtos){
            item.setOs(this);
        }
    }

    public Set<ItemServicoOs> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ItemServicoOs> servicos) {
        this.servicos = servicos;
        for (ItemServicoOs item : servicos){
            item.setOs(this);
        }
    }

    public void adicionarItemProdutoOs(ItemProdutoOs item){
        this.produtos.add(item);
        item.setOs(this);
    }

    public void removerItemProdutoOs(ItemProdutoOs item){
        this.produtos.remove(item);
        //item.setOs(null);
    }

    public void adicionarItemServico(ItemServicoOs osItemServico) {
        this.servicos.add(osItemServico);
        osItemServico.setOs(this);
    }

}
