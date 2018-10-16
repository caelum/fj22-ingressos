package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {

	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal()
	{
		Sala sala = new Sala("Eldorado", new BigDecimal("20.5"));
		Filme filme = new Filme("Batman", Duration.ofMinutes(120), "ACAO", new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.parse("12:00:00"), sala, filme);
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		
		BigDecimal precoEsperado = new BigDecimal("32.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
		
		
	}
	
}
