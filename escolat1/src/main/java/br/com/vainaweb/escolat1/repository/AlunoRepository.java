package br.com.vainaweb.escolat1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vainaweb.escolat1.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
	
//	Object findAll List<AlunoModel>;

//	String findAll = null;

	Optional<AlunoModel> findByCpf(String cpf);
	
	Optional<AlunoModel> findById(Long id);
	List<AlunoModel> findAll();
} 
