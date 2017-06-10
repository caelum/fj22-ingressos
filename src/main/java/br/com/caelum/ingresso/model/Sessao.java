package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private Integer id;

	private LocalTime horario;

	@ManyToOne
	private Sala sala;
	@ManyToOne
	private Filme filme;

	private BigDecimal preco;

	@OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();

	protected Sessao() {
	}

	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.setFilme(filme);
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public LocalTime getHorarioTermino() {
		return this.horario.plus(filme.getDuracao().toMinutes(), ChronoUnit.MINUTES);
	}

	public Map<String, List<Lugar>> getMapaDeLugares() {
		return sala.getMapaDeLugares();
	}

	public boolean isDisponivel(Lugar lugar) {
		return getIngressos().stream()
				.map(Ingresso::getLugar)
				
				.noneMatch(l -> l.equals(lugar));
	}

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

}
