package br.com.stefanini.controlepontoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.service.FuncionarioService;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<FuncionarioDTO> findAll(){
		return funcionarioService.findAll();
	}
}
