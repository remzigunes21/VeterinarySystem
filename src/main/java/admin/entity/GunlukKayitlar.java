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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cemr_
 */
@Entity
@Table(name = "gunluk_kayitlar", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GunlukKayitlar.findAll", query = "SELECT g FROM GunlukKayitlar g")
    , @NamedQuery(name = "GunlukKayitlar.findByGunlukId", query = "SELECT g FROM GunlukKayitlar g WHERE g.gunlukId = :gunlukId")
    , @NamedQuery(name = "GunlukKayitlar.findByVeterinerId", query = "SELECT g FROM GunlukKayitlar g WHERE g.veterinerId = :veterinerId")
    , @NamedQuery(name = "GunlukKayitlar.findByVtYrdId", query = "SELECT g FROM GunlukKayitlar g WHERE g.vtYrdId = :vtYrdId")
    , @NamedQuery(name = "GunlukKayitlar.findBySoforId", query = "SELECT g FROM GunlukKayitlar g WHERE g.soforId = :soforId")
    , @NamedQuery(name = "GunlukKayitlar.findByElemanId", query = "SELECT g FROM GunlukKayitlar g WHERE g.elemanId = :elemanId")})
public class GunlukKayitlar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gunluk_id", nullable = false)
    private Long gunlukId;
    @Column(name = "veteriner_id")
    private Integer veterinerId;
    @Column(name = "vt_yrd_id")
    private Integer vtYrdId;
    @Column(name = "sofor_id")
    private Integer soforId;
    @Column(name = "eleman_id")
    private Integer elemanId;

    public GunlukKayitlar() {
    }

    public GunlukKayitlar(Long gunlukId) {
        this.gunlukId = gunlukId;
    }

    public Long getGunlukId() {
        return gunlukId;
    }

    public void setGunlukId(Long gunlukId) {
        this.gunlukId = gunlukId;
    }

    public Integer getVeterinerId() {
        return veterinerId;
    }

    public void setVeterinerId(Integer veterinerId) {
        this.veterinerId = veterinerId;
    }

    public Integer getVtYrdId() {
        return vtYrdId;
    }

    public void setVtYrdId(Integer vtYrdId) {
        this.vtYrdId = vtYrdId;
    }

    public Integer getSoforId() {
        return soforId;
    }

    public void setSoforId(Integer soforId) {
        this.soforId = soforId;
    }

    public Integer getElemanId() {
        return elemanId;
    }

    public void setElemanId(Integer elemanId) {
        this.elemanId = elemanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gunlukId != null ? gunlukId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GunlukKayitlar)) {
            return false;
        }
        GunlukKayitlar other = (GunlukKayitlar) object;
        if ((this.gunlukId == null && other.gunlukId != null) || (this.gunlukId != null && !this.gunlukId.equals(other.gunlukId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.GunlukKayitlar[ gunlukId=" + gunlukId + " ]";
    }
    
}
