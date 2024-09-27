package br.com.subsistema.imposto;

import br.com.subsistema.model.Produto;

public class IPI implements br.com.subsistema.imposto.Imposto {
    @Override
    public double calcular(Produto produto) {
        if (produto.isIndustrial()) {
            return produto.getValor() * 0.12;
        } else {
            return 0;
        }
    }
}
