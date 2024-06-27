package br.com.rpe.Desafio.domain;

public class ContaRequest {
	
	private String numero;
	
	private String senha;
	
	private String status;

	private Long idProduto;
	
	private PortadorRequest portador;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public PortadorRequest getPortador() {
		return portador;
	}

	public void setPortador(PortadorRequest portador) {
		this.portador = portador;
	}
}
