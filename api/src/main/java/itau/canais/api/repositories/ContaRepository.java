package itau.canais.api.repositories;

import itau.canais.api.entities.Cliente;
import itau.canais.api.entities.Conta;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {

    @Query("SELECT e FROM Conta e WHERE e.agencia = :agencia AND e.nconta = :nconta")
    public Conta buscarContaByAgenciaConta(@Param("agencia") String agencia, @Param("nconta") String nconta);

//    @Query("SELECT e FROM Conta e WHERE e.agencia = :agencia AND e.nconta = :nconta")
//    Optional<Conta> buscarContaByAgenciaConta(@Param("agencia") String agencia, @Param("nconta") String nconta);

}

