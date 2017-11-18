package br.com.caelum.ingresso.validacao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import br.com.caelum.ingresso.model.Sessao;



public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private boolean horarioIsValido(Sessao sessaoExistente, Sessao sessaoAtual){
		LocalDate hoje = LocalDate.now();
		LocalDateTime horarioSessao = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime horarioAtual = sessaoAtual.getHorario().atDate(hoje);
		boolean ehAntes = horarioAtual.isBefore(horarioSessao);
		
		if(ehAntes){
			return horarioAtual.plus(sessaoAtual.getFilme().getDuracao()).isBefore(horarioSessao);
		} else {
			return horarioSessao.plus(sessaoExistente.getFilme().getDuracao()).isBefore(horarioAtual);
		}
	}
	
	public boolean cabe(Sessao sessaoAtual){
		Optional<Boolean> optionalCabe = sessoesDaSala.stream().map(sessaoExistente-> horarioIsValido(sessaoExistente, sessaoAtual)).reduce(Boolean::logicalAnd);
		return optionalCabe.orElse(true);
	}
	

}
