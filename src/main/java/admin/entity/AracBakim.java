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
import javax.persistence.Lob;
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
@Table(name = "arac_bakim", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AracBakim.findAll", query = "SELECT a FROM AracBakim a")
    , @NamedQuery(name = "AracBakim.findByBakimId", query = "SELECT a FROM AracBakim a WHERE a.bakimId = :bakimId")
    , @NamedQuery(name = "AracBakim.findByAracMasraf", query = "SELECT a FROM AracBakim a WHERE a.aracMasraf = :aracMasraf")
    , @NamedQuery(name = "AracBakim.findByTarih", query = "SELECT a FROM AracBakim a WHERE a.tarih = :tarih")
    , @NamedQuery(name = "AracBakim.findBySoforId", query = "SELECT a FROM AracBakim a WHERE a.soforId = :soforId")
    , @NamedQuery(name = "AracBakim.findByAracId", query = "SELECT a FROM AracBakim a WHERE a.aracId = :aracId")})
public class AracBakim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bakim_id", nullable = false)
    private Long bakimId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "arac_masraf", nullable = false, length = 200)
    private String aracMasraf;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String bilgi;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String tarih;
    @Column(name = "sofor_id")
    private Integer soforId;
    @Column(name = "arac_id")
    private Integer aracId;

    public AracBakim() {
    }

    public AracBakim(Long bakimId) {
        this.bakimId = bakimId;
    }

    public AracBakim(Long bakimId, String aracMasraf, String bilgi, String tarih) {
        this.bakimId = bakimId;
        this.aracMasraf = aracMasraf;
        this.bilgi = bilgi;
        this.tarih = tarih;
    }

    public Long getBakimId() {
        return bakimId;
    }

    public void setBakimId(Long bakimId) {
        this.bakimId = bakimId;
    }

    public String getAracMasraf() {
        return aracMasraf;
    }

    public void setAracMasraf(String aracMasraf) {
        this.aracMasraf = aracMasraf;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public Integer getSoforId() {
        return soforId;
    }

    public void setSoforId(Integer soforId) {
        this.soforId = soforId;
    }

    public Integer getAracId() {
        return aracId;
    }

    public void setAracId(Integer aracId) {
        this.aracId = aracId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bakimId != null ? bakimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AracBakim)) {
            return false;
        }
        AracBakim other = (AracBakim) object;
        if ((this.bakimId == null && other.bakimId != null) || (this.bakimId != null && !this.bakimId.equals(other.bakimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.AracBakim[ bakimId=" + bakimId + " ]";
    }
    
}
