package br.com.stefanini.controlepontoback.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.model.Ponto;

public class PontoConverter {


	public static PontoDTO getPontoAsDTO(Ponto pnt) {
		PontoDTO pntsDTO = new PontoDTO();
		pntsDTO.setId(pnt.getId());
		pntsDTO.setEntrada(pnt.getEntrada());
		pntsDTO.setSaida(pnt.getSaida());
		pntsDTO.setFuncionario(FuncionarioConverter.getFuncionarioAsDTO(pnt.getFuncionario()));
		return pntsDTO;
	}
	public static Ponto getPontoAsModel(PontoDTO pnt) {
		Ponto pntsModel = new Ponto();
		pntsModel.setId(pnt.getId());
		pntsModel.setEntrada(pnt.getEntrada());
		pntsModel.setSaida(pnt.getSaida());
		pntsModel.setFuncionario(FuncionarioConverter.getFuncionarioAsModel(pnt.getFuncionario()));
		return pntsModel;
	}
	public static List<PontoDTO> toDTO(List<Ponto> pontosModel){
		List<PontoDTO> pontosDTO = new ArrayList<>();
		if(!pontosModel.isEmpty()) {
			pontosModel.forEach(pnt -> {
				pontosDTO.add(getPontoAsDTO(pnt));
			});
		}
		return pontosDTO;
	}
	public static List<Ponto> toModel(List<PontoDTO> pontosDTO){
		List<Ponto> pontosModel = new ArrayList<>();
		if(!pontosDTO.isEmpty()) {
			pontosDTO.forEach(pnt -> {
				pontosModel.add(getPontoAsModel(pnt));
			});
		}
		return pontosModel;
	}
	
	
}
