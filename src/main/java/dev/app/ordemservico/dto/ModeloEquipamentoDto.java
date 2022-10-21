package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.ModeloEquipamento;

public class ModeloEquipamentoDto {

    private String nome;

    public ModeloEquipamentoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
