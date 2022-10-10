package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @EntityGraph(attributePaths = "enderecos")
    Optional<Cliente> findById(Integer id);

    @EntityGraph(attributePaths = "enderecos")
    List<Cliente> findAll();

}
