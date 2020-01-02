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
    @NamedQuery(name = "Muhasebeci.findAll", query = "SELECT m FROM Muhasebeci m")
    , @NamedQuery(name = "Muhasebeci.findByMuhasebeciId", query = "SELECT m FROM Muhasebeci m WHERE m.muhasebeciId = :muhasebeciId")
    , @NamedQuery(name = "Muhasebeci.findByMuhasebeNameSurname", query = "SELECT m FROM Muhasebeci m WHERE m.muhasebeNameSurname = :muhasebeNameSurname")
    , @NamedQuery(name = "Muhasebeci.findByMuhasebeTc", query = "SELECT m FROM Muhasebeci m WHERE m.muhasebeTc = :muhasebeTc")
    , @NamedQuery(name = "Muhasebeci.findByMuhasebeSicil", query = "SELECT m FROM Muhasebeci m WHERE m.muhasebeSicil = :muhasebeSicil")})
public class Muhasebeci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "muhasebeci_id", nullable = false)
    private Long muhasebeciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "muhasebe_name_surname", nullable = false, length = 200)
    private String muhasebeNameSurname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "muhasebe_tc", nullable = false)
    private int muhasebeTc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "muhasebe_sicil", nullable = false)
    private int muhasebeSicil;
    @JoinColumn(name = "ilac_id", referencedColumnName = "ilac_id", nullable = false)
    @ManyToOne(optional = false)
    private Stok ilacId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "veteriner_id", referencedColumnName = "veteriner_id")
    @ManyToOne
    private Veteriner veterinerId;

    public Muhasebeci() {
    }

    public Muhasebeci(Long muhasebeciId) {
        this.muhasebeciId = muhasebeciId;
    }

    public Muhasebeci(Long muhasebeciId, String muhasebeNameSurname, int muhasebeTc, int muhasebeSicil) {
        this.muhasebeciId = muhasebeciId;
        this.muhasebeNameSurname = muhasebeNameSurname;
        this.muhasebeTc = muhasebeTc;
        this.muhasebeSicil = muhasebeSicil;
    }

    public Long getMuhasebeciId() {
        return muhasebeciId;
    }

    public void setMuhasebeciId(Long muhasebeciId) {
        this.muhasebeciId = muhasebeciId;
    }

    public String getMuhasebeNameSurname() {
        return muhasebeNameSurname;
    }

    public void setMuhasebeNameSurname(String muhasebeNameSurname) {
        this.muhasebeNameSurname = muhasebeNameSurname;
    }

    public int getMuhasebeTc() {
        return muhasebeTc;
    }

    public void setMuhasebeTc(int muhasebeTc) {
        this.muhasebeTc = muhasebeTc;
    }

    public int getMuhasebeSicil() {
        return muhasebeSicil;
    }

    public void setMuhasebeSicil(int muhasebeSicil) {
        this.muhasebeSicil = muhasebeSicil;
    }

    public Stok getIlacId() {
        return ilacId;
    }

    public void setIlacId(Stok ilacId) {
        this.ilacId = ilacId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (muhasebeciId != null ? muhasebeciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muhasebeci)) {
            return false;
        }
        Muhasebeci other = (Muhasebeci) object;
        if ((this.muhasebeciId == null && other.muhasebeciId != null) || (this.muhasebeciId != null && !this.muhasebeciId.equals(other.muhasebeciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Muhasebeci[ muhasebeciId=" + muhasebeciId + " ]";
    }
    
}
