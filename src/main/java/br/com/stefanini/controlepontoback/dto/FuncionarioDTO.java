package br.com.stefanini.controlepontoback.dto;

public class FuncionarioDTO {
	private Long id;
	private String nome;
	private String cpf;
	private AdminDTO createdByAdmin;
	
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
	public AdminDTO getCreatedByAdmin() {
		return createdByAdmin;
	}
	public void setCreatedByAdmin(AdminDTO createdByAdmin) {
		this.createdByAdmin = createdByAdmin;
	}
}
