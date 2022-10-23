package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @EntityGraph(attributePaths = "enderecos")
    List<Cliente> findAll();

    @EntityGraph(attributePaths = "enderecos")
    Optional<Cliente> findById(Integer id);

    @EntityGraph(attributePaths = "enderecos")
    Optional<Cliente> findByDocumento(String documento);

    @Query("select c from Cliente c where " +
            "(:nome is null or lower(c.nome) like lower(concat('%', :nome, '%'))) and" +
            "(:documento is null or c.documento like :documento) and" +
            "(:email is null or c.email like :email) and" +
            "(:telefone is null or c.telefone like :telefone)")
    List<Cliente> findByFilter(String nome, String documento, String email, String telefone);

}
