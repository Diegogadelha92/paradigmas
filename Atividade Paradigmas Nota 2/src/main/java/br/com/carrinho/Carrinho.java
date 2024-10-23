package br.com.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new ItemInvalidoException("O item que deve ser adicionado ao carrinho não pode ser nulo");
        }

        this.itens.add(item);
    }

    public Item getItem(int codigo) {
        return this.itens.stream()
                .filter(item -> item.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new ItemNaoEncontradoException("Item não encontrado!"));
    }

    public List<Item> getItens() {
        return itens;
    }
}
