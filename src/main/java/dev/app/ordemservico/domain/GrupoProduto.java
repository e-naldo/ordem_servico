package dev.app.ordemservico.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_produto")
public class GrupoProduto extends EntidadeBase {

    private String nome;

    public GrupoProduto() {
    }

    public GrupoProduto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
