package br.com.balanca.models;

import br.com.balanca.exceptions.TipoInvalidoException;

import java.util.List;

public class Produto {
    private int codigo;
    private String descricao;
    private String tipo;
    private double valor;
    private static final List<String> tiposValidos = List.of("9");

    public Produto() {
    }

    public Produto(int codigo, String descricao, String tipo, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tiposValidos.contains(tipo)) {
            throw new TipoInvalidoException("Tipo não condiz com a lista de tipos permitidos");
        }

        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
