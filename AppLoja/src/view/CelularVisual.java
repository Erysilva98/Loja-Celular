package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CelularVisual {
	private JFrame frame;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField precoTField;
	private JTextArea celularestTextArea;
	private JButton addButton;
	private JButton exibirButton;
	
	public CelularVisual()
	{
		frame = new JFrame("Loja de Celulares ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
	}
}
