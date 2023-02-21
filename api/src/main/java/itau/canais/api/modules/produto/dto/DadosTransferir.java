package itau.canais.api.modules.produto.dto;

import java.math.BigDecimal;

public record DadosTransferir(
        String agencia,
        String nconta,
        String cpf,
        BigDecimal saldo,
        BigDecimal valorTransferencia,
        Operacao operacao){
}
