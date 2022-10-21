package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.dto.TipoEquipamentoDto;
import org.springframework.stereotype.Component;

@Component
public class TipoEquipamentoMapper {

    public TipoEquipamento converterParaEntidade(TipoEquipamentoDto tipoEquipamentoDto){
        TipoEquipamento tipoEquipamento = new TipoEquipamento();
        tipoEquipamento.setNome(tipoEquipamentoDto.getNome());
        return tipoEquipamento;
    }

    public TipoEquipamentoDto converterParaDto(TipoEquipamento tipoEquipamento){
        TipoEquipamentoDto tipoEquipamentoDto = new TipoEquipamentoDto();
        tipoEquipamentoDto.setNome(tipoEquipamento.getNome());
        return tipoEquipamentoDto;
    }
}
