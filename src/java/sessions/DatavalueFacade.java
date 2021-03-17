/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Datavalue;
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
public class DatavalueFacade extends AbstractFacade<Datavalue> implements DatavalueFacadeLocal {
    
    @PersistenceContext(unitName = "FACTURE_PBFPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public DatavalueFacade() {
        super(Datavalue.class);
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdStoredBy(long organisationunitId, int periodId, String storedBy) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby = :storeby");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storeby", storedBy);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitId(long organisationunitId, int periodId, String storedBy, String indicateur) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby = :storeby AND d.comment LIKE :x");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storeby", storedBy).setParameter("x", indicateur);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdCommentNull(long organisationunitId, int periodId) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.comment = :comment ORDER BY d.dataelement.name");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("comment", null);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdNotStoredByOpenRbf2(long organisationunitId, int periodId, String storedBy) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby != :storedby ORDER BY d.dataelement.name");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storedby", storedBy);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdStoredByOpenRbf2(long organisationunitId, int periodId, String storedBy) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby = :storedby ORDER BY d.dataelement.name");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storedby", storedBy);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdDeName(long organisationunitId, int periodId, String deName) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.dataelement.name like :deName");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("deName", deName);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdDeName(long organisationunitId, int periodId, String deName, String storedBy) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.dataelement.name like :deName AND d.storedby=:storedBy");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("deName", deName).setParameter("storedBy", storedBy);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdNotStoredByOpenRbf2ContainsType(long organisationunitId, int periodId, String storedBy, String type) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby != :storedby AND d.dataelement.name like :type ORDER BY d.dataelement.name");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storedby", storedBy).setParameter("type", type);
        return query.getResultList();
    }
    
    @Override
    public List<Datavalue> findByOrganisationunitIdStoredByContainsType(long organisationunitId, int periodId, String storedBy, String type) {
        Query query = em.createQuery("SELECT d FROM Datavalue d WHERE d.organisationunit.organisationunitid=:orgunitid AND d.period.periodid=:periodid AND d.storedby = :storeby AND d.dataelement.name like :type");
        query.setParameter("orgunitid", organisationunitId).setParameter("periodid", periodId).setParameter("storeby", storedBy).setParameter("type", type);
        return query.getResultList();
    }
    
}
