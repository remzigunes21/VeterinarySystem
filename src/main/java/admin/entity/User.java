/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cemr_
 */
@Entity
@Table(catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_name", nullable = false, length = 200)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "user_password", nullable = false, length = 65535)
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "user_email", nullable = false, length = 65535)
    private String userEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Muhasebeci> muhasebeciCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Teknisyen> teknisyenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Veteriner> veterinerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Sofor> soforCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<BilgiIslemSekreteri> bilgiIslemSekreteriCollection;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(mappedBy = "userId")
    private Collection<SahaElemani> sahaElemaniCollection;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String userName, String userPassword, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @XmlTransient
    public Collection<Muhasebeci> getMuhasebeciCollection() {
        return muhasebeciCollection;
    }

    public void setMuhasebeciCollection(Collection<Muhasebeci> muhasebeciCollection) {
        this.muhasebeciCollection = muhasebeciCollection;
    }

    @XmlTransient
    public Collection<Teknisyen> getTeknisyenCollection() {
        return teknisyenCollection;
    }

    public void setTeknisyenCollection(Collection<Teknisyen> teknisyenCollection) {
        this.teknisyenCollection = teknisyenCollection;
    }

    @XmlTransient
    public Collection<Veteriner> getVeterinerCollection() {
        return veterinerCollection;
    }

    public void setVeterinerCollection(Collection<Veteriner> veterinerCollection) {
        this.veterinerCollection = veterinerCollection;
    }

    @XmlTransient
    public Collection<Sofor> getSoforCollection() {
        return soforCollection;
    }

    public void setSoforCollection(Collection<Sofor> soforCollection) {
        this.soforCollection = soforCollection;
    }

    @XmlTransient
    public Collection<BilgiIslemSekreteri> getBilgiIslemSekreteriCollection() {
        return bilgiIslemSekreteriCollection;
    }

    public void setBilgiIslemSekreteriCollection(Collection<BilgiIslemSekreteri> bilgiIslemSekreteriCollection) {
        this.bilgiIslemSekreteriCollection = bilgiIslemSekreteriCollection;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<SahaElemani> getSahaElemaniCollection() {
        return sahaElemaniCollection;
    }

    public void setSahaElemaniCollection(Collection<SahaElemani> sahaElemaniCollection) {
        this.sahaElemaniCollection = sahaElemaniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.User[ userId=" + userId + " ]";
    }
    
}
