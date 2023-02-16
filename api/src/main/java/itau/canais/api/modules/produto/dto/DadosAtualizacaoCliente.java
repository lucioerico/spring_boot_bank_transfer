package itau.canais.api.modules.produto.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        String cpf,
        String nome,
        String senha) {
}
