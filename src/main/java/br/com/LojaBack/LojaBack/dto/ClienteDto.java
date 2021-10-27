package br.com.LojaBack.LojaBack.dto;

import br.com.LojaBack.LojaBack.model.Cliente;

public class ClienteDto {

	private Long id;
	private String nomeEmpresa;
	private Boolean Status;

	public Cliente TransformarEmCliente() {
		return new Cliente(id, nomeEmpresa, Status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

}
