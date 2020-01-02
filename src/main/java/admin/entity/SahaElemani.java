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
@Table(name = "saha_elemani", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SahaElemani.findAll", query = "SELECT s FROM SahaElemani s")
    , @NamedQuery(name = "SahaElemani.findByElemanId", query = "SELECT s FROM SahaElemani s WHERE s.elemanId = :elemanId")
    , @NamedQuery(name = "SahaElemani.findByElemanName", query = "SELECT s FROM SahaElemani s WHERE s.elemanName = :elemanName")
    , @NamedQuery(name = "SahaElemani.findByElemanTc", query = "SELECT s FROM SahaElemani s WHERE s.elemanTc = :elemanTc")})
public class SahaElemani implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eleman_id", nullable = false)
    private Long elemanId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "eleman_name", nullable = false, length = 200)
    private String elemanName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eleman_tc", nullable = false)
    private int elemanTc;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "veteriner_id", referencedColumnName = "veteriner_id")
    @ManyToOne
    private Veteriner veterinerId;
    @JoinColumn(name = "sofor_id", referencedColumnName = "sofor_id")
    @ManyToOne
    private Sofor soforId;

    public SahaElemani() {
    }

    public SahaElemani(Long elemanId) {
        this.elemanId = elemanId;
    }

    public SahaElemani(Long elemanId, String elemanName, int elemanTc) {
        this.elemanId = elemanId;
        this.elemanName = elemanName;
        this.elemanTc = elemanTc;
    }

    public Long getElemanId() {
        return elemanId;
    }

    public void setElemanId(Long elemanId) {
        this.elemanId = elemanId;
    }

    public String getElemanName() {
        return elemanName;
    }

    public void setElemanName(String elemanName) {
        this.elemanName = elemanName;
    }

    public int getElemanTc() {
        return elemanTc;
    }

    public void setElemanTc(int elemanTc) {
        this.elemanTc = elemanTc;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Veteriner getVeterinerId() {
        return veterinerId;
    }

    public void setVeterinerId(Veteriner veterinerId) {
        this.veterinerId = veterinerId;
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
        hash += (elemanId != null ? elemanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SahaElemani)) {
            return false;
        }
        SahaElemani other = (SahaElemani) object;
        if ((this.elemanId == null && other.elemanId != null) || (this.elemanId != null && !this.elemanId.equals(other.elemanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.SahaElemani[ elemanId=" + elemanId + " ]";
    }
    
}
