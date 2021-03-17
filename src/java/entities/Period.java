/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p"),
    @NamedQuery(name = "Period.findByPeriodid", query = "SELECT p FROM Period p WHERE p.periodid = :periodid"),
    @NamedQuery(name = "Period.findByStartdate", query = "SELECT p FROM Period p WHERE p.startdate = :startdate"),
    @NamedQuery(name = "Period.findByEnddate", query = "SELECT p FROM Period p WHERE p.enddate = :enddate")})
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer periodid;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @JoinColumn(name = "periodtypeid", referencedColumnName = "periodtypeid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periodtype periodtypeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "period", fetch = FetchType.LAZY)
    private List<Datavalue> datavalueList;

    public Period() {
    }

    public Period(Integer periodid) {
        this.periodid = periodid;
    }

    public Period(Integer periodid, Date startdate, Date enddate) {
        this.periodid = periodid;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getPeriodid() {
        return periodid;
    }

    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Periodtype getPeriodtypeid() {
        return periodtypeid;
    }

    public void setPeriodtypeid(Periodtype periodtypeid) {
        this.periodtypeid = periodtypeid;
    }

    @XmlTransient
    public List<Datavalue> getDatavalueList() {
        return datavalueList;
    }

    public void setDatavalueList(List<Datavalue> datavalueList) {
        this.datavalueList = datavalueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodid != null ? periodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.periodid == null && other.periodid != null) || (this.periodid != null && !this.periodid.equals(other.periodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Period[ periodid=" + periodid + " ]";
    }
    
}
