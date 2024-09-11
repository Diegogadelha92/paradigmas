package br.com.loja.carrinho;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }


    public void aplicarAcrescimoAoItem(String codigo, double acrescimo) {
        Item item = encontrarItemPorCodigo(codigo);
        if (item != null) {
            item.setAcrescimo(acrescimo);
        }
    }

    public void aplicarDescontoAoItem(String codigo, double desconto) {
        Item item = encontrarItemPorCodigo(codigo);
        if (item != null) {
            item.setDesconto(desconto);
        }
    }

    public void aplicarAcrescimoTotal(double valorDoAcrescimo) {
        distribuirValor(valorDoAcrescimo, true);
    }

    public void aplicarDescontoTotal(double valorDesconto) {
        distribuirValor(valorDesconto, false);
    }

    public void finalizarVenda() {
        double totalAcrescimos = 0, totalDescontos = 0, total = 0;

        System.out.println("Itens do Carrinho: ");
        for (Item item : itens) {
            System.out.println(item.getDescricao() + " - valor: " + item.getValor());
            totalAcrescimos += item.getAcrescimo();
            totalDescontos += item.getDesconto();
            total += item.getValor();
        }

        System.out.println("Acréscimo total: " + totalAcrescimos);
        System.out.println("Desconto total: " + totalDescontos);
        System.out.println("Valor total: " + total);
    }

    private Item encontrarItemPorCodigo(String codigo) {
        for (Item item : itens) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    private void distribuirValor(double valor, boolean isAcrescimo) {

        double valorDistribuido = valor / itens.size();
        for (Item item : itens) {
            if (isAcrescimo) {
                item.setAcrescimo(item.getAcrescimo() + valorDistribuido);
            } else {
                item.setDesconto(item.getDesconto() + valorDistribuido);
            }
        }
    }
}
