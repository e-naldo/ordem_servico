package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.TipoEquipamento;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.MarcaEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaEquipamentoService {

    @Autowired
    private MarcaEquipamentoRepository marcaEquipamentoRepository;

    public MarcaEquipamento save(MarcaEquipamento marcaEquipamento){
        return marcaEquipamentoRepository.save(marcaEquipamento);
    }

    public MarcaEquipamento findById(Integer id){
        MarcaEquipamento marcaEquipamento = marcaEquipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        return marcaEquipamento;
    }

    public List<MarcaEquipamento> findAll(){
        return marcaEquipamentoRepository.findAll();
    }

    public List<MarcaEquipamento> findByNome(String nome) {
        return marcaEquipamentoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
