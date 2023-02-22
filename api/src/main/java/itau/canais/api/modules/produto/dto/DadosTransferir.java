package itau.canais.api.modules.produto.dto;

import itau.canais.api.modules.produto.entities.Transferencia;

import java.math.BigDecimal;

public record DadosTransferir(
        String agencia,
        String nconta,
        String cpf,
        BigDecimal saldo,
        BigDecimal valorTransferencia,
        Operacao operacao){

    public DadosTransferir(Transferencia transferencia, Operacao operacao){
        this(transferencia.getAgencia(), transferencia.getNconta(), transferencia.getCpf(), transferencia.getValorTransferencia(), transferencia.getSaldo(), operacao);
    }
}


