package br.com.carrinho;

import java.math.BigDecimal;

public class CalculadorAcrescimo implements Calculador{
    @Override
    public Item aplicar(Item item, BigDecimal valor) {
        if (item == null) {
            throw new ItemInvalidoException("O item que deve ser aplicado o acréscimo não pode ser nulo");
        }

        item.setAcrescimo(item.getAcrescimo().add(valor));
        item.setValor(item.getValor().add(valor));
        return item;
    }
}
