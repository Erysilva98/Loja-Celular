package model;

public class Celular {
	private String marca;
	private String modelo;
	private double preco;
	
	public Celular (String marca, String modelo, double preco)
	{
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setPreco(preco);
		
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}