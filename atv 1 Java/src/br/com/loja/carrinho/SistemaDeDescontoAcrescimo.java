package br.com.loja.carrinho;
import java.util.Scanner;

public class SistemaDeDescontoAcrescimo {
    private Carrinho carrinho;
    private Scanner scanner;

    public SistemaDeDescontoAcrescimo() {
        this.carrinho = new Carrinho();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            executando = processarOpcao(opcao);
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println(" ===>  Escolha uma Opção: <=== ");
        System.out.println(" 1 --> Inserir Item no Carrinho. ");
        System.out.println(" 2 --> Aplicar Acréscimo a Item. ");
        System.out.println(" 3 --> Aplicar Desconto a Item. ");
        System.out.println(" 4 --> Aplicar Acréscimo Total. ");
        System.out.println(" 5 --> Aplicar Desconto Total. ");
        System.out.println(" 6 --> Finalizar Venda. ");
        System.out.println(" 7 --> Sair. ");
    }

    private boolean processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                inserirItem();
                break;
            case 2:
                acrescimoItem();
                break;
            case 3:
                descontoItem();
                break;
            case 4:
                acrescimoTotal();
                break;
            case 5:
                descontoTotal();
                break;
            case 6:
                carrinho.finalizarVenda();
                return false;
            case 7:
                return false;
            default:
                System.out.println("Opção Inválida.");
        }
        return true;
    }

    private void inserirItem() {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();

        System.out.println("Descrição do Item: ");
        String descricao = scanner.next();

        System.out.println("Valor do Item: ");
        double valor = scanner.nextDouble();
        carrinho.adicionarItem(new Item(codigo, descricao, valor));
    }

    private void acrescimoItem() {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();

        System.out.println("Valor do Acréscimo: ");
        double acrescimo = scanner.nextDouble();
        carrinho.aplicarAcrescimoAoItem(codigo, acrescimo);
    }

    private void descontoItem() {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();

        System.out.println("Valor do Desconto: ");
        double desconto = scanner.nextDouble();
        carrinho.aplicarDescontoAoItem(codigo, desconto);
    }

    private void acrescimoTotal() {
        System.out.println("Valor total do acréscimo: ");
        double valorAcrescimo = scanner.nextDouble();
        carrinho.aplicarAcrescimoTotal(valorAcrescimo);
    }

    private void descontoTotal() {
        System.out.println("Valor total do desconto: ");
        double valorDesconto = scanner.nextDouble();
        carrinho.aplicarDescontoTotal(valorDesconto);
    }
}