package dev.app.ordemservico.dto;

import java.time.LocalDate;

public class EquipamentoDto {

    private Integer id;
    private TipoEquipamentoDto tipoEquipamento;
    private MarcaEquipamentoDto marcaEquipamento;
    private ModeloEquipamentoDto modeloEquipamento;
    private ClienteDto cliente;
    private EnderecoDto endereco;
    private String numeroSerie;
    private String numeroLote;
    private LocalDate dataFabricacao;
    private LocalDate dataFimGarantia;
    private LocalDate dataCadastro;
    private String observacao;
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

    public MarcaEquipamentoDto getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(MarcaEquipamentoDto marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public ModeloEquipamentoDto getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(ModeloEquipamentoDto modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
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
