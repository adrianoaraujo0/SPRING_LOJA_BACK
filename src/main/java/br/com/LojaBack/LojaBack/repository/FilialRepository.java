package br.com.LojaBack.LojaBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LojaBack.LojaBack.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

}
