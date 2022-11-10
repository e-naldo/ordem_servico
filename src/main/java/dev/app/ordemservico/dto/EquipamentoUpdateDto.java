package dev.app.ordemservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EquipamentoUpdateDto {

    private Integer id;

    @NotNull
    @Positive
    private Integer tipoEquipamento;

    @NotNull
    @Positive
    private Integer marcaEquipamento;

    @NotNull
    @Positive
    private Integer modeloEquipamento;

    @NotNull
    @Positive
    private Integer cliente;

    @NotNull
    @Positive
    private Integer enderecoLocalizacao;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String numeroSerie;
    private String numeroLote;
    private LocalDate dataFabricacao;
    private LocalDate dataFimGarantia;
    private String observacao;
    private Boolean inativo;

    public EquipamentoUpdateDto(Integer id, Integer tipoEquipamento, Integer marcaEquipamento, Integer modeloEquipamento, Integer cliente, Integer endereco, String numeroSerie, String numeroLote, LocalDate dataFabricacao, LocalDate dataFimGarantia, String observacao) {
        this.id = id;
        this.tipoEquipamento = tipoEquipamento;
        this.marcaEquipamento = marcaEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.cliente = cliente;
        this.enderecoLocalizacao = endereco;
        this.numeroSerie = numeroSerie;
        this.numeroLote = numeroLote;
        this.dataFabricacao = dataFabricacao;
        this.dataFimGarantia = dataFimGarantia;
        this.observacao = observacao;
        this.inativo = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getEnderecoLocalizacao() {
        return enderecoLocalizacao;
    }

    public void setEnderecoLocalizacao(Integer enderecoLocalizacao) {
        this.enderecoLocalizacao = enderecoLocalizacao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFimGarantia() {
        return dataFimGarantia;
    }

    public void setDataFimGarantia(LocalDate dataFimGarantia) {
        this.dataFimGarantia = dataFimGarantia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
}
