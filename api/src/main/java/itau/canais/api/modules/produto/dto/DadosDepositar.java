package itau.canais.api.modules.produto.dto;

import java.math.BigDecimal;

public record DadosDepositar(
        BigDecimal saldo,
        String agencia,
        String nconta) {
}
