package br.com.LojaBack.LojaBack.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import br.com.LojaBack.LojaBack.exception.RecursoNaoEncontradoException;
import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.repository.ClienteRepository;
import br.com.LojaBack.LojaBack.service.ClienteService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Hello " + name + "!";
	}

	// *************   FAZER CADASTRO   *************
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {

		clienteRepository.save(cliente);

		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

	}

	// *************   METODOS DE FAZER SELECT   *************
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarClientes() {

		List<Cliente> lista = clienteRepository.findAll();

		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public Cliente buscar(@PathVariable Long id) {
		
		try {
			Cliente cliente = clienteService.buscarPorCodigo(id);
			
			return cliente;
		}catch (RecursoNaoEncontradoException excessao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado", excessao);
		}
	}
	
	//*************   FAZER SELECT EM TODOS SEM RESPONSEENTITY   *************
	@GetMapping(value = "listar")
	public List<Cliente> listarTodos(){
		
		List<Cliente> lista =  clienteRepository.findAll();
		
		return lista;
	}

	//*************   FAZER DELETE NO CLIENTE   *************
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletarCliente(@RequestParam Long id) {

		clienteRepository.deleteById(id);

		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);

	}

}
