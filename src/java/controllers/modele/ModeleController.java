package controllers.modele;

import entities.Model;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import utils.JsfUtil;

@ManagedBean
@ViewScoped
public class ModeleController extends AbstractModeleController implements Serializable {

    public void prepareCreate() {
        try {
            /*if (!Utilitaires.isAccess(23L)) {
             signalError("acces_refuse");
             return;
             }*/
            this.mode = "Create";
            this.model = new Model();
            RequestContext.getCurrentInstance().execute("PF('ModelCreerDialog').show()");
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
            RequestContext.getCurrentInstance().execute("PF('ModelCreerDialog').show()");
        } catch (Exception e) {
            signalException(e);
        }
    }

    public void copyModel(Model model) {
        this.mode = "Create";
        this.model = new Model();
        this.model = model;
        this.model.setModelid(0);
        RequestContext.getCurrentInstance().execute("PF('ModelCreerDialog').show()");
    }

    public void create() {
        try {
            if (this.mode.equals("Create")) {
                this.model.setModelid(modelFacadeLocal.nextVal());
                this.modelFacadeLocal.create(this.model);
                model = new Model();
                RequestContext.getCurrentInstance().execute("PF('ModelCreerDialog').hide()");
                signalSuccess();
            } else if (model != null) {
                this.modelFacadeLocal.edit(this.model);
                this.model = new Model();
                this.modifier = this.supprimer = this.consulter = detail = true;
                RequestContext.getCurrentInstance().execute("PF('ModelCreerDialog').hide()");
                signalSuccess();
            } else {
                JsfUtil.addErrorMessage("Aucun magasin selectionné");
            }
        } catch (Exception e) {
            signalException(e);
        }
    }

    public void delete() {
        try {
            if (this.model != null) {
                /*if (!Utilitaires.isAccess(25L)) {
                 signalError("acces_refuse");
                 return;
                 }*/

                this.modelFacadeLocal.remove(this.model);
                this.modifier = this.supprimer = this.consulter = detail = true;
                this.model = new Model();
                signalSuccess();
            } else {
                JsfUtil.addErrorMessage("Aucun Model selectionnée");
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
