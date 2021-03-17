/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Categoryoptioncombo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface CategoryoptioncomboFacadeLocal {

    void create(Categoryoptioncombo categoryoptioncombo);

    void edit(Categoryoptioncombo categoryoptioncombo);

    void remove(Categoryoptioncombo categoryoptioncombo);

    Categoryoptioncombo find(Object id);

    List<Categoryoptioncombo> findAll();

    List<Categoryoptioncombo> findRange(int[] range);

    int count();
    
}
