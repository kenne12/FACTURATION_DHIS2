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
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u"),
    @NamedQuery(name = "Userinfo.findByUserinfoid", query = "SELECT u FROM Userinfo u WHERE u.userinfoid = :userinfoid"),
    @NamedQuery(name = "Userinfo.findByUid", query = "SELECT u FROM Userinfo u WHERE u.uid = :uid"),
    @NamedQuery(name = "Userinfo.findByCode", query = "SELECT u FROM Userinfo u WHERE u.code = :code"),
    @NamedQuery(name = "Userinfo.findByLastupdated", query = "SELECT u FROM Userinfo u WHERE u.lastupdated = :lastupdated"),
    @NamedQuery(name = "Userinfo.findByCreated", query = "SELECT u FROM Userinfo u WHERE u.created = :created"),
    @NamedQuery(name = "Userinfo.findBySurname", query = "SELECT u FROM Userinfo u WHERE u.surname = :surname"),
    @NamedQuery(name = "Userinfo.findByFirstname", query = "SELECT u FROM Userinfo u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userinfo.findByEmail", query = "SELECT u FROM Userinfo u WHERE u.email = :email"),
    @NamedQuery(name = "Userinfo.findByPhonenumber", query = "SELECT u FROM Userinfo u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "Userinfo.findByJobtitle", query = "SELECT u FROM Userinfo u WHERE u.jobtitle = :jobtitle"),
    @NamedQuery(name = "Userinfo.findByIntroduction", query = "SELECT u FROM Userinfo u WHERE u.introduction = :introduction"),
    @NamedQuery(name = "Userinfo.findByGender", query = "SELECT u FROM Userinfo u WHERE u.gender = :gender"),
    @NamedQuery(name = "Userinfo.findByBirthday", query = "SELECT u FROM Userinfo u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "Userinfo.findByNationality", query = "SELECT u FROM Userinfo u WHERE u.nationality = :nationality"),
    @NamedQuery(name = "Userinfo.findByEmployer", query = "SELECT u FROM Userinfo u WHERE u.employer = :employer"),
    @NamedQuery(name = "Userinfo.findByEducation", query = "SELECT u FROM Userinfo u WHERE u.education = :education"),
    @NamedQuery(name = "Userinfo.findByInterests", query = "SELECT u FROM Userinfo u WHERE u.interests = :interests"),
    @NamedQuery(name = "Userinfo.findByLanguages", query = "SELECT u FROM Userinfo u WHERE u.languages = :languages"),
    @NamedQuery(name = "Userinfo.findByLastcheckedinterpretations", query = "SELECT u FROM Userinfo u WHERE u.lastcheckedinterpretations = :lastcheckedinterpretations")})
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer userinfoid;
    @Size(max = 11)
    private String uid;
    @Size(max = 50)
    private String code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    private String firstname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 160)
    private String email;
    @Size(max = 80)
    private String phonenumber;
    @Size(max = 160)
    private String jobtitle;
    @Size(max = 2147483647)
    private String introduction;
    @Size(max = 50)
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Size(max = 160)
    private String nationality;
    @Size(max = 160)
    private String employer;
    @Size(max = 2147483647)
    private String education;
    @Size(max = 2147483647)
    private String interests;
    @Size(max = 2147483647)
    private String languages;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastcheckedinterpretations;
    @ManyToMany(mappedBy = "userinfoList", fetch = FetchType.LAZY)
    private List<Organisationunit> organisationunitList;
    @ManyToMany(mappedBy = "userinfoList1", fetch = FetchType.LAZY)
    private List<Organisationunit> organisationunitList1;
    @ManyToMany(mappedBy = "userinfoList2", fetch = FetchType.LAZY)
    private List<Organisationunit> organisationunitList2;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Optionset> optionsetList;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Dataelement> dataelementList;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Organisationunit> organisationunitList3;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Categorycombo> categorycomboList;

    public Userinfo() {
    }

    public Userinfo(Integer userinfoid) {
        this.userinfoid = userinfoid;
    }

    public Userinfo(Integer userinfoid, String surname, String firstname) {
        this.userinfoid = userinfoid;
        this.surname = surname;
        this.firstname = firstname;
    }

    public Integer getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Integer userinfoid) {
        this.userinfoid = userinfoid;
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

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Date getLastcheckedinterpretations() {
        return lastcheckedinterpretations;
    }

    public void setLastcheckedinterpretations(Date lastcheckedinterpretations) {
        this.lastcheckedinterpretations = lastcheckedinterpretations;
    }

    @XmlTransient
    public List<Organisationunit> getOrganisationunitList() {
        return organisationunitList;
    }

    public void setOrganisationunitList(List<Organisationunit> organisationunitList) {
        this.organisationunitList = organisationunitList;
    }

    @XmlTransient
    public List<Organisationunit> getOrganisationunitList1() {
        return organisationunitList1;
    }

    public void setOrganisationunitList1(List<Organisationunit> organisationunitList1) {
        this.organisationunitList1 = organisationunitList1;
    }

    @XmlTransient
    public List<Organisationunit> getOrganisationunitList2() {
        return organisationunitList2;
    }

    public void setOrganisationunitList2(List<Organisationunit> organisationunitList2) {
        this.organisationunitList2 = organisationunitList2;
    }

    @XmlTransient
    public List<Optionset> getOptionsetList() {
        return optionsetList;
    }

    public void setOptionsetList(List<Optionset> optionsetList) {
        this.optionsetList = optionsetList;
    }

    @XmlTransient
    public List<Dataelement> getDataelementList() {
        return dataelementList;
    }

    public void setDataelementList(List<Dataelement> dataelementList) {
        this.dataelementList = dataelementList;
    }

    @XmlTransient
    public List<Organisationunit> getOrganisationunitList3() {
        return organisationunitList3;
    }

    public void setOrganisationunitList3(List<Organisationunit> organisationunitList3) {
        this.organisationunitList3 = organisationunitList3;
    }

    @XmlTransient
    public List<Categorycombo> getCategorycomboList() {
        return categorycomboList;
    }

    public void setCategorycomboList(List<Categorycombo> categorycomboList) {
        this.categorycomboList = categorycomboList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userinfoid != null ? userinfoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.userinfoid == null && other.userinfoid != null) || (this.userinfoid != null && !this.userinfoid.equals(other.userinfoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userinfo[ userinfoid=" + userinfoid + " ]";
    }
    
}
