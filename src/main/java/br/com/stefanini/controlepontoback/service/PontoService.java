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
	
	
	@Autowired
	private FuncionarioService funcionarioService;


	public List<PontoDTO> findAllPontos() {
		return PontoConverter.toDTO(pontoRepository.findAll());
	}
	public List<PontoDTO> findAll(Long id){
		if(id == 0) {
			return findAllPontos();
		} else {
			return findByFuncionarioId(id);
		}
	}

	public PontoDTO save(PontoDTO ponto) {
		Ponto pontoModel = null;
		Ponto pontoBuscado = null;
		if(ponto.getId() != null) {
			pontoBuscado = pontoRepository.findById(ponto.getId());
		}
		if(pontoBuscado != null) {
			pontoBuscado.setSaida(ponto.getSaida());
			return PontoConverter.getPontoAsDTO(pontoRepository.save(pontoBuscado));
		} else {
			pontoModel = PontoConverter.getPontoAsModel(ponto);
			pontoModel.setFuncionario(funcionarioService.findById(ponto.getFuncionario().getId()));
			return PontoConverter.getPontoAsDTO(pontoRepository.save(pontoModel));
		}
	}

	public PontoDTO update(PontoDTO ponto) {
		Ponto pontoAtual = pontoRepository.findById(ponto.getId());
		pontoAtual.setSaida(ponto.getSaida());
		return PontoConverter.getPontoAsDTO(pontoRepository.save(pontoAtual));
	}

	public boolean delete(PontoDTO ponto) {
		try{
			pontoRepository.delete(ponto.getId());
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public List<PontoDTO> findByFuncionarioId(Long id) {
		List<Ponto> pontos = pontoRepository.findByIdFuncionario(id);
		return PontoConverter.toDTO(pontos);
	}

	
}
