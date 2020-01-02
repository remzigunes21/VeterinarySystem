/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p")
    , @NamedQuery(name = "Personel.findByPerId", query = "SELECT p FROM Personel p WHERE p.perId = :perId")
    , @NamedQuery(name = "Personel.findByTc", query = "SELECT p FROM Personel p WHERE p.tc = :tc")
    , @NamedQuery(name = "Personel.findByAd", query = "SELECT p FROM Personel p WHERE p.ad = :ad")
    , @NamedQuery(name = "Personel.findBySoyad", query = "SELECT p FROM Personel p WHERE p.soyad = :soyad")
    , @NamedQuery(name = "Personel.findByDogumTarihi", query = "SELECT p FROM Personel p WHERE p.dogumTarihi = :dogumTarihi")
    , @NamedQuery(name = "Personel.findByCBasTarihi", query = "SELECT p FROM Personel p WHERE p.cBasTarihi = :cBasTarihi")
    , @NamedQuery(name = "Personel.findByMaaas", query = "SELECT p FROM Personel p WHERE p.maaas = :maaas")})
public class Personel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id", nullable = false)
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int tc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String ad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String soyad;
    @Column(name = "dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_bas_tarihi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cBasTarihi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double maaas;

    public Personel() {
    }

    public Personel(Integer perId) {
        this.perId = perId;
    }

    public Personel(Integer perId, int tc, String ad, String soyad, Date cBasTarihi) {
        this.perId = perId;
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.cBasTarihi = cBasTarihi;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Date getCBasTarihi() {
        return cBasTarihi;
    }

    public void setCBasTarihi(Date cBasTarihi) {
        this.cBasTarihi = cBasTarihi;
    }

    public Double getMaaas() {
        return maaas;
    }

    public void setMaaas(Double maaas) {
        this.maaas = maaas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personel)) {
            return false;
        }
        Personel other = (Personel) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Personel[ perId=" + perId + " ]";
    }
    
}
