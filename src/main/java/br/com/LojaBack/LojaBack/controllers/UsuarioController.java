package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.LojaBack.LojaBack.model.Usuario;
import br.com.LojaBack.LojaBack.repository.UsuarioRepository;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@PostMapping("/Salvar")
	public Usuario cadastrar(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	@GetMapping
	public List<Usuario> listarTodos(){
		
		return usuarioRepository.findAll();
		
	}
	
	@DeleteMapping("/Deletar")
	public String deletePorId(@RequestParam Long id) {
		
		 usuarioRepository.deleteById(id);
		 
		 return "Deletado com sucesso";
	}
}
