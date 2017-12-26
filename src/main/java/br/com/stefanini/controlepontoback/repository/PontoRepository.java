package br.com.stefanini.controlepontoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.controlepontoback.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{

	
	Ponto findById(Long id);
}
