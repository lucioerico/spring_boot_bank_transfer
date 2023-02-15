package itau.canais.api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosDepositar(
        @NotNull
        BigDecimal saldo,
        @NotNull
        String agencia,
        @NotNull
        String nconta,
        @NotNull
        String cpf) {
}
