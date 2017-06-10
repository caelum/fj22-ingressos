package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.desconto.Desconto;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	
	protected Ingresso(){}
	
	public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
	}
	
	public Sessao getSessao() {
		return sessao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
}
