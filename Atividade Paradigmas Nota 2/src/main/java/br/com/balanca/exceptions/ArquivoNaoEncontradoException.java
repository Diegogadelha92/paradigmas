package br.com.balanca.exceptions;

public class ArquivoNaoEncontradoException extends RuntimeException {
    public ArquivoNaoEncontradoException(String message) {
        super(message);
    }
}
