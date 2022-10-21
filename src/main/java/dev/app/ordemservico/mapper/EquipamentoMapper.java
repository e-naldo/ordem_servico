package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.*;
import dev.app.ordemservico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipamentoMapper {

    @Autowired
    private TipoEquipamentoService tipoEquipamentoService;

    @Autowired
    private MarcaEquipamentoService marcaEquipamentoService;

    @Autowired
    private ModeloEquipamentoService modeloEquipamentoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    public Equipamento toEntity(EquipamentoInsertDto equipamentoDto){
        Equipamento equipamento = new Equipamento();
        equipamento.setTipoEquipamento(tipoEquipamentoService.findById(equipamentoDto.getTipoEquipamentoId()));
        equipamento.setMarcaEquipamento(marcaEquipamentoService.findById(equipamentoDto.getMarcaEquipamentoId()));
        equipamento.setModeloEquipamento(modeloEquipamentoService.findById(equipamentoDto.getModeloEquipamentoId()));
        equipamento.setCliente(clienteService.findById(equipamentoDto.getClienteId()));
        equipamento.setEndereco(enderecoService.findById(equipamentoDto.getEnderecoId()));

        equipamento.setNumeroSerie(equipamentoDto.getNumeroSerie());
        equipamento.setNumeroLote(equipamentoDto.getNumeroLote());
        equipamento.setDataFabricacao(equipamentoDto.getDataFabricacao());
        equipamento.setDataFimGarantia(equipamentoDto.getDataFimGarantia());
        equipamento.setDataCadastro(equipamentoDto.getDataCadastro());
        equipamento.setObservacao(equipamentoDto.getObservacao());
        equipamento.setInativo(equipamentoDto.getInativo());

        return equipamento;
    }

    public EquipamentoDto toDto(Equipamento equipamento){
        EquipamentoDto equipamentoDto = new EquipamentoDto();
        equipamentoDto.setId(equipamento.getId());
        equipamentoDto.setTipoEquipamento(new TipoEquipamentoMapper().converterParaDto(equipamento.getTipoEquipamento()));
        equipamentoDto.setMarcaEquipamento(new MarcaEquipamentoMapper().converterParaDto(equipamento.getMarcaEquipamento()));
        equipamentoDto.setModeloEquipamento(new ModeloEquipamentoMapper().converterParaDto(equipamento.getModeloEquipamento()));
        equipamentoDto.setCliente(new ClienteMapper().toBasicDto(equipamento.getCliente()));
        equipamentoDto.setEndereco(new EnderecoMapper().converterParaDto(equipamento.getEndereco()));

        equipamentoDto.setNumeroSerie(equipamento.getNumeroSerie());
        equipamentoDto.setNumeroLote(equipamento.getNumeroLote());
        equipamentoDto.setDataFabricacao(equipamento.getDataFabricacao());
        equipamentoDto.setDataFimGarantia(equipamento.getDataFimGarantia());
        equipamentoDto.setDataCadastro(equipamento.getDataCadastro());
        equipamentoDto.setObservacao(equipamento.getObservacao());
        equipamentoDto.setInativo(equipamento.getInativo());

        return equipamentoDto;
    }

    public List<EquipamentoDto> toListDto(List<Equipamento> equipamentos){
        return equipamentos.stream().map(new EquipamentoMapper()::toDto).collect(Collectors.toList());
    }

}
