package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.domain.Produto;
import dev.app.ordemservico.dto.EquipamentoConsultaDto;
import dev.app.ordemservico.dto.ProdutoConsultaDto;
import dev.app.ordemservico.dto.ProdutoDto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.EquipamentoRepository;
import dev.app.ordemservico.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        produto.calcularPrecos(produto.getPrecoCompra());
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }


    public List<Produto> findByFilter(ProdutoConsultaDto dto) {
        List<Produto> produtos = produtoRepository.findAllByFilter(
                dto.getId(),
                dto.getGrupoProduto(),
                dto.getNome(),
                dto.getReferencia()
        );
        return produtos;
    }
}
