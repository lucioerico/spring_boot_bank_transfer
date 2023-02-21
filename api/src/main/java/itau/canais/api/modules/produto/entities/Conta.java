package itau.canais.api.modules.produto.entities;

import itau.canais.api.modules.produto.dto.DadosConta;
import itau.canais.api.modules.produto.dto.DadosDepositar;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "contas")
@Entity(name = "Conta")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {
    @Id
    private String agencia;
    private String nconta;
    private BigDecimal saldo;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    private Cliente cliente;

    public Conta(DadosConta dadosConta) {
        this.agencia = dadosConta.agencia();
        this.nconta = dadosConta.nconta();
        this.saldo = dadosConta.saldo();
        this.cpf = dadosConta.cpf();
    }

    public Conta(String agencia, String nconta, BigDecimal saldo, String cpf, Cliente cliente) {
    }

    public Conta(String agencia, String nconta, BigDecimal saldo) {
    }

    public void depositar(DadosDepositar dados) {
        if (dados.saldo() != null) {
            this.saldo = this.saldo.add(dados.saldo());
        }
    }

}
