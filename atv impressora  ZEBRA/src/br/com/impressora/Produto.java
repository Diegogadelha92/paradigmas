package br.com.impressora;
public class Produto {
    private String codigo;
    private String descricao;
    private double preco;
    private String codigoDeBarras;

    public Produto(String codigo, String descricao, double preco, String codigoDeBarras) {
        this.codigo = codigo;

        this.descricao = descricao.length() > 22 ? descricao.substring(0, 22) : descricao;
        this.preco = preco;
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", codigoDeBarras=" + codigoDeBarras + "]";
    }
}


