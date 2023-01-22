package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.domain.Os;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemProdutoOsRepository extends JpaRepository<ItemProdutoOs, Integer> {

    @EntityGraph(attributePaths = {"produto", "os"} )
    Optional<ItemProdutoOs> findById(Integer id);

    @EntityGraph(attributePaths = {"produto", "os"} )
    List<ItemProdutoOs> findAll();

}
