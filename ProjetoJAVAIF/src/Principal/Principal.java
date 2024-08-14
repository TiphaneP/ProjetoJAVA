package Principal;

import java.util.Scanner;
import Modelos.Cliente;
import Modelos.Loja;
import Modelos.Produto;
import ModelosDAO.ClienteDAO;
import ModelosDAO.ProdutoDAO;

public class Principal {
    public static void main(String[] args) {

        Loja minhaLoja = new Loja();
        Scanner leitor = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        String user;
        String senha;

        do {
            System.out.println("User: ");
            user = leitor.nextLine();

            System.out.println("Senha: ");
            senha = leitor.nextLine();
        } while (!(user.equals("root")) || !(senha.equals("1234")));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Realizar Venda");
            System.out.println("4. Ver Total de Vendas do Mês");
            System.out.println("5. Ver Produto Mais Vendido");
            System.out.println("6. Ver Melhor Cliente");
            System.out.println("7. Imprimir Resumo da Venda");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gerenciarProdutos(minhaLoja, leitor, produtoDAO);
                    break;
                case 2:
                    gerenciarClientes(minhaLoja, leitor, clienteDAO);
                    break;
                case 3:
                    // Implementar lógica de realizar venda
                    break;
                case 4:
                    // Implementar lógica de ver total de vendas do mês
                    break;
                case 5:
                    // Implementar lógica de ver produto mais vendido
                    break;
                case 6:
                    // Implementar lógica de ver melhor cliente
                    break;
                case 7:
                    // Implementar lógica de imprimir resumo da venda
                    break;
                case 8:
                    System.out.println("Saindo...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarProdutos(Loja loja, Scanner leitor, ProdutoDAO produtoDAO) {
        while (true) {
            System.out.println("Gerenciar Produtos:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = leitor.nextLine();
                    System.out.print("Preço: ");
                    double preco = leitor.nextDouble();
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeEmEstoque = leitor.nextInt();
                    System.out.print("Estoque Mínimo: ");
                    int estoqueMinimo = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    Produto novoProduto = new Produto(nome, preco, quantidadeEmEstoque, estoqueMinimo);
                    produtoDAO.adicionarProduto(novoProduto);
                    break;
                case 2:
                    System.out.print("ID do Produto a Atualizar: ");
                    int idAtualizar = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    System.out.print("Novo Nome do Produto: ");
                    String novoNome = leitor.nextLine();
                    System.out.print("Novo Preço: ");
                    double novoPreco = leitor.nextDouble();
                    System.out.print("Nova Quantidade em Estoque: ");
                    int novaQuantidade = leitor.nextInt();
                    System.out.print("Novo Estoque Mínimo: ");
                    int novoEstoqueMinimo = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    Produto produtoAtualizado = new Produto(novoNome, novoPreco, novaQuantidade, novoEstoqueMinimo);
                    produtoAtualizado.setId(idAtualizar);
                    produtoDAO.atualizarProduto(produtoAtualizado);
                    break;
                case 3:
                    System.out.print("ID do Produto a Remover: ");
                    int idRemover = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    produtoDAO.removerProduto(idRemover);
                    break;
                case 4:
                    System.out.println("Produtos:");
                    for (Produto p : produtoDAO.listarProdutos()) {
                        System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: R$ " + p.getPreco() + ", Quantidade: " + p.getQuantidadeEmEstoque());
                    }
                    break;
                case 5:
                    return; // Voltar ao Menu Principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarClientes(Loja loja, Scanner leitor, ClienteDAO clienteDAO) {
        while (true) {
            System.out.println("Gerenciar Clientes:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nome = leitor.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = leitor.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = leitor.nextLine();
                    System.out.print("Email: ");
                    String email = leitor.nextLine();
                    Cliente novoCliente = new Cliente(nome, endereco, telefone, email);
                    clienteDAO.adicionarCliente(novoCliente);
                    break;
                case 2:
                    System.out.print("ID do Cliente a Atualizar: ");
                    int idAtualizar = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    System.out.print("Novo Nome: ");
                    String novoNome = leitor.nextLine();
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = leitor.nextLine();
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = leitor.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = leitor.nextLine();
                    Cliente clienteAtualizado = new Cliente(novoNome, novoEndereco, novoTelefone, novoEmail);
                    clienteAtualizado.setId(idAtualizar);
                    clienteDAO.atualizarCliente(clienteAtualizado);
                    break;
                case 3:
                    System.out.print("ID do Cliente a Remover: ");
                    int idRemover = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha
                    clienteDAO.removerCliente(idRemover);
                    break;
                case 4:
                    System.out.println("Clientes:");
                    for (Cliente c : clienteDAO.listarClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Endereço: " + c.getEndereco() + ", Telefone: " + c.getTelefone() + ", Email: " + c.getEmail());
                    }
                    break;
                case 5:
                    return; // Voltar ao Menu Principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
