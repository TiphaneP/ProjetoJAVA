package Modelos;

import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<Produto> listaDeProdutos;
    private Date data;
    private double total;

    public Venda(Cliente cliente, List<Produto> listaDeProdutos) {
        this.id = gerarIdUnico();
        this.cliente = cliente;
        this.listaDeProdutos = listaDeProdutos;
        this.data = new Date();
        this.total = calcularTotal();
    }

    private int gerarIdUnico() {
        return (int) (Math.random() * 1000);
    }

    private double calcularTotal() {
        double total = 0;
        for (Produto produto : listaDeProdutos) {
            total += produto.getPreco() * produto.getQuantidadeCompra();
            produto.reduzirEstoque(produto.getQuantidadeCompra());
        }
        return total;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venda ID: " + id + ", Cliente: " + cliente.getNome() + ", Total: R$ " + total + ", Data: " + data;
    }

    public static Venda fromString(String str) {

    	    String[] parts = str.split(",");
    	    int id = Integer.parseInt(parts[0]);
    	    String nomeCliente = parts[1];
    	    Cliente cliente = new Cliente("Teresa Maria", "Rua Santo Antonio", "8197658-0090", "TMaria3@gmail.com"); // Suposição: Endereço, telefone e email 

    	    List<ItemVenda> itens = new ArrayList<>();
    	    for (int i = 2; i < parts.length - 1; i++) {
    	        String[] itemParts = parts[i].split(":");
    	        String nomeProduto = itemParts[0];
    	        int quantidade = Integer.parseInt(itemParts[1]);
    	        Produto produto = new Produto("Bicicleta Eletrica", 6.500,00, 4, 1); // Suposição: Preço e estoque 
    	        ItemVenda itemVenda = new ItemVenda(produto, quantidade);
    	        itens.add(itemVenda);
    	    }

    	    LocalDate data = LocalDate.parse(parts[parts.length - 1]);

    	    return new Venda(id, cliente, itens, data);
    }
}
