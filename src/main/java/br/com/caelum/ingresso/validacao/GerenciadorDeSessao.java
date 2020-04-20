package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		System.out.println("GerenciadorDeSessao= " +sessoesDaSala);
		this.sessoesDaSala = sessoesDaSala;

	}

	public boolean cabe(Sessao sessaoNova) {

		System.out.println("Cabe = " +sessaoNova);
		if (terminaAmanha(sessaoNova)) {
			return false;
		}
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
		
	}
	private boolean terminaAmanha(Sessao sessao) {
		System.out.println("terminaAmanha  ");
		
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessao);
		LocalDateTime ultimoSegundoDeHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		
		System.out.println("terminoSessaoNova - " +terminoSessaoNova);
		System.out.println("ultimoSegundoDeHoje - " +ultimoSegundoDeHoje);
		System.out.println("terminahoje  ---  LocalDateTime.of(LocalDate.now(), LocalTime.MAX --- " +LocalDateTime.of(LocalDate.now(), LocalTime.MAX));

		
		if (terminoSessaoNova.isAfter(ultimoSegundoDeHoje)) {
			
			return true;
		}
		
		return false;

	}
	
	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		
		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessaoNova);
		
		
		System.out.println("inicioSessaoExistente - " +inicioSessaoExistente);
		System.out.println("terminoSessaoExistente - " +terminoSessaoExistente);
		System.out.println("inicioSessaoNova - " +inicioSessaoNova);
		System.out.println("terminoSessaoNova - " +terminoSessaoNova);
		
		boolean sessaoNovaTerminaAntesDaExistente = terminoSessaoNova.isBefore(inicioSessaoExistente);
		boolean sessaoNovaComecaDepoisDaExistente = terminoSessaoExistente.isBefore(inicioSessaoNova);
		
		System.out.println("sessaoNovaTerminaAntesDaExistente - " +sessaoNovaTerminaAntesDaExistente);
		System.out.println("sessaoNovaComecaDepoisDaExistente - " +sessaoNovaComecaDepoisDaExistente);

		
		if (sessaoNovaTerminaAntesDaExistente || sessaoNovaComecaDepoisDaExistente) {
			
			return false;
		}
		return true;
	}
	
	private LocalDateTime getInicioSessaoComDiaDeHoje(Sessao sessao) {
		
		System.out.println("Estou getInicioSessaoComDiaDeHoje");
		System.out.println("Estou getInicioSessaoComDiaDeHoje -LocalDate.now()-" +LocalDate.now());
		
		LocalDate hoje = LocalDate.now();
		LocalDateTime da= sessao.getHorario().atDate(hoje);
		System.out.println("Estou getInicioSessaoComDiaDeHoje -- da --" +da);
		
		return sessao.getHorario().atDate(hoje);

	}
	
	private LocalDateTime getTerminoSessaoComDiaDeHoje(Sessao sessao) {
		
		
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessao);
		System.out.println("Estou getInicioSessaoComDiaDeHoje -- inicioSessaoNova --" +inicioSessaoNova);
		System.out.println("Estou getInicioSessaoComDiaDeHoje -- inicioSessaoNova.plus(sessao.getFilme().getDuracao()) --" +inicioSessaoNova.plus(sessao.getFilme().getDuracao()));

		return inicioSessaoNova.plus(sessao.getFilme().getDuracao());
		
	}
}
