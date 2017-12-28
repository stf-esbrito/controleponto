package br.com.stefanini.controlepontoback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.controlepontoback.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findById(Long id);

	List<Funcionario> findByNomeContaining(String nome);

}
