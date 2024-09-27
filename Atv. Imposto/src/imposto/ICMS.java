package br.com.subsistema.imposto;
import br.com.subsistema.model.Produto;

public class ICMS implements br.com.subsistema.imposto.Imposto {
    @Override
    public double calcular(Produto produto) {
        return produto.getValor() * 0.18;
    }
}
