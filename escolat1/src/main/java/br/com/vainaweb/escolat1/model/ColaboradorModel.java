package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.dto.DadosColaboradorAtualizados;
import br.com.vainaweb.escolat1.dto.EnderecoDTO;
import br.com.vainaweb.escolat1.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//classe responsavel pelas entidades
@Entity
@Table(name = "tb_colaboradores" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RestController
public class ColaboradorModel {	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id //Chave Primária
	private Long id;

	private String nome;
	@Column(unique = true) //Formata as colunas
	@Email //Valida isso como um email
	private String email;
	
	@Column(unique = true, nullable=false)
	@CPF //Valida como um CPF
	private String cpf;
	private Cargo cargo;
	
	@Embedded //Incorpora a classe na entidade (OS ATRIBUTOS DESSA CLASSA SERÃO PARTE DA MINHA TABELA)
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public ColaboradorModel(String nome, String email, String cpf, Cargo cargo, @Valid EnderecoDTO endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco= new Endereco(endereco.cep(), endereco.logradouro(), endereco.bairro(), endereco.cidade(),
				endereco.complemento(), endereco.numero());
 	}
	// metodo para validar
	public void atualizarInfo(@Valid DadosColaboradorAtualizados dados) {
		this.nome=dados.nome() != null ? dados.nome():this.nome;
		this.email=dados.email() != null? dados.email():this.email;
	}

}
