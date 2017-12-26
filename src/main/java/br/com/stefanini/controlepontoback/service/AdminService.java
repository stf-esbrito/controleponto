package br.com.stefanini.controlepontoback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.controlepontoback.model.Admin;
import br.com.stefanini.controlepontoback.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	
	public List<Admin> findAll(){
		return adminRepository.findAll();
	}

	public Admin findById(Long id) {
		return adminRepository.findById(id);
	}

	
	
}
