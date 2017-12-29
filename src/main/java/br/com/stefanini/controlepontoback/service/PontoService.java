package br.com.stefanini.controlepontoback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.controlepontoback.converter.FuncionarioConverter;
import br.com.stefanini.controlepontoback.converter.PontoConverter;
import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
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
	public List<PontoDTO> findAll(String nome){
		if(nome == "") {
			return findAllPontos();
		} else {
			return PontoConverter.toDTO(pontoRepository.findByFuncionario_NomeContaining(nome));
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

	public boolean delete(Long id) {
		try{
			pontoRepository.delete(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public PontoDTO findById(Long id) {
		return PontoConverter.getPontoAsDTO(pontoRepository.findById(id));
	}
	public List<PontoDTO> findAllSemSaida(String nome){
		if(nome=="") {
			return PontoConverter.toDTO(pontoRepository.findBySaidaIsNull());
		} else {
			return PontoConverter.toDTO(pontoRepository.findBySaidaIsNullAndFuncionario_NomeContaining(nome));
		}
	}
	public List<FuncionarioDTO> findAllFuncOk() {
		List<FuncionarioDTO> response = FuncionarioConverter.toDTO(pontoRepository.findByFuncionarioOk());
		response.addAll(FuncionarioConverter.toDTO(pontoRepository.findAllNonListedFuncionario()));
		return response;
	}

	
}
