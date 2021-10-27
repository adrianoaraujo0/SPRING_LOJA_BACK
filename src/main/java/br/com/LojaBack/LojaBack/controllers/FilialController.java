package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.LojaBack.LojaBack.dto.FilialDto;
import br.com.LojaBack.LojaBack.model.Filial;
import br.com.LojaBack.LojaBack.model.Usuario;
import br.com.LojaBack.LojaBack.service.FilialService;

@RestController
@RequestMapping("/filial")
public class FilialController {
	@Autowired
	private FilialService filialService;
	
	
	
	@PostMapping("/salvar")
	public Filial cadastrar(FilialDto dto) {
		
		return filialService.salvar(dto.TransformarEmFilial());
		
	}
	
	@GetMapping
	public List<Filial> listarTodos(){
		
		return filialService.listar();
		
	}
	
	@DeleteMapping("/deletar")
	public String deletePorId(@RequestParam Long id) {
		
		filialService.remover(id);
		 
		 return "Deletado com sucesso";
	}
	
}
