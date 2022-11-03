package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Equipamento;
import dev.app.ordemservico.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByReferencia(String referencia);

    @Query("select p from Produto p where " +
            "(:id is null or p.id = :id) and" +
            "(:nome is null or lower(p.nome) like lower(concat('%', :nome, '%'))) and" +
            "(:grupoProduto is null or p.grupoProduto.id = :grupoProduto) and" +
            "(:referencia is null or p.referencia = :referencia)")
    List<Produto> findAllByFilter(Integer id,
                                  Integer grupoProduto,
                                  String nome,
                                  String referencia);
}
