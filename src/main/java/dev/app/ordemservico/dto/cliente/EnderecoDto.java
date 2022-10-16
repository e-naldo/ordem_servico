package dev.app.ordemservico.dto.cliente;

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

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.descricao = endereco.getDescricao();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.municipio = endereco.getMunicipio();
        this.uf = endereco.getUf();
        this.cep = endereco.getCep();
        this.enderecoCobranca = endereco.getEnderecoCobranca();
        this.enderecoEntrega = endereco.getEnderecoEntrega();
        this.enderecoServico = endereco.getEnderecoServico();
    }

/*    public Endereco converter() {
        return new Endereco(descricao, logradouro, numero, complemento, bairro, municipio, uf,
                cep, enderecoCobranca, enderecoEntrega, enderecoServico);
    }*/

    public Endereco converter() {
        Endereco endereco = new Endereco();

        endereco.setId(id);
        endereco.setDescricao(descricao);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setMunicipio(municipio);
        endereco.setUf(uf);
        endereco.setCep(cep);
        endereco.setEnderecoCobranca(enderecoCobranca);
        endereco.setEnderecoEntrega(enderecoEntrega);
        endereco.setEnderecoServico(enderecoServico);

        return endereco;
    }

    public static List<Endereco> converterLista(List<EnderecoDto> enderecos) {
        return enderecos.stream().map(EnderecoDto::converter).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public Boolean getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public Boolean getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public Boolean getEnderecoServico() {
        return enderecoServico;
    }
}
