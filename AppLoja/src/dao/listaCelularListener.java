package dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listaCelularListener implements ActionListener
{
	private Controller controller;
	
	public listaCelularListener(Controller controller) 
	{
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.exibirCelular();
	}
}
