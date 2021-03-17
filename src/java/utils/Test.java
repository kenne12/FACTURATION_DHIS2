/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Dataelement;
import entities.Datavalue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Test {

    public static void main(String[] args) {

        //String s = "PMA-51.2-Declared-Nouvelle consultation curative - médecin - indigents";
        //String[] chaines = s.split("-", 4);
        for (String s : initDeclared()) {
            String[] chaines = s.split("-", 4);
            System.err.println("taille : " + chaines.length);
        }
    }

    public static List<String> initDeclared() {
        List<String> listDeclared = new ArrayList<>();

        listDeclared.add("PMA-51.1-Declared-Nouvelle consultation curative - médecin (nvx cas)");
        listDeclared.add("PMA-51.2-Declared-Nouvelle consultation curative - médecin - indigents");
        listDeclared.add("PMA-51.3-Declared-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS");
        listDeclared.add("PMA-52.1-Declared-Journée d'hospitalisation");
        listDeclared.add("PMA-52.2-Declared-Journée d'hospitalisation - indigents + cas d'épidémie");
        listDeclared.add("PMA-52.3-Declared-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)");
        listDeclared.add("PMA-53.1-Declared-Contre référence arrive au CS");
        listDeclared.add("PMA-53.2-Declared-Contre référence de MAS arrives au CS");
        listDeclared.add("PMA-54.1-Declared-CAS IST traité selon le protocole");
        listDeclared.add("PMA-55.1-Declared-Dépistage des cas TBC positifs par mois");
        listDeclared.add("PMA-56.1-Declared-Cas TBC traités et guéris");
        listDeclared.add("PMA-57.1-Declared-Chirurgie Majeure (non césariennes + fistules)");
        listDeclared.add("PMA-57.2-Declared-Chirurgie Majeure (non césariennes + fistules) - indigent");
        listDeclared.add("PMA-58.1-Declared-Petite Chirurgie");
        listDeclared.add("PMA-58.2-Declared-Petite Chirurgie - indigent");
        listDeclared.add("PMA-59.1-Declared-Transfusion Sanguine");
        listDeclared.add("PMA-60.0-Declared-CPON Mère et Enfant");
        listDeclared.add("PMA-60.1-Declared-Accouchement eutociques");
        listDeclared.add("PMA-60.2-Declared-Accouchement eutociques - indigent");
        listDeclared.add("PMA-61.1-Declared-Césariennes");
        listDeclared.add("PMA-61.2-Declared-Césariennes - indigent");
        listDeclared.add("PMA-62.1-Declared-Accouchement dystocique (ventouse, forceps)");
        listDeclared.add("PMA-62.2-Declared-Accouchement dystocique (ventouse, forceps) - indigent");
        listDeclared.add("PMA-63.1-Declared-PF:Nvlle ou ancienne acceptantes pilules ou injectables");
        listDeclared.add("PMA-64.1-Declared-PF: implants ou DIU");
        listDeclared.add("PMA-65.1-Declared-PF: Méthode définitive-vasectomie-ligature trompes");
        listDeclared.add("PMA-66.1-Declared-Curetage après avortement spontané (ou indication médicale)");
        listDeclared.add("PMA-67.1-Declared-CPN");
        listDeclared.add("PMA-68.1-Declared-TPI1 ou TPI2 ou TPI3");
        listDeclared.add("PMA-69.1-Declared-Dépistage volontaire VIH/SIDA y compris femmes enceintes");
        listDeclared.add("PMA-70.1-Declared-Femme enceinte VIH+ sous protocole ARV prophylaxie");
        listDeclared.add("PMA-71.1-Declared-Prise en charge du nouveau-né d'une femme VIH+");
        listDeclared.add("PMA-72.1-Declared-Nouveaux cas de VIH mis sous ARV");
        //listDeclared.add("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation");
        listDeclared.add("PMA-73.1-Declared-Patients sous ARV suivis semestriellement");
        listDeclared.add("PMA-73.2-Declared-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable");
        listDeclared.add("PMA-74.1-Declared-Sance de dialyse");
        
        
        listDeclared.add("PMA-76.1-Declared-Patients victimes de viols pris en charge");

        return listDeclared;
    }

    public static List<String> initValidated() {
        List<String> listValidated = new ArrayList<>();

        listValidated.add("PMA-51.1-Verified-Nouvelle consultation curative - médecin (nvx cas)");
        listValidated.add("PMA-51.2-Verified-Nouvelle consultation curative - médecin - indigents");
        listValidated.add("PMA-51.3-Verified-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS");
        listValidated.add("PMA-52.1-Verified-Journée d'hospitalisation");
        listValidated.add("PMA-52.2-Verified-Journée d'hospitalisation - indigents + cas d'épidémie");
        listValidated.add("PMA-52.3-Verified-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)");
        listValidated.add("PMA-53.1-Verified-Contre référence arrive au CS");
        listValidated.add("PMA-53.2-Verified-Contre référence de MAS arrives au CS");
        listValidated.add("PMA-54.1-Verified-CAS IST traité selon le protocole");
        listValidated.add("PMA-55.1-Verified-Dépistage des cas TBC positifs par mois");
        listValidated.add("PMA-57.1-Verified-Chirurgie Majeure (non césariennes + fistules)");
        listValidated.add("PMA-57.2-Verified-Chirurgie Majeure (non césariennes + fistules) - indigent");
        listValidated.add("PMA-58.1-Verified-Petite Chirurgie");
        listValidated.add("PMA-58.2-Verified-Petite Chirurgie - indigent");
        listValidated.add("PMA-59.1-Verified-Transfusion Sanguine");
        listValidated.add("PMA-60.0-Verified-CPON Mère et Enfant");
        listValidated.add("PMA-60.1-Verified-Accouchement eutociques");
        listValidated.add("PMA-60.2-Verified-Accouchement eutociques - indigent");
        listValidated.add("PMA-61.1-Verified-Césariennes");
        listValidated.add("PMA-62.1-Verified-Accouchement dystocique (ventouse, forceps)");
        listValidated.add("PMA-62.2-Verified-Accouchement dystocique (ventouse, forceps) - indigent");
        listValidated.add("PMA-63.1-Verified-PF:Nvlle ou ancienne acceptantes pilules ou injectables");
        listValidated.add("PMA-64.1-Verified-PF: implants ou DIU");
        listValidated.add("PMA-65.1-Verified-PF: Méthode définitive-vasectomie-ligature trompes");
        listValidated.add("PMA-66.1-Verified-Curetage après avortement spontané (ou indication médicale)");
        listValidated.add("PMA-67.1-Verified-CPN");
        listValidated.add("PMA-68.1-Verified-TPI1 ou TPI2 ou TPI3");
        listValidated.add("PMA-69.1-Verified-Dépistage volontaire VIH/SIDA y compris femmes enceintes");
        listValidated.add("PMA-70.1-Verified-Femme enceinte VIH+ sous protocole ARV prophylaxie");
        listValidated.add("PMA-71.1-Verified-Prise en charge du nouveau né d'une femme VIH+ y compris le dépistage précoce à la PCR");
        listValidated.add("PMA-72.1-Verified-Nouveaux cas de VIH mis sous ARV");
        listValidated.add("PMA-73.1-Verified-Patients sous ARV suivis semestriellement");
        listValidated.add("PMA-73.2-Verified-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable");
        listValidated.add("PMA-74.1-Verified-Séance de dialyse");
        listValidated.add("PMA-76.1-Verified-Patients victimes de viols pris en charge");

        return listValidated;
    }

    public static List<DvSim> setDvDeclared() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-51.1-Declared-Nouvelle consultation curative - médecin (nvx cas)", "371"));
        listDv.add(new DvSim("PMA-51.2-Declared-Nouvelle consultation curative - médecin - indigents", "0"));
        listDv.add(new DvSim("PMA-51.3-Declared-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS", "0"));
        listDv.add(new DvSim("PMA-52.1-Declared-Journée d'hospitalisation", "874"));
        listDv.add(new DvSim("PMA-52.2-Declared-Journée d'hospitalisation - indigents + cas d'épidémie", "0"));
        listDv.add(new DvSim("PMA-52.3-Declared-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)", "0"));
        listDv.add(new DvSim("PMA-53.1-Declared-Contre référence arrive au CS", "9"));
        listDv.add(new DvSim("PMA-53.2-Declared-Contre référence de MAS arrives au CS", "0"));
        listDv.add(new DvSim("PMA-54.1-Declared-CAS IST traité selon le protocole", "16"));
        listDv.add(new DvSim("PMA-55.1-Declared-Dépistage des cas TBC positifs par mois", "7"));
        listDv.add(new DvSim("PMA-56.1-Declared-Cas TBC traités et guéris", "6"));
        listDv.add(new DvSim("PMA-57.1-Declared-Chirurgie Majeure (non césariennes + fistules)", "9"));
        listDv.add(new DvSim("PMA-57.2-Declared-Chirurgie Majeure (non césariennes + fistules) - indigent", "0"));
        listDv.add(new DvSim("PMA-58.1-Declared-Petite Chirurgie", "35"));
        listDv.add(new DvSim("PMA-58.2-Declared-Petite Chirurgie - indigent", "0"));
        listDv.add(new DvSim("PMA-59.1-Declared-Transfusion Sanguine", "20"));
        listDv.add(new DvSim("PMA-60.0-Declared-CPON Mère et Enfant", "40"));
        listDv.add(new DvSim("PMA-60.1-Declared-Accouchement eutociques", "51"));
        listDv.add(new DvSim("PMA-60.2-Declared-Accouchement eutociques - indigent", "0"));
        listDv.add(new DvSim("PMA-61.1-Declared-Césariennes", "11"));
        listDv.add(new DvSim("PMA-61.2-Declared-Césariennes - indigent", "0"));
        listDv.add(new DvSim("PMA-62.1-Declared-Accouchement dystocique (ventouse, forceps)", "0"));
        listDv.add(new DvSim("PMA-62.2-Declared-Accouchement dystocique (ventouse, forceps) - indigent", "0"));
        listDv.add(new DvSim("PMA-63.1-Declared-PF:Nvlle ou ancienne acceptantes pilules ou injectables", "10"));
        listDv.add(new DvSim("PMA-64.1-Declared-PF: implants ou DIU", "5"));
        listDv.add(new DvSim("PMA-65.1-Declared-PF: Méthode définitive-vasectomie-ligature trompes", "0"));
        listDv.add(new DvSim("PMA-66.1-Declared-Curetage après avortement spontané (ou indication médicale)", "6"));
        listDv.add(new DvSim("PMA-67.1-Declared-CPN", "174"));
        listDv.add(new DvSim("PMA-68.1-Declared-TPI1 ou TPI2 ou TPI3", "119"));
        listDv.add(new DvSim("PMA-69.1-Declared-Dépistage volontaire VIH/SIDA y compris femmes enceintes", "125"));

        listDv.add(new DvSim("PMA-70.1-Declared-Femme enceinte VIH+ sous protocole ARV prophylaxie", "0"));
        listDv.add(new DvSim("PMA-71.1-Declared-Prise en charge du nouveau-né d'une femme VIH+", "5"));
        listDv.add(new DvSim("PMA-72.1-Declared-Nouveaux cas de VIH mis sous ARV", "33"));
        //listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation", "0"));
        listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis semestriellement", "0"));
        listDv.add(new DvSim("PMA-73.2-Declared-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable", "0"));
        listDv.add(new DvSim("PMA-74.1-Declared-Sance de dialyse", "0"));
        listDv.add(new DvSim("PMA-76.1-Declared-Patients victimes de viols pris en charge", "0"));

        return listDv;
    }

    public static List<DvSim> setDvValidated() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-51.1-Verified-Nouvelle consultation curative - médecin (nvx cas)", "350"));
        listDv.add(new DvSim("PMA-51.2-Verified-Nouvelle consultation curative - médecin - indigents", "0"));
        listDv.add(new DvSim("PMA-51.3-Verified-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS", "0"));
        listDv.add(new DvSim("PMA-52.1-Verified-Journée d'hospitalisation", "938"));
        listDv.add(new DvSim("PMA-52.2-Verified-Journée d'hospitalisation - indigents + cas d'épidémie", "0"));
        listDv.add(new DvSim("PMA-52.3-Verified-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)", "0"));
        listDv.add(new DvSim("PMA-53.1-Verified-Contre référence arrive au CS", "9"));
        listDv.add(new DvSim("PMA-53.2-Verified-Contre référence de MAS arrives au CS", "0"));
        listDv.add(new DvSim("PMA-54.1-Verified-CAS IST traité selon le protocole", "6"));
        listDv.add(new DvSim("PMA-55.1-Verified-Dépistage des cas TBC positifs par mois", "7"));
        listDv.add(new DvSim("PMA-56.1-Verified-Cas TBC traités et guéris", "6"));
        listDv.add(new DvSim("PMA-57.1-Verified-Chirurgie Majeure (non césariennes + fistules)", "9"));
        listDv.add(new DvSim("PMA-57.2-Verified-Chirurgie Majeure (non césariennes + fistules) - indigent", "0"));
        listDv.add(new DvSim("PMA-58.1-Verified-Petite Chirurgie", "33"));
        listDv.add(new DvSim("PMA-58.2-Verified-Petite Chirurgie - indigent", "0"));
        listDv.add(new DvSim("PMA-59.1-Verified-Transfusion Sanguine", "20"));
        listDv.add(new DvSim("PMA-60.0-Verified-CPON Mère et Enfant", "39"));
        listDv.add(new DvSim("PMA-60.1-Verified-Accouchement eutociques", "50"));
        listDv.add(new DvSim("PMA-60.2-Verified-Accouchement eutociques - indigent", "0"));
        listDv.add(new DvSim("PMA-61.1-Verified-Césariennes", "11"));
        listDv.add(new DvSim("PMA-61.2-Verified-Césariennes - indigent", "0"));
        listDv.add(new DvSim("PMA-62.1-Verified-Accouchement dystocique (ventouse, forceps)", "0"));
        listDv.add(new DvSim("PMA-62.2-Verified-Accouchement dystocique (ventouse, forceps) - indigent", "0"));
        listDv.add(new DvSim("PMA-63.1-Verified-PF:Nvlle ou ancienne acceptantes pilules ou injectables", "8"));
        listDv.add(new DvSim("PMA-64.1-Verified-PF: implants ou DIU", "5"));
        listDv.add(new DvSim("PMA-65.1-Verified-PF: Méthode définitive-vasectomie-ligature trompes", "0"));
        listDv.add(new DvSim("PMA-66.1-Verified-Curetage après avortement spontané (ou indication médicale)", "6"));
        listDv.add(new DvSim("PMA-67.1-Verified-CPN", "159"));
        listDv.add(new DvSim("PMA-68.1-Verified-TPI1 ou TPI2 ou TPI3", "111"));
        listDv.add(new DvSim("PMA-69.1-Verified-Dépistage volontaire VIH/SIDA y compris femmes enceintes", "121"));

        listDv.add(new DvSim("PMA-70.1-Declared-Femme enceinte VIH+ sous protocole ARV prophylaxie", "0"));
        listDv.add(new DvSim("PMA-71.1-Verified-Prise en charge du nouveau-né d'une femme VIH+", "5"));
        listDv.add(new DvSim("PMA-72.1-Verified-Nouveaux cas de VIH mis sous ARV", "33"));
        //listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation", "0"));
        listDv.add(new DvSim("PMA-73.1-Verified-Patients sous ARV suivis semestriellement", "0"));
        listDv.add(new DvSim("PMA-73.2-Verified-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable", "0"));
        listDv.add(new DvSim("PMA-74.1-Verified-Sance de dialyse", "0"));
        listDv.add(new DvSim("PMA-76.1-Verified-Patients victimes de viols pris en charge", "0"));

        return listDv;
    }

    public static List<DvSim> setDvPercentageError() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-51.1-Percent_Error-Nouvelle consultation curative - médecin (nvx cas)", "6"));
        listDv.add(new DvSim("PMA-51.2-Percent_Error-Nouvelle consultation curative - médecin - indigents", "0"));
        listDv.add(new DvSim("PMA-51.3-Percent_Error-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS", "0"));
        listDv.add(new DvSim("PMA-52.1-Percent_Error-Journée d'hospitalisation", "-6.823027718550106"));
        listDv.add(new DvSim("PMA-52.2-Percent_Error-Journée d'hospitalisation - indigents + cas d'épidémie", "0"));
        listDv.add(new DvSim("PMA-52.3-Percent_Error-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)", "0"));
        listDv.add(new DvSim("PMA-53.1-Percent_Error-Contre référence arrive au CS", "0"));
        listDv.add(new DvSim("PMA-53.2-Percent_Error-Contre référence de MAS arrives au CS", "0"));
        listDv.add(new DvSim("PMA-54.1-Percent_Error-CAS IST traité selon le protocole", "166.66666666666669"));
        listDv.add(new DvSim("PMA-55.1-Percent_Error-Dépistage des cas TBC positifs par mois", "0"));
        listDv.add(new DvSim("PMA-56.1-Percent_Error-Cas TBC traités et guéris", "0"));
        listDv.add(new DvSim("PMA-57.1-Percent_Error-Chirurgie Majeure (non césariennes + fistules)", "0"));
        listDv.add(new DvSim("PMA-57.2-Percent_Error-Chirurgie Majeure (non césariennes + fistules) - indigent", "0"));
        listDv.add(new DvSim("PMA-58.1-Percent_Error-Petite Chirurgie", "6.0606060606060606"));
        listDv.add(new DvSim("PMA-58.2-Percent_Error-Petite Chirurgie - indigent", "0"));
        listDv.add(new DvSim("PMA-59.1-Percent_Error-Transfusion Sanguine", "0"));
        listDv.add(new DvSim("PMA-60.0-Percent_Error-CPON Mère et Enfant", "2.564102564102564"));
        listDv.add(new DvSim("PMA-60.1-Percent_Error-Accouchement eutociques", "2"));
        listDv.add(new DvSim("PMA-60.2-Percent_Error-Accouchement eutociques - indigent", "0"));
        listDv.add(new DvSim("PMA-61.1-Percent_Error-Césariennes", "0"));
        listDv.add(new DvSim("PMA-61.2-Percent_Error-Césariennes - indigent", "0"));
        listDv.add(new DvSim("PMA-62.1-Percent_Error-Accouchement dystocique (ventouse, forceps)", "0"));
        listDv.add(new DvSim("PMA-62.2-Percent_Error-Accouchement dystocique (ventouse, forceps) - indigent", "0"));
        listDv.add(new DvSim("PMA-63.1-Percent_Error-PF:Nvlle ou ancienne acceptantes pilules ou injectables", "25"));
        listDv.add(new DvSim("PMA-64.1-Percent_Error-PF: implants ou DIU", "0"));
        listDv.add(new DvSim("PMA-65.1-Percent_Error-PF: Méthode définitive-vasectomie-ligature trompes", "0"));
        listDv.add(new DvSim("PMA-66.1-Percent_Error-Curetage après avortement spontané (ou indication médicale)", "0"));
        listDv.add(new DvSim("PMA-67.1-Percent_Error-CPN", "9.433962264150944"));
        listDv.add(new DvSim("PMA-68.1-Percent_Error-TPI1 ou TPI2 ou TPI3", "7.207207207207207"));
        listDv.add(new DvSim("PMA-69.1-Percent_Error-Dépistage volontaire VIH/SIDA y compris femmes enceintes", "3.3057851239669422"));
        listDv.add(new DvSim("PMA-70.1-Percent_Error-Femme enceinte VIH+ sous protocole ARV prophylaxie", "0"));
        listDv.add(new DvSim("PMA-71.1-Percent_Error-Prise en charge du nouveau-né d'une femme VIH+", "0"));
        listDv.add(new DvSim("PMA-72.1-Percent_Error-Nouveaux cas de VIH mis sous ARV", "0"));
        //listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation", "0"));
        listDv.add(new DvSim("PMA-73.1-Percent_Error-Patients sous ARV suivis semestriellement", "0"));

        listDv.add(new DvSim("PMA-73.2-Percent_Error-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable", "0"));
        listDv.add(new DvSim("PMA-74.1-Percent_Error-Sance de dialyse", "0"));
        listDv.add(new DvSim("PMA-76.1-Percent_Error-Patients victimes de viols pris en charge", "0"));

        return listDv;
    }

    public static List<DvSim> setDvTarrif() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-51.1-Tariff-Nouvelle consultation curative - médecin (nvx cas)", "250"));
        listDv.add(new DvSim("PMA-51.2-Tariff-Nouvelle consultation curative - médecin - indigents", "1000"));
        listDv.add(new DvSim("PMA-51.3-Tariff-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS", "1000"));
        listDv.add(new DvSim("PMA-52.1-Tariff-Journée d'hospitalisation", "375"));
        listDv.add(new DvSim("PMA-52.2-Tariff-Journée d'hospitalisation - indigents + cas d'épidémie", "1500"));
        listDv.add(new DvSim("PMA-52.3-Tariff-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)", "1500"));
        listDv.add(new DvSim("PMA-53.1-Tariff-Contre référence arrive au CS", "750"));
        listDv.add(new DvSim("PMA-53.2-Tariff-Contre référence de MAS arrives au CS", "750"));
        listDv.add(new DvSim("PMA-54.1-Tariff-CAS IST traité selon le protocole", "500"));
        listDv.add(new DvSim("PMA-55.1-Tariff-Dépistage des cas TBC positifs par mois", "2500"));
        listDv.add(new DvSim("PMA-56.1-Tariff-Cas TBC traités et guéris", "7500"));
        listDv.add(new DvSim("PMA-57.1-Tariff-Chirurgie Majeure (non césariennes + fistules)", "5000"));
        listDv.add(new DvSim("PMA-57.2-Tariff-Chirurgie Majeure (non césariennes + fistules) - indigent", "20000"));
        listDv.add(new DvSim("PMA-58.1-Tariff-Petite Chirurgie", "1000"));
        listDv.add(new DvSim("PMA-58.2-Tariff-Petite Chirurgie - indigent", "4000"));
        listDv.add(new DvSim("PMA-59.1-Tariff-Transfusion Sanguine", "1500"));
        listDv.add(new DvSim("PMA-60.0-Tariff-CPON Mère et Enfant", "39000"));
        listDv.add(new DvSim("PMA-60.1-Tariff-Accouchement eutociques", "1500"));
        listDv.add(new DvSim("PMA-60.2-Tariff-Accouchement eutociques - indigent", "6000"));
        listDv.add(new DvSim("PMA-61.1-Tariff-Césariennes", "5000"));
        listDv.add(new DvSim("PMA-61.2-Tariff-Césariennes - indigent", "20000"));
        listDv.add(new DvSim("PMA-62.1-Tariff-Accouchement dystocique (ventouse, forceps)", "2000"));
        listDv.add(new DvSim("PMA-62.2-Tariff-Accouchement dystocique (ventouse, forceps) - indigent", "8000"));
        listDv.add(new DvSim("PMA-63.1-Tariff-PF:Nvlle ou ancienne acceptantes pilules ou injectables", "1250"));
        listDv.add(new DvSim("PMA-64.1-Tariff-PF: implants ou DIU", "2500"));
        listDv.add(new DvSim("PMA-65.1-Tariff-PF: Méthode définitive-vasectomie-ligature trompes", "12500"));
        listDv.add(new DvSim("PMA-66.1-Tariff-Curetage après avortement spontané (ou indication médicale)", "3750"));
        listDv.add(new DvSim("PMA-67.1-Tariff-CPN", "250"));
        listDv.add(new DvSim("PMA-68.1-Tariff-TPI1 ou TPI2 ou TPI3", "300"));
        listDv.add(new DvSim("PMA-69.1-Tariff-Dépistage volontaire VIH/SIDA y compris femmes enceintes", "150"));
        listDv.add(new DvSim("PMA-70.1-Tariff-Femme enceinte VIH+ sous protocole ARV prophylaxie", "7000"));
        listDv.add(new DvSim("PMA-71.1-Tariff-Prise en charge du nouveau-né d'une femme VIH+", "3000"));
        listDv.add(new DvSim("PMA-72.1-Tariff-Nouveaux cas de VIH mis sous ARV", "2000"));
        //listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation", "0"));
        listDv.add(new DvSim("PMA-73.1-Tariff-Patients sous ARV suivis semestriellement", "12500"));
        listDv.add(new DvSim("PMA-73.2-Tariff-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable", "10500"));
        listDv.add(new DvSim("PMA-74.1-Tariff-Sance de dialyse", "12500"));
        listDv.add(new DvSim("PMA-76.1-Tariff-Patients victimes de viols pris en charge", "4000"));

        return listDv;
    }

    public static List<DvSim> setDvAmount() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-51.1-Amount-Nouvelle consultation curative - médecin (nvx cas)", "87500"));
        listDv.add(new DvSim("PMA-51.2-Amount-Nouvelle consultation curative - médecin - indigents", "0"));
        listDv.add(new DvSim("PMA-51.3-Amount-Nouvelle consultation curative-médecin (nouveau cas) malnutris aigue sévère avec complications médicales MAS", "0"));
        listDv.add(new DvSim("PMA-52.1-Amount-Journée d'hospitalisation", "351750"));
        listDv.add(new DvSim("PMA-52.2-Amount-Journée d'hospitalisation - indigents + cas d'épidémie", "0"));
        listDv.add(new DvSim("PMA-52.3-Amount-Journée d'hospitalisation - MAS avec complication médicale (limite à 14 jours)", "0"));
        listDv.add(new DvSim("PMA-53.1-Amount-Contre référence arrive au CS", "6750"));
        listDv.add(new DvSim("PMA-53.2-Amount-Contre référence de MAS arrives au CS", "0"));
        listDv.add(new DvSim("PMA-54.1-Amount-CAS IST traité selon le protocole", "0"));
        listDv.add(new DvSim("PMA-55.1-Amount-Dépistage des cas TBC positifs par mois", "17500"));
        listDv.add(new DvSim("PMA-56.1-Amount-Cas TBC traités et guéris", "45000"));
        listDv.add(new DvSim("PMA-57.1-Amount-Chirurgie Majeure (non césariennes + fistules)", "45000"));
        listDv.add(new DvSim("PMA-57.2-Amount-Chirurgie Majeure (non césariennes + fistules) - indigent", "0"));
        listDv.add(new DvSim("PMA-58.1-Amount-Petite Chirurgie", "33000"));
        listDv.add(new DvSim("PMA-58.2-Amount-Petite Chirurgie - indigent", "0"));
        listDv.add(new DvSim("PMA-59.1-Amount-Transfusion Sanguine", "30000"));
        listDv.add(new DvSim("PMA-60.0-Amount-CPON Mère et Enfant", "75000"));
        listDv.add(new DvSim("PMA-60.1-Amount-Accouchement eutociques", "1500"));
        listDv.add(new DvSim("PMA-60.2-Amount-Accouchement eutociques - indigent", "0"));
        listDv.add(new DvSim("PMA-61.1-Amount-Césariennes", "55000"));
        listDv.add(new DvSim("PMA-61.2-Amount-Césariennes - indigent", "0"));
        listDv.add(new DvSim("PMA-62.1-Amount-Accouchement dystocique (ventouse, forceps)", "0"));
        listDv.add(new DvSim("PMA-62.2-Amount-Accouchement dystocique (ventouse, forceps) - indigent", "0"));
        listDv.add(new DvSim("PMA-63.1-Amount-PF :Nvlle ou ancienne acceptantes pilules ou injectables", "0"));
        listDv.add(new DvSim("PMA-64.1-Amount-PF: implants ou DIU", "12500"));
        listDv.add(new DvSim("PMA-65.1-Amount-PF: Méthode définitive-vasectomie-ligature trompes", "0"));
        listDv.add(new DvSim("PMA-66.1-Amount-Curetage après avortement spontané (ou indication médicale)", "22500"));
        listDv.add(new DvSim("PMA-67.1-Amount-CPN", "39750"));
        listDv.add(new DvSim("PMA-68.1-Amount-TPI1 ou TPI2 ou TPI3", "33300"));
        listDv.add(new DvSim("PMA-69.1-Amount-Dépistage volontaire VIH/SIDA y compris femmes enceintes", "18150"));
        listDv.add(new DvSim("PMA-70.1-Amount-Femme enceinte VIH+ sous protocole ARV prophylaxie", "0"));
        listDv.add(new DvSim("PMA-71.1-Amount-Prise en charge du nouveau-né d'une femme VIH+", "15000"));
        listDv.add(new DvSim("PMA-72.1-Amount-Nouveaux cas de VIH mis sous ARV", "66000"));
        //listDv.add(new DvSim("PMA-73.1-Declared-Patients sous ARV suivis pendant les 6 premiers mois après l'initiation", "0"));
        listDv.add(new DvSim("PMA-73.1-Amount-Patients sous ARV suivis semestriellement", "0"));

        listDv.add(new DvSim("PMA-73.2-Amount-Patients sous ARV suivis pendant les 12 premiers mois après initiation avec charge virale indétectable", "0"));
        listDv.add(new DvSim("PMA-74.1-Amount-Sance de dialyse", "0"));
        listDv.add(new DvSim("PMA-76.1-Amount-Patients victimes de viols pris en charge", "0"));

        return listDv;
    }

    public static List<DvSim> setDvAgregatedValue() {
        List<DvSim> listDv = new ArrayList<>();

        listDv.add(new DvSim("PMA-Quantity_Total- PMA", "992700"));
        listDv.add(new DvSim("PMA-Equity_Bonus- PMA", "19854"));
        listDv.add(new DvSim("PMA-Total_quantity_payment_with_Equity- PMA", "1012554"));
        listDv.add(new DvSim("PMA-Quarterly_quantity_production_PCA", "3012850.5"));
        listDv.add(new DvSim("PMA-Quality_Payment- PMA", "345212.4698324999"));
        listDv.add(new DvSim("PMA-81.1-Tariff_Bonus_d'Amelioration_de_Qualite", "1000000"));
        listDv.add(new DvSim("PMA-Total_Payment- PCA", "1357766.4698325"));
        listDv.add(new DvSim("PMA-Total_Payment_Quantity_and_Quality- PMA", "1357766.4698325"));

        // quality perceived 21 %
        listDv.add(new DvSim("PMA-amount_patient_satisfaction_weighted", "0.2128"));

        // quality assesement weighted 35 %
        listDv.add(new DvSim("PMA-total_technical_quality_weighted", "0.3527667984189723"));

        // global quality score 76 %
        listDv.add(new DvSim("PMA-Total_Quality_Score", "0.7638667984189722"));

        // global quality score 76 %
        listDv.add(new DvSim("PMA-Total_Quality_Score_decimal", "0.7638667984189722"));

        // index tool 19.83 %
        listDv.add(new DvSim("PMA-amount_index_tool_weighted", "0.19829999999999998"));

        // BAQ
        listDv.add(new DvSim("PMA-BAQ_Total", "0"));

        // BAQ
        // listDv.add(new DvSim("PMA-BAQ_Total_Synth", "0"));        
        return listDv;
    }

    public static List<Datavalue> getDatavalueSim(List<DvSim> list) {
        List<Datavalue> datavalues = new ArrayList<>();
        if (list.isEmpty()) {
            return datavalues;
        }

        for (DvSim d : list) {
            Dataelement de = new Dataelement(d.getName());
            Datavalue dv = new Datavalue();
            dv.setDataelement(de);
            dv.setValue(d.getValue());

            datavalues.add(dv);
        }
        return datavalues;
    }

    public static List<Datavalue> getDatavalue(List<String> list) {

        List<Datavalue> datavalues = new ArrayList<>();
        if (list.isEmpty()) {
            return datavalues;
        }

        for (String s : list) {
            Dataelement de = new Dataelement(s);
            Datavalue dv = new Datavalue();
            dv.setDataelement(de);
            dv.setValue("");

            datavalues.add(dv);
        }
        return datavalues;
    }
}
