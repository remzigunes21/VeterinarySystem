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
    @NamedQuery(name = "Belediye.findAll", query = "SELECT b FROM Belediye b")
    , @NamedQuery(name = "Belediye.findByBelediyeId", query = "SELECT b FROM Belediye b WHERE b.belediyeId = :belediyeId")
    , @NamedQuery(name = "Belediye.findByBelediyeName", query = "SELECT b FROM Belediye b WHERE b.belediyeName = :belediyeName")
    , @NamedQuery(name = "Belediye.findByBelediyeYer", query = "SELECT b FROM Belediye b WHERE b.belediyeYer = :belediyeYer")})
public class Belediye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "belediye_id", nullable = false)
    private Long belediyeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "belediye_name", nullable = false, length = 200)
    private String belediyeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "belediye_yer", nullable = false, length = 200)
    private String belediyeYer;
    @JoinColumn(name = "bi_sekreter_id", referencedColumnName = "bi_sekreter_id", nullable = false)
    @ManyToOne(optional = false)
    private BilgiIslemSekreteri biSekreterId;

    public Belediye() {
    }

    public Belediye(Long belediyeId) {
        this.belediyeId = belediyeId;
    }

    public Belediye(Long belediyeId, String belediyeName, String belediyeYer) {
        this.belediyeId = belediyeId;
        this.belediyeName = belediyeName;
        this.belediyeYer = belediyeYer;
    }

    public Long getBelediyeId() {
        return belediyeId;
    }

    public void setBelediyeId(Long belediyeId) {
        this.belediyeId = belediyeId;
    }

    public String getBelediyeName() {
        return belediyeName;
    }

    public void setBelediyeName(String belediyeName) {
        this.belediyeName = belediyeName;
    }

    public String getBelediyeYer() {
        return belediyeYer;
    }

    public void setBelediyeYer(String belediyeYer) {
        this.belediyeYer = belediyeYer;
    }

    public BilgiIslemSekreteri getBiSekreterId() {
        return biSekreterId;
    }

    public void setBiSekreterId(BilgiIslemSekreteri biSekreterId) {
        this.biSekreterId = biSekreterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (belediyeId != null ? belediyeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Belediye)) {
            return false;
        }
        Belediye other = (Belediye) object;
        if ((this.belediyeId == null && other.belediyeId != null) || (this.belediyeId != null && !this.belediyeId.equals(other.belediyeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Belediye[ belediyeId=" + belediyeId + " ]";
    }
    
}
