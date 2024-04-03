package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_alunos")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	private Long id;
	
	private String nome;
	
	@Column(unique = true) 
	@Email 
	private String email;
	
	@Column(unique = true)
	@CPF 
	private String cpf;
	
	private Curso curso;
	private String telefone;
	
	@Embedded
	private Endereco endereco;

	public AlunoModel(String nome, String email, String cpf, String telefone, Curso curso) {
		this.nome= nome;
		this.email= email;
		this.cpf=cpf;		
		this.telefone=telefone;
		this.curso=curso;
	}
}
