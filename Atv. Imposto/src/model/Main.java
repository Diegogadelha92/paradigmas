package model;

import br.com.subsistema.imposto.ISS;
import br.com.subsistema.imposto.Imposto;
import br.com.subsistema.model.Produto;
import factory.ImpostoFactory;


public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Produto Industrial", 100.00, true, false);
        Produto produto2 = new Produto("Produto Não Industrial", 200.00, false, false);
        Produto servico1 = new Produto("Serviço de Consultoria", 300.00, false, true);


        Imposto icms = ImpostoFactory.getImposto("ICMS", produto1);
        Imposto pis = ImpostoFactory.getImposto("PIS", produto1);
        Imposto ipi = ImpostoFactory.getImposto("IPI", produto1);


        ISS iss = (ISS) ImpostoFactory.getImposto("ISS", servico1);


        double icmsValor = icms.calcular(produto1);
        double pisValor = pis.calcular(produto1);
        double ipiValor = ipi.calcular(produto1);

        System.out.println("Produto: " + produto1.getNome());
        System.out.println("ICMS: R$ " + icmsValor);
        System.out.println("PIS: R$ " + pisValor);
        System.out.println("IPI: R$ " + ipiValor);
        System.out.println("Total: R$ " + (produto1.getValor() + icmsValor + pisValor + ipiValor));

        // Produto não industrial
        double icmsValor2 = icms.calcular(produto2);
        double pisValor2 = pis.calcular(produto2);
        double ipiValor2 = ipi.calcular(produto2);

        System.out.println("\nProduto: " + produto2.getNome());
        System.out.println("ICMS: R$ " + icmsValor2);
        System.out.println("PIS: R$ " + pisValor2);
        System.out.println("IPI: R$ " + ipiValor2);
        System.out.println("Total: R$ " + (produto2.getValor() + icmsValor2 + pisValor2 + ipiValor2));

        // Calculando imposto para serviço

        double issValor = iss.calcular(servico1);

        System.out.println("\nServiço: " + servico1.getNome());
        System.out.println("ISS: R$ " + issValor);
        System.out.println("Total: R$ " + (servico1.getValor() + issValor));
    }
}
