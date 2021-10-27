package br.com.LojaBack.LojaBack.dto;

import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;

	private Cliente cliente;

	public Usuario TransformarEmUsuario() {
		return new Usuario(id, nome, email, telefone, senha, cliente);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
