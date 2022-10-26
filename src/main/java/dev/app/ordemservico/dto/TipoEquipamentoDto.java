package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.TipoEquipamento;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TipoEquipamentoDto {

    private Integer id;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nome;

    public TipoEquipamentoDto() {
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
