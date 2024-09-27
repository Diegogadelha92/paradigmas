package factory;

import br.com.subsistema.model.Produto;

public class ImpostoFactory {
    public static br.com.subsistema.imposto.Imposto getImposto(String tipo, Produto produto) {
        switch (tipo.toUpperCase()) {
            case "ICMS":
                return new br.com.subsistema.imposto.ICMS();
            case "PIS":
                return new br.com.subsistema.imposto.PIS();
            case "IPI":
                return new br.com.subsistema.imposto.IPI();
            case "ISS":
                return new br.com.subsistema.imposto.ISS();
            default:
                throw new IllegalArgumentException("Tipo de imposto desconhecido: " + tipo);
        }
    }
}
