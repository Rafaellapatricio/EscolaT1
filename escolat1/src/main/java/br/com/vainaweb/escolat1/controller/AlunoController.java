package br.com.vainaweb.escolat1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.dto.DadosAlunoAtualizados;
import br.com.vainaweb.escolat1.dto.DadosListaAluno;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;
import br.com.vainaweb.escolat1.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno-teste")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public List<AlunoModel> listarTodosOsAlunos(){
		return service.encontrarTodosOsAlunos();
	}
	
	@PostMapping
	public ResponseEntity<AlunoModel> cadastrar(@RequestBody DadosAluno dados) {
		return service.cadastrar(dados).map(resposta-> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@GetMapping("/{id}")
	public Optional<Object> listarPorId(@PathVariable Long id) {		
		return repository.findById(id).map(DadosListaAluno::new);	
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id,@RequestBody @Valid DadosAlunoAtualizados dados) {
		var aluno=repository.getReferenceById(id);
		repository.save(aluno);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
