package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.dto.MarcaEquipamentoDto;
import dev.app.ordemservico.dto.TipoEquipamentoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarcaEquipamentoMapper {

    public MarcaEquipamento toEntity(MarcaEquipamentoDto marcaEquipamentoDto){
        MarcaEquipamento marcaEquipamento = new MarcaEquipamento();
        marcaEquipamento.setNome(marcaEquipamentoDto.getNome());
        return marcaEquipamento;
    }

    public MarcaEquipamentoDto toDto(MarcaEquipamento marcaEquipamento){
        MarcaEquipamentoDto marcaEquipamentoDto = new MarcaEquipamentoDto();
        marcaEquipamentoDto.setId(marcaEquipamento.getId());
        marcaEquipamentoDto.setNome(marcaEquipamento.getNome());
        return marcaEquipamentoDto;
    }

    public List<MarcaEquipamentoDto> toListDto(List<MarcaEquipamento> listDto){
        return listDto.stream().map(new MarcaEquipamentoMapper()::toDto).collect(Collectors.toList());
    }

    public MarcaEquipamento toUpdateEntity(MarcaEquipamento marcaEquipamento, MarcaEquipamentoDto dto){
        marcaEquipamento.setNome(dto.getNome());
        return marcaEquipamento;
    }
}
