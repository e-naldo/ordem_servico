package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.MarcaEquipamento;

public class MarcaEquipamentoDto {

    private Integer id;
    private String nome;

    public MarcaEquipamentoDto() {
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
}
