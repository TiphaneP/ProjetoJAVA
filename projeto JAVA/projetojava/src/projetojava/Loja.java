package projetojava;

import java.util.List;

public class Loja {
    private List<Produto> listaDeProdutos;
    private List<Cliente> listaDeClientes;
    private List<Venda> listaDeVendas;
    
    // Getters e setters
    
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}
	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	public List<Venda> getListaDeVendas() {
		return listaDeVendas;
	}
	public void setListaDeVendas(List<Venda> listaDeVendas) {
		this.listaDeVendas = listaDeVendas;
	}

    // Métodos para adicionar, remover produtos e clientes, realizar venda, obter informações da loja
}
