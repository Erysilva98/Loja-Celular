package Teste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Inicializar a aplicação
                LojaCelular loja = new LojaCelular();
                loja.carregarProdutos(); // Carregar produtos do arquivo de texto

                // Criar interface para o gerente
                GerenteGUI gerenteGUI = new GerenteGUI(loja);
                gerenteGUI.exibir();

                // Criar interface para o cliente
                ClienteGUI clienteGUI = new ClienteGUI(loja);
                clienteGUI.exibir();
            }
        });
    }
}

abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
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
}

class Celular extends Produto {
    private String marca;
    private String modelo;

    public Celular(String nome, double preco, String marca, String modelo) {
        super(nome, preco);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

class LojaCelular {
    private List<Produto> produtos;

    public LojaCelular() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        salvarProdutos();
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        salvarProdutos();
    }

    public void atualizarProduto(Produto produto, String novoNome, double novoPreco) {
        produto.setNome(novoNome);
        produto.setPreco(novoPreco);
        salvarProdutos();
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("celulares.txt"))) {
            for (Produto produto : produtos) {
                if (produto instanceof Celular) {
                    Celular celular = (Celular) produto;
                    writer.write(String.format("Celular,%s,%.2f,%s,%s", celular.getNome(), celular.getPreco(),
                            celular.getMarca(), celular.getModelo()));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarProdutos() {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("celulares.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].equals("Celular")) {
                    String nome = parts[1];
                    double preco = Double.parseDouble(parts[2]);
                    String marca = parts[3];
                    String modelo = parts[4];
                    Celular celular = new Celular(nome, preco, marca, modelo);
                    produtos.add(celular);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GerenteGUI {
    private JFrame frame;
    private JButton btnListarProdutos;
    private JButton btnVoltar;
    private LojaCelular loja;

    public GerenteGUI(LojaCelular loja) {
        this.loja = loja;

        frame = new JFrame("Painel do Gerente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnListarProdutos = new JButton("Listar Produtos");
        btnVoltar = new JButton("Voltar");

        // Adicionar listeners aos botões
        btnListarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

        // Adicionar os componentes ao frame
        JPanel panel = new JPanel();
        panel.add(btnListarProdutos);
        panel.add(btnVoltar);
        frame.add(panel);

        frame.pack();
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private void listarProdutos() {
        List<Produto> produtos = loja.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
        }
    }

    private void voltar() {
        frame.dispose();
    }
}

class ClienteGUI {
    private JFrame frame;
    private JButton btnListarProdutos;
    private JButton btnVoltar;
    private JButton btnComprar;
    private LojaCelular loja;

    public ClienteGUI(LojaCelular loja) {
        this.loja = loja;

        frame = new JFrame("Painel do Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnListarProdutos = new JButton("Listar Produtos");
        btnVoltar = new JButton("Voltar");
        btnComprar = new JButton("Comprar");

        // Adicionar listeners aos botões
        btnListarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprar();
            }
        });

        // Adicionar os componentes ao frame
        JPanel panel = new JPanel();
        panel.add(btnListarProdutos);
        panel.add(btnVoltar);
        panel.add(btnComprar);
        frame.add(panel);

        frame.pack();
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private void listarProdutos() {
        List<Produto> produtos = loja.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
        }
    }

    private void voltar() {
        frame.dispose();
    }

    private void comprar() {
        // Implementação para comprar um produto
    }
}
