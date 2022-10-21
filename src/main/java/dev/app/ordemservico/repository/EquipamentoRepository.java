package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.domain.Equipamento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

    @EntityGraph(attributePaths = {"tipoEquipamento", "marcaEquipamento","modeloEquipamento", "cliente"})
    List<Equipamento> findAll();
}
