package br.com.subsistema.imposto;

import br.com.subsistema.model.Produto;

public class ISS implements br.com.subsistema.imposto.Imposto {
    @Override
    public double calcular(Produto servico) {
        return servico.getValor() * 0.05;
    }
}
