package br.com.stefanini.controlepontoback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stefanini.controlepontoback.model.Funcionario;
import br.com.stefanini.controlepontoback.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{

	List<Ponto> findByFuncionario_NomeContaining(String nome);
	
	Ponto findById(Long id);

	List<Ponto> findBySaidaIsNull();
	
	@Query("select distinct p.funcionario from Ponto p where p.saida is not null and p.funcionario not in (select p2.funcionario from Ponto p2 where p2.saida is null and p.funcionario = p2.funcionario)")
	List<Funcionario> findByFuncionarioOk();
	
	@Query("select f from Funcionario f where f not in (select p.funcionario from Ponto p)")
	List<Funcionario> findAllNonListedFuncionario();

	List<Ponto> findBySaidaIsNullAndFuncionario_NomeContaining(String nome);
}