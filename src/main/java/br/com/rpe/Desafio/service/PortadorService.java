package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import br.com.rpe.Desafio.model.Portador;

public interface PortadorService {
	
	Portador save(Portador portador);
	
    List<Portador> findAll();

    Optional<Portador> findById(Long id);

    Portador update(Portador portador);

}
