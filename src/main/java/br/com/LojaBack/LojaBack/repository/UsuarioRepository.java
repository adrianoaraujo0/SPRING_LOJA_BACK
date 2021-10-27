package br.com.LojaBack.LojaBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.LojaBack.LojaBack.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT u FROM Usuario u")
	List<Usuario> listarUsuarios();

}
