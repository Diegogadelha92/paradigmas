package br.com.balanca.exceptions;

public class ProdutoInvalidoException extends RuntimeException {
    public ProdutoInvalidoException(String message) {
        super(message);
    }
}
