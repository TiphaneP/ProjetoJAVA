package projetojava;

public class Produto{
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private int estoqueMinimo;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque, int estoqueMinimo) {
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidadeEmEstoque(quantidadeEmEstoque);
        this.setEstoqueMinimo(estoqueMinimo);
    }
    
    // Getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

    // Métodos para inserir, modificar, apagar, consultar e listar
	
	
	
}


