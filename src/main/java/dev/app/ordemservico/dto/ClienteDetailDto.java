package dev.app.ordemservico.dto;

import java.time.LocalDate;
import java.util.List;

public class ClienteDetailDto {

    private Integer id;
    private String nome;
    private String tipo;
    private String documento;
    private String email;
    private String site;
    private String telefone;
    private LocalDate dataCadastro;
    private List<EnderecoDto> enderecos;

    public ClienteDetailDto() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
        this.enderecos = enderecos;
    }
}
