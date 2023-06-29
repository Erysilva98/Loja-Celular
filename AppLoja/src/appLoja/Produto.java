package appLoja;

public abstract class Produto {
    protected String marca;
    protected double preco;
	public Celular modelo;
	public Celular sistemaOperacional;

    public Produto(String marca, double preco ) {
        this.marca = marca;
        this.preco = preco;
    }

    public abstract String getDescricao();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    protected abstract Object getModelo();
    
	protected abstract void setModelo(String modelo2);
    
    protected abstract Object getSistemaOperacional();
    
    protected abstract void setSistemaOperacional(String sistema);

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Preço: " + preco;
    }

	



	

	
}



