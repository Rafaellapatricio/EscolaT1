package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;
import br.com.vainaweb.escolat1.model.AlunoModel;

public record DadosListaAluno(String nome, String email,Curso curso) {
	public DadosListaAluno(AlunoModel aluno) {
		this(aluno.getNome(),aluno.getEmail(), aluno.getCurso());
	}
	
}
