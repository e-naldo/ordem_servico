package dev.app.ordemservico.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeBase {

    private String nome;

    private String tipo;

    private String documento;

    private String email;

    private String site;

    private String telefone;

    @Column(name = "data_cadastro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataCadastro;

    @OneToMany( mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String tipo, String documento, String email, String site, String telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.documento = documento;
        this.email = email;
        this.site = site;
        this.telefone = telefone;
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(String nome, String documento, String email, String site, String telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.documento = documento;
        this.email = email;
        this.site = site;
        this.telefone = telefone;
    }

    public void adicionarEndereco(Endereco endereco){
        this.enderecos.add(endereco);
        endereco.setCliente(this);
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

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        for (Endereco endereco : enderecos) {
            endereco.setCliente(this);
        }
    }

    public List<Endereco> getEnderecos() {
        return Collections.unmodifiableList(enderecos);
    }


}
