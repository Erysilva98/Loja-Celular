package dao;

import java.util.ArrayList;
import java.util.List;

import model.Celular;
import view.CelularView;

public class Controller {
	private List<Celular> celulares;
	private CelularView view;
	
	public Controller(CelularView view)
	{
		this.view = view;
		this.celulares = new ArrayList<>();
	}
	
	// method
	
	public void addCelular(String marca, String modelo, double preco) {
		Celular celular = new Celular(marca, modelo, preco);
		celulares.add(celular);
	}
	
	public void exibirCelular() 
	{
		view.listaCelular(celulares);
	}

	public void iniciar() 
	{
		view.exibir();
	}
}
