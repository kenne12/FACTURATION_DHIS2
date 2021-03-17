/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Optionset;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface OptionsetFacadeLocal {

    void create(Optionset optionset);

    void edit(Optionset optionset);

    void remove(Optionset optionset);

    Optionset find(Object id);

    List<Optionset> findAll();

    List<Optionset> findRange(int[] range);

    int count();
    
}
