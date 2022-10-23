package dev.app.ordemservico.dto;

import java.time.LocalDate;

public class EquipamentoConsultaDto {

    private Integer tipoEquipamento;
    private Integer marcaEquipamento;
    private Integer modeloEquipamento;
    private Integer cliente;
    private String numeroSerie;
    private Boolean inativo;
    private LocalDate dataFabricacaoInicial;
    private LocalDate dataFabricacaoFinal;


    public Integer getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(Integer tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Integer getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(Integer marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public Integer getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(Integer modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public LocalDate getDataFabricacaoInicial() {
        return dataFabricacaoInicial;
    }

    public void setDataFabricacaoInicial(LocalDate dataFabricacaoInicial) {
        this.dataFabricacaoInicial = dataFabricacaoInicial;
    }

    public LocalDate getDataFabricacaoFinal() {
        return dataFabricacaoFinal;
    }

    public void setDataFabricacaoFinal(LocalDate dataFabricacaoFinal) {
        this.dataFabricacaoFinal = dataFabricacaoFinal;
    }
}
