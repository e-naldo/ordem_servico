package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.ModeloEquipamento;
import dev.app.ordemservico.dto.ModeloEquipamentoDto;
import org.springframework.stereotype.Component;

@Component
public class ModeloEquipamentoMapper {

    public ModeloEquipamento toEntity(ModeloEquipamentoDto modeloEquipamentoDto){
        ModeloEquipamento modeloEquipamento = new ModeloEquipamento();
        modeloEquipamento.setNome(modeloEquipamentoDto.getNome());
        return modeloEquipamento;
    }

    public ModeloEquipamentoDto toDto(ModeloEquipamento modeloEquipamento){
        ModeloEquipamentoDto modeloEquipamentoDto = new ModeloEquipamentoDto();
        modeloEquipamentoDto.setNome(modeloEquipamento.getNome());
        return modeloEquipamentoDto;
    }
}
