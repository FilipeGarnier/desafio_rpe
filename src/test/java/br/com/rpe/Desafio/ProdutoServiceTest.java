package br.com.rpe.Desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.rpe.Desafio.model.Produto;
import br.com.rpe.Desafio.repository.ProdutoRepository;
import br.com.rpe.Desafio.service.ProdutoService;

@SpringBootTest
class ProdutoServiceTest {
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Test
	public void novoProduto() {
		
		Produto produto = new Produto();
		
		produto.setId(1L);
		produto.setDescricao("credito");
		produto.setStatus("ATIVO");
		produto.setDataCriacao(new Date());
		
		Mockito.when(produtoService.save(produto)).thenReturn(produto);
		
	}
	
	@Test
    public void testId() {
		Produto produto = new Produto();
        Long id = 1L;
        produto.setId(id);
        assertEquals(id, produto.getId());
    }

    @Test
    public void testDescricao() {
    	Produto produto = new Produto();
        String descricao = "Descrição de teste";
        produto.setDescricao(descricao);
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    public void testStatus() {
    	Produto produto = new Produto();
        String status = "Ativo";
        produto.setStatus(status);
        assertEquals(status, produto.getStatus());
    }

    @Test
    public void testDataCriacao() {
    	Produto produto = new Produto();
        Date dataCriacao = new Date();
        produto.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, produto.getDataCriacao());
    }

    @Test
    public void testDataAtualizacao() {
    	Produto produto = new Produto();
        Date dataAtualizacao = new Date();
        produto.setDataAtualizacao(dataAtualizacao);
        assertEquals(dataAtualizacao, produto.getDataAtualizacao());
    }
	
	
	
}
