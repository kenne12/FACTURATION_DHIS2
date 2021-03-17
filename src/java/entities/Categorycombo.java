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
    @NamedQuery(name = "Categorycombo.findAll", query = "SELECT c FROM Categorycombo c"),
    @NamedQuery(name = "Categorycombo.findByCategorycomboid", query = "SELECT c FROM Categorycombo c WHERE c.categorycomboid = :categorycomboid"),
    @NamedQuery(name = "Categorycombo.findByUid", query = "SELECT c FROM Categorycombo c WHERE c.uid = :uid"),
    @NamedQuery(name = "Categorycombo.findByCode", query = "SELECT c FROM Categorycombo c WHERE c.code = :code"),
    @NamedQuery(name = "Categorycombo.findByCreated", query = "SELECT c FROM Categorycombo c WHERE c.created = :created"),
    @NamedQuery(name = "Categorycombo.findByLastupdated", query = "SELECT c FROM Categorycombo c WHERE c.lastupdated = :lastupdated"),
    @NamedQuery(name = "Categorycombo.findByName", query = "SELECT c FROM Categorycombo c WHERE c.name = :name"),
    @NamedQuery(name = "Categorycombo.findByDatadimensiontype", query = "SELECT c FROM Categorycombo c WHERE c.datadimensiontype = :datadimensiontype"),
    @NamedQuery(name = "Categorycombo.findBySkiptotal", query = "SELECT c FROM Categorycombo c WHERE c.skiptotal = :skiptotal"),
    @NamedQuery(name = "Categorycombo.findByPublicaccess", query = "SELECT c FROM Categorycombo c WHERE c.publicaccess = :publicaccess")})
public class Categorycombo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer categorycomboid;
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
    @Size(min = 1, max = 255)
    private String datadimensiontype;
    @Basic(optional = false)
    @NotNull
    private boolean skiptotal;
    @Size(max = 8)
    private String publicaccess;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorycomboid", fetch = FetchType.LAZY)
    private List<Dataelement> dataelementList;
    @JoinColumn(name = "userid", referencedColumnName = "userinfoid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userinfo userid;

    public Categorycombo() {
    }

    public Categorycombo(Integer categorycomboid) {
        this.categorycomboid = categorycomboid;
    }

    public Categorycombo(Integer categorycomboid, String uid, String name, String datadimensiontype, boolean skiptotal) {
        this.categorycomboid = categorycomboid;
        this.uid = uid;
        this.name = name;
        this.datadimensiontype = datadimensiontype;
        this.skiptotal = skiptotal;
    }

    public Integer getCategorycomboid() {
        return categorycomboid;
    }

    public void setCategorycomboid(Integer categorycomboid) {
        this.categorycomboid = categorycomboid;
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

    public String getDatadimensiontype() {
        return datadimensiontype;
    }

    public void setDatadimensiontype(String datadimensiontype) {
        this.datadimensiontype = datadimensiontype;
    }

    public boolean getSkiptotal() {
        return skiptotal;
    }

    public void setSkiptotal(boolean skiptotal) {
        this.skiptotal = skiptotal;
    }

    public String getPublicaccess() {
        return publicaccess;
    }

    public void setPublicaccess(String publicaccess) {
        this.publicaccess = publicaccess;
    }

    @XmlTransient
    public List<Dataelement> getDataelementList() {
        return dataelementList;
    }

    public void setDataelementList(List<Dataelement> dataelementList) {
        this.dataelementList = dataelementList;
    }

    public Userinfo getUserid() {
        return userid;
    }

    public void setUserid(Userinfo userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorycomboid != null ? categorycomboid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorycombo)) {
            return false;
        }
        Categorycombo other = (Categorycombo) object;
        if ((this.categorycomboid == null && other.categorycomboid != null) || (this.categorycomboid != null && !this.categorycomboid.equals(other.categorycomboid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorycombo[ categorycomboid=" + categorycomboid + " ]";
    }
    
}
