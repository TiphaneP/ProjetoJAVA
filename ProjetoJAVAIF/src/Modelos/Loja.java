package Modelos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    // Métodos para manipular vendas
    public void registrarVenda(Venda venda) {
        listaDeVendas.add(venda);
        salvarVendas();
    }

    public void removerVenda(Venda venda) {
        listaDeVendas.remove(venda);
        salvarVendas();
    }

    public Venda buscarVendaPorId(int id) {
        for (Venda venda : listaDeVendas) {
            if (venda.getId() == id) {
                return venda;
            }
        }
        return null;
    }

    public List<Venda> listarVendas() {
        return listaDeVendas;
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
}
