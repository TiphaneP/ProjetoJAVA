package DAO;

import modelo.Cliente;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String FILE_NAME = "clientes.json";
    private Gson gson = new Gson();

    public void adicionarCliente(Cliente cliente) {
        List<Cliente> clientes = listarClientes();
        clientes.add(cliente);
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(clientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type clienteListType = new TypeToken<ArrayList<Cliente>>() {}.getType();
            return gson.fromJson(reader, clienteListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
    	List<Cliente> clientes = listarClientes(); 
    	for (Cliente cliente : clientes) {
    		if (cliente.getId() == clienteAtualizado.getId()) {
    			cliente.setNome(clienteAtualizado.getNome());
    			cliente.setEndereco(clienteAtualizado.getEndereco());
    			cliente.setTelefone(clienteAtualizado.getTelefone());
    			cliente.setEmail(clienteAtualizado.getEmail());
    			break; 
    		}
    	}

    }

    public void removerCliente(int id) {
        List<Cliente> clientes = listarClientes();
        try (Writer writer = new FileWriter(FILE_NAME)) {
            for (Cliente c : clientes) {
                if (c.getId() != id) {
                    writer.write(gson.toJson(c) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
