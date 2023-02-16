package itau.canais.api.modules.dto;

import itau.canais.api.modules.entities.Conta;

import java.math.BigDecimal;

public record DadosListagemContas(
        String cpf,
        String agencia,
        String nconta,
        BigDecimal saldo) {

    public DadosListagemContas(Conta conta){
        this(conta.getCpf(), conta.getAgencia(), conta.getNconta(), conta.getSaldo());
    }
}
