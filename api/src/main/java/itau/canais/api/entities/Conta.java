package itau.canais.api.entities;
import itau.canais.api.dto.DadosConta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="contas")
@Entity(name="Conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
