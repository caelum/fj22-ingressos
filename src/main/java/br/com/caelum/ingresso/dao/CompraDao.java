package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Compra;

@Repository
public class CompraDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Compra compra){
		manager.persist(compra);
	}
}
