package br.com.carrinho;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private int codigo;
    private String descrica;
    private BigDecimal valor;
    private BigDecimal acrescimo;
    private BigDecimal desconto;

    public Item(int codigo, String descrica, BigDecimal valor) {
        this.codigo = codigo;
        this.descrica = descrica;
        this.valor = valor;
        this.acrescimo = BigDecimal.ZERO;
        this.desconto = BigDecimal.ZERO;
    }

    public void setValor(BigDecimal valor) {
        if (valor.signum() == -1) {
            throw new IllegalArgumentException("Valor deve ser maior ou igual que zero");
        }

        this.valor = valor;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        if (valor.signum() == -1) {
            throw new IllegalArgumentException("Valor do acréscimo deve ser maior ou igual que zero");
        }

        this.acrescimo = acrescimo;
    }

    public void setDesconto(BigDecimal desconto) {
        if (valor.signum() == -1) {
            throw new IllegalArgumentException("Valor do desconto deve ser maior ou igual que zero");
        }

        this.desconto = desconto;
    }
}
