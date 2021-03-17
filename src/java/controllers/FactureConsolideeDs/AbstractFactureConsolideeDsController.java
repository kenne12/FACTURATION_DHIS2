/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.FactureConsolideeDs;

import entities.ModelFcd;
import entities.Organisationunit;
import entities.Period;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.model.TreeNode;
import sessions.ModelFcdFacadeLocal;
import sessions.OrganisationunitFacadeLocal;
import sessions.PeriodFacadeLocal;
import utils.DataConstituantFCD;
import utils.Routine;

/**
 *
 * @author USER
 */
public class AbstractFactureConsolideeDsController {

    protected Connection connection;

    protected Routine routine = new Routine();

    protected TreeNode root;
    protected TreeNode selected;

    @EJB
    protected OrganisationunitFacadeLocal organisationunitFacadeLocal;
    protected Organisationunit organisationunit = new Organisationunit();
    protected List<Organisationunit> organisationunits = new ArrayList<>();

    @EJB
    protected PeriodFacadeLocal periodFacadeLocal;
    protected Period period = new Period();
    protected List<Period> periods = new ArrayList<>();

    @EJB
    protected ModelFcdFacadeLocal modelFcdFacadeLocal;
    protected ModelFcd modelFcd = new ModelFcd();
    protected List<ModelFcd> modelFcds = new ArrayList<>();

    protected List<DataConstituantFCD> listDataValue = new ArrayList<>();

    protected Integer total = 0;

    protected boolean imprimer = true;

    protected String printFileName = "";

    public Organisationunit getOrganisationunit() {
        return organisationunit;
    }

    public void setOrganisationunit(Organisationunit organisationunit) {
        this.organisationunit = organisationunit;
    }

    public List<Organisationunit> getOrganisationunits() {
        organisationunits = organisationunitFacadeLocal.findAll();
        return organisationunits;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public List<Period> getPeriods() {
        periods = periodFacadeLocal.findAll();
        return periods;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelected() {
        return selected;
    }

    public void setSelected(TreeNode selected) {
        this.selected = selected;
    }

    public boolean isImprimer() {
        return imprimer;
    }

    public Routine getRoutine() {
        return routine;
    }

    public ModelFcd getModelFcd() {
        return modelFcd;
    }

    public void setModelFcd(ModelFcd modelFcd) {
        this.modelFcd = modelFcd;
    }

    public List<ModelFcd> getModelFcds() {
        modelFcds = modelFcdFacadeLocal.findAllRangeAnnee();
        return modelFcds;
    }

    public List<DataConstituantFCD> getListDataValue() {
        return listDataValue;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPrintFileName() {
        return printFileName;
    }

}
