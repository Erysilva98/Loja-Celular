package dao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		view.set
	}
	
	// Gets and Sets

	public List<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}

	public CelularView getView() {
		return view;
	}

	public void setView(CelularView view) {
		this.view = view;
	}	
	
	// method
	
	public void addCelular(String marca, String modelo, double preco) {
		Celular celular = new Celular(marca, modelo, preco);
		celulares.add(celular);
	}
	
	public void exibirCelular() {
		view.lojaCelular(celulares);
	}
	
	public void iniciar() {
		view.appLoja();
	}
	
	
}
