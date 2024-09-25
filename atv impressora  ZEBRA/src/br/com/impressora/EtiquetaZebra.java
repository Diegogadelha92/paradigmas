package br.com.impressora;
public class EtiquetaZebra {
    private Produto produto;

    public EtiquetaZebra(Produto produto) {
        this.produto = produto;
    }
    public String gerarEtiqueta() {

        String template = """
        ^XA
        ^FO50,50^ADN,36,20^FDProduto: {codigo}^FS
        ^FO50,100^ADN,36,20^FDDescricao: {descricao}^FS
        ^FO50,150^ADN,36,20^FDPreco: R${preco}^FS

        ^FO50,200^BY2,3,50
        ^BCN,100,Y,N,N
        ^FD{codigoDeBarras}^FS

        ^XZ
        """;

        return template
                .replace("{codigo}", produto.getCodigo())
                .replace("{descricao}", produto.getDescricao())
                .replace("{preco}", String.format("%.2f", produto.getPreco()))
                .replace("{codigoDeBarras}", produto.getCodigoDeBarras());
    }
}
