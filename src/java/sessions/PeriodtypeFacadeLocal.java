/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Periodtype;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface PeriodtypeFacadeLocal {

    void create(Periodtype periodtype);

    void edit(Periodtype periodtype);

    void remove(Periodtype periodtype);

    Periodtype find(Object id);

    List<Periodtype> findAll();

    List<Periodtype> findRange(int[] range);

    int count();
    
}
