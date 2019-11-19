package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Sala sala;
	@ManyToOne
	private Filme filme;
	@Column(nullable = false)
	private LocalTime horario;
	
	/**
	 * @deprecated hibernate only
	 */
	public Sessao() {}
	
	public Sessao(Sala sala, Filme filme, LocalTime horario) {
		this.sala = sala;
		this.filme = filme;
		this.horario = horario;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
}
