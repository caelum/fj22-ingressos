package ingresso;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class SessaoTest {

	@Test
	public void garanteQueOLugarA1EstaOcupadoEOsLugaresA2EA3Disponiveis(){
					Lugar	a1	=	new	Lugar("A",	1);
					Lugar	a2	=	new	Lugar("A",	2);
					Lugar	a3	=	new	Lugar("A",	3);
					Filme	rogueOne	=	new	Filme("Rogue	One",	Duration.ofMinutes(120), "SCI_FI", new BigDecimal("12.0"));
					Sala	eldorado7	=	new	Sala("Eldorado	7",	new	BigDecimal("8.5"));
					Sessao	sessao	=	new	Sessao(LocalTime.now(),	rogueOne,	eldorado7);
					Ingresso ingresso = new	Ingresso(sessao, TipoDeIngresso.INTEIRO,	a1);
					Set<Ingresso>	ingressos	=	Stream.of(ingresso).collect(toSet());
					sessao.setIngressos(ingressos);
					assertFalse(sessao.isDisponivel(a1));
					assertTrue(sessao.isDisponivel(a2));
					assertTrue(sessao.isDisponivel(a3));
	}

	
}
