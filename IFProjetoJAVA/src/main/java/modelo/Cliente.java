package modelo;

import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;


    public Cliente(String nome, String endereco, String telefone, String email) {
        this.id = gerarIdUnico();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
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

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + endereco + ";" + telefone + ";" + email;
    }

    public static Cliente fromString(String str) {
        String[] parts = str.split(";");
        Cliente cliente = new Cliente(parts[1], parts[2], parts[3], parts[4]);
        cliente.id = Integer.parseInt(parts[0]);
        return cliente;
    }

    public void setId(int idAtualizar) {
        this.id = idAtualizar;
    }
    
    public double getTotalGasto(List<Venda> listaDeVendas) {
        return listaDeVendas.stream()
            .filter(venda -> venda.getCliente().equals(this))
            .mapToDouble(Venda::getValorTotal)
            .sum();
    }

	
}
