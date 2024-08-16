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


    @Override
    public String toString() {
        return id + ";" + nome + ";" + preco + ";" + quantidadeEmEstoque + ";" + estoqueMinimo;
    }

    public int getQuantidadeCompra() {
        return quantidadeVendida;
    }


    public void reduzirEstoque(int quantidadeCompra) {
        if (quantidadeEmEstoque >= quantidadeCompra) {
            quantidadeEmEstoque -= quantidadeCompra;
            quantidadeVendida += quantidadeCompra;  // Aumenta a contagem de quantidade vendida
        } else {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente.");
        }
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }


    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

	
}
