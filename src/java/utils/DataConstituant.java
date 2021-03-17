/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Dataelement;

/**
 *
 * @author USER
 */
public class DataConstituant {

    private Integer id;
    private Dataelement dataelement;
    private Double declared;
    private Double validated;
    private Double percentage;
    private Double unitPrice;
    private Double total;

    public DataConstituant() {

    }

    public DataConstituant(Dataelement dataelement, Double declared, Double validated, Double unitPrice) {
        this.dataelement = dataelement;
        this.declared = declared;
        this.validated = validated;
        this.unitPrice = unitPrice;
    }

    public DataConstituant(Dataelement dataelement, Double declared, Double validated, Double percentage, Double unitPrice, Double total) {
        this.dataelement = dataelement;
        this.declared = declared;
        this.validated = validated;
        this.percentage = percentage;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public Dataelement getDataelement() {
        return dataelement;
    }

    public void setDataelement(Dataelement dataelement) {
        this.dataelement = dataelement;
    }

    public Double getDeclared() {
        return declared;
    }

    public void setDeclared(Double declared) {
        this.declared = declared;
    }

    public Double getValidated() {
        return validated;
    }

    public void setValidated(Double validated) {
        this.validated = validated;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
