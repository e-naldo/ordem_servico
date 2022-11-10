package dev.app.ordemservico.dto;

import java.time.LocalDate;

public class EquipamentoDto {

    private Integer id;
    private TipoEquipamentoDto tipoEquipamento;
    private ModeloEquipamentoDto modeloEquipamento;
    private EnderecoDto enderecoLocalizacao;
    private String numeroSerie;
    private LocalDate dataFimGarantia;
    private Boolean inativo;

    public EquipamentoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEquipamentoDto getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamentoDto tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public ModeloEquipamentoDto getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(ModeloEquipamentoDto modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public EnderecoDto getEnderecoLocalizacao() {
        return enderecoLocalizacao;
    }

    public void setEnderecoLocalizacao(EnderecoDto enderecoLocalizacao) {
        this.enderecoLocalizacao = enderecoLocalizacao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataFimGarantia() {
        return dataFimGarantia;
    }

    public void setDataFimGarantia(LocalDate dataFimGarantia) {
        this.dataFimGarantia = dataFimGarantia;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
}
