package dev.app.ordemservico.dto;

import dev.app.ordemservico.domain.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDetalheDto implements Serializable {
    private final Integer id;
    private final String nome;
    private final String tipo;
    private final String documento;
    private final String email;
    private final String site;
    private final String telefone;
    private final LocalDate dataCadastro;
    private final List<EnderecoDto> enderecos;

    public ClienteDetalheDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.tipo = cliente.getTipo();
        this.documento = cliente.getDocumento();
        this.email = cliente.getEmail();
        this.site = cliente.getSite();
        this.telefone = cliente.getTelefone();
        this.dataCadastro = cliente.getDataCadastro();
        this.enderecos = cliente.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList());
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

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }
}
