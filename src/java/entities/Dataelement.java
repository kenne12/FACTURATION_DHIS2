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
    @NamedQuery(name = "Dataelement.findAll", query = "SELECT d FROM Dataelement d"),
    @NamedQuery(name = "Dataelement.findByDataelementid", query = "SELECT d FROM Dataelement d WHERE d.dataelementid = :dataelementid"),
    @NamedQuery(name = "Dataelement.findByUid", query = "SELECT d FROM Dataelement d WHERE d.uid = :uid"),
    @NamedQuery(name = "Dataelement.findByCode", query = "SELECT d FROM Dataelement d WHERE d.code = :code"),
    @NamedQuery(name = "Dataelement.findByCreated", query = "SELECT d FROM Dataelement d WHERE d.created = :created"),
    @NamedQuery(name = "Dataelement.findByLastupdated", query = "SELECT d FROM Dataelement d WHERE d.lastupdated = :lastupdated"),
    @NamedQuery(name = "Dataelement.findByName", query = "SELECT d FROM Dataelement d WHERE d.name = :name"),
    @NamedQuery(name = "Dataelement.findByShortname", query = "SELECT d FROM Dataelement d WHERE d.shortname = :shortname"),
    @NamedQuery(name = "Dataelement.findByDescription", query = "SELECT d FROM Dataelement d WHERE d.description = :description"),
    @NamedQuery(name = "Dataelement.findByFormname", query = "SELECT d FROM Dataelement d WHERE d.formname = :formname"),
    @NamedQuery(name = "Dataelement.findByValuetype", query = "SELECT d FROM Dataelement d WHERE d.valuetype = :valuetype"),
    @NamedQuery(name = "Dataelement.findByDomaintype", query = "SELECT d FROM Dataelement d WHERE d.domaintype = :domaintype"),
    @NamedQuery(name = "Dataelement.findByAggregationtype", query = "SELECT d FROM Dataelement d WHERE d.aggregationtype = :aggregationtype"),
    @NamedQuery(name = "Dataelement.findByUrl", query = "SELECT d FROM Dataelement d WHERE d.url = :url"),
    @NamedQuery(name = "Dataelement.findByZeroissignificant", query = "SELECT d FROM Dataelement d WHERE d.zeroissignificant = :zeroissignificant"),
    @NamedQuery(name = "Dataelement.findByPublicaccess", query = "SELECT d FROM Dataelement d WHERE d.publicaccess = :publicaccess")})
public class Dataelement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer dataelementid;
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
    private String shortname;
    @Size(max = 2147483647)
    private String description;
    @Size(max = 230)
    private String formname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String valuetype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String domaintype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String aggregationtype;
    @Size(max = 255)
    private String url;
    @Basic(optional = false)
    @NotNull
    private boolean zeroissignificant;
    @Size(max = 8)
    private String publicaccess;
    @JoinColumn(name = "categorycomboid", referencedColumnName = "categorycomboid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categorycombo categorycomboid;
    @JoinColumn(name = "legendsetid", referencedColumnName = "maplegendsetid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Maplegendset legendsetid;
    @JoinColumn(name = "commentoptionsetid", referencedColumnName = "optionsetid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Optionset commentoptionsetid;
    @JoinColumn(name = "optionsetid", referencedColumnName = "optionsetid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Optionset optionsetid;
    @JoinColumn(name = "userid", referencedColumnName = "userinfoid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userinfo userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataelement", fetch = FetchType.LAZY)
    private List<Datavalue> datavalueList;

    public Dataelement() {
    }

    public Dataelement(Integer dataelementid) {
        this.dataelementid = dataelementid;
    }

    public Dataelement(String name) {
        this.name = name;
    }

    public Dataelement(Integer dataelementid, String uid, String name, String shortname, String valuetype, String domaintype, String aggregationtype, boolean zeroissignificant) {
        this.dataelementid = dataelementid;
        this.uid = uid;
        this.name = name;
        this.shortname = shortname;
        this.valuetype = valuetype;
        this.domaintype = domaintype;
        this.aggregationtype = aggregationtype;
        this.zeroissignificant = zeroissignificant;
    }

    public Integer getDataelementid() {
        return dataelementid;
    }

    public void setDataelementid(Integer dataelementid) {
        this.dataelementid = dataelementid;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public String getDomaintype() {
        return domaintype;
    }

    public void setDomaintype(String domaintype) {
        this.domaintype = domaintype;
    }

    public String getAggregationtype() {
        return aggregationtype;
    }

    public void setAggregationtype(String aggregationtype) {
        this.aggregationtype = aggregationtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getZeroissignificant() {
        return zeroissignificant;
    }

    public void setZeroissignificant(boolean zeroissignificant) {
        this.zeroissignificant = zeroissignificant;
    }

    public String getPublicaccess() {
        return publicaccess;
    }

    public void setPublicaccess(String publicaccess) {
        this.publicaccess = publicaccess;
    }

    public Categorycombo getCategorycomboid() {
        return categorycomboid;
    }

    public void setCategorycomboid(Categorycombo categorycomboid) {
        this.categorycomboid = categorycomboid;
    }

    public Maplegendset getLegendsetid() {
        return legendsetid;
    }

    public void setLegendsetid(Maplegendset legendsetid) {
        this.legendsetid = legendsetid;
    }

    public Optionset getCommentoptionsetid() {
        return commentoptionsetid;
    }

    public void setCommentoptionsetid(Optionset commentoptionsetid) {
        this.commentoptionsetid = commentoptionsetid;
    }

    public Optionset getOptionsetid() {
        return optionsetid;
    }

    public void setOptionsetid(Optionset optionsetid) {
        this.optionsetid = optionsetid;
    }

    public Userinfo getUserid() {
        return userid;
    }

    public void setUserid(Userinfo userid) {
        this.userid = userid;
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
        hash += (dataelementid != null ? dataelementid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataelement)) {
            return false;
        }
        Dataelement other = (Dataelement) object;
        if ((this.dataelementid == null && other.dataelementid != null) || (this.dataelementid != null && !this.dataelementid.equals(other.dataelementid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dataelement[ dataelementid=" + dataelementid + " ]";
    }

}
