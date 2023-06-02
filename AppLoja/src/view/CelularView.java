package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import dao.addCelularListener;
import model.Celular;

public class CelularView {
	private JFrame frame;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField precoTField;
	private JTextArea celularestTextArea;
	private JButton addButton;
	private JButton exibirButton;
	
	public CelularView() {
        frame = new JFrame("Loja de Celulares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
	}
	
	// Gets and sets
	
	public JTextField getMarcaTextField() {
		return marcaTextField;
	}

	public void setMarcaTextField(JTextField marcaTextField) {
		this.marcaTextField = marcaTextField;
	}

	public JTextField getModeloTextField() {
		return modeloTextField;
	}

	public void setModeloTextField(JTextField modeloTextField) {
		this.modeloTextField = modeloTextField;
	}

	public JTextField getPrecoTField() {
		return precoTField;
	}

	public void setPrecoTField(JTextField precoTField) {
		this.precoTField = precoTField;
	}

	public JTextArea getCelularestTextArea() {
		return celularestTextArea;
	}

	public void setCelularestTextArea(JTextArea celularestTextArea) {
		this.celularestTextArea = celularestTextArea;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getExibirButton() {
		return exibirButton;
	}

	public void setExibirButton(JButton exibirButton) {
		this.exibirButton = exibirButton;
	}
	
	// Method 
	
	public void appLoja() {
		frame.setVisible(true);
	}

	public void lojaCelular(List<Celular> celulares) {
		// TODO Stub de método gerado automaticamente
		
	}
}
