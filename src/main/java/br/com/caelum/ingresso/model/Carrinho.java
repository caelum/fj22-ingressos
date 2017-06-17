package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrinho {

	private List<Ingresso> ingressos = new ArrayList<>();
	
	public void add(Ingresso ingresso){
		getIngressos().add(ingresso);
	}
	
	public BigDecimal getTotal(){
		return getIngressos().stream().map(Ingresso::getPrecoComDesconto).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	public Compra toCompra(){
		return new Compra(ingressos);
	}
	
	public void clear(){
		getIngressos().clear();
	}
	
}
