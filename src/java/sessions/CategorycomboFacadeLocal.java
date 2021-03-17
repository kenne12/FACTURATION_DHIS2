/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Categorycombo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface CategorycomboFacadeLocal {

    void create(Categorycombo categorycombo);

    void edit(Categorycombo categorycombo);

    void remove(Categorycombo categorycombo);

    Categorycombo find(Object id);

    List<Categorycombo> findAll();

    List<Categorycombo> findRange(int[] range);

    int count();
    
}
