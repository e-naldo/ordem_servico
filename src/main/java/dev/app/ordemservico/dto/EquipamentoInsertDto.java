package dev.app.ordemservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EquipamentoInsertDto {
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
    private Integer endereco;
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

    public EquipamentoInsertDto(Integer tipoEquipamento, Integer marcaEquipamento, Integer modeloEquipamento, Integer cliente, Integer endereco, String numeroSerie, String numeroLote, LocalDate dataFabricacao, LocalDate dataFimGarantia, String observacao) {
        this.tipoEquipamento = tipoEquipamento;
        this.marcaEquipamento = marcaEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.cliente = cliente;
        this.endereco = endereco;
        this.numeroSerie = numeroSerie;
        this.numeroLote = numeroLote;
        this.dataFabricacao = dataFabricacao;
        this.dataFimGarantia = dataFimGarantia;
        this.dataCadastro = LocalDate.now();
        this.observacao = observacao;
        this.inativo = false;
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

    public Integer getEndereco() {
        return endereco;
    }

    public void setEndereco(Integer endereco) {
        this.endereco = endereco;
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
