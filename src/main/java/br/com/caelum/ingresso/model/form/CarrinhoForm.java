package br.com.caelum.ingresso.model.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.TipoDeIngresso;
import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;

public class CarrinhoForm {

	private List<Ingresso> ingressos = new ArrayList<>();
	
	public List<Ingresso> getIngressos(){
		return ingressos;
	}
	
	public void setIngressos(List<Ingresso> ingressos){
		this.ingressos = ingressos;
	}
	
	public boolean isSelecionado(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}
	
	public List<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao){
		
		return this.ingressos.stream().map(ingresso -> {
			System.out.println(ingresso.getTipo());
			System.out.println(ingresso.getSessao().getId());
			System.out.println(ingresso.getLugar().getId());
			Sessao sessao = sessaoDao.findOne(ingresso.getSessao().getId());
			Lugar lugar = lugarDao.findOne(ingresso.getLugar().getId());
			TipoDeIngresso tipoDeIngresso = ingresso.getTipo();
			
			return new Ingresso(sessao, tipoDeIngresso, lugar);
		}).collect(Collectors.toList()) ;
	}
	
}
