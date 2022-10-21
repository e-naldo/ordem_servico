package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.repository.TipoEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoEquipamentoService {

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;

    public TipoEquipamento findById(Integer id){
        Optional<TipoEquipamento> tipoEquipamento = tipoEquipamentoRepository.findById(id);
        if(tipoEquipamento.isPresent()){
            return tipoEquipamento.get();
        }
        return null;
    }

}
