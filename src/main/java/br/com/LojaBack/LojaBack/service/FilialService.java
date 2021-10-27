package br.com.LojaBack.LojaBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LojaBack.LojaBack.model.Filial;
import br.com.LojaBack.LojaBack.repository.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;

	// SALVAR
	public Filial salvar(Filial filial) {
		return filialRepository.save(filial);
	}

	// SELECT
	public List<Filial> listar() {
		return filialRepository.listarFiliais();
	}

	// DELETE
	public void remover(Long id) {
		filialRepository.deleteById(id);

	}

	// ALTERAR
	public Filial alterar(Filial filial) {
		return filialRepository.save(filial);
	}

}
