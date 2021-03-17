/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Period;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface PeriodFacadeLocal {

    void create(Period period);

    void edit(Period period);

    void remove(Period period);

    Period find(Object id);

    List<Period> findAll();

    List<Period> findRange(int[] range);

    int count();
    
}
