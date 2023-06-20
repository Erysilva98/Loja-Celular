package appLoja;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        LojaVirtual loja = new LojaVirtual(produtos);

        int opcao;
        do {
            opcao = exibirMenu();

            switch (opcao) {
                case 1:
                    cadastrarProduto(loja);
                    break;
                case 2:
                    listarProdutos(loja);
                    break;
                case 3:
                    comprarProduto(loja);
                    break;
                case 4:
                    exibirCarrinho(loja);
                    break;
                case 5:
                    finalizarPedido(loja);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar a loja virtual!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 6);
    }

    private static int exibirMenu() {
        String menu = "Selecione uma opção:\n" +
                "1. Cadastrar produto\n" +
                "2. Listar produtos disponíveis\n" +
                "3. Comprar produto\n" +
                "4. Exibir carrinho de compras\n" +
                "5. Finalizar pedido\n" +
                "6. Sair";

        String opcaoStr = JOptionPane.showInputDialog(null, menu);
        int opcao = Integer.parseInt(opcaoStr);

        return opcao;
    }

    private static void cadastrarProduto(LojaVirtual loja) {
        String marca = JOptionPane.showInputDialog("Digite a marca do celular:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do celular:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do celular:"));
        String sistemaOperacional = JOptionPane.showInputDialog("Digite o sistema operacional do celular:");

        Produto celular = new Celular(marca, modelo, preco, sistemaOperacional);
        loja.adicionarProduto(celular);

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    }

    private static void listarProdutos(LojaVirtual loja) {
        List<Produto> produtos = loja.listarProdutos();

        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto.toString());
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void comprarProduto(LojaVirtual loja) {
        String modelo = JOptionPane.showInputDialog("Digite o modelo do celular que deseja comprar:");
        Produto produto = loja.buscarProduto(modelo);

        if (produto != null) {
            loja.adicionarAoCarrinho(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        }
    }

    private static void exibirCarrinho(LojaVirtual loja) {
        List<Produto> carrinho = loja.getCarrinho();

        StringBuilder sb = new StringBuilder();
        for (Produto produto : carrinho) {
            sb.append(produto.toString());
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void finalizarPedido(LojaVirtual loja) {
        Pedido pedido = loja.finalizarPedido();
        if (pedido != null) {
            JOptionPane.showMessageDialog(null, "Pedido finalizado!\nValor total: R$" + pedido.getValorTotal());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto no carrinho para finalizar o pedido!");
        }
    }
}
