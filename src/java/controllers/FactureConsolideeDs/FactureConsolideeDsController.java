/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.FactureConsolideeDs;

import entities.Organisationunit;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import utils.DataAnalytic;
import utils.DataConstituantFCD;
import utils.JsfUtil;
import utils.PrintUtils;
import utils.Utilitaires;

/**
 *
 * @author USER
 */
public class FactureConsolideeDsController extends AbstractFactureConsolideeDsController implements Serializable {

    /**
     * Creates a new instance of ImpressionController
     */
    public FactureConsolideeDsController() {

    }

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
                                        childs3.clear();
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

    public void search() {
        try {
            imprimer = true;
            organisationunits.clear();
            listDataValue.clear();

            if (selected == null) {
                signalError("veuillez_selectionner_une_structure");
                return;
            }

            if ((period.getPeriodid() == null || period.getPeriodid() == 0)) {
                signalError("veuillez_selectionner_une_periode");
                return;
            }

            if (modelFcd.getModelId() == null || modelFcd.getModelId() == 0) {
                signalError("veuillez_selectionner_un_type_facture");
                return;
            }

            organisationunit = (Organisationunit) selected.getData();

            if ((organisationunit.getHierarchylevel() != 3)) {
                signalError("veuillez_selectionner_une_structure_niveau_district");
                return;
            }

            period = periodFacadeLocal.find(period.getPeriodid());
            modelFcd = modelFcdFacadeLocal.find(modelFcd.getModelId());

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            String dateDebut = df.format(period.getStartdate());
            String dateFin = df.format(period.getEnddate());

            organisationunits = organisationunitFacadeLocal.findByParentId(organisationunit.getOrganisationunitid());

            if (organisationunits.isEmpty()) {
                signalError("notification.aucune_donnee_trouvee");
                return;
            }

            this.connection = Utilitaires.connexionDB();
            Statement statement = connection.createStatement();

            total = 0;
            String table = "analytics_" + modelFcd.getAnnee();
            String bankNameCode = "" + modelFcd.getBankNameCode();
            String bankAccountNumberCode = "" + modelFcd.getBankAccountNumberCode();
            String amountCode = "" + modelFcd.getTotalAmountCode();

            List<String> uiIdLevel4 = new ArrayList<>();
            List<DataAnalytic> dataAnaliticAmounts = new ArrayList<>();

            ResultSet reqResultsAmount = statement.executeQuery("SELECT uidlevel3,uidlevel4,value,textvalue FROM " + table + " WHERE uidlevel3 = '" + organisationunit.getUid() + "' AND dx = '" + amountCode + "' AND pestartdate = '" + period.getStartdate() + "' AND peenddate = '" + period.getEnddate() + "'");

            if (reqResultsAmount != null) {
                while (reqResultsAmount.next()) {
                    String level3 = reqResultsAmount.getString("uidlevel3");
                    String level4 = reqResultsAmount.getString("uidlevel4");
                    Double value = reqResultsAmount.getDouble("value");
                    String textValue = reqResultsAmount.getString("textvalue");

                    if (!uiIdLevel4.contains(level4)) {
                        uiIdLevel4.add(level4);
                        dataAnaliticAmounts.add(new DataAnalytic(level3, level4, value, textValue));
                    }
                }
            }

            int i = 0;
            for (Organisationunit ou : organisationunits) {

                DataConstituantFCD constituantFCD = new DataConstituantFCD();
                constituantFCD.setId(i + 1);

                constituantFCD.setOrganisationunit(ou);

                //select uidlevel4 , value , textvalue , level , pestartdate , peenddate , dx from analytics_2020 where uidlevel4 = 'hU4ysRzVslO' AND textvalue NOTNULL;
                ResultSet reqResultsBName = statement.executeQuery("SELECT textvalue FROM " + table + " WHERE uidlevel4 = '" + ou.getUid() + "' AND dx = '" + bankNameCode + "'");
                constituantFCD.setBankName(null);
                if (reqResultsBName != null) {
                    while (reqResultsBName.next()) {
                        constituantFCD.setBankName(reqResultsBName.getString("textvalue"));
                    }
                }

                ResultSet reqResultsBAccount = statement.executeQuery("SELECT textvalue FROM " + table + " WHERE uidlevel4 = '" + ou.getUid() + "' AND dx = '" + bankAccountNumberCode + "'");
                constituantFCD.setBankAccountNumber(null);
                if (reqResultsBAccount != null) {
                    while (reqResultsBAccount.next()) {
                        constituantFCD.setBankAccountNumber(reqResultsBAccount.getString("textvalue"));
                    }
                }
                //select uidlevel4 , value , textvalue , level , pestartdate , peenddate , dx from analytics_2020 where uidlevel4 = 'hU4ysRzVslO'
                //AND pestartdate = '2020-03-01' AND peenddate = '2020-03-31' AND dx = 'fAUaK8yG7d4';

                //String req = "SELECT value FROM " + table + " WHERE uidlevel4 = '" + ou.getUid() + "' AND dx = '" + amountCode + "' AND pestartdate = '" + dateDebut + "' AND peenddate = '" + dateFin + "'";
                //System.err.print("     ----Requette---- " + req);
                constituantFCD.setAmount(null);
                int count = 0;
                for (DataAnalytic da : dataAnaliticAmounts) {
                    if (da.getUiIdLevel4().equals(ou.getUid())) {
                        try {
                            if (da.getValue() != null) {
                                constituantFCD.setAmount(da.getValue());
                                total += da.getValue().intValue();
                            }
                        } catch (Exception e) {
                            constituantFCD.setAmount(null);
                        }
                        dataAnaliticAmounts.remove(count);
                        break;
                    }
                    count++;
                }

                boolean var1 = true;
                try {
                    var1 = (constituantFCD.getBankAccountNumber() == null || constituantFCD.getBankAccountNumber().length() == 0);
                } catch (Exception e) {
                    var1 = true;
                }

                boolean var2 = true;
                try {
                    var2 = (constituantFCD.getBankName() == null || constituantFCD.getBankName().length() == 0);
                } catch (Exception e) {
                    var2 = true;
                }

                boolean var3 = true;
                try {
                    var3 = (constituantFCD.getAmount() == null);
                } catch (Exception e) {
                    var3 = true;
                }

                if ((var1 && var2 && var3) == false) {
                    listDataValue.add(constituantFCD);
                }
                i++;
            }
            if (!listDataValue.isEmpty()) {
                imprimer = false;
            }
            RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            signalException(e);
            imprimer = true;
            RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public String format(Integer d) {
        return Utilitaires.formaterStringMoney(d);
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
            String periodString = returnDateLabel(period.getStartdate(), period.getEnddate());
            Organisationunit ou_region = organisationunitFacadeLocal.find(organisationunit.getParentid().getOrganisationunitid());
            printFileName = PrintUtils.printFactureConsolideeDs(organisationunit, listDataValue, periodString, ou_region.getName());
            RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
            RequestContext.getCurrentInstance().execute("PF('FactureImprimerDialog').show()");
        } catch (Exception e) {
            this.signalException(e);
        }
    }

    private void signalError(String chaine) {
        RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
        this.routine.feedBack("information", "/resources/tool_images/error.png", this.routine.localizeMessage(chaine));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }

    private void signalSuccess() {
        RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
        this.routine.feedBack("information", "/resources/tool_images/success.png", this.routine.localizeMessage("operation_reussie"));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }

    private void signalException(Exception e) {
        RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
        this.routine.catchException(e, this.routine.localizeMessage("erreur_execution"));
        RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
    }

}
