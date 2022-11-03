package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.GrupoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Integer> {
}
