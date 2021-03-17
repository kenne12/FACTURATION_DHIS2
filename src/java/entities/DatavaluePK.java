/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USER
 */
@Embeddable
public class DatavaluePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int dataelementid;
    @Basic(optional = false)
    @NotNull
    private int periodid;
    @Basic(optional = false)
    @NotNull
    private int sourceid;
    @Basic(optional = false)
    @NotNull
    private int categoryoptioncomboid;
    @Basic(optional = false)
    @NotNull
    private int attributeoptioncomboid;

    public DatavaluePK() {
    }

    public DatavaluePK(int dataelementid, int periodid, int sourceid, int categoryoptioncomboid, int attributeoptioncomboid) {
        this.dataelementid = dataelementid;
        this.periodid = periodid;
        this.sourceid = sourceid;
        this.categoryoptioncomboid = categoryoptioncomboid;
        this.attributeoptioncomboid = attributeoptioncomboid;
    }

    public int getDataelementid() {
        return dataelementid;
    }

    public void setDataelementid(int dataelementid) {
        this.dataelementid = dataelementid;
    }

    public int getPeriodid() {
        return periodid;
    }

    public void setPeriodid(int periodid) {
        this.periodid = periodid;
    }

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getCategoryoptioncomboid() {
        return categoryoptioncomboid;
    }

    public void setCategoryoptioncomboid(int categoryoptioncomboid) {
        this.categoryoptioncomboid = categoryoptioncomboid;
    }

    public int getAttributeoptioncomboid() {
        return attributeoptioncomboid;
    }

    public void setAttributeoptioncomboid(int attributeoptioncomboid) {
        this.attributeoptioncomboid = attributeoptioncomboid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataelementid;
        hash += (int) periodid;
        hash += (int) sourceid;
        hash += (int) categoryoptioncomboid;
        hash += (int) attributeoptioncomboid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatavaluePK)) {
            return false;
        }
        DatavaluePK other = (DatavaluePK) object;
        if (this.dataelementid != other.dataelementid) {
            return false;
        }
        if (this.periodid != other.periodid) {
            return false;
        }
        if (this.sourceid != other.sourceid) {
            return false;
        }
        if (this.categoryoptioncomboid != other.categoryoptioncomboid) {
            return false;
        }
        if (this.attributeoptioncomboid != other.attributeoptioncomboid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DatavaluePK[ dataelementid=" + dataelementid + ", periodid=" + periodid + ", sourceid=" + sourceid + ", categoryoptioncomboid=" + categoryoptioncomboid + ", attributeoptioncomboid=" + attributeoptioncomboid + " ]";
    }
    
}
