package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.ModeloEquipamento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloEquipamentoRepository extends JpaRepository<ModeloEquipamento, Integer> {
    @EntityGraph( attributePaths = "marcaEquipamento")
    List<ModeloEquipamento> findByNomeContainingIgnoreCase(String nome);
}