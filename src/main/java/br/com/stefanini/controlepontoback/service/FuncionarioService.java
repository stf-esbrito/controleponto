package br.com.stefanini.controlepontoback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.controlepontoback.converter.FuncionarioConverter;
import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.model.Funcionario;
import br.com.stefanini.controlepontoback.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private AdminService adminService;
	


	public Funcionario findById(Long id) {
		return funcionarioRepository.findById(id);
	}


	public FuncionarioDTO save(FuncionarioDTO funcionario) {
		return FuncionarioConverter.getFuncionarioAsDTO(funcionarioRepository.save(getFuncionarioAsModel(funcionario)));
	}


	private Funcionario getFuncionarioAsModel(FuncionarioDTO funcionario) {
		Funcionario func = FuncionarioConverter.getFuncionarioAsModel(funcionario);
		func.setAdmin(adminService.findById(func.getAdmin().getId()));
		return func;
	}


	public List<FuncionarioDTO> findAll(String name) {
		return FuncionarioConverter.toDTO(funcionarioRepository.findByNomeContaining(name));
	}
	
}
