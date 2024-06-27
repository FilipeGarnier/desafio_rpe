package br.com.rpe.Desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rpe.Desafio.model.Cartao;
import br.com.rpe.Desafio.model.Portador;
import br.com.rpe.Desafio.model.Produto;

@SpringBootTest
class CartaoServiceTest {
	
	private Cartao cartao;
    private Produto produto;
    private Portador portador;

    @BeforeEach
    public void setUp() {
        cartao = new Cartao();
        produto = mock(Produto.class);
        portador = mock(Portador.class);
    }

    @Test
    public void testGetAndSetId() {
        Long id = 1L;
        cartao.setId(id);
        assertEquals(id, cartao.getId());
    }

    @Test
    public void testGetAndSetNumeroCartao() {
        String numeroCartao = "1234567890123456";
        cartao.setNumeroCartao(numeroCartao);
        assertEquals(numeroCartao, cartao.getNumeroCartao());
    }

    @Test
    public void testGetAndSetSenha() {
        String senha = "senha123";
        cartao.setSenha(senha);
        assertEquals(senha, cartao.getSenha());
    }

    @Test
    public void testGetAndSetStatus() {
        String status = "ACTIVE";
        cartao.setStatus(status);
        assertEquals(status, cartao.getStatus());
    }

    @Test
    public void testGetAndSetDataCriacao() {
        LocalDateTime dataCriacao = LocalDateTime.now();
        cartao.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, cartao.getDataCriacao());
    }

    @Test
    public void testGetAndSetDataAtualizacao() {
        LocalDateTime dataAtualizacao = LocalDateTime.now();
        cartao.setDataAtualizacao(dataAtualizacao);
        assertEquals(dataAtualizacao, cartao.getDataAtualizacao());
    }

    @Test
    public void testGetAndSetProduto() {
        cartao.setProduto(produto);
        assertEquals(produto, cartao.getProduto());
    }

    @Test
    public void testGetAndSetPortador() {
        cartao.setPortador(portador);
        assertEquals(portador, cartao.getPortador());
    }

}
