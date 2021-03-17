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
    @NamedQuery(name = "Maplegendset.findAll", query = "SELECT m FROM Maplegendset m"),
    @NamedQuery(name = "Maplegendset.findByMaplegendsetid", query = "SELECT m FROM Maplegendset m WHERE m.maplegendsetid = :maplegendsetid"),
    @NamedQuery(name = "Maplegendset.findByUid", query = "SELECT m FROM Maplegendset m WHERE m.uid = :uid"),
    @NamedQuery(name = "Maplegendset.findByCode", query = "SELECT m FROM Maplegendset m WHERE m.code = :code"),
    @NamedQuery(name = "Maplegendset.findByCreated", query = "SELECT m FROM Maplegendset m WHERE m.created = :created"),
    @NamedQuery(name = "Maplegendset.findByLastupdated", query = "SELECT m FROM Maplegendset m WHERE m.lastupdated = :lastupdated"),
    @NamedQuery(name = "Maplegendset.findByName", query = "SELECT m FROM Maplegendset m WHERE m.name = :name"),
    @NamedQuery(name = "Maplegendset.findBySymbolizer", query = "SELECT m FROM Maplegendset m WHERE m.symbolizer = :symbolizer")})
public class Maplegendset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer maplegendsetid;
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
    @Size(max = 255)
    private String symbolizer;
    @OneToMany(mappedBy = "legendsetid", fetch = FetchType.LAZY)
    private List<Dataelement> dataelementList;

    public Maplegendset() {
    }

    public Maplegendset(Integer maplegendsetid) {
        this.maplegendsetid = maplegendsetid;
    }

    public Maplegendset(Integer maplegendsetid, String uid, String name) {
        this.maplegendsetid = maplegendsetid;
        this.uid = uid;
        this.name = name;
    }

    public Integer getMaplegendsetid() {
        return maplegendsetid;
    }

    public void setMaplegendsetid(Integer maplegendsetid) {
        this.maplegendsetid = maplegendsetid;
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

    public String getSymbolizer() {
        return symbolizer;
    }

    public void setSymbolizer(String symbolizer) {
        this.symbolizer = symbolizer;
    }

    @XmlTransient
    public List<Dataelement> getDataelementList() {
        return dataelementList;
    }

    public void setDataelementList(List<Dataelement> dataelementList) {
        this.dataelementList = dataelementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maplegendsetid != null ? maplegendsetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maplegendset)) {
            return false;
        }
        Maplegendset other = (Maplegendset) object;
        if ((this.maplegendsetid == null && other.maplegendsetid != null) || (this.maplegendsetid != null && !this.maplegendsetid.equals(other.maplegendsetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Maplegendset[ maplegendsetid=" + maplegendsetid + " ]";
    }
    
}
