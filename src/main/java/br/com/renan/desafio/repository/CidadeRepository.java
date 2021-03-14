package br.com.renan.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renan.desafio.modelo.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	Cidade findByCidade(String cidade);
	
	Page<Cidade> findByEstado(String estado, Pageable paginacao);
	
	Page<Cidade> findByCidade(String cidade, Pageable paginacao);

	}
