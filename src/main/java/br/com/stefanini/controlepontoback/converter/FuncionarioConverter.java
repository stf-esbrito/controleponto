package br.com.stefanini.controlepontoback.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.model.Funcionario;

public class FuncionarioConverter {

	public static FuncionarioDTO getFuncionarioAsDTO(Funcionario funcionarioModel) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf(funcionarioModel.getCpf());
		funcionarioDTO.setId(funcionarioModel.getId());
		funcionarioDTO.setNome(funcionarioModel.getNome());
		funcionarioDTO.setCreatedByAdmin(AdminConverter.getAdminAsDTO(funcionarioModel.getAdmin()));
		
		return funcionarioDTO;
	}
	public static Funcionario getFuncionarioAsModel(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionarioModel = new Funcionario();
		funcionarioModel.setCpf(funcionarioDTO.getCpf());
		funcionarioModel.setNome(funcionarioDTO.getNome());
		return funcionarioModel;
	}
	public static List<FuncionarioDTO> toDTO(List<Funcionario> funcionariosModel) {
		List<FuncionarioDTO> funcionariosDTO = new ArrayList<>(); 
		if(!funcionariosModel.isEmpty()) {
			funcionariosModel.forEach(func -> {
				funcionariosDTO.add(getFuncionarioAsDTO(func));
			});
		}
		return funcionariosDTO;
	}
	public static List<Funcionario> toModel(List<FuncionarioDTO> funcionariosDTO){
		List<Funcionario> funcionariosModel = new ArrayList<>();
		if(!funcionariosDTO.isEmpty()) {
			funcionariosDTO.forEach(func -> {
				funcionariosModel.add(getFuncionarioAsModel(func));
			});
		}
		return funcionariosModel;
	}
	
	
}
