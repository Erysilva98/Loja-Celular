package appLoja;

import java.util.ArrayList;

public class TesteLojaCelulares {
    public static void main(String[] args) {
        // Criação de objetos Celular
        Celular celular1 = new Celular("Samsung", 1499.99, "Galaxy S21", "Android");
        Celular celular2 = new Celular("Apple", 1999.99, "iPhone 12", "iOS");
        Celular celular3 = new Celular("Xiaomi", 899.99, "Redmi Note 10", "MIUI");

        // Exibição das descrições dos celulares
        System.out.println(celular1.getDescricao());
        System.out.println(celular2.getDescricao());
        System.out.println(celular3.getDescricao());

        // Modificação do preço do celular 1
        celular1.setPreco(1399.99);

        // Exibição dos dados atualizados do celular 1
        System.out.println(celular1);

        // Uso do polimorfismo para armazenar objetos Celular em uma lista de Produtos
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(celular1);
        listaProdutos.add(celular2);
        listaProdutos.add(celular3);

        // Exibição dos produtos da lista
        for (Produto produto : listaProdutos) {
            System.out.println(produto);
            System.out.println();
        }
    }
}

