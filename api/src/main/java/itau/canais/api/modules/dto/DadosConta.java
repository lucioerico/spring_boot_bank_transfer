package itau.canais.api.modules.dto;

import jakarta.validation.constraints.NotBlank;
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
