package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    Optional<Servico> findByReferencia(String referencia);

    @Query("select s from Servico s where " +
            "(:id is null or s.id = :id) and" +
            "(:nome is null or lower(s.nome) like lower(concat('%', :nome, '%'))) and" +
            "(:referencia is null or s.referencia = :referencia)")
    List<Servico> findAllByFilter(Integer id,
                                  String nome,
                                  String referencia);
}
