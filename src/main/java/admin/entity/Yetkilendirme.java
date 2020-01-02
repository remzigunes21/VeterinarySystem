/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cemr_
 */
@Entity
@Table(catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yetkilendirme.findAll", query = "SELECT y FROM Yetkilendirme y")
    , @NamedQuery(name = "Yetkilendirme.findById", query = "SELECT y FROM Yetkilendirme y WHERE y.id = :id")
    , @NamedQuery(name = "Yetkilendirme.findByModule", query = "SELECT y FROM Yetkilendirme y WHERE y.module = :module")
    , @NamedQuery(name = "Yetkilendirme.findByEkle", query = "SELECT y FROM Yetkilendirme y WHERE y.ekle = :ekle")
    , @NamedQuery(name = "Yetkilendirme.findByOku", query = "SELECT y FROM Yetkilendirme y WHERE y.oku = :oku")
    , @NamedQuery(name = "Yetkilendirme.findByGuncelle", query = "SELECT y FROM Yetkilendirme y WHERE y.guncelle = :guncelle")
    , @NamedQuery(name = "Yetkilendirme.findBySil", query = "SELECT y FROM Yetkilendirme y WHERE y.sil = :sil")})
public class Yetkilendirme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String module;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean ekle;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean oku;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean guncelle;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean sil;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Role roleId;

    public Yetkilendirme() {
    }

    public Yetkilendirme(Long id) {
        this.id = id;
    }

    public Yetkilendirme(Long id, String module, boolean ekle, boolean oku, boolean guncelle, boolean sil) {
        this.id = id;
        this.module = module;
        this.ekle = ekle;
        this.oku = oku;
        this.guncelle = guncelle;
        this.sil = sil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public boolean getEkle() {
        return ekle;
    }

    public void setEkle(boolean ekle) {
        this.ekle = ekle;
    }

    public boolean getOku() {
        return oku;
    }

    public void setOku(boolean oku) {
        this.oku = oku;
    }

    public boolean getGuncelle() {
        return guncelle;
    }

    public void setGuncelle(boolean guncelle) {
        this.guncelle = guncelle;
    }

    public boolean getSil() {
        return sil;
    }

    public void setSil(boolean sil) {
        this.sil = sil;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yetkilendirme)) {
            return false;
        }
        Yetkilendirme other = (Yetkilendirme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Yetkilendirme[ id=" + id + " ]";
    }
    
}
