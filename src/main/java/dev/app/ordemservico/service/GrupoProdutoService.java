package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.GrupoProduto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.GrupoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepository;

    public GrupoProduto save(GrupoProduto grupoProduto){
        return grupoProdutoRepository.save(grupoProduto);
    }

    public GrupoProduto findById(Integer id){
        GrupoProduto grupoProduto = grupoProdutoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());

        return grupoProduto;
    }

    public List<GrupoProduto> findAll(){
        return grupoProdutoRepository.findAll();
    }
}
