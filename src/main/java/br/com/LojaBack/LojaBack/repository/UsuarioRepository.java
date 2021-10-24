package br.com.LojaBack.LojaBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LojaBack.LojaBack.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	
}
