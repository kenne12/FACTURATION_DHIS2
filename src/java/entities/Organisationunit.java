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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Organisationunit.findAll", query = "SELECT o FROM Organisationunit o"),
    @NamedQuery(name = "Organisationunit.findByOrganisationunitid", query = "SELECT o FROM Organisationunit o WHERE o.organisationunitid = :organisationunitid"),
    @NamedQuery(name = "Organisationunit.findByUid", query = "SELECT o FROM Organisationunit o WHERE o.uid = :uid"),
    @NamedQuery(name = "Organisationunit.findByCode", query = "SELECT o FROM Organisationunit o WHERE o.code = :code"),
    @NamedQuery(name = "Organisationunit.findByCreated", query = "SELECT o FROM Organisationunit o WHERE o.created = :created"),
    @NamedQuery(name = "Organisationunit.findByLastupdated", query = "SELECT o FROM Organisationunit o WHERE o.lastupdated = :lastupdated"),
    @NamedQuery(name = "Organisationunit.findByName", query = "SELECT o FROM Organisationunit o WHERE o.name = :name"),
    @NamedQuery(name = "Organisationunit.findByShortname", query = "SELECT o FROM Organisationunit o WHERE o.shortname = :shortname"),
    @NamedQuery(name = "Organisationunit.findByPath", query = "SELECT o FROM Organisationunit o WHERE o.path = :path"),
    @NamedQuery(name = "Organisationunit.findByHierarchylevel", query = "SELECT o FROM Organisationunit o WHERE o.hierarchylevel = :hierarchylevel"),
    @NamedQuery(name = "Organisationunit.findByUuid", query = "SELECT o FROM Organisationunit o WHERE o.uuid = :uuid"),
    @NamedQuery(name = "Organisationunit.findByDescription", query = "SELECT o FROM Organisationunit o WHERE o.description = :description"),
    @NamedQuery(name = "Organisationunit.findByOpeningdate", query = "SELECT o FROM Organisationunit o WHERE o.openingdate = :openingdate"),
    @NamedQuery(name = "Organisationunit.findByCloseddate", query = "SELECT o FROM Organisationunit o WHERE o.closeddate = :closeddate"),
    @NamedQuery(name = "Organisationunit.findByComment", query = "SELECT o FROM Organisationunit o WHERE o.comment = :comment"),
    @NamedQuery(name = "Organisationunit.findByFeaturetype", query = "SELECT o FROM Organisationunit o WHERE o.featuretype = :featuretype"),
    @NamedQuery(name = "Organisationunit.findByCoordinates", query = "SELECT o FROM Organisationunit o WHERE o.coordinates = :coordinates"),
    @NamedQuery(name = "Organisationunit.findByUrl", query = "SELECT o FROM Organisationunit o WHERE o.url = :url"),
    @NamedQuery(name = "Organisationunit.findByContactperson", query = "SELECT o FROM Organisationunit o WHERE o.contactperson = :contactperson"),
    @NamedQuery(name = "Organisationunit.findByAddress", query = "SELECT o FROM Organisationunit o WHERE o.address = :address"),
    @NamedQuery(name = "Organisationunit.findByEmail", query = "SELECT o FROM Organisationunit o WHERE o.email = :email"),
    @NamedQuery(name = "Organisationunit.findByPhonenumber", query = "SELECT o FROM Organisationunit o WHERE o.phonenumber = :phonenumber")})
public class Organisationunit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer organisationunitid;
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
    @Size(max = 255)
    private String path;
    private Integer hierarchylevel;
    @Size(max = 36)
    private String uuid;
    @Size(max = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date openingdate;
    @Temporal(TemporalType.DATE)
    private Date closeddate;
    @Size(max = 2147483647)
    private String comment;
    @Size(max = 50)
    private String featuretype;
    @Size(max = 2147483647)
    private String coordinates;
    @Size(max = 255)
    private String url;
    @Size(max = 255)
    private String contactperson;
    @Size(max = 255)
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    private String email;
    @Size(max = 150)
    private String phonenumber;
    @JoinTable(name = "usermembership", joinColumns = {
        @JoinColumn(name = "organisationunitid", referencedColumnName = "organisationunitid")}, inverseJoinColumns = {
        @JoinColumn(name = "userinfoid", referencedColumnName = "userinfoid")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Userinfo> userinfoList;
    @JoinTable(name = "userteisearchorgunits", joinColumns = {
        @JoinColumn(name = "organisationunitid", referencedColumnName = "organisationunitid")}, inverseJoinColumns = {
        @JoinColumn(name = "userinfoid", referencedColumnName = "userinfoid")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Userinfo> userinfoList1;
    @JoinTable(name = "userdatavieworgunits", joinColumns = {
        @JoinColumn(name = "organisationunitid", referencedColumnName = "organisationunitid")}, inverseJoinColumns = {
        @JoinColumn(name = "userinfoid", referencedColumnName = "userinfoid")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Userinfo> userinfoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisationunit", fetch = FetchType.LAZY)
    private List<Datavalue> datavalueList;
    @OneToMany(mappedBy = "parentid", fetch = FetchType.LAZY)
    private List<Organisationunit> organisationunitList;
    @JoinColumn(name = "parentid", referencedColumnName = "organisationunitid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organisationunit parentid;
    @JoinColumn(name = "userid", referencedColumnName = "userinfoid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userinfo userid;

    public Organisationunit() {
    }

    public Organisationunit(Integer organisationunitid) {
        this.organisationunitid = organisationunitid;
    }

    public Organisationunit(Integer organisationunitid, String uid, String name, String shortname, Date openingdate) {
        this.organisationunitid = organisationunitid;
        this.uid = uid;
        this.name = name;
        this.shortname = shortname;
        this.openingdate = openingdate;
    }

    public Integer getOrganisationunitid() {
        return organisationunitid;
    }

    public void setOrganisationunitid(Integer organisationunitid) {
        this.organisationunitid = organisationunitid;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getHierarchylevel() {
        return hierarchylevel;
    }

    public void setHierarchylevel(Integer hierarchylevel) {
        this.hierarchylevel = hierarchylevel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOpeningdate() {
        return openingdate;
    }

    public void setOpeningdate(Date openingdate) {
        this.openingdate = openingdate;
    }

    public Date getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(Date closeddate) {
        this.closeddate = closeddate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeaturetype() {
        return featuretype;
    }

    public void setFeaturetype(String featuretype) {
        this.featuretype = featuretype;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @XmlTransient
    public List<Userinfo> getUserinfoList() {
        return userinfoList;
    }

    public void setUserinfoList(List<Userinfo> userinfoList) {
        this.userinfoList = userinfoList;
    }

    @XmlTransient
    public List<Userinfo> getUserinfoList1() {
        return userinfoList1;
    }

    public void setUserinfoList1(List<Userinfo> userinfoList1) {
        this.userinfoList1 = userinfoList1;
    }

    @XmlTransient
    public List<Userinfo> getUserinfoList2() {
        return userinfoList2;
    }

    public void setUserinfoList2(List<Userinfo> userinfoList2) {
        this.userinfoList2 = userinfoList2;
    }

    @XmlTransient
    public List<Datavalue> getDatavalueList() {
        return datavalueList;
    }

    public void setDatavalueList(List<Datavalue> datavalueList) {
        this.datavalueList = datavalueList;
    }

    @XmlTransient
    public List<Organisationunit> getOrganisationunitList() {
        return organisationunitList;
    }

    public void setOrganisationunitList(List<Organisationunit> organisationunitList) {
        this.organisationunitList = organisationunitList;
    }

    public Organisationunit getParentid() {
        return parentid;
    }

    public void setParentid(Organisationunit parentid) {
        this.parentid = parentid;
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
        hash += (organisationunitid != null ? organisationunitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisationunit)) {
            return false;
        }
        Organisationunit other = (Organisationunit) object;
        if ((this.organisationunitid == null && other.organisationunitid != null) || (this.organisationunitid != null && !this.organisationunitid.equals(other.organisationunitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
