package br.com.stefanini.controlepontoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.service.PontoService;

@CrossOrigin
@RestController
@RequestMapping("pontos")
public class PontoController {

	@Autowired
	private PontoService pontoService;
	
	@GetMapping
	public List<PontoDTO> findAll(@RequestParam(value = "nome", defaultValue="") String nome){
		return pontoService.findAll(nome);
	}
	@GetMapping("/allFuncOk")
	public List<FuncionarioDTO> findAllFuncOk(){
		return pontoService.findAllFuncOk();
	}
	
	@GetMapping("/all")
	public List<PontoDTO> findAllPontosSemSaida(){
		return pontoService.findAllSemSaida();
	}
	@GetMapping("{id}")
	public PontoDTO find(@PathVariable Long id){
		return pontoService.findById(id);
	}
	
	@PostMapping
	public PontoDTO save(@RequestBody PontoDTO ponto){
		return pontoService.save(ponto);
	}
	
	@PutMapping
	public PontoDTO update(@RequestBody PontoDTO ponto) {
		return pontoService.update(ponto);
	}
	
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id) {
		return pontoService.delete(id);
	}
	

	
}
