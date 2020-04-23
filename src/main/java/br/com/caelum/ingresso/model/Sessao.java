package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;
import javax.persistence.Entity;


@Entity
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	private BigDecimal preco;
	
	@OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();
	
	public Map<String, List<Lugar>> getMapaDeLugares(){
		return sala.getMapaDeLugares();
		
	}
	
	/**
	 * @deprecated hibernate only
	 * 
	 */
	public Sessao() {
		
	}
	
	public Sessao(LocalTime horario,Filme filme, Sala sala) {
		
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
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

	public Sala getSala() {
		return sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
    public boolean isDisponivel(Lugar lugarSelecionado) {
    	return ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar -> lugar.equals(lugarSelecionado));
    	
    }
	
}
