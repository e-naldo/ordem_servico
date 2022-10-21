package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.ModeloEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloEquipamentoRepository extends JpaRepository<ModeloEquipamento, Integer> {
}