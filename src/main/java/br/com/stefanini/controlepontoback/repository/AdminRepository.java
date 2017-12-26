package br.com.stefanini.controlepontoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.controlepontoback.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findById(Long id);
	
}
