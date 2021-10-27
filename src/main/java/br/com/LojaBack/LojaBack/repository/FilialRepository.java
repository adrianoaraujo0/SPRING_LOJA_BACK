package br.com.LojaBack.LojaBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.LojaBack.LojaBack.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

	@Query(value = "SELECT u FROM Filial u")
	List<Filial> listarFiliais();
	
	
}
