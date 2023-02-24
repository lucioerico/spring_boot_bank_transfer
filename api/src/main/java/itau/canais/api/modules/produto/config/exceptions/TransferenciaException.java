package itau.canais.api.modules.produto.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TransferenciaException extends RuntimeException {
    public TransferenciaException(String message) {
        super(message);
    }
}


