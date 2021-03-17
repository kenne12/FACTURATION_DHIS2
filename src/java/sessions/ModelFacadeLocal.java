/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Model;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface ModelFacadeLocal {

    void create(Model model);

    void edit(Model model);

    void remove(Model model);

    Model find(Object id);

    List<Model> findAll();

    List<Model> findRange(int[] range);

    int count();

    Integer nextVal();

    List<Model> findAllRange();

}
