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
public class DataAnalytic {

    private String uiIdLevel3;
    private String uiIdLevel4;
    private Double value;
    private String textValue;

    public DataAnalytic() {
    }

    public DataAnalytic(String uiIdLevel3, String uiIdLevel4, Double value, String textValue) {
        this.uiIdLevel3 = uiIdLevel3;
        this.uiIdLevel4 = uiIdLevel4;
        this.value = value;
        this.textValue = textValue;
    }

    public String getUiIdLevel3() {
        return uiIdLevel3;
    }

    public void setUiIdLevel3(String uiIdLevel3) {
        this.uiIdLevel3 = uiIdLevel3;
    }

    public String getUiIdLevel4() {
        return uiIdLevel4;
    }

    public void setUiIdLevel4(String uiIdLevel4) {
        this.uiIdLevel4 = uiIdLevel4;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

}
