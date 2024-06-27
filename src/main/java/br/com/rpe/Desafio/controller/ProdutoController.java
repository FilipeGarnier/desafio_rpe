package br.com.rpe.Desafio.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpe.Desafio.model.Produto;
import br.com.rpe.Desafio.service.ProdutoService;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
	
	@Autowired
    private ProdutoService produtoService;
	
	@GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
    	
    	produto.setDataCriacao(new Date());
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
    	
    	produto.setDataAtualizacao(new Date());
    	
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(produto));
    }
}
