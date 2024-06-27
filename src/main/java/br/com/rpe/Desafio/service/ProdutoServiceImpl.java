package br.com.rpe.Desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.rpe.Desafio.model.Produto;
import br.com.rpe.Desafio.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
    private ProdutoRepository produtoRepository;

	@CacheEvict(cacheNames = "produtos", allEntries = true)
    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Cacheable(cacheNames = "produtos")
    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Cacheable(cacheNames = "produto", key = "#id")
    @Override
    public Optional<Produto> findById(Long id) {   	
        return produtoRepository.findById(id);
    }

    @CacheEvict(cacheNames = "produtos", allEntries = true)
    @Override
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }
}
