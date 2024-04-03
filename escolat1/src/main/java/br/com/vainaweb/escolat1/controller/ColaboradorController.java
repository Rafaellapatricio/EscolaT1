package br.com.vainaweb.escolat1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.ColaboradorRepository;
import br.com.vainaweb.escolat1.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	@Autowired
	private ColaboradorRepository repository;
	
	@GetMapping
	public List<ColaboradorModel> listarTodosOsColaboradores(){
		return service.encontrarTodosOsColaboradores();
	}
	
	@GetMapping("/{id}") //o valor seja pego pela requisição e usaremos ele
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta-> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/*
	 * public BodyBuinding<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND);
	}*/
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados) {
		return service.cadastrar(dados);

	}
	
	 
}