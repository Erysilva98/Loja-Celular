package appLoja;

public class Celular extends Produto {
	private String sistemaOperacional;
	
	public Celular ( String marca, double preco, String sistemaOperacional){
		super(marca,preco);
		this.setSistemaOperacional(sistemaOperacional); 
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	
	public void exibirDetalhes() {
		System.out.println("Marca: " + getMarca());
		System.out.println("Preço: R$" + getPreco());
		System.out.println("Sistema Operacional: "+ sistemaOperacional);
	}

	private String getPreco() {
		// TODO Stub de método gerado automaticamente
		return null;
	}

	private String getMarca() {
		// TODO Stub de método gerado automaticamente
		return null;
	}
	
}
