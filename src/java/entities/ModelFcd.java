/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "modelfcd")
public class ModelFcd implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer modelId;
    @Column(length = 150)
    private String nom;
    @Column(length = 10)
    private String annee;
    @Column(name = "banknamecode" , length = 35)
    private String bankNameCode;
    @Column(name = "bankaccountnumbercode" , length = 35)
    private String bankAccountNumberCode;
    @Column(name = "totalamountcode" , length = 35)
    private String totalAmountCode;

    public ModelFcd() {
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getBankNameCode() {
        return bankNameCode;
    }

    public void setBankNameCode(String bankNameCode) {
        this.bankNameCode = bankNameCode;
    }

    public String getBankAccountNumberCode() {
        return bankAccountNumberCode;
    }

    public void setBankAccountNumberCode(String bankAccountNumberCode) {
        this.bankAccountNumberCode = bankAccountNumberCode;
    }

    public String getTotalAmountCode() {
        return totalAmountCode;
    }

    public void setTotalAmountCode(String totalAmountCode) {
        this.totalAmountCode = totalAmountCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.modelId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelFcd other = (ModelFcd) obj;
        if (!Objects.equals(this.modelId, other.modelId)) {
            return false;
        }
        return true;
    }

}
