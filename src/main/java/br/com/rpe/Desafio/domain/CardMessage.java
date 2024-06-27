package br.com.rpe.Desafio.domain;

import java.time.LocalDateTime;

public record CardMessage(String numero, String senha, String status, Long idPortador, Long idProduto, LocalDateTime dataCriacao) {

}
