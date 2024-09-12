import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> carrinho = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;
        
        while (executando) {
            // Exibição do menu
            System.out.println(" ===> Escolha uma opção: <=== ");
            System.out.println(" 1 --> Inserir Item no Carrinho. ");
            System.out.println(" 2 --> Aplicar Acréscimo ao Item. ");
            System.out.println(" 3 --> Aplicar Desconto ao Item. ");
            System.out.println(" 4 --> Aplicar Acréscimo Total. ");
            System.out.println(" 5 --> Aplicar Desconto Total. ");
            System.out.println(" 6 --> Finalizar Venda. ");
            System.out.println(" 7 --> Sair. ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirItem(carrinho, scanner);
                    break;
                case 2:
                    acrescimoItem(carrinho, scanner);
                    break;
                case 3:
                    descontoItem(carrinho, scanner);
                    break;
                case 4:
                    acrescimoTotal(carrinho, scanner);
                    break;
                case 5:
                    descontoTotal(carrinho, scanner);
                    break;
                case 6:
                    finalizarVenda(carrinho);
                    executando = false; // Finaliza o loop e o sistema
                    break;
                case 7:
                    executando = false; // Sai do sistema
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }
        scanner.close();
    }

    public static void inserirItem(ArrayList<Item> carrinho, Scanner scanner) {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();
        System.out.println("Descrição do Item: ");
        String descricao = scanner.next();
        System.out.println("Valor do Item: ");
        double valor = scanner.nextDouble();
        carrinho.add(new Item(codigo, descricao, valor, 0, 0));
    }

    public static void acrescimoItem(ArrayList<Item> carrinho, Scanner scanner) {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();
        System.out.println("Valor do Acréscimo: ");
        double acrescimo = scanner.nextDouble();
        aplicarAcrescimoAoItem(carrinho, codigo, acrescimo);
    }

    public static void descontoItem(ArrayList<Item> carrinho, Scanner scanner) {
        System.out.println("Código do Item: ");
        String codigo = scanner.next();
        System.out.println("Valor do Desconto: ");
        double desconto = scanner.nextDouble();
        aplicarDescontoAoItem(carrinho, codigo, desconto);
    }

    public static void acrescimoTotal(ArrayList<Item> carrinho, Scanner scanner) {
        System.out.println("Valor total do acréscimo: ");
        double valorAcrescimo = scanner.nextDouble();
        distribuirValor(carrinho, valorAcrescimo, true);
    }

    public static void descontoTotal(ArrayList<Item> carrinho, Scanner scanner) {
        System.out.println("Valor total do desconto: ");
        double valorDesconto = scanner.nextDouble();
        distribuirValor(carrinho, valorDesconto, false);
    }

    public static void finalizarVenda(ArrayList<Item> carrinho) {
        double totalAcrescimos = 0, totalDescontos = 0, total = 0;
        System.out.println("Itens do Carrinho: ");
        for (Item item : carrinho) {
            System.out.println(item.descricao + " - valor: " + (item.valor + item.acrescimo - item.desconto));
            totalAcrescimos += item.acrescimo;
            totalDescontos += item.desconto;
            total += item.valor + item.acrescimo - item.desconto;
        }
        System.out.println("Acréscimo total: " + totalAcrescimos);
        System.out.println("Desconto total: " + totalDescontos);
        System.out.println("Valor total: " + total);
    }

    public static void aplicarAcrescimoAoItem(ArrayList<Item> carrinho, String codigo, double acrescimo) {
        for (Item item : carrinho) {
            if (item.codigo.equals(codigo)) {
                item.acrescimo += acrescimo;
            }
        }
    }

    public static void aplicarDescontoAoItem(ArrayList<Item> carrinho, String codigo, double desconto) {
        for (Item item : carrinho) {
            if (item.codigo.equals(codigo)) {
                item.desconto += desconto;
            }
        }
    }

    public static void distribuirValor(ArrayList<Item> carrinho, double valor, boolean isAcrescimo) {
        double valorDistribuido = valor / carrinho.size();
        for (Item item : carrinho) {
            if (isAcrescimo) {
                item.acrescimo += valorDistribuido;
            } else {
                item.desconto += valorDistribuido;
            }
        }
    }
}

class Item {
    String codigo;
    String descricao;
    double valor;
    double acrescimo;
    double desconto;

    public Item(String codigo, String descricao, double valor, double acrescimo, double desconto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
    }
}
