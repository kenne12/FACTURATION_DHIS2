/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Datavalue;

/**
 *
 * @author USER
 */
public class DataForm {

    private String code;
    private String nameWithCode;
    private String nameWithoutCode;
    private Datavalue datavalue;

    public DataForm() {
    }

    public DataForm(String code, String nameWithCode, String nameWithoutCode, Datavalue datavalue) {
        this.code = code;
        this.nameWithCode = nameWithCode;
        this.nameWithoutCode = nameWithoutCode;
        this.datavalue = datavalue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameWithCode() {
        return nameWithCode;
    }

    public void setNameWithCode(String nameWithCode) {
        this.nameWithCode = nameWithCode;
    }

    public String getNameWithoutCode() {
        return nameWithoutCode;
    }

    public void setNameWithoutCode(String nameWithoutCode) {
        this.nameWithoutCode = nameWithoutCode;
    }

    public Datavalue getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(Datavalue datavalue) {
        this.datavalue = datavalue;
    }

}
