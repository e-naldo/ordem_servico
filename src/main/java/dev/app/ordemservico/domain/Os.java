package dev.app.ordemservico.domain;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "os")
public class Os extends EntidadeBase {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @Enumerated(EnumType.STRING)
    private PosicaoOs posicaoOs;

    private String status;

    @Column(name = "valor_total")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorTotal;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    private String observacao;

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL)
    private List<ItemProdutoOs> produtos = new ArrayList<>();

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL)
    private List<ItemServicoOs> servicos = new ArrayList<>();

    public Os() {
    }

    public Os(Cliente cliente, Equipamento equipamento, String status) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.status = "A";
    }

    public void adicionarItemProduto(ItemProdutoOs osItemProduto){
        this.produtos.add(osItemProduto);
        osItemProduto.setOs(this);
    }

    public void adicionarItemServico(ItemServicoOs osItemServico){
        this.servicos.add(osItemServico);
        osItemServico.setOs(this);
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

    public PosicaoOs getPosicaoOs() {
        return posicaoOs;
    }

    public void setPosicaoOs(PosicaoOs posicaoOs) {
        this.posicaoOs = posicaoOs;
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

    public List<ItemProdutoOs> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public List<ItemServicoOs> getServicos() {
        return Collections.unmodifiableList(servicos);
    }
}
