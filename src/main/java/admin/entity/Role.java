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
import javax.persistence.Lob;
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
@Table(name = "role", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role_1.findAll", query = "SELECT r FROM Role_1 r")
    , @NamedQuery(name = "Role_1.findByRoleId", query = "SELECT r FROM Role_1 r WHERE r.roleId = :roleId")
    , @NamedQuery(name = "Role_1.findByRoleName", query = "SELECT r FROM Role_1 r WHERE r.roleName = :roleName")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "role_name", nullable = false, length = 200)
    private String roleName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "role_bilgi", nullable = false, length = 65535)
    private String roleBilgi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<Yetkilendirme> yetkilendirmeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<User> userCollection;

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, String roleName, String roleBilgi) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleBilgi = roleBilgi;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleBilgi() {
        return roleBilgi;
    }

    public void setRoleBilgi(String roleBilgi) {
        this.roleBilgi = roleBilgi;
    }

    @XmlTransient
    public Collection<Yetkilendirme> getYetkilendirmeCollection() {
        return yetkilendirmeCollection;
    }

    public void setYetkilendirmeCollection(Collection<Yetkilendirme> yetkilendirmeCollection) {
        this.yetkilendirmeCollection = yetkilendirmeCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Role_1[ roleId=" + roleId + " ]";
    }
    
}
