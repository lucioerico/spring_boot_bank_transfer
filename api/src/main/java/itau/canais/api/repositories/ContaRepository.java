package itau.canais.api.repositories;

import itau.canais.api.entities.Cliente;
import itau.canais.api.entities.Conta;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT c FROM Conta c WHERE c.agencia = :agencia AND c.nconta = :conta")
    public Conta buscarContaByAgenciaConta(@Param("agencia") String agencia, @Param("conta") String conta);
}
