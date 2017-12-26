package br.com.stefanini.controlepontoback.dto;

import java.util.Date;

public class PontoDTO {
	
	private Long id;
	private Date entrada;
	private Date saida;
	private FuncionarioDTO funcionario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}
	

}
