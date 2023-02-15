package itau.canais.api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosDepositar(
        BigDecimal saldo,
        String agencia,
        String nconta) {
}
