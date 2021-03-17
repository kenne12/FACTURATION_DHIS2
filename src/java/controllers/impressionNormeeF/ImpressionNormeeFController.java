/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impressionNormeeF;

import entities.Dataelement;
import entities.Datavalue;
import entities.Organisationunit;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import utils.DataConstituant;
import utils.DataElementTreated;
import utils.DataForm;
import utils.JsfUtil;
import utils.PrintUtils;
import utils.Test;
import utils.Utilitaires;

/**
 *
 * @author USER
 */
@SessionScoped
public class ImpressionNormeeFController extends AbstractImpressionNormeeFController implements Serializable {

    /**
     * Creates a new instance of ImpressionController
     */
    private Map param = new HashMap();

    @PostConstruct
    private void init() {
        try {
            root = new DefaultTreeNode("Root", null);
            selected = new DefaultTreeNode();
            List<Organisationunit> organisationunits = organisationunitFacadeLocal.findByParentNull();
            if (!organisationunits.isEmpty()) {
                for (Organisationunit ou_1 : organisationunits) {
                    TreeNode t_1 = new DefaultTreeNode(ou_1, root);
                    List<Organisationunit> childs = organisationunitFacadeLocal.findByParentId(ou_1.getOrganisationunitid());
                    if (!childs.isEmpty()) {
                        for (Organisationunit ou_2 : childs) {
                            TreeNode t_2 = new DefaultTreeNode(ou_2, t_1);

                            List<Organisationunit> childs2 = organisationunitFacadeLocal.findByParentId(ou_2.getOrganisationunitid());
                            if (!childs.isEmpty()) {
                                for (Organisationunit ou_3 : childs2) {
                                    TreeNode t_3 = new DefaultTreeNode(ou_3, t_2);

                                    List<Organisationunit> childs3 = organisationunitFacadeLocal.findByParentId(ou_3.getOrganisationunitid());
                                    if (!childs3.isEmpty()) {
                                        for (Organisationunit ou_4 : childs3) {
                                            TreeNode t_4 = new DefaultTreeNode(ou_4, t_3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImpressionNormeeFController() {

    }

    public void search() {
        try {
            imprimer = true;

            param = new HashMap();
            dataConstituants.clear();
            total_1 = 0d;
            total_2 = 0d;
            total_general = 0d;
            bonus_equity_percentage = 0d;
            tariff_bonus_qualite = 0d;

            datavalues_1.clear();

            listDeclared.clear();
            listVerified.clear();

            listTarif.clear();
            listPercentageError.clear();
            listAmount.clear();
            listAgregateDataValue.clear();

            listDataFormDecalared.clear();

            data_elements_string.clear();
            data_elements_string_without_code.clear();
            data_elements_treated.clear();

            if (selected == null) {
                JsfUtil.addErrorMessage("Veuillez selectionner une unité d'organisation");
                RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
                return;
            }

            if ((period.getPeriodid() == null || period.getPeriodid() == 0)) {
                RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
                JsfUtil.addErrorMessage("Veuillez selectionner une période");
                return;
            }

            if (model.getModelid() == null || model.getModelid() == 0) {
                RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
                JsfUtil.addErrorMessage("Veuillez selectionner une un type de facture");
                return;
            }

            organisationunit = (Organisationunit) selected.getData();
            period = periodFacadeLocal.find(period.getPeriodid());
            model = modelFacadeLocal.find(model.getModelid());

            //Cette variable contient les valeur declarées et les valeurs validées 
            datavalues_1 = datavalueFacadeLocal.findByOrganisationunitIdNotStoredByOpenRbf2ContainsType(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "%" + model.getType() + "%");
            
            //datavalues_1.addAll(Test.getDatavalueSim(Test.setDvDeclared()));
            //datavalues_1.addAll(Test.getDatavalueSim(Test.setDvValidated()));

            if (!datavalues_1.isEmpty()) {

                String[] regexDeclared = model.getDeclaredRegex().split(";");
                String[] regexValidated = model.getValidatedRegex().split(";");
                String[] regexUnitePrice = model.getUnitPriceRegex().split(";");
                String[] regexPercentageError = model.getPercentageErrorRegex().split(";");
                String[] regexTotalAmount = model.getTotalAmountRegex().split(";");

                for (Datavalue dv : datavalues_1) {
                    String deName = dv.getDataelement().getName();
                    boolean flag = false;
                    for (int i = 0; i < regexDeclared.length; i++) {
                        if (deName.contains(regexDeclared[i])) {
                            listDeclared.add(dv);
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        for (int i = 0; i < regexValidated.length; i++) {
                            if (deName.contains(regexValidated[i])) {
                                listVerified.add(dv);
                                break;
                            }
                        }
                    }
                }

                System.err.println("-----------------------------Déclaration-------------");

                for (Datavalue dv : listDeclared) {
                    String deName = dv.getDataelement().getName();
                    String nameWithCode = "";

                    String[] split = deName.split("-", 4);

                    if (split.length == 4) {
                        nameWithCode = split[1] + " " + split[3];

                        if (!data_elements_string.contains(nameWithCode)) {

                            data_elements_string.add(nameWithCode);

                            DataForm df = new DataForm(split[1], nameWithCode, split[3], dv);
                            listDataFormDecalared.add(df);

                            data_elements_string_without_code.add(split[3]);

                            DataElementTreated det = new DataElementTreated(split[1], nameWithCode, split[3], "");
                            data_elements_treated.add(det);
                        }
                    }
                }

                System.err.println("Taille declared : " + data_elements_string.size());
                System.err.println("Taille declared treated: " + data_elements_treated.size());
                System.err.println("-----------------------------Fin Déclaration-------------");

                listAgregateDataValue = datavalueFacadeLocal.findByOrganisationunitIdStoredByContainsType(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "%" + model.getType() + "%");
                for (Datavalue dv : listAgregateDataValue) {
                    String deName = dv.getDataelement().getName();

                    boolean flag = false;
                    for (int i = 0; i < regexUnitePrice.length; i++) {
                        if (deName.contains(regexUnitePrice[i])) {
                            listTarif.add(dv);
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        for (int i = 0; i < regexPercentageError.length; i++) {
                            if ((deName.contains(regexPercentageError[i]))) {
                                listPercentageError.add(dv);
                                flag = true;
                                break;
                            }
                        }
                    }

                    if (!flag) {
                        for (int i = 0; i < regexTotalAmount.length; i++) {
                            if ((deName.contains(regexTotalAmount[i]))) {
                                listAmount.add(dv);
                                flag = true;
                                break;
                            }
                        }
                    }
                }

                //listPercentageError.clear();
                //listPercentageError.addAll(Test.getDatavalueSim(Test.setDvPercentageError()));
                //listTarif.clear();
                //listTarif.addAll(Test.getDatavalueSim(Test.setDvTarrif()));

                //listAmount.clear();
                //listAmount.addAll(Test.getDatavalueSim(Test.setDvAmount()));

                int counter_data = 0;
                for (String value : data_elements_string) {

                    String code = data_elements_treated.get(counter_data).getCode();

                    String valeurDeclaree = "";
                    String valeurVerifiee = "";
                    String tariff = "";
                    String percentageError = "";
                    String totalAmount = "";

                    for (Datavalue dv : listDeclared) {
                        if (dv.getDataelement().getName().contains(code)) {
                            valeurDeclaree = dv.getValue();
                            break;
                        }
                    }

                    for (Datavalue dv : listVerified) {
                        if (dv.getDataelement().getName().contains(code)) {
                            valeurVerifiee = dv.getValue();
                            break;
                        }
                    }

                    for (Datavalue dv : listPercentageError) {
                        if (dv.getDataelement().getName().contains(code)) {
                            percentageError = dv.getValue();
                            break;
                        }
                    }

                    for (Datavalue dv : listTarif) {
                        String deName = dv.getDataelement().getName();
                        if (deName.contains(code)) {
                            tariff = dv.getValue();
                            break;
                        }
                    }

                    for (Datavalue dv : listAmount) {
                        if ((dv.getDataelement().getName().contains(code))) {
                            totalAmount = dv.getValue();
                            break;
                        }
                    }

                    Double valeur_declaree_double = this.getValue(valeurDeclaree);
                    Double valeur_validee_double = this.getValue(valeurVerifiee);
                    Double valeur_percentage_double = this.getValue(percentageError);
                    Double valeur_tariff_double = this.getValue(tariff);
                    Double valeur_amount_double = this.getValue(totalAmount);

                    dataConstituants.add(new DataConstituant(new Dataelement(value), valeur_declaree_double, valeur_validee_double, valeur_percentage_double, valeur_tariff_double, valeur_amount_double));
                    counter_data += 1;
                }

                quality_assessment_score = 0d;
                param.put("quality_assessement_score", quality_assessment_score);

                quality_assessment_scoreweighted = 0d;
                param.put("quality_assessement_scoreweighted", quality_assessment_score);

                quality_perceived_score = 0d;
                param.put("quality_perceived_score", quality_assessment_score);

                quality_perceived_scoreweighted = 0d;
                param.put("quality_perceived_scoreweighted", quality_perceived_scoreweighted);

                index_tool_score = 0d;
                param.put("index_tool_score", index_tool_score);

                index_tool_scoreweighted = 0d;
                param.put("index_tool_scoreweighted", index_tool_scoreweighted);

                param.put("global_quality_score", global_quality_score);

                listAgregateDataValue.clear();
                listAgregateDataValue.addAll(Test.getDatavalueSim(Test.setDvAgregatedValue()));

                for (Datavalue dv : listAgregateDataValue) {
                    String deName = dv.getDataelement().getName();

                    //Total 1
                    String v = deName.toLowerCase();
                    if (v.equals(model.getTotal1Regex().toLowerCase())) {
                        total_1 = Double.valueOf(dv.getValue());
                        param.put("total_1", total_1);
                    }

                    //Pourcentage bonus equité
                    v = deName.toLowerCase();
                    if (v.equals(model.getPercentageBonusEquiteRegex().toLowerCase())) {
                        bonus_equity_percentage = Double.valueOf(dv.getValue());
                        param.put("equity_bonus_percentage", bonus_equity_percentage);
                    }

                    //Bonus d'amélioration qualité
                    v = deName.toLowerCase();
                    if (v.equals(model.getBonusAmeliorationQualiteRegex().toLowerCase())) {
                        bonus_qualite = Double.valueOf(dv.getValue());
                        param.put("bonus_amelioration_qualite", bonus_qualite);
                    }

                    //Equity bonus
                    v = deName.toLowerCase();
                    if (v.equals(model.getBonusEquiteRegex().toLowerCase())) {
                        bonus_equity = Double.valueOf(dv.getValue());
                        param.put("equity_bonus", bonus_equity);
                    }

                    //Total 2
                    v = deName.toLowerCase();
                    if (v.equals(model.getTotal2Regex().toLowerCase())) {
                        total_2 = Double.valueOf(dv.getValue());
                        param.put("total_2", total_2);
                    }

                    //Quaterly production
                    v = deName.toLowerCase();
                    if (v.equals(model.getQuarterlyProductionRegex().toLowerCase())) {
                        quarterly_production = Double.valueOf(dv.getValue());
                        param.put("quarterly_production", quarterly_production);
                    }

                    //tariff_bonus_qualite
                    v = deName.toLowerCase();
                    if (v.contains(model.getTarrifBonusQualiteRegex().toLowerCase())) {
                        tariff_bonus_qualite = Double.valueOf(dv.getValue());
                        param.put("tariff_baq", tariff_bonus_qualite);
                    }

                    //Quarterly Bonus d'amélioration qualité (QIB)
                    v = deName.toLowerCase();
                    if (v.equals(model.getQuarterlyBonusQualiteRegex().toLowerCase())) {
                        quarterly_bonus_quality = Double.valueOf(dv.getValue());
                        param.put("quarterly_bonus_quality", quarterly_bonus_quality);
                    }

                    // Montant total
                    v = dv.getDataelement().getName().toLowerCase();
                    if (v.equals(model.getTotalGeneralRegex().toLowerCase())) {
                        total_general = Double.valueOf(dv.getValue());
                        param.put("total_general", total_general);
                    }

                    // Quality assement score weighted
                    v = dv.getDataelement().getName().toLowerCase();
                    if (v.equals(model.getQualityAssessmentWeightedScoreRegex().toLowerCase())) {
                        quality_assessment_scoreweighted = Double.valueOf(dv.getValue());
                        param.put("quality_assessement_scoreweighted", quality_assessment_scoreweighted);
                    }

                    // Quality perceived score weighted
                    v = dv.getDataelement().getName().toLowerCase();
                    if (v.equals(model.getQualityPerceivedWeightedScoreRegex().toLowerCase())) {
                        quality_perceived_scoreweighted = Double.valueOf(dv.getValue());
                        param.put("quality_perceived_scoreweighted", quality_perceived_scoreweighted);
                    }

                    // Index tools score weighted
                    v = dv.getDataelement().getName().toLowerCase();
                    if (v.equals(model.getIndexToolWeightedScoreRegex().toLowerCase())) {
                        index_tool_scoreweighted = Double.valueOf(dv.getValue());
                        param.put("index_tool_scoreweighted", index_tool_scoreweighted);
                    }

                    // Global quality score
                    v = dv.getDataelement().getName().toLowerCase();
                    if (v.equals(model.getGlobalQualityScoreRegex().toLowerCase())) {
                        global_quality_score = Double.valueOf(dv.getValue());
                        param.put("global_quality_score", global_quality_score);
                    }
                }
                if (!dataConstituants.isEmpty()) {
                    imprimer = false;
                }

                RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
                signalError("notification.aucune_donnee_trouvee");
            }
        } catch (Exception e) {
            e.printStackTrace();
            signalException(e);
            imprimer = true;
            RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
        }
    }

    public String format(Double d) {
        return Utilitaires.formaterStringMoney(d.intValue());
    }

    private Double getValue(String value) {
        try {
            Double v = null;
            if ((value == null || value.isEmpty())) {
                v = null;
            } else if (value.equals("0")) {
                v = 0d;
            } else {
                v = Double.parseDouble(value);
            }
            return v;
        } catch (Exception e) {
            return null;
        }
    }

    public String returnDateLabel(Date datedebut, Date datefin) {
        DateFormat df;
        String result = "";
        int nbr_jr = Utilitaires.duration(datedebut, datefin);
        if (nbr_jr >= 1 && nbr_jr <= 7) {
            result = "Semaine ";
            df = new SimpleDateFormat("MMMMM W");
            result += df.format(datedebut);
        } else if (nbr_jr >= 28 && nbr_jr <= 31) {
            df = new SimpleDateFormat("MMMMM yyyy");
            result = df.format(datedebut);
        } else if (nbr_jr >= 78 && nbr_jr <= 91) {
            result = "Trimestre : ";
        } else if (nbr_jr >= 187 && nbr_jr <= 182) {
            result = "Semestre";
        } else if (nbr_jr >= 363 && nbr_jr <= 366) {
            df = new SimpleDateFormat("yyyy");
            result = df.format(datedebut);
        }
        return result;
    }

    public void imprimer() {
        try {
            period = periodFacadeLocal.find(period.getPeriodid());
            String periodString = returnDateLabel(period.getStartdate(), period.getEnddate());
            Organisationunit ou_district = organisationunitFacadeLocal.find(organisationunit.getParentid().getOrganisationunitid());
            Organisationunit ou_region = organisationunitFacadeLocal.find(ou_district.getParentid().getOrganisationunitid());
            printFileName = PrintUtils.printFacture(organisationunit, dataConstituants, periodString, ou_district.getName(), ou_region.getName(), param);
            RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
            RequestContext.getCurrentInstance().execute("PF('FactureImprimerDialog').show()");
        } catch (Exception e) {
            this.signalException(e);
        }
    }

    public void signalError(String chaine) {
        this.routine.feedBack("information", "/resources/tool_images/error.png", this.routine.localizeMessage(chaine));
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
