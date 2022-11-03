package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.ModeloEquipamento;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ModeloEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloEquipamentoService {

    @Autowired
    private ModeloEquipamentoRepository modeloEquipamentoRepository;

    public ModeloEquipamento save(ModeloEquipamento modeloEquipamento){
        return modeloEquipamentoRepository.save(modeloEquipamento);
    }

    public ModeloEquipamento findById(Integer id){
       ModeloEquipamento modeloEquipamento = modeloEquipamentoRepository.findById(id)
               .orElseThrow(() -> new RecursoNaoEncontradoException());

        return modeloEquipamento;
    }

    public List<ModeloEquipamento> findAll(){
        return modeloEquipamentoRepository.findAll();
    }

}
