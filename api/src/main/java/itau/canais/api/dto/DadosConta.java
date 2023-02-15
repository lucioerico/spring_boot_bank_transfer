package itau.canais.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record DadosConta(
        BigDecimal saldo,
        @NotBlank
        String agencia,
        @NotBlank
        String nconta,
        @NotBlank(message = "CPF Obrigatório")
        @CPF
        String cpf) {
}
