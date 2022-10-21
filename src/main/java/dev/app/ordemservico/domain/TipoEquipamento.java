package dev.app.ordemservico.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_equipamento")
public class TipoEquipamento extends EntidadeBase {

    private String nome;

    public TipoEquipamento() {
    }

    public TipoEquipamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
