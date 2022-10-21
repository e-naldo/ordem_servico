package dev.app.ordemservico.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modelo_equipamento")
public class ModeloEquipamento extends EntidadeBase {

    @ManyToOne
    @JoinColumn(name = "marca_equipamento_id")
    private MarcaEquipamento marcaEquipamento;

    private String nome;

    public ModeloEquipamento() {
    }

    public ModeloEquipamento(MarcaEquipamento marcaEquipamento, String nome) {
        this.marcaEquipamento = marcaEquipamento;
        this.nome = nome;
    }

    public MarcaEquipamento getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(MarcaEquipamento marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
