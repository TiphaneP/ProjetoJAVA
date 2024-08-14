package modelo;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private int estoqueMinimo;
    private int quantidadeVendida;
    
    private static int contadorId = 1;

    public Produto(String nome, double preco, int quantidadeEmEstoque, int estoqueMinimo) {
        this.id = contadorId++;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.quantidadeVendida = 0;
    }

	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void reduzirEstoque(int quantidade) {
        this.quantidadeEmEstoque -= quantidade;
        this.quantidadeVendida += quantidade;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + preco + ";" + quantidadeEmEstoque + ";" + estoqueMinimo;
    }

	public double getQuantidadeCompra() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void reduzirEstoque(double quantidadeCompra) {
		// TODO Auto-generated method stub
		
	}
}
