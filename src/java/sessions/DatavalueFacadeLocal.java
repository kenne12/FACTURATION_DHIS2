/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Datavalue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface DatavalueFacadeLocal {

    void create(Datavalue datavalue);

    void edit(Datavalue datavalue);

    void remove(Datavalue datavalue);

    Datavalue find(Object id);

    List<Datavalue> findAll();

    List<Datavalue> findRange(int[] range);

    int count();

    List<Datavalue> findByOrganisationunitIdStoredBy(long organisationunitId, int periodId, String storedBy);

    List<Datavalue> findByOrganisationunitId(long organisationunitId, int periodId, String storedBy, String indicateur);

    List<Datavalue> findByOrganisationunitIdCommentNull(long organisationunitId, int periodId);

    List<Datavalue> findByOrganisationunitIdNotStoredByOpenRbf2(long organisationunitId, int periodId, String storedBy);

    List<Datavalue> findByOrganisationunitIdStoredByOpenRbf2(long organisationunitId, int periodId, String storedBy);

    List<Datavalue> findByOrganisationunitIdDeName(long organisationunitId, int periodId, String deName);

    List<Datavalue> findByOrganisationunitIdDeName(long organisationunitId, int periodId, String deName, String storedBy);

    List<Datavalue> findByOrganisationunitIdNotStoredByOpenRbf2ContainsType(long organisationunitId, int periodId, String storedBy, String type);

    List<Datavalue> findByOrganisationunitIdStoredByContainsType(long organisationunitId, int periodId, String storedBy, String type);

}
