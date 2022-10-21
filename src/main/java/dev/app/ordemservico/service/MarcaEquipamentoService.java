package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.repository.MarcaEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaEquipamentoService {

    @Autowired
    private MarcaEquipamentoRepository marcaEquipamentoRepository;

    public MarcaEquipamento findById(Integer id){
        Optional<MarcaEquipamento> marcaEquipamento = marcaEquipamentoRepository.findById(id);
        if(marcaEquipamento.isPresent()){
            return marcaEquipamento.get();
        }
        return null;
    }

}
