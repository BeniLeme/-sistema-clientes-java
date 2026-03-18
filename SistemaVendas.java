import java.util.ArrayList;
import java.util.Scanner;

// Representa um produto do sistema
class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preço: R$ " + String.format("%.2f", preco);
    }
}

// Representa uma venda (produto + quantidade + total)
class Venda {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Venda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Venda - Produto: " + produto.getNome()
                + " | Quantidade: " + quantidade
                + " | Total: R$ " + String.format("%.2f", valorTotal);
    }
}

// Classe principal com o menu de controle de vendas
public class SistemaVendas {

    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static ArrayList<Venda> vendas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
                    listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo do sistema de vendas. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }

    // Exibe o menu principal
    private static void exibirMenu() {
        System.out.println("===== SISTEMA DE CONTROLE DE VENDAS =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Registrar venda");
        System.out.println("4 - Listar vendas");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção digitada, tratando erros básicos
    private static int lerOpcao() {
        int opcao = -1;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // deixa como -1 (inválido)
        }
        return opcao;
    }

    // Cadastra um novo produto na lista
    private static void cadastrarProduto() {
        System.out.println("=== Cadastro de Produto ===");

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Preço do produto: ");
        String precoStr = scanner.nextLine().trim();

        if (nome.isEmpty() || precoStr.isEmpty()) {
            System.out.println("Nome e preço não podem ser vazios. Cadastro cancelado.");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr.replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido. Use apenas números e vírgula/ponto. Cadastro cancelado.");
            return;
        }

        if (preco < 0) {
            System.out.println("Preço não pode ser negativo. Cadastro cancelado.");
            return;
        }

        Produto produto = new Produto(nome, preco);
         produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    // Lista todos os produtos cadastrados
    private static void listarProdutos() {
        System.out.println("=== Lista de Produtos ===");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println((i + 1) + " - " + p.toString());
        }
    }

    // Registra uma venda, escolhendo um produto e a quantidade
    private static void registrarVenda() {
        System.out.println("=== Registrar Venda ===");

        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados. Cadastre um produto antes de registrar vendas.");
            return;
        }

        listarProdutos();
        System.out.print("Digite o número do produto que deseja vender: ");

        int indiceProduto;
        try {
            indiceProduto = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Venda cancelada.");
            return;
        }

        int posProduto = indiceProduto - 1;
        if (posProduto < 0 || posProduto >= produtos.size()) {
            System.out.println("Número de produto inválido. Venda cancelada.");
            return;
        }

        Produto produtoSelecionado = produtos.get(posProduto);

        System.out.print("Quantidade: ");
        int quantidade;
        try {
            quantidade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida. Venda cancelada.");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero. Venda cancelada.");
            return;
        }

        Venda venda = new Venda(produtoSelecionado, quantidade);
        vendas.add(venda);

        System.out.println("Venda registrada com sucesso!");
        System.out.println("Valor total da venda: R$ " + String.format("%.2f", venda.getValorTotal()));
    }

    // Lista todas as vendas realizadas
    private static void listarVendas() {
        System.out.println("=== Lista de Vendas ===");

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        for (int i = 0; i < vendas.size(); i++) {
            Venda v = vendas.get(i);
            System.out.println((i + 1) + " - " + v.toString());
        }

        // Opcional: somatório do faturamento total
        double totalGeral = 0.0;
        for (Venda v : vendas) {
            totalGeral += v.getValorTotal();
        }
        System.out.println("------------------------------------------");
        System.out.println("Total geral de vendas: R$ " + String.format("%.2f", totalGeral));
    }
}

