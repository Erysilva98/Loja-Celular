package appLoja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaInterface extends JFrame {
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField sistemaTextField;
    private JTextField precoTextField;
    private JPanel listaPanel;
    private LojaController controller;

    public LojaInterface() {
        super("Loja de Celular");
        controller = new LojaController();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(6, 3));

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
    	// Obter os dados do produto
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String sistema = sistemaTextField.getText();
        double preco = Double.parseDouble(precoTextField.getText());

        // Chamada do método na classe LojaController
        controller.cadastrarProduto(marca, modelo, sistema, preco);

        marcaTextField.setText("");
        modeloTextField.setText("");
        sistemaTextField.setText("");
        precoTextField.setText("");

        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
    }

    private void listarProdutos() {
        listaPanel.removeAll();
        for (Produto produto : controller.listarProdutos()) {
            JButton button = new JButton(produto.getDescricao());
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] options = { "Editar", "Remover", "Cancelar" };
                    int opcao = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Opções do Produto",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                    switch (opcao) {
                        case 0:
                            controller.editarProduto(produto);
                            break;
                        case 1:
                            controller.removerProduto(produto);
                            break;
                        case 2:
                            // Cancelar ação, não fazer nada
                            break;
                        default:
                            break;
                    }

                    listarProdutos();
                }
            });
            listaPanel.add(button);
        }
        listaPanel.revalidate();
        listaPanel.repaint();
    }
}
