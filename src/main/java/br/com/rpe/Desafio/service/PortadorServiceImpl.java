package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rpe.Desafio.model.Portador;
import br.com.rpe.Desafio.repository.PortadorRepository;

@Service
public class PortadorServiceImpl implements PortadorService{
	
	@Autowired
    private PortadorRepository portadorRepository;

    @Override
    public Portador save(Portador portador) {
        return portadorRepository.save(portador);
    }

    @Override
    public List<Portador> findAll() {
        return portadorRepository.findAll();
    }

    @Override
    public Optional<Portador> findById(Long id) {
        return portadorRepository.findById(id);
    }

    @Override
    public Portador update(Portador portador) {
        return portadorRepository.save(portador);
    }

}
