/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cemr_
 */
@Entity
@Table(catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sofor.findAll", query = "SELECT s FROM Sofor s")
    , @NamedQuery(name = "Sofor.findBySoforId", query = "SELECT s FROM Sofor s WHERE s.soforId = :soforId")
    , @NamedQuery(name = "Sofor.findBySoforNameSurname", query = "SELECT s FROM Sofor s WHERE s.soforNameSurname = :soforNameSurname")
    , @NamedQuery(name = "Sofor.findBySoforTc", query = "SELECT s FROM Sofor s WHERE s.soforTc = :soforTc")})
public class Sofor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sofor_id", nullable = false)
    private Long soforId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "sofor_name_surname", nullable = false, length = 200)
    private String soforNameSurname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sofor_tc", nullable = false)
    private int soforTc;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soforId")
    private Collection<Arac> aracCollection;
    @OneToMany(mappedBy = "soforId")
    private Collection<SahaElemani> sahaElemaniCollection;

    public Sofor() {
    }

    public Sofor(Long soforId) {
        this.soforId = soforId;
    }

    public Sofor(Long soforId, String soforNameSurname, int soforTc) {
        this.soforId = soforId;
        this.soforNameSurname = soforNameSurname;
        this.soforTc = soforTc;
    }

    public Long getSoforId() {
        return soforId;
    }

    public void setSoforId(Long soforId) {
        this.soforId = soforId;
    }

    public String getSoforNameSurname() {
        return soforNameSurname;
    }

    public void setSoforNameSurname(String soforNameSurname) {
        this.soforNameSurname = soforNameSurname;
    }

    public int getSoforTc() {
        return soforTc;
    }

    public void setSoforTc(int soforTc) {
        this.soforTc = soforTc;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Arac> getAracCollection() {
        return aracCollection;
    }

    public void setAracCollection(Collection<Arac> aracCollection) {
        this.aracCollection = aracCollection;
    }

    @XmlTransient
    public Collection<SahaElemani> getSahaElemaniCollection() {
        return sahaElemaniCollection;
    }

    public void setSahaElemaniCollection(Collection<SahaElemani> sahaElemaniCollection) {
        this.sahaElemaniCollection = sahaElemaniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soforId != null ? soforId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sofor)) {
            return false;
        }
        Sofor other = (Sofor) object;
        if ((this.soforId == null && other.soforId != null) || (this.soforId != null && !this.soforId.equals(other.soforId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.Sofor[ soforId=" + soforId + " ]";
    }
    
}
