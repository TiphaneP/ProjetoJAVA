package modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Date data;
    private double total;

    public Venda(Cliente cliente, List<ItemVenda> itens) {
        this.id = gerarIdUnico();
        this.cliente = cliente;
        this.itens = itens;
        this.data = new Date();
        this.total = calcularTotal();
    }

    public Venda(int id, Cliente cliente, List<ItemVenda> itens, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.data = java.sql.Date.valueOf(data);
        this.total = calcularTotal();
    }

    private int gerarIdUnico() {
        return (int) (Math.random() * 1000);
    }

    private double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            Produto produto = item.getProduto();  
            total += produto.getPreco() * item.getQuantidade();  
            produto.reduzirEstoque(item.getQuantidade()); 
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
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

    public boolean isVendaDoMes() {
        Calendar calendarioAtual = Calendar.getInstance();
        Calendar calendarioVenda = Calendar.getInstance();
        calendarioVenda.setTime(this.data);
        
        return calendarioAtual.get(Calendar.YEAR) == calendarioVenda.get(Calendar.YEAR) &&
               calendarioAtual.get(Calendar.MONTH) == calendarioVenda.get(Calendar.MONTH);
    }

    public double getValorTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return "Venda ID: " + id + ", Cliente: " + cliente.getNome() + ", Total: R$ " + total + ", Data: " + data;
    }
}

