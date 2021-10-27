package br.com.LojaBack.LojaBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LojaBack.LojaBack.model.Usuario;
import br.com.LojaBack.LojaBack.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// SALVAR
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// SELECT
	public List<Usuario> listar() {
		return usuarioRepository.listarUsuarios();
	}

	// DELETE
	public void remover(Long id) {
		usuarioRepository.deleteById(id);

	}

	// ALTERAR
	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
