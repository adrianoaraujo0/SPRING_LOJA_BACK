package br.com.LojaBack.LojaBack.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Filial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private int cnpj;
	private String apelidoLoja;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Filial() {

	}

	public Filial(Long id, String razaoSocial, int cnpj, String apelidoLoja, Cliente cliente) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.apelidoLoja = apelidoLoja;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getApelidoLoja() {
		return apelidoLoja;
	}

	public void setApelidoLoja(String apelidoLoja) {
		this.apelidoLoja = apelidoLoja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
