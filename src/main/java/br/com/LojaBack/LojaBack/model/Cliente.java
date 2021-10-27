package br.com.LojaBack.LojaBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeEmpresa;
	private Boolean Status;

	public Cliente() {

	}

	public Cliente(String nomeEmpresa, Boolean status) {
		this.nomeEmpresa = nomeEmpresa;
		Status = status;
	}

	public Cliente(Long id, String nomeEmpresa, Boolean status) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		Status = status;
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
