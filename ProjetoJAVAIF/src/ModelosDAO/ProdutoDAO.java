package ModelosDAO;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Modelos.Produto;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static final String FILE_NAME = "produtos.json";
    private Gson gson = new Gson();

    public void adicionarProduto(Produto produto) {
        List<Produto> produtos = listarProdutos();
        produtos.add(produto);
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(produtos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type produtoListType = new TypeToken<ArrayList<Produto>>() {}.getType();
            return gson.fromJson(reader, produtoListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void atualizarProduto(Produto produto) {
        List<Produto> produtos = listarProdutos();
        try (Writer writer = new FileWriter(FILE_NAME)) {
            for (Produto p : produtos) {
                if (p.getId() == produto.getId()) {
                    writer.write(gson.toJson(produto) + "\n");
                } else {
                    writer.write(gson.toJson(p) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removerProduto(int id) {
        List<Produto> produtos = listarProdutos();
        try (Writer writer = new FileWriter(FILE_NAME)) {
            for (Produto p : produtos) {
                if (p.getId() != id) {
                    writer.write(gson.toJson(p) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
