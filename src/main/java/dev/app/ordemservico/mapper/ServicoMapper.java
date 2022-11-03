package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Servico;
import dev.app.ordemservico.dto.ServicoDto;
import dev.app.ordemservico.dto.ServicoInsertDto;
import dev.app.ordemservico.dto.ServicoUpdateDto;
import dev.app.ordemservico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicoMapper {

    @Autowired
    private ServicoService servicoService;

    public Servico toEntity(ServicoInsertDto dto){
        Servico servico = new Servico();
        servico.setReferencia(dto.getReferencia());
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setPreco(dto.getPreco());

        return servico;
    }

    public Servico toUpdateEntity(Servico servico, ServicoUpdateDto dto){
        servico.setReferencia(dto.getReferencia());
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setPreco(dto.getPreco());

        return servico;
    }

    public ServicoDto toDto(Servico servico){
        ServicoDto dto = new ServicoDto();
        dto.setId(servico.getId());
        dto.setReferencia(servico.getReferencia());
        dto.setNome(servico.getNome());
        dto.setDescricao(servico.getDescricao());
        dto.setPreco(servico.getPreco());
        return dto;
    }

    public List<ServicoDto> toListDto(List<Servico> servicos){
        return servicos.stream()
                .map(new ServicoMapper()::toDto)
                .collect(Collectors.toList());
    }
}
