package appLoja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LojaCelulares extends JFrame {
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField sistemaTextField;
    private JTextField precoTextField;
    private JPanel listaPanel;

    private ArrayList<Produto> listaProdutos;

    public LojaCelulares() {
        super("Loja de Celular");

        listaProdutos = new ArrayList<>();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(6,3));

        painelCadastro.add(new JLabel("Marca:"));
        marcaTextField = new JTextField();
        painelCadastro.add(marcaTextField);

        painelCadastro.add(new JLabel("Modelo:"));
        modeloTextField = new JTextField();
        painelCadastro.add(modeloTextField);

        painelCadastro.add(new JLabel("Sistema Operacional:"));
        sistemaTextField = new JTextField();
        painelCadastro.add(sistemaTextField);

        painelCadastro.add(new JLabel("Preço:"));
        precoTextField = new JTextField();
        painelCadastro.add(precoTextField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });
        painelCadastro.add(cadastrarButton);

        JButton listarButton = new JButton("Listar");
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });
        painelCadastro.add(listarButton);

        add(painelCadastro, BorderLayout.NORTH);

        listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(listaPanel), BorderLayout.CENTER);
    }

    private void cadastrarProduto() {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String sistema = sistemaTextField.getText();
        double preco = Double.parseDouble(precoTextField.getText());

        Produto celular = new Celular(marca, preco, modelo, sistema);
        listaProdutos.add(celular);
        salvarProdutos();

        marcaTextField.setText("");
        modeloTextField.setText("");
        sistemaTextField.setText("");
        precoTextField.setText("");

        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
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

    private void listarProdutos() {
        listaPanel.removeAll();
        for (Produto produto : listaProdutos) {
            JButton button = new JButton(produto.getDescricao());
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este produto?", "Remover Produto", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        removerProduto(produto);
                        listarProdutos();
                    }
                }
            });
            listaPanel.add(button);
        }
        listaPanel.revalidate();
        listaPanel.repaint();
    }

    private void removerProduto(Produto produto) {
        listaProdutos.remove(produto);
        salvarProdutos();
        JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
    }

    public static void main(String[] args) {
        LojaCelulares loja = new LojaCelulares();
        loja.carregarProdutos();
        loja.setVisible(true);
    }
}
