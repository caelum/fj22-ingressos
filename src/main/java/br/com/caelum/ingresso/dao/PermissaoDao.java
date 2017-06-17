package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Permissao;

@Repository
public class PermissaoDao {

    @PersistenceContext
    private EntityManager manager;
    
    public void save(Permissao permissao) {
        manager.persist(permissao);
    }
    
}
