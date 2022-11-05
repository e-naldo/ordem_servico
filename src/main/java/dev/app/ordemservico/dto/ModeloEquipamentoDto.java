package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.ModeloEquipamento;

public class ModeloEquipamentoDto {

    private Integer id;
    private String nome;

    private MarcaEquipamentoDto marcaEquipamento;

    public ModeloEquipamentoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaEquipamentoDto getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(MarcaEquipamentoDto marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }
}
