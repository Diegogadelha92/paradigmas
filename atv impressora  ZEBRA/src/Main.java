import br.com.impressora.EtiquetaZebra;
import br.com.impressora.ImpressoraZebra;
import br.com.impressora.Produto;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto("12345", "Cerveja Pilsen Zuaum", 55.50, "147896325");

        EtiquetaZebra etiqueta = new EtiquetaZebra(produto);

        ImpressoraZebra impressora = new ImpressoraZebra("192.168.0.100", 9100);

        impressora.imprimirEtiqueta(etiqueta);
    }
}
