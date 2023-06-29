package appLoja;

import java.util.ArrayList;

public class CadastroTest {
    public static void main(String[] args) {
        LojaController controller = new LojaController();

        // Teste do método cadastrarProduto()
        controller.cadastrarProduto("Samsung", "Galaxy S21", "Android", 2999.99);
        controller.cadastrarProduto("Apple", "iPhone 12", "iOS", 3999.99);
        controller.cadastrarProduto("Xiaomi", "Mi 11", "Android", 2599.99);
        controller.cadastrarProduto("Motorola", "Moto G Power", "Android", 999.99);
        controller.cadastrarProduto("Google", "Pixel 5", "Android", 1799.99);
        controller.cadastrarProduto("OnePlus", "8 Pro", "Android", 2999.99);
        controller.cadastrarProduto("LG", "Velvet", "Android", 1999.99);
        controller.cadastrarProduto("Sony", "Xperia 1 III", "Android", 4499.99);
        controller.cadastrarProduto("Nokia", "9 PureView", "Android", 1499.99);
        controller.cadastrarProduto("Huawei", "P40 Pro", "Android", 3899.99);

        // Verifica se todos os produtos foram cadastrados
        ArrayList<Produto> produtosCadastrados = controller.listarProdutos();
        boolean todosCadastrados = true;

        for (Produto produto : produtosCadastrados) {
            if (produto == null) {
                todosCadastrados = false;
                break;
            }
        }

        if (todosCadastrados) {
            System.out.println("Todos os produtos foram cadastrados com sucesso!");
        } else {
            System.out.println("Alguns produtos não foram cadastrados corretamente.");
        }
    }
}


