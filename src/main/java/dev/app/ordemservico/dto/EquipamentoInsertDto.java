package dev.app.ordemservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EquipamentoInsertDto {
    @NotNull
    @Positive
    private Integer tipoEquipamentoId;

    @NotNull
    @Positive
    private Integer marcaEquipamentoId;

    @NotNull
    @Positive
    private Integer modeloEquipamentoId;

    @NotNull
    @Positive
    private Integer clienteId;

    @NotNull
    @Positive
    private Integer enderecoId;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String numeroSerie;
    private String numeroLote;
    private LocalDate dataFabricacao;
    private LocalDate dataFimGarantia;
    private LocalDate dataCadastro;
    private String observacao;
    private Boolean inativo;

    public EquipamentoInsertDto(Integer tipoEquipamentoId, Integer marcaEquipamentoId, Integer modeloEquipamentoId, Integer clienteId, Integer enderecoId, String numeroSerie, String numeroLote, LocalDate dataFabricacao, LocalDate dataFimGarantia, String observacao) {
        this.tipoEquipamentoId = tipoEquipamentoId;
        this.marcaEquipamentoId = marcaEquipamentoId;
        this.modeloEquipamentoId = modeloEquipamentoId;
        this.clienteId = clienteId;
        this.enderecoId = enderecoId;
        this.numeroSerie = numeroSerie;
        this.numeroLote = numeroLote;
        this.dataFabricacao = dataFabricacao;
        this.dataFimGarantia = dataFimGarantia;
        this.dataCadastro = LocalDate.now();
        this.observacao = observacao;
        this.inativo = false;
    }

    public Integer getTipoEquipamentoId() {
        return tipoEquipamentoId;
    }

    public void setTipoEquipamentoId(Integer tipoEquipamentoId) {
        this.tipoEquipamentoId = tipoEquipamentoId;
    }

    public Integer getMarcaEquipamentoId() {
        return marcaEquipamentoId;
    }

    public void setMarcaEquipamentoId(Integer marcaEquipamentoId) {
        this.marcaEquipamentoId = marcaEquipamentoId;
    }

    public Integer getModeloEquipamentoId() {
        return modeloEquipamentoId;
    }

    public void setModeloEquipamentoId(Integer modeloEquipamentoId) {
        this.modeloEquipamentoId = modeloEquipamentoId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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
