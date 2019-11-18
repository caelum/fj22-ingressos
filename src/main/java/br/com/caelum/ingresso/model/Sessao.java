package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {
	private Sala sala;
	private Filme filme;
	private LocalTime horario;

	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
}
