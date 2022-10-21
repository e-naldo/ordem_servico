package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.dto.MarcaEquipamentoDto;
import org.springframework.stereotype.Component;

@Component
public class MarcaEquipamentoMapper {

    public MarcaEquipamento converterParaEntidade(MarcaEquipamentoDto marcaEquipamentoDto){
        MarcaEquipamento marcaEquipamento = new MarcaEquipamento();
        marcaEquipamento.setNome(marcaEquipamentoDto.getNome());
        return marcaEquipamento;
    }

    public MarcaEquipamentoDto converterParaDto(MarcaEquipamento marcaEquipamento){
        MarcaEquipamentoDto marcaEquipamentoDto = new MarcaEquipamentoDto();
        marcaEquipamentoDto.setNome(marcaEquipamento.getNome());
        return marcaEquipamentoDto;
    }
}
