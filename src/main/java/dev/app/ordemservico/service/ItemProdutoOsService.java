package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.domain.Os;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ItemProdutoOsRepository;
import dev.app.ordemservico.repository.OsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemProdutoOsService {

    @Autowired
    private ItemProdutoOsRepository itemProdutoOsRepository;

    public ItemProdutoOs findById(Integer id){
        ItemProdutoOs os = itemProdutoOsRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return os;
    }

    public List<ItemProdutoOs> findAll(){
        List<ItemProdutoOs> listaOs = itemProdutoOsRepository.findAll();
        return listaOs;
    }

}
