package br.com.LojaBack.LojaBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LojaBack.LojaBack.exception.RecursoNaoEncontradoException;
import br.com.LojaBack.LojaBack.model.Cliente;
import br.com.LojaBack.LojaBack.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarPorCodigo(Long id) {

		Optional<Cliente> busca = clienteRepository.findById(id);

		if (busca.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return busca.get();

	}

	// SALVAR
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// SELECT
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	// DELETE
	public void remover(Long id) {
		clienteRepository.deleteById(id);

	}

	//ALTERAR
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
