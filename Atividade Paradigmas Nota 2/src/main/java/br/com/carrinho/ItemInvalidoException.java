package br.com.carrinho;

public class ItemInvalidoException extends RuntimeException {
    public ItemInvalidoException(String message) {
        super(message);
    }
}
