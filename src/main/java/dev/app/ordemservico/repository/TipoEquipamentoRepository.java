package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.TipoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamento, Integer> {
}