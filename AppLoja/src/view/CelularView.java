package view;

import java.util.List;

import model.Celular;

public class CelularView 
{
	private CelularVisual visual;
	
	public CelularView() {
		visual = new CelularVisual();		
	}
	
	public String getMarca()
	{
		return visual.getMarca();
	}
	
	private String getModelo()
	{
		return visual.getModelo();
	}
	
	public double getPreco()
	{
		return visual.getPreco();
	}
	
	public void limparCampos()
	{
		visual.limparCampos();
	}

	public void listaCelular(List<Celular> celulares) {
		// TODO Stub de método gerado automaticamente
		
	}

	public void exibir() {
		// TODO Stub de método gerado automaticamente
		
	}
}
