package br.com.balanca.exceptions;

public class TipoInvalidoException extends RuntimeException {
    public TipoInvalidoException(String message) {
        super(message);
    }
}
