/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author USER
 */
public class Utilitaires {

    private static final ServletContext servletConetxt = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    public static final String path = servletConetxt.getRealPath("");

    public static String user = "postgres";
    public static String password = "batrapi";
    public static String driverClassName = "org.postgresql.Driver";
    public static String url = "jdbc:postgresql://localhost:5433/dhis2_test";

    public static String formaterStringMoney(Long valeur) {
        String chaine = Long.toString(valeur);
        if (chaine == null) {
            return "0";
        }
        int taille = chaine.length(), j = taille;
        String result = "";
        int i = 0;
        while (i < taille) {
            result += chaine.charAt(i);
            i++;
            j--;
            if (j > 0 && j % 3 == 0) {
                result += ' ';
            }
        }
        return result;
    }

    public static String formaterStringMoney(Integer valeur) {
        String chaine = Integer.toString(valeur);
        if (chaine == null) {
            return "0";
        }
        int taille = chaine.length(), j = taille;
        String result = "";
        int i = 0;
        while (i < taille) {
            result += chaine.charAt(i);
            i++;
            j--;
            if (j > 0 && j % 3 == 0) {
                result += ' ';
            }
        }
        return result;
    }

    public static String formaterStringMoney(String valeur) {
        String chaine = valeur;
        if (chaine == null) {
            return null;
        }
        int taille = chaine.length(), j = taille;
        String result = "";
        int i = 0;
        while (i < taille) {
            result += chaine.charAt(i);
            i++;
            j--;
            if (j > 0 && j % 3 == 0) {
                result += ' ';
            }
        }
        return result;
    }

    public static String formaterStringMoney(Double val) {
        String result = "";
        try {
            String pEntiere = partieEntiere(val);
            String pDec = partieDecimale(val);
            String chaine = pEntiere;
            int taille = chaine.length(), j = taille;

            int i = 0;
            while (i < taille) {
                result += chaine.charAt(i);
                i++;
                j--;
                if (j > 0 && j % 3 == 0) {
                    result += ' ';
                }
            }
            if (pDec != null) {
                result = result + "." + pDec;
            }

        } catch (Exception e) {
            result = "0";
            e.printStackTrace();
        }
        return result;
    }

    private static String partieDecimale(Double nombre) {
        return partieDecimale(nombre.toString());
    }

    private static String partieEntiere(Double nombre) {
        Integer tmp = nombre.intValue();
        return tmp.toString();
    }

    private static String partieDecimale(String nombre) {
        String result = "";
        int taille = nombre.length();
        boolean copie = false;
        for (int i = 0; i < taille; i++) {
            if (copie) {
                result += nombre.charAt(i);
            } else if (nombre.charAt(i) == '.') {
                copie = true;
            }
        }
        if (result.equals("0")) {
            return null;
        }
        return result;
    }

    public static Date addDayToDate(Date date, int nbre) {
        DateTime date_time = new DateTime("" + (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate());
        date_time.plusDays(nbre);
        return date_time.toDate();
    }

    public static Integer duration(Date date1, Date date2) {
        DateTime dateDebut = new DateTime("" + (date1.getYear() + 1900) + "-" + (date1.getMonth() + 1) + "-" + date1.getDate() + "");
        DateTime dateFin = new DateTime("" + (date2.getYear() + 1900) + "-" + (date2.getMonth() + 1) + "-" + date2.getDate() + "");

        Integer nbjr = Integer.valueOf(Days.daysBetween(dateDebut, dateFin).getDays());
        return nbjr;
    }

    public static Double arrondiNDecimales(Double x, int n) {
        if (x == null) {
            return null;
        }
        double pow = Math.pow(10, n);
        return (Math.floor(x * pow)) / pow;
    }

    public static String formatStringMaj(String chaine) {
        if (chaine.isEmpty()) {
            return " ";
        }
        char prenLettre = '0';
        prenLettre = chaine.charAt(0);
        String leReste = chaine.substring(1, chaine.length());
        String lettre1 = String.valueOf(prenLettre);
        leReste = leReste.toLowerCase();

        return lettre1.toUpperCase() + leReste;
    }

    public static String getValue(Double value) {
        try {
            if (value == null) {
                return "";
            } else {
                return "" + value;
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static String getValue(Integer value) {
        try {
            if (value == null) {
                return "";
            } else {
                return "" + value;
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static Connection connexionDB() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connecion réussie");
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utilitaires.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
