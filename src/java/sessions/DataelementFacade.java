/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Dataelement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class DataelementFacade extends AbstractFacade<Dataelement> implements DataelementFacadeLocal {
    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DataelementFacade() {
        super(Dataelement.class);
    }
    
}
