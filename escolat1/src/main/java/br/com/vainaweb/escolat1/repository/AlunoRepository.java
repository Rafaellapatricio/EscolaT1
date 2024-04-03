package br.com.vainaweb.escolat1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vainaweb.escolat1.model.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
	Optional<AlunoModel> findByCpf(String cpf);
}
