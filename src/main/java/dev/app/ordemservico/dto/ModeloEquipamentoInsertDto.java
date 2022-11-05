package dev.app.ordemservico.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ModeloEquipamentoInsertDto {

    @NotNull
    @Positive
    private Integer marcaEquipamento;

    @NotEmpty
    private String nome;


    public Integer getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(Integer marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
