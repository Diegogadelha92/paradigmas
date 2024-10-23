package br.com.carrinho;

import java.math.BigDecimal;

public class CalculadorDesconto implements Calculador{
    @Override
    public Item aplicar(Item item, BigDecimal valor) {
        if (item == null) {
            throw new ItemInvalidoException("O item que deve ser aplicado o desconto não pode ser nulo");
        }

        item.setDesconto(item.getDesconto().add(valor));
        item.setValor(item.getValor().subtract(valor));
        return item;
    }
}
