package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.MarcaEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaEquipamentoRepository extends JpaRepository<MarcaEquipamento, Integer> {
}