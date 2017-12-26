package br.com.stefanini.controlepontoback.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.model.Funcionario;

public class FuncionarioDTO {
	private Long id;
	private String nome;
	private String cpf;
	private Long createdByAdmin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getCreatedByAdmin() {
		return createdByAdmin;
	}
	public void setCreatedByAdmin(Long createdByAdmin) {
		this.createdByAdmin = createdByAdmin;
	}
	
	
	public static List<FuncionarioDTO> converter(List<Funcionario> funcs) {
		List<FuncionarioDTO> funcionarios = new ArrayList<>(); 
		if(!funcs.isEmpty()) {
			funcs.forEach(func -> {
				funcionarios.add(getFuncAsDTO(func));
			});
		}
		return funcionarios;
	}
	
	public static FuncionarioDTO getFuncAsDTO(Funcionario func) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf(func.getCpf());
		funcionarioDTO.setId(func.getId());
		funcionarioDTO.setNome(func.getNome());
		funcionarioDTO.setCreatedByAdmin(func.getAdmin().getId());
		
		return funcionarioDTO;
	}
}
