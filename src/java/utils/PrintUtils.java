/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Organisationunit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gervais
 */
public class PrintUtils {

    private static final Routine routine = new Routine();

    public static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    public static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.RED);
    public static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
    public static Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLUE);
    public static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    public static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Font setUpFont(final float size, final int style, final BaseColor color) {
        Font font = new Font();
        font.setStyle(style);
        font.setSize(size);
        font.setColor(color);
        return font;
    }

    public static PdfPCell createPdfPCell(String sCell, int colspan, int position, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell, font));
        cell.setColspan(colspan);
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int colspan, int position) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell));
        cell.setColspan(colspan);
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        }
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int position, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell, font));
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int position, Font font, int borderLeft, int borderRight, int borderTop, int borderBottom) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell, font));
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        cell.setBorderWidthLeft(borderLeft);
        cell.setBorderWidthRight(borderRight);
        cell.setBorderWidthTop(borderTop);
        cell.setBorderWidthBottom(borderBottom);
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int position, int colspan, Font font, int borderLeft, int borderRight, int borderTop, int borderBottom) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell, font));
        cell.setColspan(colspan);
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        cell.setBorderWidthLeft(borderLeft);
        cell.setBorderWidthRight(borderRight);
        cell.setBorderWidthTop(borderTop);
        cell.setBorderWidthBottom(borderBottom);
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int position, int colspan, int rowspan, Font font, int borderLeft, int borderRight, int borderTop, int borderBottom) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell, font));
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        cell.setBorderWidthLeft(borderLeft);
        cell.setBorderWidthRight(borderRight);
        cell.setBorderWidthTop(borderTop);
        cell.setBorderWidthBottom(borderBottom);
        return cell;
    }

    public static PdfPCell createPdfPCell(String sCell, int position) {
        PdfPCell cell = new PdfPCell(new Paragraph(sCell));
        if (position == 1) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        } else if (position == 2) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        }
        return cell;
    }

    public static String printFacture(Organisationunit ou, List<DataConstituant> dataConstituants, String periodString, String ou_district, String ou_region, Map param) {
        String fileName = "";
        try {

            fileName = "Facture_" + ou.getName() + "_" + Utilitaires.formatStringMaj(periodString) + "_" + sdf.format(new Date()) + ".pdf";
            Document rapport = new Document();
            PdfWriter.getInstance(rapport, new FileOutputStream(Utilitaires.path + "/reports/facture/" + fileName));
            rapport.open();

            float[] width_entete = {6f, 3f};
            PdfPTable entete_1 = new PdfPTable(width_entete);
            entete_1.setWidthPercentage(70);

            entete_1.addCell(PrintUtils.createPdfPCell("Region", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));
            entete_1.addCell(PrintUtils.createPdfPCell("District", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));

            entete_1.addCell(PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(ou_region), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0));
            entete_1.addCell((PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(ou_district), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0)));

            entete_1.addCell(PrintUtils.createPdfPCell("Facility", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));
            entete_1.addCell(PrintUtils.createPdfPCell("Period ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));

            entete_1.addCell(PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(ou.getName()), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0));
            entete_1.addCell(PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(periodString), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0));

            rapport.add(entete_1);
            rapport.add(new Paragraph(" ", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));

            float[] widths = {5.8f, 0.7f, 0.7f, 0.8f, 0.9f, 0.9f};
            PdfPTable table = new PdfPTable(widths);
            table.setWidthPercentage(100);

            Paragraph titre = new Paragraph("MAIN contractor invoice - Synthesis", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
            titre.setAlignment(Element.ALIGN_CENTER);
            rapport.add(titre);

            rapport.add(new Paragraph(" "));

            table.addCell(PrintUtils.createPdfPCell("Indicator - Health care activity", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("Declared", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("Validated", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("% of \nerror", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("Unit cost", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("Total price", 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));

            for (DataConstituant d : dataConstituants) {
                table.addCell(PrintUtils.createPdfPCell(" " + d.getDataelement().getName(), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(d.getDeclared() == null ? "" : "" + Utilitaires.getValue(d.getDeclared().intValue()), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(d.getValidated() == null ? "" : "" + Utilitaires.getValue(d.getValidated().intValue()), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(" " + Utilitaires.arrondiNDecimales(d.getPercentage(), 2), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(" " + JsfUtil.formaterStringMoney(d.getUnitPrice()), 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(" " + JsfUtil.formaterStringMoney(d.getTotal()), 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
            }

            rapport.add(table);

            float[] widths_bas = {5.4f, 0.7f, 0.9f, 0.9f, 1.1f, 1.1f};
            PdfPTable bas_de_page = new PdfPTable(widths_bas);
            bas_de_page.setWidthPercentage(100);

            String espace = "                              ";
            String espace_1 = "                                           ";

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace + "Total 1 (Production Quantity) ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 1, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" " + getValue(param, "total_1"), 3, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Equity Bonus ( = Total 1 * " + getValueString(param, "equity_bonus_percentage") + " %) ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("", 1, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValue(param, "equity_bonus"), 3, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace + "Total 2 = Total 1 + Equity Bonus", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("", 1, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValue(param, "total_2"), 3, 4, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Score", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Weight", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Weighted score", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Quality assessment", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("35%", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValueString(param, "quality_assessement_scoreweighted"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Quality perceived by the community", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("35%", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValueString(param, "quality_perceived_scoreweighted"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Index tool score", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("30%", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValueString(param, "index_tool_scoreweighted"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 2, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Month 1 ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Month 2 ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("This Month", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("Quarter", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Quarterly production", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValue(param, "total_2"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("" + getValue(param, "quarterly_production"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Quarterly quality bonus = Quarterly\n " + espace_1 + "production ( " + JsfUtil.formaterStringMoney(((Double) param.get("quarterly_production")).intValue()) + ") x 15% x\n" + espace_1 + "Global quality score (  " + getValueString(param, "global_quality_score") + " ) %", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 4, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" " + getValue(param, "quarterly_bonus_quality"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace + "Total 3 = Total 2 + Quarterly quality bonus", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 4, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace_1 + "Quality improvement bonus (QIB)", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell("*", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" " + getValue(param, "tariff_baq"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" " + getValue(param, "bonus_amelioration_qualite"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(espace + "Total general = total 3 + QIB", 1, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 1, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" ", 2, 4, new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL), 0, 0, 0, 0));
            bas_de_page.addCell(PrintUtils.createPdfPCell(" " + getValue(param, "total_general"), 2, 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD), 0, 1, 0, 0));

            bas_de_page.addCell(PrintUtils.createPdfPCell(" N B : % of error > 10% ou < -10% cancels the indicator", 1, 6, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 1));

            rapport.add(bas_de_page);

            float[] width_signature = {2.0f, 2.5f, 2f, 2.5f, 2.5f, 2.0f};
            PdfPTable zone_signature = new PdfPTable(width_signature);
            zone_signature.setWidthPercentage(100);
            rapport.add(new Paragraph(" "));

            /**
             * *****************premiere ligne ******************
             */
            zone_signature.addCell(PrintUtils.createPdfPCell("", 1, 6, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 1, 0));

            /*
             *premier ecart
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *Premiere ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" Declared at", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" Verified at", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" Validated at", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *Deuxieme ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" On", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" On", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" On", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *troisieme ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" Chief of center", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" Verificator ppa", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" Deputy manager ppa", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *dernier ecart
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell("", 1, 6, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 1));

            rapport.add(zone_signature);

            rapport.close();

        } catch (DocumentException ex) {
            Logger.getLogger(PrintUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }

    public static String printFactureConsolideeDs(Organisationunit ou, List<DataConstituantFCD> dataConstituants, String periodString, String ou_region, String titreFacture) {
        String fileName = "";
        try {

            fileName = "Facture_Consolidee_" + ou.getName() + "_" + Utilitaires.formatStringMaj(periodString) + "_" + sdf.format(new Date()) + ".pdf";
            Document rapport = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(rapport, new FileOutputStream(Utilitaires.path + "/reports/facture/" + fileName));
            rapport.open();

            float[] width_entete = {6f, 3f};
            PdfPTable entete_1 = new PdfPTable(width_entete);
            entete_1.setWidthPercentage(70);

            entete_1.addCell(PrintUtils.createPdfPCell("Region", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));
            entete_1.addCell(PrintUtils.createPdfPCell("District", 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));

            entete_1.addCell(PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(ou_region), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0));
            entete_1.addCell((PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(ou.getName()), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0)));

            entete_1.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("periode"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL), 0, 0, 0, 0));
            entete_1.addCell(PrintUtils.createPdfPCell("" + Utilitaires.formatStringMaj(periodString), 1, new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD), 0, 0, 0, 0));

            rapport.add(entete_1);
            rapport.add(new Paragraph(" ", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));

            float[] widths = {3.2f, 3.5f, 2.7f, 1.3f};
            PdfPTable table = new PdfPTable(widths);
            table.setWidthPercentage(100);

            Paragraph titre = new Paragraph(titreFacture, new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
            titre.setAlignment(Element.ALIGN_CENTER);
            rapport.add(titre);

            rapport.add(new Paragraph(" "));

            table.addCell(PrintUtils.createPdfPCell("" + routine.localizeMessage("formation_sanitaire"), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("" + routine.localizeMessage("banque"), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("" + routine.localizeMessage("bank_account_number"), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));
            table.addCell(PrintUtils.createPdfPCell("" + routine.localizeMessage("montant"), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD)));

            Integer total = 0;
            for (DataConstituantFCD d : dataConstituants) {
                table.addCell(PrintUtils.createPdfPCell(" " + d.getOrganisationunit().getName(), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(d.getBankName() == null ? "" : "" + d.getBankName(), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                table.addCell(PrintUtils.createPdfPCell(d.getBankAccountNumber() == null ? "" : "" + d.getBankAccountNumber(), 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                try {
                    if (d.getAmount() != null) {
                        table.addCell(PrintUtils.createPdfPCell(" " + d.getAmount() == null ? "" : "" + JsfUtil.formaterStringMoney(d.getAmount().intValue()), 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                        total += d.getAmount().intValue();
                    } else {
                        table.addCell(PrintUtils.createPdfPCell(" ", 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                    }
                } catch (Exception e) {
                    table.addCell(PrintUtils.createPdfPCell(" ", 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));
                }
            }

            table.addCell(PrintUtils.createPdfPCell(" Total ", 3, 3, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
            table.addCell(PrintUtils.createPdfPCell(" " + JsfUtil.formaterStringMoney(total), 3, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL)));

            rapport.add(table);

            float[] width_signature = {2.0f, 2.5f, 2f, 2.5f, 2.5f, 2.0f};
            PdfPTable zone_signature = new PdfPTable(width_signature);
            zone_signature.setWidthPercentage(100);
            rapport.add(new Paragraph(" "));

            /**
             * *****************premiere ligne ******************
             */
            zone_signature.addCell(PrintUtils.createPdfPCell("", 1, 6, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 1, 0));

            /*
             *premier ecart
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *Premiere ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("verifie_a"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("verifie_a"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *Deuxieme ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("le_date"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("le_date"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *troisieme ligne
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("district_medical_officer"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell(" " + routine.localizeMessage("cdva_manager"), 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 0, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell("----------------------", 1, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            /*
             *dernier ecart
             */
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));
            zone_signature.addCell(PrintUtils.createPdfPCell(" ", 1, 2, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 0, 1, 0, 0));

            zone_signature.addCell(PrintUtils.createPdfPCell("", 1, 6, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL), 1, 1, 0, 1));

            rapport.add(zone_signature);

            rapport.close();

        } catch (DocumentException ex) {
            Logger.getLogger(PrintUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }

    public static void createLine(Document document) throws DocumentException {
        Paragraph ligne = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------------", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC));
        document.add(ligne);
    }

    private static String getValue(Map map, String key) {
        try {
            Double value = (Double) map.get(key);
            if (value != null) {
                return JsfUtil.formaterStringMoney(value.intValue());
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String getValueString(Map map, String key) {
        try {
            Double value = (Double) map.get(key);
            if (value != null) {
                return "" + Utilitaires.arrondiNDecimales(value * 100, 2);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

}
