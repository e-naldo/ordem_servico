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

    public Equipamento toEntity(EquipamentoInsertDto dto){
        Equipamento equipamento = new Equipamento();
        equipamento.setTipoEquipamento(tipoEquipamentoService.findById(dto.getTipoEquipamento()));
        equipamento.setMarcaEquipamento(marcaEquipamentoService.findById(dto.getMarcaEquipamento()));
        equipamento.setModeloEquipamento(modeloEquipamentoService.findById(dto.getModeloEquipamento()));
        equipamento.setCliente(clienteService.findById(dto.getCliente()));
        equipamento.setEnderecoLocalizacao(enderecoService.findById(dto.getEnderecoLocalizacao()));

        equipamento.setNumeroSerie(dto.getNumeroSerie());
        equipamento.setNumeroLote(dto.getNumeroLote());
        equipamento.setDataFabricacao(dto.getDataFabricacao());
        equipamento.setDataFimGarantia(dto.getDataFimGarantia());
        equipamento.setDataCadastro(dto.getDataCadastro());
        equipamento.setObservacao(dto.getObservacao());
        equipamento.setInativo(dto.getInativo());

        return equipamento;
    }

    public Equipamento toUpdateEntity(Equipamento equipamento, EquipamentoUpdateDto dto){
        equipamento.setTipoEquipamento(tipoEquipamentoService.findById(dto.getTipoEquipamento()));
        equipamento.setMarcaEquipamento(marcaEquipamentoService.findById(dto.getMarcaEquipamento()));
        equipamento.setModeloEquipamento(modeloEquipamentoService.findById(dto.getModeloEquipamento()));
        equipamento.setCliente(clienteService.findById(dto.getCliente()));
        equipamento.setEnderecoLocalizacao(enderecoService.findById(dto.getEnderecoLocalizacao()));

        equipamento.setNumeroSerie(dto.getNumeroSerie());
        equipamento.setNumeroLote(dto.getNumeroLote());
        equipamento.setDataFabricacao(dto.getDataFabricacao());
        equipamento.setDataFimGarantia(dto.getDataFimGarantia());
        equipamento.setObservacao(dto.getObservacao());
        equipamento.setInativo(dto.getInativo());

        return equipamento;
    }

    public EquipamentoDto toDto(Equipamento equipamento){
        EquipamentoDto dto = new EquipamentoDto();
        dto.setId(equipamento.getId());
        dto.setTipoEquipamento(new TipoEquipamentoMapper().toDto(equipamento.getTipoEquipamento()));
        dto.setModeloEquipamento(new ModeloEquipamentoMapper().toDto(equipamento.getModeloEquipamento()));
        dto.setEnderecoLocalizacao(new EnderecoMapper().toDto(equipamento.getEnderecoLocalizacao()));

        dto.setNumeroSerie(equipamento.getNumeroSerie());
        dto.setDataFimGarantia(equipamento.getDataFimGarantia());
        dto.setInativo(equipamento.getInativo());

        return dto;
    }

    public EquipamentoDetailDto toDetailDto(Equipamento equipamento){
        EquipamentoDetailDto dto = new EquipamentoDetailDto();
        dto.setId(equipamento.getId());
        dto.setTipoEquipamento(new TipoEquipamentoMapper().toDto(equipamento.getTipoEquipamento()));
        dto.setMarcaEquipamento(new MarcaEquipamentoMapper().toDto(equipamento.getMarcaEquipamento()));
        dto.setModeloEquipamento(new ModeloEquipamentoMapper().toDto(equipamento.getModeloEquipamento()));
        dto.setCliente(new ClienteMapper().toDto(equipamento.getCliente()));
        dto.setEndereco(new EnderecoMapper().toDto(equipamento.getEnderecoLocalizacao()));

        dto.setNumeroSerie(equipamento.getNumeroSerie());
        dto.setNumeroLote(equipamento.getNumeroLote());
        dto.setDataFabricacao(equipamento.getDataFabricacao());
        dto.setDataFimGarantia(equipamento.getDataFimGarantia());
        dto.setDataCadastro(equipamento.getDataCadastro());
        dto.setObservacao(equipamento.getObservacao());
        dto.setInativo(equipamento.getInativo());

        return dto;
    }

    public List<EquipamentoDto> toListDto(List<Equipamento> equipamentos){
        return equipamentos.stream().map(new EquipamentoMapper()::toDto).collect(Collectors.toList());
    }

    public List<EquipamentoDetailDto> toListDetailDto(List<Equipamento> equipamentos){
        return equipamentos.stream().map(new EquipamentoMapper()::toDetailDto).collect(Collectors.toList());
    }


}
