/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Maplegendset;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface MaplegendsetFacadeLocal {

    void create(Maplegendset maplegendset);

    void edit(Maplegendset maplegendset);

    void remove(Maplegendset maplegendset);

    Maplegendset find(Object id);

    List<Maplegendset> findAll();

    List<Maplegendset> findRange(int[] range);

    int count();
    
}
