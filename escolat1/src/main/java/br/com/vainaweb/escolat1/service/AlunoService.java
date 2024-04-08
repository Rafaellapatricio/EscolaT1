package br.com.vainaweb.escolat1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.dto.DadosListaAluno;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;
import jakarta.validation.Valid;

@Service
public class AlunoService {
	
	
	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarTodosOsAlunos(){
		return repository.findAll();	
}
	//public List<AlunoModel> encontrarTodosOsAlunos(DadosListaAluno dados){		
	//	return repository.findAll();
				//.map(DadosListaAluno::new);
//	}
	
	/*
	 * @GetMapping
	public Optional<AlunoModel> encontrarTodosOsAlunos(){		
		return repository.findAll.map(DadosListaAluno::new);
		
	 */
	public Optional<AlunoModel> cadastrar(DadosAluno dados) {
		var aluno= repository.findByCpf(dados.cpf());
		
		if(aluno.isPresent()) {
			return Optional.empty();
		}
		else {
			return Optional.of(repository.save(new AlunoModel(dados)));
		}
	}

}
