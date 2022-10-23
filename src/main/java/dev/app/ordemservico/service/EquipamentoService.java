package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> findAll(){
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        return equipamentos;
    }

    public Equipamento findById(Integer id) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(id);
        if (equipamento.isPresent()) {
            return equipamento.get();
        }
        return null;
    }

    public Equipamento insert(Equipamento equipamento){
        equipamentoRepository.save(equipamento);
        return equipamento;
    }

    public Equipamento findByNumeroSerie(String numeroSerie) {
        Optional<Equipamento> equipamento = equipamentoRepository.findByNumeroSerie(numeroSerie);
        if(!equipamento.isPresent()){
            return null;
        }
        return equipamento.get();
    }

    public List<Equipamento> findByFilter(EquipamentoConsultaDto dto) {
        List<Equipamento> equipamentos = equipamentoRepository.findByFilter(
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
