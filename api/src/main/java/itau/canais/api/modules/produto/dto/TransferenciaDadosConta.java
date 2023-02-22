package itau.canais.api.modules.produto.dto;

import java.math.BigDecimal;

public record TransferenciaDadosConta(
        String agencia,
        String nconta,
        String cpf,
        BigDecimal saldo) {

}
