/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.ModelFcd;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface ModelFcdFacadeLocal {

    void create(ModelFcd modelFcd);

    void edit(ModelFcd modelFcd);

    void remove(ModelFcd modelFcd);

    ModelFcd find(Object id);

    List<ModelFcd> findAll();

    List<ModelFcd> findRange(int[] range);

    int count();

    Integer nextVal();

    List<ModelFcd> findAllRangeAnnee();

}
