package dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCelularListener implements ActionListener {
	private Controller controller;
	
	public addCelularListener(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String marca = controller.getView().getMarca();
		String modelo = controller.getView().getModelo();
		double preco = controller.getView().getPreco();
		
		controller.addCelular(marca, modelo, preco);
		controller.getView().;
		
	}
}
