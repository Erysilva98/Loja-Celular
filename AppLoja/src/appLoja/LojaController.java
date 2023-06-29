package appLoja;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class LojaController {
    private ArrayList<Produto> listaProdutos;

    public LojaController() {
        listaProdutos = new ArrayList<>();
        carregarProdutos();
    }

    public void cadastrarProduto(String marca, String modelo, String sistema, double preco) {
        Produto celular = new Celular(marca, preco, modelo, sistema);
        listaProdutos.add(celular);
        salvarProdutos();
    }

    public ArrayList<Produto> listarProdutos() {
        return listaProdutos;
    }

    public void editarProduto(Produto produto) {
        String marca = JOptionPane.showInputDialog(null, "Digite a nova marca:", produto.getMarca());
        String modelo = JOptionPane.showInputDialog(null, "Digite o novo modelo:", produto.getModelo());
        String sistema = JOptionPane.showInputDialog(null, "Digite o novo sistema operacional:", produto.getSistemaOperacional());
        double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o novo preço:", produto.getPreco()));

        produto.setMarca(marca);
        produto.setModelo(modelo);
        produto.setSistemaOperacional(sistema);
        produto.setPreco(preco);

        salvarProdutos();
        JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    }

    public void removerProduto(Produto produto) {
        listaProdutos.remove(produto);
        salvarProdutos();
        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
    }

    private void salvarProdutos() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("celulares.txt"));
            for (Produto produto : listaProdutos) {
                if (produto instanceof Celular) {
                    Celular celular = (Celular) produto;
                    writer.write("Celular," +
                            celular.getMarca() + "," +
                            celular.getPreco() + "," +
                            celular.getModelo() + "," +
                            celular.getSistemaOperacional());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarProdutos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("celulares.txt"));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals("Celular")) {
                    String marca = dados[1];
                    double preco = Double.parseDouble(dados[2]);
                    String modelo = dados[3];
                    String sistema = dados[4];
                    Produto celular = new Celular(marca, preco, modelo, sistema);
                    listaProdutos.add(celular);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
