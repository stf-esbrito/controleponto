package br.com.stefanini.controlepontoback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.controlepontoback.converter.PontoConverter;
import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.model.Ponto;
import br.com.stefanini.controlepontoback.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository pontoRepository;
	

	public List<PontoDTO> findAll() {
		return PontoConverter.toDTO(pontoRepository.findAll());
	}

	public Ponto save(PontoDTO ponto) {
		return pontoRepository.save(PontoConverter.getPontoAsModel(ponto));
	}
	
}
