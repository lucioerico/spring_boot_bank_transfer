package itau.canais.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        String cpf,
        String nome,
        String senha) {
}
