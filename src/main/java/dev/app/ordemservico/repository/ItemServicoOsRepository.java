package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.domain.ItemServicoOs;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemServicoOsRepository extends JpaRepository<ItemServicoOs, Integer> {

    @EntityGraph(attributePaths = {"cliente", "produto"} )
    Optional<ItemServicoOs> findById(Integer id);

    @EntityGraph(attributePaths = {"cliente", "produto"} )
    List<ItemServicoOs> findAll();

}
