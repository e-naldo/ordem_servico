package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento save(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    public Equipamento findById(Integer id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Equipamento findByNumeroSerie(String numeroSerie) {
        return equipamentoRepository.findByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public List<Equipamento> findByFilter(EquipamentoConsultaDto dto) {
        List<Equipamento> equipamentos = equipamentoRepository.findAllByFilter(
                dto.getTipoEquipamento(),
                dto.getMarcaEquipamento(),
                dto.getModeloEquipamento(),
                dto.getCliente(),
                dto.getDataFabricacaoInicial(),
                dto.getDataFabricacaoFinal(),
                dto.getNumeroSerie(),
                dto.getInativo()
        );
        return equipamentos;
    }
}
