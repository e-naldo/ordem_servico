package dev.app.ordemservico.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marca_equipamento")
public class MarcaEquipamento extends EntidadeBase {

    private String nome;

    public MarcaEquipamento() {
    }

    public MarcaEquipamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
