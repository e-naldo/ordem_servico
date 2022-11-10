package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.domain.Os;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ItemProdutoOsRepository;
import dev.app.ordemservico.repository.OsRepository;
import dev.app.ordemservico.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsService {

    @Autowired
    private OsRepository osRepository;

    public Os save(Os os){
        return osRepository.save(os);
    }

    public Os findById(Integer id){
        Os os = osRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        return os;
    }

    public List<Os> findAll(){
        List<Os> listaOs = osRepository.findAll();
        return listaOs;
    }

    public Os addItemProdutoOs(Integer osId, ItemProdutoOs item){
        Os os = osRepository.findById(osId)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
        os.adicionarItemProdutoOs(item);
        return osRepository.save(os);
    }

}
