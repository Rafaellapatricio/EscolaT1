package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;

public record DadosAlunoAtualizados(String nome, String telefone, Curso curso, EnderecoDTO endereco) {


}
