package dev.app.ordemservico.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipamento")
public class Equipamento extends EntidadeBase {

    @ManyToOne
    @JoinColumn(name = "tipo_equipamento_id")
    private TipoEquipamento tipoEquipamento;

    @ManyToOne
    @JoinColumn(name = "marca_equipamento_id")
    private MarcaEquipamento marcaEquipamento;

    @ManyToOne
    @JoinColumn(name = "modelo_equipamento_id")
    private ModeloEquipamento modeloEquipamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoLocalizacao;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "numero_lote")
    private String numeroLote;

    @Column(name = "data_fabricacao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataFabricacao;

    @Column(name = "data_fim_garantia")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataFimGarantia;

    @Column(name = "data_cadastro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataCadastro;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "inativo")
    private Boolean inativo;

    public Equipamento() {
    }

    public Equipamento(TipoEquipamento tipoEquipamento, MarcaEquipamento marcaEquipamento, ModeloEquipamento modeloEquipamento, Cliente cliente, String numeroSerie) {
        this.tipoEquipamento = tipoEquipamento;
        this.marcaEquipamento = marcaEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.cliente = cliente;
        this.numeroSerie = numeroSerie;
        this.inativo = false;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public MarcaEquipamento getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(MarcaEquipamento marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public ModeloEquipamento getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(ModeloEquipamento modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoLocalizacao() {
        return enderecoLocalizacao;
    }

    public void setEnderecoLocalizacao(Endereco enderecoLocalizacao) {
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
