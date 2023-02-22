package itau.canais.api.modules.produto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaRequest {

    private DadosTransferir origem;
    private DadosTransferir destino;
}
