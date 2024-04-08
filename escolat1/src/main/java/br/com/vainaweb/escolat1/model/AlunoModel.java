package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.dto.DadosAlunoAtualizados;
import br.com.vainaweb.escolat1.dto.DadosColaboradorAtualizados;
import br.com.vainaweb.escolat1.dto.DadosListaAluno;
import br.com.vainaweb.escolat1.dto.EnderecoDTO;
import br.com.vainaweb.escolat1.enums.Curso;
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
	
	@Column(unique = true, nullable=false) 
	@Email 
	private String email;
	
	@Column(unique = true, nullable=false)
	@CPF 
	private String cpf;
	
	private Curso curso;
	private String telefone;
	
	@Embedded
	private Endereco endereco;

	public AlunoModel(DadosAluno dados) {
		this.nome= dados.nome();
		this.email= dados.email();
		this.cpf=dados.cpf();		
		this.telefone=dados.telefone();
		this.curso=dados.curso();
		this.endereco= new Endereco(dados.endereco().cep(), dados.endereco().logradouro(),dados.endereco().bairro(),
				dados.endereco().cidade(),dados.endereco().complemento(), dados.endereco().numero());
	}
		
	public void AlunoLista(DadosListaAluno dados) {
		this.nome= dados.nome();
		this.email=dados.email();
		this.curso=dados.curso();
	}
	
	public void atualizarInfo(@Valid DadosAlunoAtualizados dados) {
		this.nome=dados.nome() != null ? dados.nome():this.nome;
		this.telefone=dados.telefone() != null ?  dados.telefone():this.telefone;
		this.curso=dados.curso() != null ? dados.curso():this.curso;
	}	
}
