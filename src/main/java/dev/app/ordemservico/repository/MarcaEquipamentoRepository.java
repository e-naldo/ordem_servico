package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.MarcaEquipamento;
import dev.app.ordemservico.domain.TipoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaEquipamentoRepository extends JpaRepository<MarcaEquipamento, Integer> {
    List<MarcaEquipamento> findByNomeContainingIgnoreCase(String nome);
}