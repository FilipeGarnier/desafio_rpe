package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rpe.Desafio.model.Cartao;
import br.com.rpe.Desafio.repository.CartaoRepository;

@Service
public class CartaoServiceImpl implements CartaoService{
	
	@Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Override
    public List<Cartao> findAll() {
        return cartaoRepository.findAll();
    }

    @Override
    public Optional<Cartao> findById(Long id) {
        return cartaoRepository.findById(id);
    }

    @Override
    public Cartao update(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

}
