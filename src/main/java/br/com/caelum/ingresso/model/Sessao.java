package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

	private Integer id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
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
	
	public Sessao(Integer id, LocalTime horario, Sala sala, Filme filme) {
		super();
		this.id = id;
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
	}
	
	public LocalTime getHorarioTermino()
	{
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	
}
