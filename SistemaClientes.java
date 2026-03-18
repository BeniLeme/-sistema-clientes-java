import java.util.ArrayList;
import java.util.Scanner;

// Classe que representa um cliente
class Cliente {
    private String nome;
    private String email;
    private String senha;

    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        // Por segurança, a senha não é exibida aqui
        return "Nome: " + nome + " | Email: " + email;
    }
}

public class SistemaClientes {

    // Lista que armazenará os clientes em memória
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        // Loop principal do menu
        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // linha em branco para separar as interações
        } while (opcao != 4);

        scanner.close();
    }

    // Exibe o menu de opções no console
    private static void exibirMenu() {
        System.out.println("===== SISTEMA DE CADASTRO DE CLIENTES =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Remover cliente");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção escolhida pelo usuário (tratando erros básicos)
    private static int lerOpcao() {
        int opcao = -1;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Se o usuário digitar algo que não seja número, deixa como -1 (inválido)
        }
        return opcao;
    }

    // Cadastra um novo cliente na lista
    private static void cadastrarCliente() {
        System.out.println("=== Cadastro de Cliente ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();

        // Validação simples de campos vazios
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            System.out.println("Nome, email e senha não podem ser vazios. Cadastro cancelado.");
            return;
        }

        Cliente novoCliente = new Cliente(nome, email, senha);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Lista todos os clientes cadastrados
    private static void listarClientes() {
        System.out.println("=== Lista de Clientes ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        // Exibe o índice junto com os dados para facilitar a remoção
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + " - " + c.toString());
        }
    }

    // Remove um cliente a partir do índice selecionado
    private static void removerCliente() {
        System.out.println("=== Remover Cliente ===");

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes para remover.");
            return;
        }

        // Mostra a lista antes de pedir o índice
        listarClientes();

        System.out.print("Digite o número do cliente que deseja remover: ");
        int indice;

        try {
            indice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Remoção cancelada.");
            return;
        }

        // Ajusta para índice baseado em 0
        int posicao = indice - 1;

        // Verifica se o índice está dentro dos limites da lista
        if (posicao < 0 || posicao >= clientes.size()) {
            System.out.println("Número de cliente inválido. Remoção cancelada.");
            return;
        }

        Cliente removido = clientes.remove(posicao);
        System.out.println("Cliente removido: " + removido.getNome());
    }
}
