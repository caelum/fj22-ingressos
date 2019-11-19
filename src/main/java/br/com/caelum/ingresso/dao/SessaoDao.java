package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {
	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Sessao sessao) {
		manager.persist(sessao);
	}
	
	public List<Sessao> buscaSessoesDaSala(Sala sala) {
		String sql = "select s from Sessao s where s.sala = :salaParam";
		Query query = manager.createQuery(sql, Sessao.class);
		query.setParameter("salaParam", sala);
		return query.getResultList();
	}
	
	
}
