/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

import java.io.Serializable;
import java.util.Collection;
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
    @NamedQuery(name = "Veteriner.findAll", query = "SELECT v FROM Veteriner v")
    , @NamedQuery(name = "Veteriner.findByVeterinerId", query = "SELECT v FROM Veteriner v WHERE v.veterinerId = :veterinerId")
    , @NamedQuery(name = "Veteriner.findByVeterinerNameSurname", query = "SELECT v FROM Veteriner v WHERE v.veterinerNameSurname = :veterinerNameSurname")
    , @NamedQuery(name = "Veteriner.findByVeterinerTc", query = "SELECT v FROM Veteriner v WHERE v.veterinerTc = :veterinerTc")
    , @NamedQuery(name = "Veteriner.findByVeterinerSicilNu", query = "SELECT v FROM Veteriner v WHERE v.veterinerSicilNu = :veterinerSicilNu")})
public class Veteriner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "veteriner_id", nullable = false)
    private Long veterinerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "veteriner_name_surname", nullable = false, length = 200)
    private String veterinerNameSurname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "veteriner_tc", nullable = false)
    private int veterinerTc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "veteriner_sicil_nu", nullable = false)
    private int veterinerSicilNu;
    @OneToMany(mappedBy = "veterinerId")
    private Collection<Muhasebeci> muhasebeciCollection;
    @OneToMany(mappedBy = "veterinerId")
    private Collection<Teknisyen> teknisyenCollection;
    @JoinColumn(name = "stok_id", referencedColumnName = "stok_id", nullable = false)
    @ManyToOne(optional = false)
    private Stok stokId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "veterinerId")
    private Collection<BilgiIslemSekreteri> bilgiIslemSekreteriCollection;
    @OneToMany(mappedBy = "veterinerId")
    private Collection<SahaElemani> sahaElemaniCollection;

    public Veteriner() {
    }

    public Veteriner(Long veterinerId) {
        this.veterinerId = veterinerId;
    }

    public Veteriner(Long veterinerId, String veterinerNameSurname, int veterinerTc, int veterinerSicilNu) {
        this.veterinerId = veterinerId;
        this.veterinerNameSurname = veterinerNameSurname;
        this.veterinerTc = veterinerTc;
        this.veterinerSicilNu = veterinerSicilNu;
    }

    public Long getVeterinerId() {
        return veterinerId;
    }

    public void setVeterinerId(Long veterinerId) {
        this.veterinerId = veterinerId;
    }

    public String getVeterinerNameSurname() {
        return veterinerNameSurname;
    }

    public void setVeterinerNameSurname(String veterinerNameSurname) {
        this.veterinerNameSurname = veterinerNameSurname;
    }

    public int getVeterinerTc() {
        return veterinerTc;
    }

    public void setVeterinerTc(int veterinerTc) {
        this.veterinerTc = veterinerTc;
    }

    public int getVeterinerSicilNu() {
        return veterinerSicilNu;
    }

    public void setVeterinerSicilNu(int veterinerSicilNu) {
        this.veterinerSicilNu = veterinerSicilNu;
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

    public Stok getStokId() {
        return stokId;
    }

    public void setIlacId(Stok stokId) {
        this.stokId = stokId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<BilgiIslemSekreteri> getBilgiIslemSekreteriCollection() {
        return bilgiIslemSekreteriCollection;
    }

    public void setBilgiIslemSekreteriCollection(Collection<BilgiIslemSekreteri> bilgiIslemSekreteriCollection) {
        this.bilgiIslemSekreteriCollection = bilgiIslemSekreteriCollection;
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
        hash += (veterinerId != null ? veterinerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veteriner)) {
            return false;
        }
        Veteriner other = (Veteriner) object;
        if ((this.veterinerId == null && other.veterinerId != null) || (this.veterinerId != null && !this.veterinerId.equals(other.veterinerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Veteriner{" + "veterinerId=" + veterinerId + ", veterinerNameSurname=" + veterinerNameSurname + ", veterinerTc=" + veterinerTc + ", veterinerSicilNu=" + veterinerSicilNu + '}';
    }

   
    
}
