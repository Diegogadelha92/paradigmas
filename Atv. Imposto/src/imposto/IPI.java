package br.com.subsistema.imposto;

import br.com.subsistema.model.Produto;

public class IPI implements br.com.subsistema.imposto.Imposto {
    @Override
    public double calcular(Produto produto) {
        return produto.isIndustrial() ? produto.getValor() * 0.12 : 0;
    }
}
