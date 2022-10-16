package dev.app.ordemservico.dto.cliente;

import dev.app.ordemservico.domain.Cliente;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDetalheDto extends ClienteDto implements Serializable {
    private final List<EnderecoDto> enderecos;

    public ClienteDetalheDto(Cliente cliente){
        super(cliente);
        this.enderecos = cliente.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList());
    }

    public static List<ClienteDto> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }
}
