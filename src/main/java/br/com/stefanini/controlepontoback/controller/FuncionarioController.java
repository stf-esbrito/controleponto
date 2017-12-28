package br.com.stefanini.controlepontoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.controlepontoback.dto.FuncionarioDTO;
import br.com.stefanini.controlepontoback.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<FuncionarioDTO> findAll(@RequestParam("name") String name){
		return funcionarioService.findAll(name);
	}
	
	@PostMapping
	public FuncionarioDTO save(@RequestBody FuncionarioDTO funcionario) {
		return funcionarioService.save(funcionario);
	}
}
