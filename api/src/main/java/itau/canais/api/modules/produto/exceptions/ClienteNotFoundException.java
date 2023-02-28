package itau.canais.api.modules.produto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ClienteNotFoundException extends Throwable {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}