package controller;
import service.ServiceProduto;

public class ControllerProduto {
	private ServiceProduto servicos;
	
	public ControllerProduto()
	{
		this.setServicos(new ServiceProduto());
	}

	public ServiceProduto getServicos() {
		return servicos;
	}

	public void setServicos(ServiceProduto servicos) {
		this.servicos = servicos;
	}
}
