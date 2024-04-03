package br.com.vainaweb.escolat1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.service.AlunoService;

@RestController
@RequestMapping("/aluno-teste")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public  List<AlunoModel> listarTodosOsAlunos(){
		return service.encontrarTodosOsAlunos();		
	}
	
	@ResponseStatus(code= HttpStatus.CREATED)
	@PostMapping
	public String cadastrar(@RequestBody DadosAluno dados) {
		return service.cadastrar(dados);
	}

}
