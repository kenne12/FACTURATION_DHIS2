/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Organisationunit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface OrganisationunitFacadeLocal {

    void create(Organisationunit organisationunit);

    void edit(Organisationunit organisationunit);

    void remove(Organisationunit organisationunit);

    Organisationunit find(Object id);

    List<Organisationunit> findAll();

    List<Organisationunit> findRange(int[] range);

    int count();

    List<Organisationunit> findByParentNull();

    List<Organisationunit> findByParentId(int parentId);

}
