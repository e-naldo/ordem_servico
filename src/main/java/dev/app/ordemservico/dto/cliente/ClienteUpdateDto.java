package dev.app.ordemservico.dto.cliente;

import dev.app.ordemservico.domain.Cliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteUpdateDto {

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 150)
    private String nome;
    @Size(min = 14, max = 14) @CNPJ(message = "CNPJ inválido")
    private String documento;
    @NotNull @NotBlank
    @Email(message = "formato de email inválido")
    private String email;
    private String site;
    @NotNull
    private String telefone;
    private List<EnderecoDto> enderecos = new ArrayList<>();

   /* public ClienteUpdateDto() {
    }*/

    public Cliente atualizar(Cliente cliente){
        cliente.setNome(this.nome);
        cliente.setDocumento(this.documento);
        cliente.setEmail(this.email);
        cliente.setSite(this.site);
        cliente.setTelefone(this.telefone);
        cliente.setEnderecos(EnderecoDto.converterLista(enderecos));
        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

}
