package br.com.LojaBack.LojaBack.dto;

import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.model.Filial;

public class FilialDto {

	private Long id;
	private String razaoSocial;
	private int cnpj;
	private String apelidoLoja;

	private Cliente cliente;

	public Filial TransformarEmFilial() {
		return new Filial(id, razaoSocial, cnpj, apelidoLoja, cliente);
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
