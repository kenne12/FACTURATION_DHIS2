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
    @NamedQuery(name = "Optionset.findAll", query = "SELECT o FROM Optionset o"),
    @NamedQuery(name = "Optionset.findByOptionsetid", query = "SELECT o FROM Optionset o WHERE o.optionsetid = :optionsetid"),
    @NamedQuery(name = "Optionset.findByUid", query = "SELECT o FROM Optionset o WHERE o.uid = :uid"),
    @NamedQuery(name = "Optionset.findByCode", query = "SELECT o FROM Optionset o WHERE o.code = :code"),
    @NamedQuery(name = "Optionset.findByCreated", query = "SELECT o FROM Optionset o WHERE o.created = :created"),
    @NamedQuery(name = "Optionset.findByLastupdated", query = "SELECT o FROM Optionset o WHERE o.lastupdated = :lastupdated"),
    @NamedQuery(name = "Optionset.findByName", query = "SELECT o FROM Optionset o WHERE o.name = :name"),
    @NamedQuery(name = "Optionset.findByValuetype", query = "SELECT o FROM Optionset o WHERE o.valuetype = :valuetype"),
    @NamedQuery(name = "Optionset.findByVersion", query = "SELECT o FROM Optionset o WHERE o.version = :version"),
    @NamedQuery(name = "Optionset.findByPublicaccess", query = "SELECT o FROM Optionset o WHERE o.publicaccess = :publicaccess")})
public class Optionset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer optionsetid;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 230)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String valuetype;
    private Integer version;
    @Size(max = 8)
    private String publicaccess;
    @JoinColumn(name = "userid", referencedColumnName = "userinfoid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userinfo userid;
    @OneToMany(mappedBy = "commentoptionsetid", fetch = FetchType.LAZY)
    private List<Dataelement> dataelementList;
    @OneToMany(mappedBy = "optionsetid", fetch = FetchType.LAZY)
    private List<Dataelement> dataelementList1;

    public Optionset() {
    }

    public Optionset(Integer optionsetid) {
        this.optionsetid = optionsetid;
    }

    public Optionset(Integer optionsetid, String uid, String name, String valuetype) {
        this.optionsetid = optionsetid;
        this.uid = uid;
        this.name = name;
        this.valuetype = valuetype;
    }

    public Integer getOptionsetid() {
        return optionsetid;
    }

    public void setOptionsetid(Integer optionsetid) {
        this.optionsetid = optionsetid;
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

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPublicaccess() {
        return publicaccess;
    }

    public void setPublicaccess(String publicaccess) {
        this.publicaccess = publicaccess;
    }

    public Userinfo getUserid() {
        return userid;
    }

    public void setUserid(Userinfo userid) {
        this.userid = userid;
    }

    @XmlTransient
    public List<Dataelement> getDataelementList() {
        return dataelementList;
    }

    public void setDataelementList(List<Dataelement> dataelementList) {
        this.dataelementList = dataelementList;
    }

    @XmlTransient
    public List<Dataelement> getDataelementList1() {
        return dataelementList1;
    }

    public void setDataelementList1(List<Dataelement> dataelementList1) {
        this.dataelementList1 = dataelementList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionsetid != null ? optionsetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Optionset)) {
            return false;
        }
        Optionset other = (Optionset) object;
        if ((this.optionsetid == null && other.optionsetid != null) || (this.optionsetid != null && !this.optionsetid.equals(other.optionsetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Optionset[ optionsetid=" + optionsetid + " ]";
    }
    
}
