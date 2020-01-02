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
@Table(catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kayit.findAll", query = "SELECT k FROM Kayit k")
    , @NamedQuery(name = "Kayit.findByKayitId", query = "SELECT k FROM Kayit k WHERE k.kayitId = :kayitId")
    , @NamedQuery(name = "Kayit.findByYerIsmi", query = "SELECT k FROM Kayit k WHERE k.yerIsmi = :yerIsmi")
    , @NamedQuery(name = "Kayit.findByRandevuTarih", query = "SELECT k FROM Kayit k WHERE k.randevuTarih = :randevuTarih")})
public class Kayit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kayit_id", nullable = false)
    private Long kayitId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "yer_ismi", nullable = false, length = 200)
    private String yerIsmi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "randevu_tarih", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String randevuTarih;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "kayit_not", nullable = false, length = 65535)
    private String kayitNot;

    public Kayit() {
    }

    public Kayit(Long kayitId) {
        this.kayitId = kayitId;
    }

    public Kayit(Long kayitId, String yerIsmi, String randevuTarih, String kayitNot) {
        this.kayitId = kayitId;
        this.yerIsmi = yerIsmi;
        this.randevuTarih = randevuTarih;
        this.kayitNot = kayitNot;
    }

    public Long getKayitId() {
        return kayitId;
    }

    public void setKayitId(Long kayitId) {
        this.kayitId = kayitId;
    }

    public String getYerIsmi() {
        return yerIsmi;
    }

    public void setYerIsmi(String yerIsmi) {
        this.yerIsmi = yerIsmi;
    }

    public String getRandevuTarih() {
        return randevuTarih;
    }

    public void setRandevuTarih(String randevuTarih) {
        this.randevuTarih = randevuTarih;
    }

    public String getKayitNot() {
        return kayitNot;
    }

    public void setKayitNot(String kayitNot) {
        this.kayitNot = kayitNot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kayitId != null ? kayitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kayit)) {
            return false;
        }
        Kayit other = (Kayit) object;
        if ((this.kayitId == null && other.kayitId != null) || (this.kayitId != null && !this.kayitId.equals(other.kayitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Kayit[ kayitId=" + kayitId + " ]";
    }
    
}
