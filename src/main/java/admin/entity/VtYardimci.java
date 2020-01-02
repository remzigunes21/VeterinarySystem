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
@Table(name = "vt_yardimci", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtYardimci.findAll", query = "SELECT v FROM VtYardimci v")
    , @NamedQuery(name = "VtYardimci.findByVtYrdId", query = "SELECT v FROM VtYardimci v WHERE v.vtYrdId = :vtYrdId")
    , @NamedQuery(name = "VtYardimci.findByYrdAd", query = "SELECT v FROM VtYardimci v WHERE v.yrdAd = :yrdAd")
    , @NamedQuery(name = "VtYardimci.findByYrdSoyad", query = "SELECT v FROM VtYardimci v WHERE v.yrdSoyad = :yrdSoyad")
    , @NamedQuery(name = "VtYardimci.findByTc", query = "SELECT v FROM VtYardimci v WHERE v.tc = :tc")
    , @NamedQuery(name = "VtYardimci.findByDogumTarihi", query = "SELECT v FROM VtYardimci v WHERE v.dogumTarihi = :dogumTarihi")
    , @NamedQuery(name = "VtYardimci.findBy\u00c7BasTarih", query = "SELECT v FROM VtYardimci v WHERE v.\u00e7BasTarih = :\u00e7BasTarih")
    , @NamedQuery(name = "VtYardimci.findByMaas", query = "SELECT v FROM VtYardimci v WHERE v.maas = :maas")})
public class VtYardimci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vt_yrd_id", nullable = false)
    private Long vtYrdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "yrd_ad", nullable = false, length = 200)
    private String yrdAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "yrd_soyad", nullable = false, length = 200)
    private String yrdSoyad;
    private Integer tc;
    @Column(name = "dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private String dogumTarihi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\u00e7_bas_tarih", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String çBasTarih;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String maas;

    public VtYardimci() {
    }

    public VtYardimci(Long vtYrdId) {
        this.vtYrdId = vtYrdId;
    }

    public VtYardimci(Long vtYrdId, String yrdAd, String yrdSoyad, String çBasTarih, String maas) {
        this.vtYrdId = vtYrdId;
        this.yrdAd = yrdAd;
        this.yrdSoyad = yrdSoyad;
        this.çBasTarih = çBasTarih;
        this.maas = maas;
    }

    public Long getVtYrdId() {
        return vtYrdId;
    }

    public void setVtYrdId(Long vtYrdId) {
        this.vtYrdId = vtYrdId;
    }

    public String getYrdAd() {
        return yrdAd;
    }

    public void setYrdAd(String yrdAd) {
        this.yrdAd = yrdAd;
    }

    public String getYrdSoyad() {
        return yrdSoyad;
    }

    public void setYrdSoyad(String yrdSoyad) {
        this.yrdSoyad = yrdSoyad;
    }

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getÇBasTarih() {
        return çBasTarih;
    }

    public void setÇBasTarih(String çBasTarih) {
        this.çBasTarih = çBasTarih;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtYrdId != null ? vtYrdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtYardimci)) {
            return false;
        }
        VtYardimci other = (VtYardimci) object;
        if ((this.vtYrdId == null && other.vtYrdId != null) || (this.vtYrdId != null && !this.vtYrdId.equals(other.vtYrdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.VtYardimci[ vtYrdId=" + vtYrdId + " ]";
    }
    
}
