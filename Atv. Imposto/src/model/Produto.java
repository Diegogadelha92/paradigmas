package br.com.subsistema.model;

public class Produto {
    private String nome;
    private double valor;
    private boolean industrial;
    private boolean servico;
    public Produto(String nome, double valor, boolean industrial, boolean servico) {
        this.nome = nome;
        this.valor = valor;
        this.industrial = industrial;
        this.servico = servico;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public boolean isIndustrial() {
        return industrial;
    }

    public boolean isServico() {
        return servico;
    }
}
