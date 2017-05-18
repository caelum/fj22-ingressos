package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesDoFilme {

	@JsonProperty("Title")
	private String titulo;
	
	@JsonProperty("Year")
	private Integer ano;
	
	@JsonProperty("Poster")
	private String imagem;
	
	@JsonProperty("Director")
	private String diretores;
	
	@JsonProperty("Writer")
	private String escritores;
	
	@JsonProperty("Actors")
	private String atores;
	
	@JsonProperty("Plot")
	private String descricao;
	
	@JsonProperty("imdbRating")
	private Double avaliacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDiretores() {
		return diretores;
	}

	public void setDiretores(String diretores) {
		this.diretores = diretores;
	}

	public String getEscritores() {
		return escritores;
	}

	public void setEscritores(String escritores) {
		this.escritores = escritores;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

}
