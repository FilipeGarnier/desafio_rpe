package br.com.rpe.Desafio.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpe.Desafio.domain.CardMessage;
import br.com.rpe.Desafio.domain.ContaRequest;
import br.com.rpe.Desafio.model.Cartao;
import br.com.rpe.Desafio.model.Portador;
import br.com.rpe.Desafio.model.Produto;
import br.com.rpe.Desafio.service.CartaoQueueService;
import br.com.rpe.Desafio.service.CartaoService;
import br.com.rpe.Desafio.service.PortadorService;
import br.com.rpe.Desafio.service.ProdutoService;

@RestController
@RequestMapping("api/conta")
public class ContaController {
	
	@Autowired
	CartaoQueueService service;
	
	@Autowired
	PortadorService portadorService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	CartaoService cartaoService;
	
	@PostMapping
    public ResponseEntity<?> novaConta(@RequestBody ContaRequest request){

		
		Portador portador = new Portador();
		
		portador.setCpf(request.getPortador().getCpf());
		portador.setDataNascimento(request.getPortador().getDataNascimento());
		portador.setNome(request.getPortador().getNome());
		portador.setStatus("ATIVO");
		portador.setDataCriacao(LocalDateTime.now());
		
		portador = portadorService.save(portador);
				
		Produto produto = produtoService.findById(request.getIdProduto()).get();
		
    	var message = new CardMessage(
    			request.getNumero(), 
    			request.getSenha(), 
    			request.getStatus(),
    			portador.getId(),
    			produto.getId(),
    			LocalDateTime.now());	
		
        service.publish(message);
    	
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<Cartao>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.findAll());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Optional<Cartao>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.findById(id));
    }

}
