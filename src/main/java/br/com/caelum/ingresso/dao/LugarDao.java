package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Lugar;

/**
 * Created by nando on 03/03/17.
 */
@Repository
public class LugarDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Lugar lugar) {
        manager.persist(lugar);
    }

	public Lugar findOne(Integer id) {
		return manager.find(Lugar.class, id);
	}
}
