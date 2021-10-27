package br.com.LojaBack.LojaBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.LojaBack.LojaBack.dto.ClienteDto;
import br.com.LojaBack.LojaBack.exception.RecursoNaoEncontradoException;
import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.repository.ClienteRepository;
import br.com.LojaBack.LojaBack.service.ClienteService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	// ************* FAZER CADASTRO *************
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDto dto) {

		Cliente cliente = clienteRepository.save(dto.TransformarEmCliente());

		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

	}

	// ************* METODOS DE FAZER SELECT *************
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarClientes() {

		List<Cliente> lista = clienteService.listarCliente();

		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public Cliente buscar(@PathVariable Long id) {

		try {
			Cliente cliente = clienteService.buscarPorCodigo(id);

			return cliente;
		} catch (RecursoNaoEncontradoException excessao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado", excessao);
		}
	}
	
	@GetMapping("/clientesAtivos")
	public ResponseEntity<List<Cliente>> buscarClientesAtivos() {
		List<Cliente> lista = clienteRepository.BuscarClientesAtivos();
	
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/ordemAlfabetica")
	public ResponseEntity<List<Cliente>> buscarClienteOrdemAlfabetica(){
		
		List<Cliente> lista = clienteRepository.BuscarOrdemAlfabetica();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	// ************* FAZER DELETE NO CLIENTE *************
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletarCliente(@RequestParam Long id) {

		clienteService.remover(id);

		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);

	}

	// ************* FAZER ALTERAR NO CLIENTE *************
	@PutMapping("/alterar")
	public ResponseEntity<Cliente> alterar(@RequestBody ClienteDto dto){
		Cliente cliente = clienteService.alterar(dto.TransformarEmCliente());
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
