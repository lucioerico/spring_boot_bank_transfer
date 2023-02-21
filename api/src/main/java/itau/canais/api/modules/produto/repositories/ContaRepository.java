package itau.canais.api.modules.produto.repositories;

import itau.canais.api.modules.produto.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {

    @Query("SELECT e FROM Conta e WHERE e.agencia = :agencia AND e.nconta = :nconta")
    public Conta buscarContaByAgenciaConta(@Param("agencia") String agencia, @Param("nconta") String nconta);


    //    @Query("SELECT e.saldo FROM Conta e WHERE e.agencia = :agencia AND e.nconta = :nconta")
//    public BigDecimal buscarSaldoByAgenciaConta(@Param("agencia") String agencia, @Param("nconta")String nconta);
    @Query("SELECT e FROM Conta e WHERE e.agencia = :agencia AND e.nconta = :nconta AND e.saldo = :saldo")
    public Conta buscarSaldoByAgenciaConta(@Param("agencia") String agencia, @Param("nconta") String nconta, @Param("saldo") BigDecimal saldo);


}

