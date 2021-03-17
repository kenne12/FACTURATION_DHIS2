/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Dataelement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface DataelementFacadeLocal {

    void create(Dataelement dataelement);

    void edit(Dataelement dataelement);

    void remove(Dataelement dataelement);

    Dataelement find(Object id);

    List<Dataelement> findAll();

    List<Dataelement> findRange(int[] range);

    int count();
    
}
