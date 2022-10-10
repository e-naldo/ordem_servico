package dev.app.ordemservico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.app.ordemservico.dto.EnderecoDto;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco extends EntidadeBase {

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;

    private String descricao;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String municipio;

    private String uf;

    private String cep;
    @Column(name = "endereco_cobranca")
    private Boolean enderecoCobranca;

    @Column(name = "endereco_entrega")
    private Boolean enderecoEntrega;

    @Column(name = "endereco_servico")
    private Boolean enderecoServico;

    public Endereco() {
    }

    public Endereco(String descricao, String logradouro, String numero, String complemento, String bairro, String municipio, String uf, String cep, Boolean enderecoCobranca, Boolean enderecoEntrega, Boolean enderecoServico) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.cep = cep;
        this.enderecoCobranca = enderecoCobranca;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoServico = enderecoServico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(Boolean enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public Boolean getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Boolean enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Boolean getEnderecoServico() {
        return enderecoServico;
    }

    public void setEnderecoServico(Boolean enderecoServico) {
        this.enderecoServico = enderecoServico;
    }
}
