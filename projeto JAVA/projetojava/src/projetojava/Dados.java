package projetojava;

import java.io.*;

public class Dados {

    public static void salvar(Object objeto, String caminho) throws IOException {
        FileOutputStream fos = new FileOutputStream(caminho);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objeto);
        oos.close();
    }

    public static Object carregar(String caminho) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(caminho);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object objeto = ois.readObject();
        ois.close();
        return objeto;
    }
}
