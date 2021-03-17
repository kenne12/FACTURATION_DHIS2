/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodtype.findAll", query = "SELECT p FROM Periodtype p"),
    @NamedQuery(name = "Periodtype.findByPeriodtypeid", query = "SELECT p FROM Periodtype p WHERE p.periodtypeid = :periodtypeid"),
    @NamedQuery(name = "Periodtype.findByName", query = "SELECT p FROM Periodtype p WHERE p.name = :name")})
public class Periodtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer periodtypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @OneToMany(mappedBy = "periodtypeid", fetch = FetchType.LAZY)
    private List<Period> periodList;

    public Periodtype() {
    }

    public Periodtype(Integer periodtypeid) {
        this.periodtypeid = periodtypeid;
    }

    public Periodtype(Integer periodtypeid, String name) {
        this.periodtypeid = periodtypeid;
        this.name = name;
    }

    public Integer getPeriodtypeid() {
        return periodtypeid;
    }

    public void setPeriodtypeid(Integer periodtypeid) {
        this.periodtypeid = periodtypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Period> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Period> periodList) {
        this.periodList = periodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodtypeid != null ? periodtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodtype)) {
            return false;
        }
        Periodtype other = (Periodtype) object;
        if ((this.periodtypeid == null && other.periodtypeid != null) || (this.periodtypeid != null && !this.periodtypeid.equals(other.periodtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Periodtype[ periodtypeid=" + periodtypeid + " ]";
    }
    
}
