package br.com.rpe.Desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rpe.Desafio.domain.CardMessage;
import br.com.rpe.Desafio.model.Cartao;
import br.com.rpe.Desafio.model.Portador;
import br.com.rpe.Desafio.model.Produto;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;

@Service
public class CartaoQueueService {
	
	@Autowired
    private SqsTemplate sqsTemplate;
	
	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PortadorService portadorService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void publish(CardMessage message) {
		sqsTemplate.send(to -> to.queue("cartao-queue").payload(message));
	}
	
	@SqsListener("${events.queue}")
	public void receiveRecordMessage(CardMessage mensagem) {
		
		Portador portador = portadorService.findById(mensagem.idPortador()).get();
		
		Produto produto = produtoService.findById(mensagem.idProduto()).get();
		
		Cartao cartao = new Cartao();
		
		cartao.setNumeroCartao(mensagem.numero());
		cartao.setPortador(portador);
		cartao.setProduto(produto);
		cartao.setSenha(passwordEncoder.encode(mensagem.senha()));
		cartao.setStatus(mensagem.status());
		cartao.setDataCriacao(mensagem.dataCriacao());
		
		cartaoService.save(cartao);
	   
	}

}
