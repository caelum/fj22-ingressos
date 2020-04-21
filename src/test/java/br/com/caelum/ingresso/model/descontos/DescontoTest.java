package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {

	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	
	@Before
	public void preparaSessao(){
		this.sala = new Sala("ELDORADO - IMAX", new BigDecimal("20.5"));
		this.filme = new Filme("AMERICAN GODS", Duration.ofMinutes(120),"SCI-FI",new BigDecimal("12"));
		this.sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		Assert.assertEquals(new BigDecimal("32.50"), ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos() {
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaBancos());
		Assert.assertEquals(new BigDecimal("22.75"), ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante() {
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudantes());
		Assert.assertEquals(new BigDecimal("16.25"),ingresso.getPreco());
	}
	
	

	
	
}
