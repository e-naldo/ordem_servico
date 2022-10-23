package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Cliente;
import dev.app.ordemservico.domain.Equipamento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    @EntityGraph(attributePaths = {"tipoEquipamento", "marcaEquipamento", "modeloEquipamento", "cliente", "endereco"})
    List<Equipamento> findAll();

    @EntityGraph(attributePaths = {"tipoEquipamento", "marcaEquipamento", "modeloEquipamento", "cliente", "endereco"})
    Optional<Equipamento> findById(Integer id);

    @EntityGraph(attributePaths = {"tipoEquipamento", "marcaEquipamento", "modeloEquipamento", "cliente", "endereco"})
    Optional<Equipamento> findByNumeroSerie(String numeroSerie);

    @EntityGraph(attributePaths = {"tipoEquipamento", "marcaEquipamento", "modeloEquipamento", "cliente", "endereco"})
    @Query("select e from Equipamento e where " +
            "(:tipoEquipamentoId is null or e.tipoEquipamento.id = :tipoEquipamentoId) and" +
            "(:marcaEquipamentoId is null or e.marcaEquipamento.id = :marcaEquipamentoId) and" +
            "(:modeloEquipamentoId is null or e.modeloEquipamento.id = :modeloEquipamentoId) and" +
            "(:clienteId is null or e.cliente.id = :clienteId) and" +
            "(:dataFabricacaoInicial is null or e.dataFabricacao >= :dataFabricacaoInicial) and" +
            "(:dataFabricacaoFinal is null or e.dataFabricacao <= :dataFabricacaoFinal) and" +
            "(:numeroSerie is null or e.numeroSerie like :numeroSerie) and" +
            "(:inativo is null or e.inativo = :inativo)")
    List<Equipamento> findByFilter(Integer tipoEquipamentoId,
                                   Integer marcaEquipamentoId,
                                   Integer modeloEquipamentoId,
                                   Integer clienteId,
                                   LocalDate dataFabricacaoInicial,
                                   LocalDate dataFabricacaoFinal,
                                   String numeroSerie,
                                   Boolean inativo);
}
