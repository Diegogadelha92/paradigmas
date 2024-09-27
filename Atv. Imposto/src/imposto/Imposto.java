package br.com.subsistema.imposto;

import br.com.subsistema.model.Produto;

public interface Imposto {
    double calcular(Produto produto);
}
