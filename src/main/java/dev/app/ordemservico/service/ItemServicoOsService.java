package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.ItemServicoOs;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ItemServicoOsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServicoOsService {

    @Autowired
    private ItemServicoOsRepository itemServicoOsRepository;

    public ItemServicoOs findById(Integer id){
        ItemServicoOs os = itemServicoOsRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return os;
    }

    public List<ItemServicoOs> findAll(){
        List<ItemServicoOs> listaOs = itemServicoOsRepository.findAll();
        return listaOs;
    }

}
