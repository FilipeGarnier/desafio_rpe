package br.com.rpe.Desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpe.Desafio.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
