package modelo;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Loja {
	private List<Produto> listaDeProdutos;
	private List<Cliente> listaDeClientes;
	private List<Venda> listaDeVendas;

	private static final String ARQUIVO_PRODUTOS = "produtos.json";
	private static final String ARQUIVO_CLIENTES = "clientes.json";
	private static final String ARQUIVO_VENDAS = "vendas.json";

	private Gson gson;

	public Loja() {
		listaDeProdutos = new ArrayList<>();
		listaDeClientes = new ArrayList<>();
		listaDeVendas = new ArrayList<>();
		gson = new Gson();
	}

	// Métodos para manipular produtos
	public void adicionarProduto(Produto produto) {
		listaDeProdutos.add(produto);
		salvarProdutos();
	}

	public void removerProduto(Produto produto) {
		listaDeProdutos.remove(produto);
		salvarProdutos();
	}

	public Produto buscarProdutoPorNome(String nome) {
		for (Produto produto : listaDeProdutos) {
			if (produto.getNome().equalsIgnoreCase(nome)) {
				return produto;
			}
		}
		return null;
	}

	public List<Produto> listarProdutos() {
		return listaDeProdutos;
	}

	// Métodos para manipular clientes
	public void adicionarCliente(Cliente cliente) {
		listaDeClientes.add(cliente);
		salvarClientes();
	}

	public void removerCliente(Cliente cliente) {
		listaDeClientes.remove(cliente);
		salvarClientes();
	}

	public Cliente buscarClientePorNome(String nome) {
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				return cliente;
			}
		}
		return null;
	}

	public List<Cliente> listarClientes() {
		return listaDeClientes;
	}


	// Métodos para salvar e carregar dados
	private void salvarProdutos() {
		try (Writer writer = new FileWriter(ARQUIVO_PRODUTOS)) {
			gson.toJson(listaDeProdutos, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void salvarClientes() {
		try (Writer writer = new FileWriter(ARQUIVO_CLIENTES)) {
			gson.toJson(listaDeClientes, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void salvarVendas() {
		try (Writer writer = new FileWriter(ARQUIVO_VENDAS)) {
			gson.toJson(listaDeVendas, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carregarDados() {
		carregarProdutos();
		carregarClientes();
		carregarVendas();
	}

	private void carregarProdutos() {
		try (Reader reader = new FileReader(ARQUIVO_PRODUTOS)) {
			Type productListType = new TypeToken<List<Produto>>(){}.getType();
			listaDeProdutos = gson.fromJson(reader, productListType);
		} catch (FileNotFoundException e) {
			listaDeProdutos = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void carregarClientes() {
		try (Reader reader = new FileReader(ARQUIVO_CLIENTES)) {
			Type clientListType = new TypeToken<List<Cliente>>(){}.getType();
			listaDeClientes = gson.fromJson(reader, clientListType);
		} catch (FileNotFoundException e) {
			listaDeClientes = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void carregarVendas() {
		try (Reader reader = new FileReader(ARQUIVO_VENDAS)) {
			Type saleListType = new TypeToken<List<Venda>>(){}.getType();
			listaDeVendas = gson.fromJson(reader, saleListType);
		} catch (FileNotFoundException e) {
			listaDeVendas = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double calcularTotalVendasMes() {
		double total = 0.0;
		for (Venda venda : listaDeVendas) {
			// Suponha que temos um método `isVendaDoMes` para verificar se a venda ocorreu no mês atual
			if (venda.isVendaDoMes()) {
				total += venda.getValorTotal();
			}
		}
		return total;
	}

	public Produto produtoMaisVendido() {
	    Map<Produto, Integer> contagemVendas = new HashMap<>();
	    
	    // Contando a quantidade vendida de cada produto
	    for (Venda venda : listaDeVendas) {
	        for (ItemVenda item : venda.getItens()) {
	            Produto produto = item.getProduto();
	            contagemVendas.put(produto, contagemVendas.getOrDefault(produto, 0) + item.getQuantidade());
	        }
	    }

	    // Se nenhuma venda foi registrada, retorna null
	    if (contagemVendas.isEmpty()) {
	        return null;
	    }

	    // Encontrando o produto com maior quantidade vendida
	    return contagemVendas.entrySet().stream()
	        .max(Map.Entry.comparingByValue())  // Encontrar a entrada com o valor máximo
	        .map(Map.Entry::getKey)  // Obter a chave dessa entrada (o produto)
	        .orElse(null);  // Se não houver entradas, retorna null
	}



	public void imprimirResumoVendas() {
		for (Venda venda : listaDeVendas) {
			System.out.println("Venda ID: " + venda.getId() + ", Cliente: " + venda.getCliente().getNome() + ", Total: R$ " + venda.getValorTotal());
			for (ItemVenda item : venda.getItens()) {
				System.out.println(" - Produto: " + item.getProduto().getNome() + ", Quantidade: " + item.getQuantidade() + ", Subtotal: R$ " + item.getSubtotal());
			}
		}
	}
	
	public Cliente melhorCliente() {
        return listaDeClientes.stream()
            .max(Comparator.comparing(cliente -> calcularTotalGastoPorCliente(cliente)))
            .orElse(null);
    }

	public double calcularTotalGastoPorCliente(Cliente cliente) {
	    return listaDeVendas.stream()
	        .filter(venda -> venda.getCliente().equals(cliente))
	        .mapToDouble(Venda::getValorTotal)
	        .sum();
	}



}
