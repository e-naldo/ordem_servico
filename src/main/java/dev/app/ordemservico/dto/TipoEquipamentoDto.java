package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.TipoEquipamento;

public class TipoEquipamentoDto {

    private String nome;

    public TipoEquipamentoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
