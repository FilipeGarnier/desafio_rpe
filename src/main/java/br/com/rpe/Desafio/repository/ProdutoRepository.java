package br.com.rpe.Desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpe.Desafio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
