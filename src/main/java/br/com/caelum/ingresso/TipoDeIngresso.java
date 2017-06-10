package br.com.caelum.ingresso;

import java.math.BigDecimal;

import br.com.caelum.ingresso.desconto.Desconto;
import br.com.caelum.ingresso.desconto.DescontoEstudante;
import br.com.caelum.ingresso.desconto.DescontoTrintaPorcentoParaBancos;
import br.com.caelum.ingresso.desconto.SemDesconto;

public enum TipoDeIngresso {

	INTEIRO(new SemDesconto()), 
	ESTUDANTE(new DescontoEstudante()), 
	BANCO(new DescontoTrintaPorcentoParaBancos());
	private final Desconto desconto;

	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}

	public String getDescricao() {
		return desconto.getDescricao();
	}

}
