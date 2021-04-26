/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impression;

import entities.Dataelement;
import entities.Datavalue;
import entities.Organisationunit;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import utils.Utilitaires;

/**
 *
 * @author USER
 */
@SessionScoped
public class ImpressionController extends AbstractImpressionController implements Serializable {

    /**
     * Creates a new instance of ImpressionController
     */
    private Map param = new HashMap();

    @PostConstruct
    private void init() {
        try {

            modeImpression = 1;

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

    public ImpressionController() {

    }

    private void splitAgregateData(String code, Datavalue dv, List<DataForm> dataForms) {
        String s = dv.getDataelement().getName().replaceAll(code, "");
        if (code.equals("RBF - Price unit -")) {
            String[] split = s.split("-", 2);
            if (split.length >= 2) {
                DataForm df = new DataForm(split[0], s, split[1], dv);
                dataForms.add(df);
            } else {
                System.err.println("less than 2 - " + dv.getDataelement().getName());
            }
        } else {
            String[] split = s.split(" ", 2);
            if (split.length >= 2) {
                DataForm df = new DataForm(split[0], s, split[1], dv);
                dataForms.add(df);
            }
        }
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

            organisationunit = (Organisationunit) selected.getData();
            period = periodFacadeLocal.find(period.getPeriodid());

            if (modeImpression == 1) {

                //Cette variable contient les valeur declarées et les valeurs validées 
                datavalues_1 = datavalueFacadeLocal.findByOrganisationunitIdNotStoredByOpenRbf2(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2");

                if (!datavalues_1.isEmpty()) {

                    for (Datavalue objTemp : datavalues_1) {
                        String deName = objTemp.getDataelement().getName();

                        if ((deName.contains("Declared-") || deName.contains("Declared -"))) {
                            listDeclared.add(objTemp);
                        } else if ((deName.contains("Declared ") || deName.contains("Declared"))) {
                            listDeclared.add(objTemp);
                        }

                        if (deName.contains("Verified-")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("Validated-")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("validated-")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("verified-")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("Verified")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("Validated")) {
                            listVerified.add(objTemp);
                        } else if (deName.contains("verified")) {
                            listVerified.add(objTemp);
                        }
                    }

                    System.err.println("-----------------------------Déclaration-------------");
                    for (Datavalue dv : listDeclared) {

                        String s = "";
                        String deName = dv.getDataelement().getName();

                        if (((deName.charAt(0) == 'U' && deName.charAt(1) == 'F')) == true) {
                            if (deName.contains("-Declared-")) {
                                s = deName.replace("-Declared-", " ");
                            } else if (deName.contains("-declared-")) {
                                s = deName.replace("-declared-", " ");
                            } else if (deName.contains("-Declared -")) {
                                s = deName.replace("-Declared -", " ");
                            } else if (deName.contains("-declared -")) {
                                s = deName.replace("-declared -", " ");
                            }
                        } else {
                            if (deName.contains("Declared-")) {
                                s = deName.replace("Declared-", "");
                            } else if (deName.contains("Declared -")) {
                                s = deName.replace("Declared -", "");
                            } else if (deName.contains("Declared ")) {
                                s = deName.replace("Declared ", "");
                            } else if (deName.contains("Declared")) {
                                s = deName.replace("Declared", "");
                            }

                            if (deName.contains("71.1")) {
                                s = "71.1 Prise en charge du nouveau-né d'une femme VIH+";
                            }
                        }

                        if (s.contains("null -")) {
                            s = s.replaceAll("null -", "");
                        }

                        if (!data_elements_string.contains(s)) {
                            data_elements_string.add(s);

                            String[] split = s.split(" ", 2);
                            DataForm df = new DataForm(split[0], s, split[1], dv);
                            listDataFormDecalared.add(df);

                            data_elements_string_without_code.add(split[1]);

                            DataElementTreated det = new DataElementTreated(split[0], s, split[1], "");
                            data_elements_treated.add(det);
                        }
                    }

                    System.err.println("Taille declared : " + data_elements_string.size());
                    System.err.println("-----------------------------Fin Déclaration-------------");

                    listAgregateDataValue = datavalueFacadeLocal.findByOrganisationunitIdStoredBy(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2");

                    for (Datavalue dv : listAgregateDataValue) {
                        String deName = dv.getDataelement().getName();
                        if (deName.contains("Tariff-")) {
                            listTarif.add(dv);
                        } else if (deName.contains("Tariff -")) {
                            listTarif.add(dv);
                        } else if (deName.contains("Tarif-")) {
                            listTarif.add(dv);
                        } else if (deName.contains("Tarif -")) {
                            listTarif.add(dv);
                        } else if (deName.contains("RBF - Price unit -")) {
                            listTarif.add(dv);
                        } else if (deName.contains("RBF - Price unit")) {
                            listTarif.add(dv);
                        }

                        if (deName.contains("Percent Error-")) {
                            listPercentageError.add(dv);
                        } else if (deName.contains("Percent Error -")) {
                            listPercentageError.add(dv);
                        } else if (deName.contains("RBF - Diff %")) {
                            listPercentageError.add(dv);
                        }

                        if ((!dv.getDataelement().getName().contains("Synth") && dv.getDataelement().getName().contains("Amount-"))) {
                            listAmount.add(dv);
                        } else if ((!dv.getDataelement().getName().contains("Synth") && dv.getDataelement().getName().contains("Amount -"))) {
                            listAmount.add(dv);
                        } else if (deName.contains("RBF - Amount -")) {
                            listAmount.add(dv);
                        }

                        if ((dv.getDataelement().getName().contains("RBF - SynthAmount - "))) {
                            listAmount.add(dv);
                        }
                    }

                    int counter_data = 0;
                    List<Datavalue> listDv71 = new ArrayList<>();
                    for (String value : data_elements_string) {

                        //System.err.println("*Indicateur :" + value);
                        String data_element_duo = data_elements_string_without_code.get(counter_data);
                        //System.err.println("-Indicateur :" + data_element_duo);

                        String valeur_declaree = "";
                        String valeur_verifiee = "";
                        String tariff = "";
                        String percentage = "";
                        String amount = "";

                        for (Datavalue dv : listDeclared) {
                            if (dv.getDataelement().getName().contains(data_element_duo)) {
                                valeur_declaree = dv.getValue();
                                break;
                            }
                        }

                        for (Datavalue dv : listVerified) {
                            if (dv.getDataelement().getName().contains(data_element_duo)) {
                                valeur_verifiee = dv.getValue();
                                break;
                            }
                        }

                        if (value.contains("71.1")) {

                            listDv71 = datavalueFacadeLocal.findByOrganisationunitIdDeName(organisationunit.getOrganisationunitid(), period.getPeriodid(), "%Prise en charge du nouveau né d'une femme VIH+%");
                            if (listDv71.isEmpty()) {
                                listDv71 = datavalueFacadeLocal.findByOrganisationunitIdDeName(organisationunit.getOrganisationunitid(), period.getPeriodid(), "71.1 Prise en charge du nouveau-né d'une femme VIH+%");
                            }
                            for (Datavalue dvTemp : listDv71) {
                                if (dvTemp.getDataelement().getName().contains("Declared")) {
                                    valeur_declaree = dvTemp.getValue();
                                }

                                if (dvTemp.getDataelement().getName().contains("Validated")) {
                                    valeur_verifiee = dvTemp.getValue();
                                }
                            }
                        }

                        boolean search_p = false;
                        for (Datavalue dv : listPercentageError) {
                            if (dv.getDataelement().getName().contains(data_element_duo)) {
                                percentage = dv.getValue();
                                search_p = true;
                                break;
                            }
                        }

                        if (!search_p) {
                            if (value.contains("60.0")) {
                                List<Datavalue> dvTemp = datavalueFacadeLocal.findByOrganisationunitIdDeName(organisationunit.getOrganisationunitid(), period.getPeriodid(), "%Consulation Post Natale (CPON) Mère et Enfant%", "openrbf2");
                                if (!dvTemp.isEmpty()) {
                                    for (Datavalue dvOther : dvTemp) {
                                        String deName = dvOther.getDataelement().getName();
                                        if ((deName.contains("RBF - Diff") || deName.contains("Percent Error"))) {
                                            percentage = dvOther.getValue();
                                            break;
                                        }
                                    }
                                }
                            }

                            if (value.contains("73.1")) {
                                List<Datavalue> dvTemp = datavalueFacadeLocal.findByOrganisationunitIdDeName(organisationunit.getOrganisationunitid(), period.getPeriodid(), "%Patients sous ARV suivis pendant les 6 premiers mois après l’initiation%", "openrbf2");
                                if (!dvTemp.isEmpty()) {
                                    for (Datavalue dvOther : dvTemp) {
                                        String deName = dvOther.getDataelement().getName();
                                        if ((deName.contains("RBF - Diff") || deName.contains("Percent Error"))) {
                                            percentage = dvOther.getValue();
                                            break;
                                        }
                                    }
                                }
                            }

                            if (value.contains("73.2")) {
                                List<Datavalue> dvTemp = datavalueFacadeLocal.findByOrganisationunitIdDeName(organisationunit.getOrganisationunitid(), period.getPeriodid(), "%Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable%", "openrbf2");
                                if (!dvTemp.isEmpty()) {
                                    for (Datavalue dvOther : dvTemp) {
                                        String deName = dvOther.getDataelement().getName();
                                        if ((deName.contains("RBF - Diff") || deName.contains("Percent Error"))) {
                                            percentage = dvOther.getValue();
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        for (Datavalue dv : listTarif) {
                            String deName = dv.getDataelement().getName();
                            if (deName.contains("RBF - Price unit -")) {
                                String s = deName.replace("RBF - Price unit -", "");
                                if (s.contains("(CPON)")) {
                                    //indicateur cpon 60.0
                                    s = s.replace("(CPON)", "CPON");
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        tariff = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("Patients sous ARV suivis pendant les 6 premiers mois après l’initiation")) {
                                    //indicateur 73.1
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        tariff = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable")) {
                                    //indicateur 73.2
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        tariff = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("Patients victimes de viols pris en charge")) {
                                    //indicateur 76.1
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        tariff = dv.getValue();
                                        break;
                                    }
                                }
                            } else {
                                //indicateur normaux
                                if (dv.getDataelement().getName().contains(data_element_duo)) {
                                    if (dv.getDataelement().getName().contains(data_elements_treated.get(counter_data).getCode())) {
                                        tariff = dv.getValue();
                                        break;
                                    }
                                }
                            }
                        }

                        for (Datavalue dv : listAmount) {
                            if (dv.getDataelement().getName().contains("RBF - Amount -")) {
                                String s = dv.getDataelement().getName().replaceAll("RBF - Amount -", "");
                                if (s.contains("(CPON)")) {
                                    s = s.replace("(CPON)", "CPON");
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        amount = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("Patients sous ARV suivis pendant les 6 premiers mois après l’initiation")) {
                                    //indicateur 73.1
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        amount = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("")) {

                                }
                            } else if (dv.getDataelement().getName().contains("RBF - SynthAmount -")) {
                                String s = dv.getDataelement().getName().replaceAll("RBF - SynthAmount -", "");
                                if (s.contains("Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable")) {
                                    //indicateur 73.2
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        amount = dv.getValue();
                                        break;
                                    }
                                } else if (s.contains("victimes de viols pris en charge")) {
                                    if (s.contains(data_elements_treated.get(counter_data).getCode())) {
                                        amount = dv.getValue();
                                        break;
                                    }
                                }
                            } else {
                                if ((dv.getDataelement().getName().contains(data_element_duo))) {
                                    if (dv.getDataelement().getName().contains(data_elements_treated.get(counter_data).getCode())) {
                                        amount = dv.getValue();
                                        break;
                                    }
                                }
                            }
                        }

                        Double valeur_declaree_double = this.getValue(valeur_declaree);
                        Double valeur_validee_double = this.getValue(valeur_verifiee);
                        Double valeur_percentage_double = this.getValue(percentage);
                        Double valeur_tariff_double = this.getValue(tariff);
                        Double valeur_amount_double = this.getValue(amount);

                        dataConstituants.add(new DataConstituant(new Dataelement(value), valeur_declaree_double, valeur_validee_double, valeur_percentage_double, valeur_tariff_double, valeur_amount_double));
                        counter_data += 1;
                    }

                    //System.err.println("\n\n\tliste des verification");
                    //System.err.println("data element without code size : " + data_elements_string_without_code.size());
                    //System.err.println("data element with code size : " + data_elements_string.size());
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

                    for (Datavalue dv : listAgregateDataValue) {

                        String deName = dv.getDataelement().getName();

                        //Total 1
                        String v = deName.toLowerCase();
                        v = v.replaceAll(" ", "");
                        if (v.equals("quantitytotal-pca")) {
                            total_1 = Double.valueOf(dv.getValue());
                            param.put("total_1", total_1);
                        }

                        //Equity bonus
                        v = deName.toLowerCase();
                        v = v.replaceAll(" ", "");
                        if (v.equals("equitybonus-pca")) {
                            bonus_equity = Double.valueOf(dv.getValue());
                            param.put("equity_bonus", bonus_equity);
                        }

                        //Total 2
                        v = deName.toLowerCase();
                        v = v.replaceAll(" ", "");
                        if (v.equals("totalquantitypaymentwithequity-pca")) {
                            total_2 = Double.valueOf(dv.getValue());
                            param.put("total_2", total_2);
                        }

                        //Quaterly production
                        v = deName.toLowerCase();
                        v = v.replaceAll(" ", "");
                        if (v.equals("quarterlyquantityproductionpca")) {
                            quarterly_production = Double.valueOf(dv.getValue());
                            param.put("quarterly_production", quarterly_production);
                        }

                        //tariff_bonus_qualite
                        v = deName.toLowerCase();
                        v = v.replaceAll(" ", "");
                        v = v.replaceAll("é", "e");
                        if (v.contains("tariff-bonusd'ameliorationdequalite")) {
                            tariff_bonus_qualite = Double.valueOf(dv.getValue());
                            param.put("tariff_baq", tariff_bonus_qualite);
                        }

                        /*Bonus d'amélioration qualité (QIB)
                         v = dv.getDataelement().getName().toLowerCase();
                         v = v.replaceAll(" ", "");
                         if (v.equals("baqtotal-pma-synth")) {
                         total_3 = Double.valueOf(dv.getValue());
                         }*/
                        //Quarterly Bonus d'amélioration qualité (QIB)
                        v = deName;
                        if (v.equals("Quality Payment- PCA")) {
                            quarterly_bonus_quality = Double.valueOf(dv.getValue());
                            param.put("quarterly_bonus_quality", quarterly_bonus_quality);
                        }

                        //Montant total
                        v = dv.getDataelement().getName().toLowerCase();
                        v = v.replaceAll(" ", "");
                        if (v.equals("totalpayment-quantityandquality-pca")) {
                            total_general = Double.valueOf(dv.getValue());
                            param.put("total_general", total_general);
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
            } else if (modeImpression == 2) {

                data_elements_string = new ArrayList<>();
                datavalues = datavalueFacadeLocal.findByOrganisationunitId(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "A-synth_claimed-Quantity" + "%");
                System.out.println("Size : " + datavalues.size());

                for (Datavalue dv : datavalues) {
                    String comment = dv.getComment();
                    String s = comment.replace("A-synth_claimed-Quantity- PMA- ", "");
                    if (!data_elements_string.contains(s)) {
                        data_elements_string.add(s);
                    }
                }

                //A-difference_percentage-Quantity- PMA-
                //A-synth_verified-Quantity - PMA
                //A-synth_claimed-Quantity - PMA -
                //A-difference_percentage-Quantity- PMA-
                //List<Datavalue> claimeds = datavalueFacadeLocal.findByOrganisationunitId(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "A-synth_claimed-Quantity" + "%");
                List<Datavalue> verifieds = datavalueFacadeLocal.findByOrganisationunitId(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "A-synth_verified-Quantity" + "%");
                List<Datavalue> percentage_errors = datavalueFacadeLocal.findByOrganisationunitId(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "A-difference_percentage-Quantity" + "%");
                List<Datavalue> amounts = datavalueFacadeLocal.findByOrganisationunitId(organisationunit.getOrganisationunitid(), period.getPeriodid(), "openrbf2", "A-amount-Quantity-" + "%");

                data_elements_string.forEach(value -> {
                    System.out.println("-- " + value);

                    String valeur_declaree = "";
                    String valeur_validee = "";
                    String tariff = "";
                    String valeur_percentage = "";
                    String valeur_montant = "";

                    for (Datavalue dv : this.datavalues) {
                        if (dv.getComment().contains(value)) {
                            valeur_declaree = dv.getValue();
                            System.err.println("\t\t\t\t Valeur declarée : " + dv.getValue());
                            break;
                        }
                    }

                    for (Datavalue dv : verifieds) {
                        if (dv.getComment().contains(value)) {
                            valeur_validee = dv.getValue();
                            //System.err.println("\t\t\t\t Valeur validée : " + dv.getValue());
                            break;
                        }
                    }

                    for (Datavalue dv : percentage_errors) {
                        if (dv.getComment().contains(value)) {
                            if (dv.getDataelement().getName().contains("Synth")) {
                                valeur_percentage = dv.getValue();
                                //System.err.println("\t\t\t\t Pourcentage erreur : " + dv.getValue());
                                break;
                            }
                        }
                    }

                    for (Datavalue dv : amounts) {
                        if (dv.getComment().contains(value)) {
                            if (dv.getDataelement().getName().contains("Synth")) {
                                valeur_montant = dv.getValue();
                                //System.err.println("\t\t\t\t Pourcentage erreur : " + dv.getValue());
                                break;
                            }
                        }
                    }

                    Double valeur_declaree_double = this.getValue(valeur_declaree);
                    Double valeur_validee_double = this.getValue(valeur_validee);
                    Double valeur_tariff_double = this.getValue(tariff);
                    Double valeur_percentage_double = this.getValue(valeur_percentage);
                    Double valeur_amount_double = this.getValue(valeur_montant);

                    dataConstituants.add(new DataConstituant(new Dataelement(value), valeur_declaree_double, valeur_validee_double, valeur_percentage_double, valeur_tariff_double, valeur_amount_double));

                    System.out.println("Fin------------------------------------------");

                });

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
