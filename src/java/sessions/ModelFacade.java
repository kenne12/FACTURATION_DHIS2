/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Model;
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
public class ModelFacade extends AbstractFacade<Model> implements ModelFacadeLocal {

    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelFacade() {
        super(Model.class);
    }
    
    @Override
    public Integer nextVal() {
        Query query = this.em.createQuery("SELECT MAX(m.modelid) FROM Model m");
        Integer result = (Integer) query.getSingleResult();
        if (result == null) {
            result = 1;
        } else {
            result = result + 1;
        }
        return result;
    }

    @Override
    public List<Model> findAllRange() {
        Query query = em.createQuery("SELECT m FROM Model m ORDER BY m.name");
        return query.getResultList();
    }

}
