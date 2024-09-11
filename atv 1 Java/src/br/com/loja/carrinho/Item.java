package br.com.loja.carrinho;

public class Item {
    private String codigo;
    private String descricao;
    private double valor;
    private double acrescimo;
    private double desconto;

    // Construtor
    public Item(String codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.acrescimo = 0;
        this.desconto = 0;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor + acrescimo - desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public double getDesconto() {
        return desconto;
    }

    // Setters
    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
