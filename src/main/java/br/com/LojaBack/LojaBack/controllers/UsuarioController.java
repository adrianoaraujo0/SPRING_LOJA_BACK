package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.LojaBack.LojaBack.dto.UsuarioDto;
import br.com.LojaBack.LojaBack.model.Usuario;
import br.com.LojaBack.LojaBack.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@PostMapping("/salvar")
	public Usuario cadastrar(UsuarioDto dto) {
		
		return usuarioService.salvar(dto.TransformarEmUsuario());
		
	}
	
	@GetMapping
	public List<Usuario> listarTodos(){
		
		return usuarioService.listar();
		
	}
	
	@DeleteMapping("/deletar")
	public String deletePorId(@RequestParam Long id) {
		
		usuarioService.remover(id);
		 
		 return "Deletado com sucesso";
	}
}
