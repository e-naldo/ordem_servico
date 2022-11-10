package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Os;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsRepository extends JpaRepository<Os, Integer> {

    @EntityGraph(attributePaths = {"cliente", "equipamento", "produtos", "servicos"} )
    Optional<Os> findById(Integer id);

    @EntityGraph(attributePaths = {"cliente", "equipamento", "produtos", "servicos"} )
    List<Os> findAll();

}
