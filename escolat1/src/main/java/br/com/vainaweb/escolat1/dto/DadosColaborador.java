package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Cargo;

public record DadosColaborador(String nome, String email, String cpf, Cargo cargo, EnderecoDTO endereco) {

}