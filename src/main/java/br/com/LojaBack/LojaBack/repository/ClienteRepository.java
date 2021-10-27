package br.com.LojaBack.LojaBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.LojaBack.LojaBack.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT nomeEmpresa, Status FROM Cliente WHERE Status = true")
	List<Cliente> BuscarClientesAtivos();
	
	@Query(value = "SELECT nomeEmpresa FROM Cliente ORDER BY nomeEmpresa ASC")
	List<Cliente> BuscarOrdemAlfabetica();

}
