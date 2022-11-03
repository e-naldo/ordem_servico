package dev.app.ordemservico.domain;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
public class Servico extends EntidadeBase {

    private String referencia;

    private String nome;

    private String descricao;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal preco;

    public Servico() {
    }

    public Servico(String referencia, String nome, String descricao, BigDecimal preco) {
        this.referencia = referencia;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
