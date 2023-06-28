package appLoja;

public abstract class Produto {
	private Integer id;
    protected String marca;
    protected double preco;
	public Celular modelo;
	public Celular sistemaOperacional;

    public Produto(String marca, double preco) {
        this.marca = marca;
        this.preco = preco;
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public abstract String getDescricao();

    // Outros métodos e atributos comuns a todos os produtos

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

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Preço: " + preco;
    }

	protected abstract String getModelo();
}



