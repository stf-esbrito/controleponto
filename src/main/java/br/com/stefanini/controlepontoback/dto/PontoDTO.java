package br.com.stefanini.controlepontoback.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.model.Ponto;

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
	public static PontoDTO getPontoAsDTO(Ponto pnt) {
		PontoDTO pntsDTO = new PontoDTO();
		pntsDTO.setId(pnt.getId());
		pntsDTO.setEntrada(pnt.getEntrada());
		pntsDTO.setSaida(pnt.getSaida());
		pntsDTO.setFuncionario(FuncionarioDTO.getFuncAsDTO(pnt.getFuncionario()));
		return pntsDTO;
	}
	public static List<PontoDTO> converter(List<Ponto> pontosBatidos){
		List<PontoDTO> pnts = new ArrayList<>();
		if(!pontosBatidos.isEmpty()) {
			pontosBatidos.forEach(pnt -> {
				pnts.add(getPontoAsDTO(pnt));
			});
		}
		return pnts;
	}

}
