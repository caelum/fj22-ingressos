package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	@NotNull
	private Integer salaId;

	@NotNull
	private Integer filmeid;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;

	public Sessao criaSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Filme filme = filmeDao.findOne(filmeid); 
		Sala sala = salaDao.findOne(salaId);
	  
		Sessao sessao = new Sessao(this.horario, filme, sala);
		
	return sessao;
	}
	
	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public Integer getFilmeid() {
		return filmeid;
	}

	public void setFilmeid(Integer filmeid) {
		this.filmeid = filmeid;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

}
