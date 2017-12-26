package br.com.stefanini.controlepontoback.util;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;

public class Grafico {
	private FuncionarioDTO funcionario;
	private String horasNoMes;
	
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}
	public String getHorasNoMes() {
		return horasNoMes;
	}
	public void setHorasNoMes(String horasNoMes) {
		this.horasNoMes = horasNoMes;
	}
	
	
}
