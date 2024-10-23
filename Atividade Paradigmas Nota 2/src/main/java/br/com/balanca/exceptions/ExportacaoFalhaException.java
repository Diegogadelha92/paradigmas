package br.com.balanca.exceptions;

public class ExportacaoFalhaException extends RuntimeException {
    public ExportacaoFalhaException(String message) {
        super(message);
    }
}
