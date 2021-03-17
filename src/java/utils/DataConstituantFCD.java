/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Organisationunit;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class DataConstituantFCD {

    private Integer id;
    private Organisationunit organisationunit;
    private String bankName;
    private String bankAccountNumber;
    private Double amount;

    public DataConstituantFCD() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organisationunit getOrganisationunit() {
        return organisationunit;
    }

    public void setOrganisationunit(Organisationunit organisationunit) {
        this.organisationunit = organisationunit;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final DataConstituantFCD other = (DataConstituantFCD) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
