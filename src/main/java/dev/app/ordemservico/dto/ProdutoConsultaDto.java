package dev.app.ordemservico.dto;

import java.time.LocalDate;

public class ProdutoConsultaDto {
    private Integer id;
    private Integer grupoProduto;
    private String referencia;
    private String nome;

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
}
