package itau.canais.api.entities;
import itau.canais.api.dto.DadosAtualizacaoCliente;
import itau.canais.api.dto.DadosConta;
import itau.canais.api.dto.DadosDepositar;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="contas")
@Entity(name="Conta")
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

            public Conta(String agencia, String nconta, Float saldo) {
            }

            public Conta(String agencia, String nconta, BigDecimal saldo) {
            }
            public void depositar(DadosDepositar dados) {
                if(dados.saldo() != null){
                    this.saldo = this.saldo.add(dados.saldo());                }

//    public void depositar(Conta dados) {
//        this.saldo = this.saldo.add(dados.getSaldo());
////    }
//    public void depositar(Conta conta) {
//        this.saldo = this.saldo.add(conta.getSaldo());
//}
}}
