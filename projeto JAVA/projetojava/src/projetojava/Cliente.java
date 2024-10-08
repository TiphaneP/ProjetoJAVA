package projetojava;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String endereco, String telefone, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEmail(email);
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



    // Métodos para inserir, modificar, apagar, consultar e listar
}

