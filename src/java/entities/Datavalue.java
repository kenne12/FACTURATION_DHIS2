/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datavalue.findAll", query = "SELECT d FROM Datavalue d"),
    @NamedQuery(name = "Datavalue.findByDataelementid", query = "SELECT d FROM Datavalue d WHERE d.datavaluePK.dataelementid = :dataelementid"),
    @NamedQuery(name = "Datavalue.findByPeriodid", query = "SELECT d FROM Datavalue d WHERE d.datavaluePK.periodid = :periodid"),
    @NamedQuery(name = "Datavalue.findBySourceid", query = "SELECT d FROM Datavalue d WHERE d.datavaluePK.sourceid = :sourceid"),
    @NamedQuery(name = "Datavalue.findByCategoryoptioncomboid", query = "SELECT d FROM Datavalue d WHERE d.datavaluePK.categoryoptioncomboid = :categoryoptioncomboid"),
    @NamedQuery(name = "Datavalue.findByAttributeoptioncomboid", query = "SELECT d FROM Datavalue d WHERE d.datavaluePK.attributeoptioncomboid = :attributeoptioncomboid"),
    @NamedQuery(name = "Datavalue.findByValue", query = "SELECT d FROM Datavalue d WHERE d.value = :value"),
    @NamedQuery(name = "Datavalue.findByStoredby", query = "SELECT d FROM Datavalue d WHERE d.storedby = :storedby"),
    @NamedQuery(name = "Datavalue.findByCreated", query = "SELECT d FROM Datavalue d WHERE d.created = :created"),
    @NamedQuery(name = "Datavalue.findByLastupdated", query = "SELECT d FROM Datavalue d WHERE d.lastupdated = :lastupdated"),
    @NamedQuery(name = "Datavalue.findByComment", query = "SELECT d FROM Datavalue d WHERE d.comment = :comment"),
    @NamedQuery(name = "Datavalue.findByFollowup", query = "SELECT d FROM Datavalue d WHERE d.followup = :followup")})
public class Datavalue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatavaluePK datavaluePK;
    @Size(max = 50000)
    private String value;
    @Size(max = 255)
    private String storedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdated;
    @Size(max = 50000)
    private String comment;
    private Boolean followup;
    @JoinColumn(name = "attributeoptioncomboid", referencedColumnName = "categoryoptioncomboid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoryoptioncombo categoryoptioncombo;
    @JoinColumn(name = "categoryoptioncomboid", referencedColumnName = "categoryoptioncomboid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoryoptioncombo categoryoptioncombo1;
    @JoinColumn(name = "dataelementid", referencedColumnName = "dataelementid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dataelement dataelement;
    @JoinColumn(name = "sourceid", referencedColumnName = "organisationunitid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Organisationunit organisationunit;
    @JoinColumn(name = "periodid", referencedColumnName = "periodid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Period period;

    public Datavalue() {

    }

    public Datavalue(DatavaluePK datavaluePK) {
        this.datavaluePK = datavaluePK;
    }

    public Datavalue(int dataelementid, int periodid, int sourceid, int categoryoptioncomboid, int attributeoptioncomboid) {
        this.datavaluePK = new DatavaluePK(dataelementid, periodid, sourceid, categoryoptioncomboid, attributeoptioncomboid);
    }

    public DatavaluePK getDatavaluePK() {
        return datavaluePK;
    }

    public void setDatavaluePK(DatavaluePK datavaluePK) {
        this.datavaluePK = datavaluePK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStoredby() {
        return storedby;
    }

    public void setStoredby(String storedby) {
        this.storedby = storedby;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getFollowup() {
        return followup;
    }

    public void setFollowup(Boolean followup) {
        this.followup = followup;
    }

    public Categoryoptioncombo getCategoryoptioncombo() {
        return categoryoptioncombo;
    }

    public void setCategoryoptioncombo(Categoryoptioncombo categoryoptioncombo) {
        this.categoryoptioncombo = categoryoptioncombo;
    }

    public Categoryoptioncombo getCategoryoptioncombo1() {
        return categoryoptioncombo1;
    }

    public void setCategoryoptioncombo1(Categoryoptioncombo categoryoptioncombo1) {
        this.categoryoptioncombo1 = categoryoptioncombo1;
    }

    public Dataelement getDataelement() {
        return dataelement;
    }

    public void setDataelement(Dataelement dataelement) {
        this.dataelement = dataelement;
    }

    public Organisationunit getOrganisationunit() {
        return organisationunit;
    }

    public void setOrganisationunit(Organisationunit organisationunit) {
        this.organisationunit = organisationunit;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datavaluePK != null ? datavaluePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datavalue)) {
            return false;
        }
        Datavalue other = (Datavalue) object;
        if ((this.datavaluePK == null && other.datavaluePK != null) || (this.datavaluePK != null && !this.datavaluePK.equals(other.datavaluePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Datavalue[ datavaluePK=" + datavaluePK + " ]";
    }

}
