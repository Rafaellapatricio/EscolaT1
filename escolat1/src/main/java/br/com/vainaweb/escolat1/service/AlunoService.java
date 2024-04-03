package br.com.vainaweb.escolat1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarTodosOsAlunos(){
		return repository.findAll();
	}
	
	public String cadastrar(DadosAluno dados) {
		var alunoExistente= repository.findByCpf(dados.cpf());
		
		if(dados.cpf()== alunoExistente.get().getCpf()) {
			return "Aluno já cadastrado.";
		}
		else {
			var aluno= new AlunoModel(dados.nome(),dados.email(), dados.cpf(), dados.telefone(), dados.curso());
			repository.save(aluno);
			return "Cadastro efeituado com sucesso!";
		}
	}
	
	

}
