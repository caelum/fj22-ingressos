package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.TipoDeIngresso;

@Entity
public class Ingresso {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Sessao sessao;
	@ManyToOne
	private Lugar lugar;

	private BigDecimal preco;

	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipo;

	public Ingresso() {
	}

	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeDesconto, Lugar lugar) {
		this.sessao = sessao;
		this.tipo = tipoDeDesconto;
		this.preco = this.tipo.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	public BigDecimal getPrecoComDesconto() {
		return tipo.aplicaDesconto(preco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeIngresso tipo) {
		this.tipo = tipo;
	}
	
	


}
