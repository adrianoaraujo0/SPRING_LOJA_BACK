package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.LojaBack.LojaBack.model.Filial;
import br.com.LojaBack.LojaBack.repository.FilialRepository;

@RestController
@RequestMapping("/Filial")
public class FilialController {

	@Autowired
	FilialRepository filialRepository;
	
	@PostMapping("/Salvar")
	public Filial cadastrar(@RequestParam Filial filial) {

		return filialRepository.save(filial);

	}
	
	@DeleteMapping("/Deletar")
	public String deletarPorId(Long id) {
		
		filialRepository.deleteById(id);
		
		return  "Deletado com sucesso";
	}
	
	@GetMapping
	public List<Filial> listarTodos(){
		List<Filial> lista = filialRepository.findAll();
		
		return lista;
	}
	
}
