package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;
import br.com.caelum.ingresso.model.descontos.SemDesconto;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class DescontoTest {
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		Lugar lugar = new Lugar("A", 1);
		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));
		//BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.5");
		
		Assert.assertEquals(precoEsperado,  ingresso.getPreco());
		
	}

}

