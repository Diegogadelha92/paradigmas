package br.com.impressora;
public class ImpressoraZebra {
    private String ip;
    private int porta;

    public ImpressoraZebra(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
    }
    public void imprimirEtiqueta(EtiquetaZebra etiqueta) {

        String zplCode = etiqueta.gerarEtiqueta();
        System.out.println("Enviando para a impressora Zebra:");
        System.out.println(zplCode);
    }
}

