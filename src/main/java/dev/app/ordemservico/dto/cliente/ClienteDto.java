package dev.app.ordemservico.dto.cliente;

import dev.app.ordemservico.domain.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto implements Serializable {
    private Integer id;
    private String nome;
    private String tipo;
    private String documento;
    private String email;
    private String site;
    private String telefone;
    private LocalDate dataCadastro;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.tipo = cliente.getTipo();
        this.documento = cliente.getDocumento();
        this.email = cliente.getEmail();
        this.site = cliente.getSite();
        this.telefone = cliente.getTelefone();
        this.dataCadastro = cliente.getDataCadastro();
    }

    public static List<ClienteDto> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getSite() {
        return site;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
}
