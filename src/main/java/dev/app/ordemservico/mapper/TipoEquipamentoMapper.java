package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.dto.TipoEquipamentoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoEquipamentoMapper {

    public TipoEquipamento toEntity(TipoEquipamentoDto dto){
        TipoEquipamento tipoEquipamento = new TipoEquipamento();
        tipoEquipamento.setNome(dto.getNome());
        return tipoEquipamento;
    }

    public TipoEquipamentoDto toDto(TipoEquipamento tipoEquipamento){
        TipoEquipamentoDto dto = new TipoEquipamentoDto();
        dto.setId(tipoEquipamento.getId());
        dto.setNome(tipoEquipamento.getNome());
        return dto;
    }

    public List<TipoEquipamentoDto> toListDto(List<TipoEquipamento> listDto){
        return listDto.stream().map(new TipoEquipamentoMapper()::toDto).collect(Collectors.toList());
    }

    public TipoEquipamento toUpdateEntity(TipoEquipamento tipoEquipamento, TipoEquipamentoDto dto){
        tipoEquipamento.setNome(dto.getNome());
        return tipoEquipamento;
    }
}
