package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.ModeloEquipamento;
import dev.app.ordemservico.dto.MarcaEquipamentoDto;
import dev.app.ordemservico.dto.ModeloEquipamentoDto;
import dev.app.ordemservico.dto.ModeloEquipamentoInsertDto;
import dev.app.ordemservico.service.MarcaEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModeloEquipamentoMapper {

    @Autowired
    MarcaEquipamentoService marcaEquipamentoService;

    public ModeloEquipamento toEntity(ModeloEquipamentoInsertDto dto){
        ModeloEquipamento modeloEquipamento = new ModeloEquipamento();
        modeloEquipamento.setMarcaEquipamento(marcaEquipamentoService.findById(dto.getMarcaEquipamento()));
        modeloEquipamento.setNome(dto.getNome());
        return modeloEquipamento;
    }

    public ModeloEquipamentoDto toDto(ModeloEquipamento modeloEquipamento){
        ModeloEquipamentoDto modeloEquipamentoDto = new ModeloEquipamentoDto();
        modeloEquipamentoDto.setId(modeloEquipamento.getId());
        modeloEquipamentoDto.setNome(modeloEquipamento.getNome());
        modeloEquipamentoDto.setMarcaEquipamento(new MarcaEquipamentoMapper().toDto(modeloEquipamento.getMarcaEquipamento()));
        return modeloEquipamentoDto;
    }

    public List<ModeloEquipamentoDto> toListDto(List<ModeloEquipamento> listDto){
        return listDto.stream().map(new ModeloEquipamentoMapper()::toDto).collect(Collectors.toList());
    }

    public ModeloEquipamento toUpdateEntity(ModeloEquipamento modeloEquipamento, ModeloEquipamentoDto dto){
        modeloEquipamento.setNome(dto.getNome());
        return modeloEquipamento;
    }
}
