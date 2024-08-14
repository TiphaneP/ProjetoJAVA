package Modelos;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int categoriaId;

    public Produto(String nome, double preco, int quantidade, int categoriaId) {
        this.id = gerarIdUnico();
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoriaId = categoriaId;
    }

    private int gerarIdUnico() {
        return (int) (Math.random() * 1000);
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

    public int getQuantidade() {
        return quantidade;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + preco + ";" + quantidade + ";" + categoriaId;
    }

    public static Produto fromString(String str) {
        String[] parts = str.split(";");
        Produto produto = new Produto(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
        produto.id = Integer.parseInt(parts[0]);
        return produto;
    }

	public double getQuantidadeCompra() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void reduzirEstoque(double quantidadeCompra) {
		// TODO Auto-generated method stub
		
	}

	public String getQuantidadeEmEstoque() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(int idAtualizar) {
		// TODO Auto-generated method stub
		
	}
}
