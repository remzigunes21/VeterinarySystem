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
    @NamedQuery(name = "Stok.findAll", query = "SELECT s FROM Stok s")
    , @NamedQuery(name = "Stok.findByStokId", query = "SELECT s FROM Stok s WHERE s.stokId = :stokId")
    , @NamedQuery(name = "Stok.findByStokName", query = "SELECT s FROM Stok s WHERE s.stokName = :stokName")
    , @NamedQuery(name = "Stok.findByStokSayi", query = "SELECT s FROM Stok s WHERE s.stokSayi = :stokSayi")})
public class Stok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stok_id", nullable = false)
    private Long stokId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "stok_name", nullable = false, length = 200)
    private String stokName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stok_sayi", nullable = false)
    private long stokSayi;

    public Stok() {
    }

    public Stok(Long stokId) {
        this.stokId = stokId;
    }

    public Stok(Long stokId, String stokName, long stokSayi) {
        this.stokId = stokId;
        this.stokName = stokName;
        this.stokSayi = stokSayi;
    }

    public Long getStokId() {
        return stokId;
    }

    public void setStokId(Long stokId) {
        this.stokId = stokId;
    }

    public String getStokName() {
        return stokName;
    }

    public void setStokName(String stokName) {
        this.stokName = stokName;
    }

    public long getStokSayi() {
        return stokSayi;
    }

    public void setStokSayi(long stokSayi) {
        this.stokSayi = stokSayi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stokId != null ? stokId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stok)) {
            return false;
        }
        Stok other = (Stok) object;
        if ((this.stokId == null && other.stokId != null) || (this.stokId != null && !this.stokId.equals(other.stokId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Stok[ stokId=" + stokId + " ]";
    }
    
}
    