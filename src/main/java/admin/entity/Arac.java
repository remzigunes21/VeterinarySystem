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
    @NamedQuery(name = "Arac.findAll", query = "SELECT a FROM Arac a")
    , @NamedQuery(name = "Arac.findByAracId", query = "SELECT a FROM Arac a WHERE a.aracId = :aracId")
    , @NamedQuery(name = "Arac.findByAracMarka", query = "SELECT a FROM Arac a WHERE a.aracMarka = :aracMarka")
    , @NamedQuery(name = "Arac.findByPlaka", query = "SELECT a FROM Arac a WHERE a.plaka = :plaka")
    , @NamedQuery(name = "Arac.findByAracTipi", query = "SELECT a FROM Arac a WHERE a.aracTipi = :aracTipi")})
public class Arac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "arac_id", nullable = false)
    private Long aracId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "arac_marka", nullable = false, length = 200)
    private String aracMarka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String plaka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "arac_tipi", nullable = false, length = 200)
    private String aracTipi;
    @JoinColumn(name = "sofor_id", referencedColumnName = "sofor_id", nullable = false)
    @ManyToOne(optional = false)
    private Sofor soforId;

    public Arac() {
    }

    public Arac(Long aracId) {
        this.aracId = aracId;
    }

    public Arac(Long aracId, String aracMarka, String plaka, String aracTipi) {
        this.aracId = aracId;
        this.aracMarka = aracMarka;
        this.plaka = plaka;
        this.aracTipi = aracTipi;
    }

    public Long getAracId() {
        return aracId;
    }

    public void setAracId(Long aracId) {
        this.aracId = aracId;
    }

    public String getAracMarka() {
        return aracMarka;
    }

    public void setAracMarka(String aracMarka) {
        this.aracMarka = aracMarka;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getAracTipi() {
        return aracTipi;
    }

    public void setAracTipi(String aracTipi) {
        this.aracTipi = aracTipi;
    }

    public Sofor getSoforId() {
        return soforId;
    }

    public void setSoforId(Sofor soforId) {
        this.soforId = soforId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aracId != null ? aracId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arac)) {
            return false;
        }
        Arac other = (Arac) object;
        if ((this.aracId == null && other.aracId != null) || (this.aracId != null && !this.aracId.equals(other.aracId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Arac[ aracId=" + aracId + " ]";
    }
    
}
