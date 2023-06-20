package appLoja;

public class testeAppLoja {

	public static void main(String[] args) {
		
		Celular celular1 = new Celular("Samsung",1999.9, "Androd");
		Celular celular2 = new Celular("Apple", 2499.9, "IoS");
		
		Cliente cliente1 = new Cliente("Ery", "Rua A 123 ", "ery@gmail.com");
		Cliente clinete2 = new Cliente("Kelly"," Rua B 321", "kelly@gmail.com");
		
		AppLoja loja = AppLoja();
		
		//Produtos
		loja.adicionarProduto(celular1);
		loja.adicionarProduto(celular2);
		
		// Exibir Produto da Loja
		Pedido pedido1 = new Pedido(cliente1);
		pedido1.adicionarItem(celular1);
		pedido2.adicionarItem(celular2);
		
		//Exibir detalhes do Pedido
		System.out.println("Detalhes do Pedido");
		pedido1.exibirDetalhes();
		
		//Remover um produto da Loja
		loja.removerProduto(celular);
		
		//Exibir Produto Atualizado
		System.out.println("Produtos Disponivel na Loja");
		loja.exibirProdutos();	
	}

	private static AppLoja AppLoja() {
		// TODO Stub de método gerado automaticamente
		return null;
	}

	private static appLoja appLoja() {
		// TODO Stub de método gerado automaticamente
		return null;
	}
}
