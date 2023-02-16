package itau.canais.api.modules.produto.dto;

import itau.canais.api.modules.produto.entities.Conta;

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
