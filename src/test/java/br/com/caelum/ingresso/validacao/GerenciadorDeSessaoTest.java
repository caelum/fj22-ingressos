package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {

	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {

		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();

		Sala sala = new Sala("3D", BigDecimal.TEN);
		List<Sessao> sessoes = Arrays.asList(new Sessao(horario, filme, sala));

		Sessao sessao = new Sessao(horario, filme, sala);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);

		Assert.assertFalse(gerenciador.cabe(sessao));

	}

	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente() {

		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();

		Sala sala = new Sala("3D", BigDecimal.TEN);
		List<Sessao> sessoes = Arrays.asList(new Sessao(horario, filme, sala));

		Sessao sessao = new Sessao(horario.plusHours(1), filme, sala);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);

		Assert.assertFalse(gerenciador.cabe(sessao));

	}

	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente() {

		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();
		Sala sala = new Sala("3D", BigDecimal.TEN);
		List<Sessao> sessoesDaSala = Arrays.asList(new Sessao(horario, filme, sala));
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoesDaSala);

		Assert.assertFalse(gerenciador.cabe(new Sessao(horario.plus(1, ChronoUnit.HOURS), filme, sala)));
	}

	@Test
	public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes() {

		Sala sala = new Sala("3D", BigDecimal.TEN);
		Filme filme1 = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		filme1.setDuracao(90);
		LocalTime dezHoras = LocalTime.parse("10:00:00");
		Sessao sessaoDasDez = new Sessao(dezHoras, filme1, sala);
		Filme filme2 = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		filme2.setDuracao(120);
		LocalTime dezoitoHoras = LocalTime.parse("18:00:00");
		Sessao sessaoDasDezoito = new Sessao(dezoitoHoras, filme2, sala);
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);

		Assert.assertTrue(gerenciador.cabe(new Sessao(LocalTime.parse("13:00:00"), filme2, sala)));
	}

}
