/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.ModelFcd;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
@Stateless
public class ModelFcdFacade extends AbstractFacade<ModelFcd> implements ModelFcdFacadeLocal {

    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelFcdFacade() {
        super(ModelFcd.class);
    }
    
    @Override
    public Integer nextVal() {
        Query query = this.em.createQuery("SELECT MAX(m.modelId) FROM ModelFcd m");
        Integer result = (Integer) query.getSingleResult();
        if (result == null) {
            result = 1;
        } else {
            result = result + 1;
        }
        return result;
    }

    @Override
    public List<ModelFcd> findAllRangeAnnee() {
        Query query = em.createQuery("SELECT m FROM ModelFcd m ORDER BY m.annee");
        return query.getResultList();
    }

}
