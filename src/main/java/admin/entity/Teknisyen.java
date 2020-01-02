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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Teknisyen.findAll", query = "SELECT t FROM Teknisyen t")
    , @NamedQuery(name = "Teknisyen.findByTeknisyenId", query = "SELECT t FROM Teknisyen t WHERE t.teknisyenId = :teknisyenId")
    , @NamedQuery(name = "Teknisyen.findByTeknisyenName", query = "SELECT t FROM Teknisyen t WHERE t.teknisyenName = :teknisyenName")})
public class Teknisyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teknisyen_id", nullable = false)
    private Long teknisyenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "teknisyen_name", nullable = false, length = 200)
    private String teknisyenName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "teknisyen_bilgi", nullable = false, length = 65535)
    private String teknisyenBilgi;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "veteriner_id", referencedColumnName = "veteriner_id")
    @ManyToOne
    private Veteriner veterinerId;

    public Teknisyen() {
    }

    public Teknisyen(Long teknisyenId) {
        this.teknisyenId = teknisyenId;
    }

    public Teknisyen(Long teknisyenId, String teknisyenName, String teknisyenBilgi) {
        this.teknisyenId = teknisyenId;
        this.teknisyenName = teknisyenName;
        this.teknisyenBilgi = teknisyenBilgi;
    }

    public Long getTeknisyenId() {
        return teknisyenId;
    }

    public void setTeknisyenId(Long teknisyenId) {
        this.teknisyenId = teknisyenId;
    }

    public String getTeknisyenName() {
        return teknisyenName;
    }

    public void setTeknisyenName(String teknisyenName) {
        this.teknisyenName = teknisyenName;
    }

    public String getTeknisyenBilgi() {
        return teknisyenBilgi;
    }

    public void setTeknisyenBilgi(String teknisyenBilgi) {
        this.teknisyenBilgi = teknisyenBilgi;
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
        hash += (teknisyenId != null ? teknisyenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teknisyen)) {
            return false;
        }
        Teknisyen other = (Teknisyen) object;
        if ((this.teknisyenId == null && other.teknisyenId != null) || (this.teknisyenId != null && !this.teknisyenId.equals(other.teknisyenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Teknisyen[ teknisyenId=" + teknisyenId + " ]";
    }
    
}
