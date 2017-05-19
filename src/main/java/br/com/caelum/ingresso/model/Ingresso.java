package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private	Integer	id;
	
	@ManyToOne
	private	Sessao	sessao;
	
	@ManyToOne
	private	Lugar	lugar;
	
	private	BigDecimal	preco;

	@Enumerated(EnumType.STRING)
	private	TipoDeIngresso	tipoDeIngresso;
	
	@Deprecated
	public Ingresso() {
		// TODO Auto-generated constructor stub
	}
	
	public	Ingresso(Sessao	sessao,	TipoDeIngresso	tipoDeDesconto,	Lugar lugar)	{
		this.sessao	=	sessao;
		this.tipoDeIngresso	=	tipoDeDesconto;
		this.preco	=	this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar	=	lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public Integer getId() {
		return id;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}
	
	
}