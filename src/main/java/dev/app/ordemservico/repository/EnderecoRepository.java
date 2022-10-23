package dev.app.ordemservico.repository;

import dev.app.ordemservico.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("select e from Endereco e where e.id =:enderecoId and e.cliente.id =:clienteId")
    Optional<Endereco> findByClienteIdAndEnderecoId(Integer clienteId, Integer enderecoId);

}
