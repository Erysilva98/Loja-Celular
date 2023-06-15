package appLoja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class View {
    private Controller controller;

    private JFrame frame;
    private JTextArea textArea;
    private JTextField nomeTextField;
    private JTextField marcaTextField;
    private JTextField precoTextField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    public View() {
        this.controller = new Controller("celulares.txt");

        frame = new JFrame("Loja de Celulares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        nomeTextField = new JTextField();
        marcaTextField = new JTextField();
        precoTextField = new JTextField();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeTextField);
        inputPanel.add(new JLabel("Marca:"));
        inputPanel.add(marcaTextField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(precoTextField);
        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        createButton = new JButton("Adicionar");
        readButton = new JButton("Listar");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Remover");

        buttonPanel.add(createButton);
        buttonPanel.add(readButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String marca = marcaTextField.getText();
                double preco = Double.parseDouble(precoTextField.getText());
                controller.create(nome, marca, preco);
                nomeTextField.setText("");
                marcaTextField.setText("");
                precoTextField.setText("");
                JOptionPane.showMessageDialog(frame, "Celular adicionado com sucesso!");
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Model> celulares = controller.read();
                StringBuilder sb = new StringBuilder();
                for (Model celular : celulares) {
                    sb.append("Nome: ").append(celular.getNome()).append("\n");
                    sb.append("Marca: ").append(celular.getMarca()).append("\n");
                    sb.append("Preço: ").append(celular.getPreco()).append("\n");
                    sb.append("--------------------\n");
                }
                textArea.setText(sb.toString());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String marca = marcaTextField.getText();
                double preco = Double.parseDouble(precoTextField.getText());
                List<Model> celulares = controller.read();
                for (Model celular : celulares) {
                    if (celular.getNome().equals(nome)) {
                        controller.update(celular, nome, marca, preco);
                        JOptionPane.showMessageDialog(frame, "Celular atualizado com sucesso!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Celular não encontrado!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                List<Model> celulares = controller.read();
                for (Model celular : celulares) {
                    if (celular.getNome().equals(nome)) {
                        controller.delete(celular);
                        JOptionPane.showMessageDialog(frame, "Celular removido com sucesso!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Celular não encontrado!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View();
            }
        });
    }
}
