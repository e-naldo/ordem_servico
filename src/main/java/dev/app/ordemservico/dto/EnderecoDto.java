package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.Endereco;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDto implements Serializable {
    private Integer id;
    private String descricao;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
    private Boolean enderecoCobranca;
    private Boolean enderecoEntrega;
    private Boolean enderecoServico;

    public EnderecoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
