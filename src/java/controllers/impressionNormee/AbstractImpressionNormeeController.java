/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impressionNormee;

import entities.Datavalue;
import entities.Model;
import entities.Organisationunit;
import entities.Period;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.model.TreeNode;
import sessions.DatavalueFacadeLocal;
import sessions.ModelFacadeLocal;
import sessions.OrganisationunitFacadeLocal;
import sessions.PeriodFacadeLocal;
import utils.DataConstituant;
import utils.DataElementTreated;
import utils.DataForm;
import utils.Routine;

/**
 *
 * @author USER
 */
public class AbstractImpressionNormeeController {

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
    protected ModelFacadeLocal modelFacadeLocal;
    protected Model model = new Model();
    protected List<Model> models = new ArrayList<>();

    @EJB
    protected DatavalueFacadeLocal datavalueFacadeLocal;
    protected Datavalue datavalue = new Datavalue();
    protected List<Datavalue> datavalues = new ArrayList<>();

    protected DataConstituant dataConstituant = new DataConstituant();
    protected List<DataConstituant> dataConstituants = new ArrayList<>();

    protected List<Datavalue> datavalues_1 = new ArrayList<>();
    protected List<Datavalue> listDeclared = new ArrayList<>();
    protected List<Datavalue> listVerified = new ArrayList<>();
    protected List<Datavalue> listPercentageError = new ArrayList<>();
    protected List<Datavalue> listTarif = new ArrayList<>();
    protected List<Datavalue> listAmount = new ArrayList<>();

    protected List<DataForm> listDataFormDecalared = new ArrayList<>();

    protected List<String> data_elements_string = new ArrayList<>();
    protected List<String> data_elements_string_without_code = new ArrayList<>();
    protected List<DataElementTreated> data_elements_treated = new ArrayList<>();

    protected List<Datavalue> listAgregateDataValue = new ArrayList<>();

    protected String printFileName = "";

    protected Double total_1 = 0d;
    protected Double total_2 = 0d;
    protected Double total_3 = 0d;
    protected Double total_general = 0d;
    protected Double bonus_equity = 0d;
    protected Double bonus_qualite = 0d;
    protected double quarterly_bonus_quality = 0d;

    protected Double bonus_equity_percentage = 0d;

    protected Double quality_assessment_score = 0d;
    protected Double quality_assessment_weight = 35d;
    protected Double quality_assessment_scoreweighted = 0d;

    protected Double quality_perceived_score = 0d;
    protected Double quality_perceived_weight = 35d;
    protected Double quality_perceived_scoreweighted = 0d;

    protected Double index_tool_score = 0d;
    protected Double index_tool_weight = 30d;
    protected Double index_tool_scoreweighted = 0d;

    protected Double quarterly_production = 0d;
    protected Double tariff_bonus_qualite = 0d;
    
    protected Double global_quality_score = 0d;

    protected boolean imprimer = true;
    protected Integer modeImpression = 0;

    public Datavalue getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(Datavalue datavalue) {
        this.datavalue = datavalue;
    }

    public List<Datavalue> getDatavalues() {
        return datavalues;
    }

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

    public void setOrganisationunits(List<Organisationunit> organisationunits) {
        this.organisationunits = organisationunits;
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

    public List<DataConstituant> getDataConstituants() {
        return dataConstituants;
    }

    public DataConstituant getDataConstituant() {
        return dataConstituant;
    }

    public void setDataConstituant(DataConstituant dataConstituant) {
        this.dataConstituant = dataConstituant;
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

    public Double getTotal_1() {
        return total_1;
    }

    public Double getBonus_equity_percentage() {
        return bonus_equity_percentage;
    }

    public Double getBonus_equity() {
        return bonus_equity;
    }

    public Double getTotal_2() {
        return total_2;
    }

    public Double getQuality_assessment_score() {
        return quality_assessment_score;
    }

    public Double getQuality_assessment_weight() {
        return quality_assessment_weight;
    }

    public Double getQuality_assessment_scoreweighted() {
        return quality_assessment_scoreweighted;
    }

    public Double getQuality_perceived_score() {
        return quality_perceived_score;
    }

    public Double getQuality_perceived_weight() {
        return quality_perceived_weight;
    }

    public Double getQuality_perceived_scoreweighted() {
        return quality_perceived_scoreweighted;
    }

    public Double getIndex_tool_score() {
        return index_tool_score;
    }

    public Double getIndex_tool_weight() {
        return index_tool_weight;
    }

    public Double getIndex_tool_scoreweighted() {
        return index_tool_scoreweighted;
    }

    public Double getQuarterly_production() {
        return quarterly_production;
    }

    public String getPrintFileName() {
        return printFileName;
    }

    public boolean isImprimer() {
        return imprimer;
    }

    public Routine getRoutine() {
        return routine;
    }

    public Integer getModeImpression() {
        return modeImpression;
    }

    public void setModeImpression(Integer modeImpression) {
        this.modeImpression = modeImpression;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<Model> getModels() {
        return models;
    }

    public Double getBonus_qualite() {
        return bonus_qualite;
    }

}
