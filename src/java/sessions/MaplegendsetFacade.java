/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Maplegendset;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class MaplegendsetFacade extends AbstractFacade<Maplegendset> implements MaplegendsetFacadeLocal {
    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaplegendsetFacade() {
        super(Maplegendset.class);
    }
    
}
