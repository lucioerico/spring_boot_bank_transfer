package itau.canais.api.dto;

import itau.canais.api.entities.Conta;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record DadosCliente(
        @NotBlank(message = "Nome Obrigatório")
        String nome,
        @Size(min = 8, max = 8, message = "A senha deve ter exatamente 8 caracteres")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%&*])(?=.*[0-9])(?=.*[a-z]).{8}$",
                message = "A senha deve conter 8 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
        String senha,
        @NotBlank(message = "CPF Obrigatório")
        @CPF
        String cpf) {
}

