package view;

import javax.swing.*;

import model.Celular;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CelularVisual {
	private JFrame frame;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField precoTextField;
	private JTextArea celularestTextArea;
	private JButton addButton;
	private JButton exibirButton;
	
	public CelularVisual()
	{
		frame = new JFrame("Loja de Celulares ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setLayout(new BorderLayout());
		
		// Panel 
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		// marcaLabel
		
		JLabel marcaLabel = new JLabel("Marca: ");
		panel.add(marcaLabel, constraints);
		
		marcaTextField = ( new JTextField(20) );
		constraints.gridx = 1;
		panel.add(marcaTextField, constraints);
		
		// modeloLabel
		
		JLabel modeloJLabel = new JLabel("Modelo: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(modeloJLabel, constraints);
		
		modeloTextField = new JTextField(20);
		constraints.gridx = 1;
		panel.add(modeloJLabel, constraints);
		
		// precoLabel
		
		JLabel precoJLabel = new JLabel("Preco: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(precoJLabel, constraints);
		
		precoTextField = new JTextField(20);
		constraints.gridx = 1;
		panel.add(precoJLabel, constraints);
		
		// addButton
		
		addButton = new JButton("ADD Celular");
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(addButton, constraints);
		
		exibirButton = new JButton("LIST Celular");
		constraints.gridx = 1;
		panel.add(exibirButton, constraints);
		
		celularestTextArea = new JTextArea(10, 30);
		celularestTextArea.setEditable(false);

		frame.add(panel, BorderLayout.CENTER);
		frame.add( new JScrollPane(celularestTextArea), BorderLayout.SOUTH);
	}
	
	// gets e sets
	
	public String getMarca()
	{
		return marcaTextField.getText();
	}
	
	public String getModelo()
	{
		return modeloTextField.getText();
	}
	
	public double getPreco()
	{
		String precoStr = precoTextField.getText();
		return Double.parseDouble(precoStr);
	}
	
	public void limparCampos() 
	{
		marcaTextField.setText("");
		modeloTextField.setText("");
		precoTextField.setText("");
	}
	
	public void listaCelular(List<Celular> celulares) 
	{
		celularestTextArea.setText("");
		
		for( Celular celular : celulares)
		{
			celularestTextArea.append(celular.toString() + "\n");
		}
	}
	
	public void setAddCelularListener(ActionListener listener)
	{
		addButton.addActionListener(listener);
	}
	
	public void setListaCelularListener(ActionListener listener)
	{
		exibirButton.addActionListener(listener);
	}
	
	public void exibir()
	{
		frame.setVisible(true);
	}
}

































