package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.ModeloEquipamento;
import dev.app.ordemservico.repository.ModeloEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeloEquipamentoService {

    @Autowired
    private ModeloEquipamentoRepository modeloEquipamentoRepository;

    public ModeloEquipamento findById(Integer id){
        Optional<ModeloEquipamento> modeloEquipamento = modeloEquipamentoRepository.findById(id);
        if(modeloEquipamento.isPresent()){
            return modeloEquipamento.get();
        }
        return null;
    }

}
