package br.com.stefanini.controlepontoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.controlepontoback.dto.PontoDTO;
import br.com.stefanini.controlepontoback.service.PontoService;

@CrossOrigin
@RestController
@RequestMapping
public class PontoController {

	@Autowired
	private PontoService pontoService;
	
	@GetMapping
	public List<PontoDTO> findAll(@RequestParam(value = "id", defaultValue = "0") Long id){
		return pontoService.findAll(id);
	}
	
	@PostMapping("save")
	public PontoDTO save(@RequestBody PontoDTO ponto){
		return pontoService.save(ponto);
	}
	
	@PutMapping("save")
	public PontoDTO update(@RequestBody PontoDTO ponto) {
		return pontoService.update(ponto);
	}
	
	@DeleteMapping("delete")
	public boolean delete(@RequestBody PontoDTO ponto) {
		return pontoService.delete(ponto);
	}
	

	
}
