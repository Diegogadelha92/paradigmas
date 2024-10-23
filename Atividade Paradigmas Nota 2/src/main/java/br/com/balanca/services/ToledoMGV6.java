package br.com.balanca.services;

import br.com.balanca.exceptions.ArquivoNaoEncontradoException;
import br.com.balanca.exceptions.ExportacaoFalhaException;
import br.com.balanca.exceptions.ProdutoFormatException;
import br.com.balanca.exceptions.ProdutoInvalidoException;
import br.com.balanca.interfaces.IBalanca;
import br.com.balanca.models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToledoMGV6 implements IBalanca<Produto> {

    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt) {
        File directory = new File(pastaArquivoTxt);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new ArquivoNaoEncontradoException("A pasta especificada não foi encontrada: " + pastaArquivoTxt);
        }

        if (produtos == null) {
            throw new RuntimeException("A lista de produtos não pode ser nula");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/ITENSMGV.TXT"))) {
            for (Produto produto : produtos) {
                if (produto == null) {
                    throw new ProdutoInvalidoException("Produto nulo encontrado na lista de produtos");
                }
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (ProdutoInvalidoException | IOException e) {
            throw new ExportacaoFalhaException("Erro ao exportar os produtos para o arquivo: " + pastaArquivoTxt + "/CADTXT.TXT");
        }
    }

    private String formatarProduto(Produto produto) {
        try {
            String dept = "01";
            String tipo = "0";
            String codigo = String.format("%06d", produto.getCodigo());
            String preco = String.format("%06d", (int) (produto.getValor() * 100));
            String descricao = String.format("%-50s", produto.getDescricao());

            String linha = dept + tipo + codigo + preco + "000" + descricao +
                    "0000000000|01|                                                                      0000000000000000000000000|0000|0||";

            return linha;
        } catch (Exception e) {
            throw new ProdutoFormatException("Erro ao formatar o produto: " + produto);
        }
    }
}
