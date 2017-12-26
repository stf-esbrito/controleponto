package br.com.stefanini.controlepontoback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.stefanini.controlepontoback.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Query("Select p from Ponto p where p.funcionario.id = :id")
	List<Ponto> findByIdFuncionario(@Param("id") Long id);
	
	
	Ponto findById(Long id);
}
