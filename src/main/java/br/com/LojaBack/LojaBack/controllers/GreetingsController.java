package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.repository.ClienteRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Hello " + name + "!";
	}

	// FAZER CADASTRO
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {

		clienteRepository.save(cliente);

		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

	}

	// FAZER SELECT EM TODOS COM RESPONSEENTITY
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarClientes() {

		List<Cliente> lista = clienteRepository.findAll();

		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	// FAZER SELECT EM TODOS SEM RESPONSEENTITY
	@GetMapping(value = "listar")
	public List<Cliente> listarTodos(){
		
		List<Cliente> lista =  clienteRepository.findAll();
		
		return lista;
	}

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletarCliente(@RequestParam Long id) {

		clienteRepository.deleteById(id);

		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);

	}

}
