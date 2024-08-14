package projetojava;

import java.util.Date;
import java.util.List;

public class Venda {
	private int id;
    private Date data;
    private Cliente cliente;
    private List<Produto> listaDeProdutos;
    private double total;

    public Venda(int id, Date data, Cliente cliente, List<Produto> listaDeProdutos) {
        this.setId(id);
        this.setData(data);
        this.setCliente(cliente);
        this.listaDeProdutos = listaDeProdutos;
        calcularTotal();
    }

    private void calcularTotal() {
        this.setTotal(0);
        for (Produto p : listaDeProdutos) {
            this.setTotal(this.getTotal() + p.getPreco());
        }
    }

    // Getters e setters
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

    // Métodos para inserir, emitir fatura, verificar estoque
}


