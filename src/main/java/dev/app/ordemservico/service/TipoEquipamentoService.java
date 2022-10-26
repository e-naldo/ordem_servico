package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.TipoEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEquipamentoService {

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;

    public TipoEquipamento save(TipoEquipamento tipoEquipamento){
        return tipoEquipamentoRepository.save(tipoEquipamento);
    }

    public TipoEquipamento findById(Integer id) {
        return tipoEquipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public List<TipoEquipamento> findAll(){
        return tipoEquipamentoRepository.findAll();
    }

    public List<TipoEquipamento> findByNome(String nome) {
        return tipoEquipamentoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
