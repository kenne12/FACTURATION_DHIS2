package controllers.modele;

import entities.Model;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import sessions.ModelFacadeLocal;

import utils.Routine;

public class AbstractModeleController {

    @EJB
    protected ModelFacadeLocal modelFacadeLocal;
    protected Model model = new Model();
    protected List<Model> models = new ArrayList();

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

    public void setConsulter(Boolean consulter) {
        this.consulter = consulter;
    }

    public Boolean getImprimer() {
        return this.imprimer;
    }

    public Boolean getSupprimer() {
        return this.supprimer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.modifier = (this.supprimer = this.detail = model == null);
        this.model = model;
    }

    public List<Model> getModels() {
        models = modelFacadeLocal.findAllRange();
        return models;
    }

    public Routine getRoutine() {
        return this.routine;
    }

}
