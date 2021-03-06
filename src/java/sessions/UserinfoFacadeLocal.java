/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Userinfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface UserinfoFacadeLocal {

    void create(Userinfo userinfo);

    void edit(Userinfo userinfo);

    void remove(Userinfo userinfo);

    Userinfo find(Object id);

    List<Userinfo> findAll();

    List<Userinfo> findRange(int[] range);

    int count();
    
}
