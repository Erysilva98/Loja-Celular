package appLoja;

public class Celular extends Produto {
    private String modelo;
    private String sistemaOperacional;

    public Celular(String marca, double preco, String modelo, String sistemaOperacional) {
        super(marca, preco);
        this.modelo = modelo;
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getDescricao() {
        return marca + " " + modelo + " - " + sistemaOperacional + " - R$" + preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    // Outros métodos específicos de Celular

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Modelo: " + modelo + "\n" +
                "Sistema Operacional: " + sistemaOperacional;
    }
}

