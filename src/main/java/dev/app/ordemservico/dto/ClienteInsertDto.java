package dev.app.ordemservico.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertDto {

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 150)
    private String nome;
    @NotNull
    @NotEmpty
    private String tipo;
    @Size(min = 14, max = 14)
    @CNPJ(message = "CNPJ inválido")
    private String documento;
    @NotNull
    @NotBlank
    @Email(message = "formato de email inválido")
    private String email;
    private String site;
    @NotNull
    private String telefone;
    private LocalDate dataCadastro;
    private List<EnderecoDto> enderecos = new ArrayList<>();

    public ClienteInsertDto(String nome, String tipo, String documento, String email, String site, String telefone, List<EnderecoDto> enderecos) {
        this.nome = nome;
        this.tipo = tipo;
        this.documento = documento;
        this.email = email;
        this.site = site;
        this.telefone = telefone;
        this.enderecos = enderecos;
        this.dataCadastro = LocalDate.now();
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

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
        this.enderecos = enderecos;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
