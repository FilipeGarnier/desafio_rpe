package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import br.com.rpe.Desafio.model.Produto;

public interface ProdutoService {
	
	Produto save(Produto produto);

    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    Produto update(Produto produto);

}
