package dev.app.ordemservico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto extends EntidadeBase {

    @ManyToOne
    @JoinColumn(name = "grupo_produto_id")
    private GrupoProduto grupoProduto;

    private String referencia;

    private String nome;

    private String descricao;

    private String unidade;

    @Column(name = "preco_compra")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoCompra;

    @Column(name = "preco_venda")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoVenda;

    @Column(name = "preco_maximo")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoMaximo;

    @Column(name = "preco_minimo")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoMinimo;

    public Produto() {
    }

/*    public Produto(String referencia, String nome, String descricao, String unidade, BigDecimal precoCompra) {
        this.referencia = referencia;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.precoCompra = precoCompra;
        calcularPrecos(precoCompra);
    }*/

    public void calcularPrecos(BigDecimal precoCompra) {
        this.precoVenda = precoCompra.multiply(new BigDecimal(2.05));
        this.precoMaximo = precoVenda.multiply(new BigDecimal(1.25));
        this.precoMinimo = precoVenda.multiply(new BigDecimal(0.85));
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
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
