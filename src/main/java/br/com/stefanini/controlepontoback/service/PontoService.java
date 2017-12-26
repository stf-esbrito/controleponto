package br.com.stefanini.controlepontoback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.controlepontoback.converter.PontoConverter;
import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.model.Ponto;
import br.com.stefanini.controlepontoback.repository.AdminRepository;
import br.com.stefanini.controlepontoback.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	public List<PontoDTO> findAll() {
		return PontoConverter.toDTO(pontoRepository.findAll());
	}

	public PontoDTO save(PontoDTO ponto) {
		Ponto pontoModel = PontoConverter.getPontoAsModel(ponto);		
		pontoModel.getFuncionario().setAdmin(adminRepository.findById(ponto.getFuncionario().getCreatedByAdmin().getId()));
		return PontoConverter.getPontoAsDTO(pontoRepository.save(pontoModel));
	}

	public PontoDTO update(PontoDTO ponto) {
		Ponto pontoAtual = pontoRepository.findById(ponto.getId());
		pontoAtual.setSaida(ponto.getSaida());
		return PontoConverter.getPontoAsDTO(pontoRepository.save(pontoAtual));
	}

	public boolean delete(PontoDTO ponto) {
		Ponto pontoAtual = pontoRepository.findById(ponto.getId());
		try{
			pontoRepository.delete(ponto.getId());
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	
}
