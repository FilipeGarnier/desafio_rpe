package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import br.com.rpe.Desafio.model.Cartao;

public interface CartaoService {
	
	Cartao save(Cartao cartao);
	
    List<Cartao> findAll();

    Optional<Cartao> findById(Long id);

    Cartao update(Cartao produto);

}
