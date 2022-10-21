package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.MarcaEquipamento;

public class MarcaEquipamentoDto {

    private String nome;

    public MarcaEquipamentoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
