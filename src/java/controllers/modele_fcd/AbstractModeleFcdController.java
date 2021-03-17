package controllers.modele_fcd;

import entities.ModelFcd;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import sessions.ModelFcdFacadeLocal;

import utils.Routine;
public class AbstractModeleFcdController {

    @EJB
    protected ModelFcdFacadeLocal modelFcdFacadeLocal;
    protected ModelFcd modelFcd = new ModelFcd();
    protected List<ModelFcd> models = new ArrayList();

    protected Boolean detail = true;
    protected Boolean modifier = true;
    protected Boolean consulter = true;
    protected Boolean imprimer = true;
    protected Boolean supprimer = true;

    protected Routine routine = new Routine();

    protected String mode = "";

    public Boolean getDetail() {
        return this.detail;
    }

    public Boolean getModifier() {
        return this.modifier;
    }

    public Boolean getConsulter() {
        return this.consulter;
    }

    public Boolean getImprimer() {
        return this.imprimer;
    }

    public Boolean getSupprimer() {
        return this.supprimer;
    }

    public ModelFcd getModelFcd() {
        return modelFcd;
    }

    public void setModelFcd(ModelFcd modelFcd) {
        this.modifier = this.supprimer = this.detail = modelFcd == null;
        this.modelFcd = modelFcd;
    }

    public List<ModelFcd> getModels() {
        models = modelFcdFacadeLocal.findAllRangeAnnee();
        return models;
    }

    public Routine getRoutine() {
        return this.routine;
    }

}
