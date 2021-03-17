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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Categoryoptioncombo.findAll", query = "SELECT c FROM Categoryoptioncombo c"),
    @NamedQuery(name = "Categoryoptioncombo.findByCategoryoptioncomboid", query = "SELECT c FROM Categoryoptioncombo c WHERE c.categoryoptioncomboid = :categoryoptioncomboid"),
    @NamedQuery(name = "Categoryoptioncombo.findByUid", query = "SELECT c FROM Categoryoptioncombo c WHERE c.uid = :uid"),
    @NamedQuery(name = "Categoryoptioncombo.findByCode", query = "SELECT c FROM Categoryoptioncombo c WHERE c.code = :code"),
    @NamedQuery(name = "Categoryoptioncombo.findByCreated", query = "SELECT c FROM Categoryoptioncombo c WHERE c.created = :created"),
    @NamedQuery(name = "Categoryoptioncombo.findByLastupdated", query = "SELECT c FROM Categoryoptioncombo c WHERE c.lastupdated = :lastupdated"),
    @NamedQuery(name = "Categoryoptioncombo.findByName", query = "SELECT c FROM Categoryoptioncombo c WHERE c.name = :name"),
    @NamedQuery(name = "Categoryoptioncombo.findByIgnoreapproval", query = "SELECT c FROM Categoryoptioncombo c WHERE c.ignoreapproval = :ignoreapproval")})
public class Categoryoptioncombo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer categoryoptioncomboid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    private String uid;
    @Size(max = 50)
    private String code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdated;
    @Size(max = 2147483647)
    private String name;
    private Boolean ignoreapproval;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryoptioncombo", fetch = FetchType.LAZY)
    private List<Datavalue> datavalueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryoptioncombo1", fetch = FetchType.LAZY)
    private List<Datavalue> datavalueList1;

    public Categoryoptioncombo() {
    }

    public Categoryoptioncombo(Integer categoryoptioncomboid) {
        this.categoryoptioncomboid = categoryoptioncomboid;
    }

    public Categoryoptioncombo(Integer categoryoptioncomboid, String uid) {
        this.categoryoptioncomboid = categoryoptioncomboid;
        this.uid = uid;
    }

    public Integer getCategoryoptioncomboid() {
        return categoryoptioncomboid;
    }

    public void setCategoryoptioncomboid(Integer categoryoptioncomboid) {
        this.categoryoptioncomboid = categoryoptioncomboid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIgnoreapproval() {
        return ignoreapproval;
    }

    public void setIgnoreapproval(Boolean ignoreapproval) {
        this.ignoreapproval = ignoreapproval;
    }

    @XmlTransient
    public List<Datavalue> getDatavalueList() {
        return datavalueList;
    }

    public void setDatavalueList(List<Datavalue> datavalueList) {
        this.datavalueList = datavalueList;
    }

    @XmlTransient
    public List<Datavalue> getDatavalueList1() {
        return datavalueList1;
    }

    public void setDatavalueList1(List<Datavalue> datavalueList1) {
        this.datavalueList1 = datavalueList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryoptioncomboid != null ? categoryoptioncomboid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoryoptioncombo)) {
            return false;
        }
        Categoryoptioncombo other = (Categoryoptioncombo) object;
        if ((this.categoryoptioncomboid == null && other.categoryoptioncomboid != null) || (this.categoryoptioncomboid != null && !this.categoryoptioncomboid.equals(other.categoryoptioncomboid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categoryoptioncombo[ categoryoptioncomboid=" + categoryoptioncomboid + " ]";
    }
    
}
