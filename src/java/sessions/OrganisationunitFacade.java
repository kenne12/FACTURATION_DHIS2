/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Organisationunit;
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
public class OrganisationunitFacade extends AbstractFacade<Organisationunit> implements OrganisationunitFacadeLocal {

    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganisationunitFacade() {
        super(Organisationunit.class);
    }

    @Override
    public List<Organisationunit> findByParentNull() {
        Query query = em.createQuery("SELECT ou FROM Organisationunit ou WHERE ou.parentid IS NULL ORDER BY ou.name");
        return query.getResultList();
    }

    @Override
    public List<Organisationunit> findByParentId(int parentId) {
        Query query = em.createQuery("SELECT ou FROM Organisationunit ou WHERE ou.parentid.organisationunitid=:parentId ORDER BY ou.name");
        query.setParameter("parentId", parentId);
        return query.getResultList();
    }

}
