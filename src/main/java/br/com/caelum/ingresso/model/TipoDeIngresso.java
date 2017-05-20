package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.descontos.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoEstudante;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public enum TipoDeIngresso {

	INTEIRO(new	SemDesconto()),
	ESTUDANTE(new	DescontoEstudante()),
	BANCO(new	DescontoDeTrintaPorCentoParaBancos());
	private	final	Desconto	desconto;
	TipoDeIngresso(Desconto	desconto)	{
					this.desconto	=	desconto;
	}
	public	BigDecimal	aplicaDesconto(BigDecimal	valor){
					return	desconto.aplicarDescontoSobre(valor);
	}
	public	String	getDescricao(){
					return	desconto.getDescricao();
	}

}
