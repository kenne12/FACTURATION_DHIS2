package controllers.modele_fcd;

import entities.ModelFcd;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import utils.JsfUtil;

@ManagedBean
@ViewScoped
public class ModeleFcdController extends AbstractModeleFcdController implements Serializable {
    
    public void prepareCreate() {
        try {
            /*if (!Utilitaires.isAccess(23L)) {
             signalError("acces_refuse");
             return;
             }*/
            this.mode = "Create";
            this.modelFcd = new ModelFcd();
            RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').show()");
        } catch (Exception e) {
            signalException(e);
        }
    }
    
    public void prepareEdit() {
        try {
            /*if (!Utilitaires.isAccess(24L)) {
             signalError("acces_refuse");
             return;
             }*/
            
            this.mode = "Edit";
            RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').show()");
        } catch (Exception e) {
            signalException(e);
        }
    }
    
    public void copyModel(ModelFcd model) {
        this.mode = "Copy";
        this.copy(model, modelFcd);
        RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').show()");
    }
    
    private ModelFcd copy(ModelFcd source, ModelFcd dest) {
        dest.setModelId(0);
        dest.setNom(source.getNom());
        dest.setAnnee(source.getAnnee());
        dest.setBankNameCode(source.getBankNameCode());
        dest.setBankAccountNumberCode(source.getBankAccountNumberCode());
        dest.setTotalAmountCode(source.getTotalAmountCode());
        return dest;
    }
    
    public void copyModel() {
        this.mode = "Copy";
        this.modelFcd.setModelId(null);
        RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').show()");
    }
    
    public void create() {
        try {
            if (this.mode.equals("Create")) {
                this.modelFcd.setModelId(modelFcdFacadeLocal.nextVal());
                this.modelFcdFacadeLocal.create(this.modelFcd);
                modelFcd = new ModelFcd();
                RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').hide()");
                signalSuccess();
            } else if (this.mode.equals("Edit")) {
                if (modelFcd != null) {
                    this.modelFcdFacadeLocal.edit(this.modelFcd);
                    this.modelFcd = new ModelFcd();
                    this.modifier = this.supprimer = detail = consulter = true;
                    RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').hide()");
                    signalSuccess();
                } else {
                    JsfUtil.addErrorMessage("Aucun model selectionné");
                }
            } else if (mode.equals("Copy")) {
                ModelFcd copy = new ModelFcd();
                copy = copy(modelFcd, copy);
                copy.setModelId(modelFcdFacadeLocal.nextVal());
                modelFcdFacadeLocal.create(copy);
                this.modifier = this.supprimer = detail = consulter = true;
                modelFcd = new ModelFcd();
                RequestContext.getCurrentInstance().execute("PF('ModeleCreerDialog').hide()");
                signalSuccess();
            }
        } catch (Exception e) {
            signalException(e);
        }
    }
    
    public void delete() {
        try {
            if (this.modelFcd != null) {
                /*if (!Utilitaires.isAccess(25L)) {
                 signalError("acces_refuse");
                 return;
                 }*/
                
                this.modelFcdFacadeLocal.remove(this.modelFcd);
                this.modifier = this.supprimer = detail = consulter = true;
                this.modelFcd = new ModelFcd();
                signalSuccess();
            } else {
                JsfUtil.addErrorMessage("Aucune Model selectionnée");
            }
        } catch (Exception e) {
            signalException(e);
        }
    }
    
    public void signalError(String chaine) {
        this.routine.feedBack("information", "/resources/tool_images/warning.jpeg", this.routine.localizeMessage(chaine));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }
    
    public void signalSuccess() {
        this.routine.feedBack("information", "/resources/tool_images/success.png", this.routine.localizeMessage("operation_reussie"));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }
    
    public void signalException(Exception e) {
        this.routine.catchException(e, this.routine.localizeMessage("erreur_execution"));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }
}
