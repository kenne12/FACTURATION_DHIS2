/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author USER
 */
public class DataElementTreated {

    String code;
    String nomWithCode;
    String nomWithoutCode;
    String nomComplete;

    public DataElementTreated() {
    }

    public DataElementTreated(String code, String nomWithCode, String nomWithoutCode, String nomComplete) {
        this.code = code;
        this.nomWithCode = nomWithCode;
        this.nomWithoutCode = nomWithoutCode;
        this.nomComplete = nomComplete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomWithCode() {
        return nomWithCode;
    }

    public void setNomWithCode(String nomWithCode) {
        this.nomWithCode = nomWithCode;
    }

    public String getNomWithoutCode() {
        return nomWithoutCode;
    }

    public void setNomWithoutCode(String nomWithoutCode) {
        this.nomWithoutCode = nomWithoutCode;
    }

    public String getNomComplete() {
        return nomComplete;
    }

    public void setNomComplete(String nomComplete) {
        this.nomComplete = nomComplete;
    }

}
