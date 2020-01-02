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
@Table(name = "bilgi_islem_sekreteri", catalog = "firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BilgiIslemSekreteri.findAll", query = "SELECT b FROM BilgiIslemSekreteri b")
    , @NamedQuery(name = "BilgiIslemSekreteri.findByBiSekreterId", query = "SELECT b FROM BilgiIslemSekreteri b WHERE b.biSekreterId = :biSekreterId")
    , @NamedQuery(name = "BilgiIslemSekreteri.findByBiSekreterNameSurname", query = "SELECT b FROM BilgiIslemSekreteri b WHERE b.biSekreterNameSurname = :biSekreterNameSurname")
    , @NamedQuery(name = "BilgiIslemSekreteri.findByBiSekreterTc", query = "SELECT b FROM BilgiIslemSekreteri b WHERE b.biSekreterTc = :biSekreterTc")})
public class BilgiIslemSekreteri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bi_sekreter_id", nullable = false)
    private Long biSekreterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "bi_sekreter_name_surname", nullable = false, length = 200)
    private String biSekreterNameSurname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bi_sekreter_tc", nullable = false)
    private int biSekreterTc;
    @JoinColumn(name = "veteriner_id", referencedColumnName = "veteriner_id")
    @ManyToOne
    private Veteriner veterinerId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biSekreterId")
    private Collection<Belediye> belediyeCollection;

    public BilgiIslemSekreteri() {
    }

    public BilgiIslemSekreteri(Long biSekreterId) {
        this.biSekreterId = biSekreterId;
    }

    public BilgiIslemSekreteri(Long biSekreterId, String biSekreterNameSurname, int biSekreterTc) {
        this.biSekreterId = biSekreterId;
        this.biSekreterNameSurname = biSekreterNameSurname;
        this.biSekreterTc = biSekreterTc;
    }

    public Long getBiSekreterId() {
        return biSekreterId;
    }

    public void setBiSekreterId(Long biSekreterId) {
        this.biSekreterId = biSekreterId;
    }

    public String getBiSekreterNameSurname() {
        return biSekreterNameSurname;
    }

    public void setBiSekreterNameSurname(String biSekreterNameSurname) {
        this.biSekreterNameSurname = biSekreterNameSurname;
    }

    public int getBiSekreterTc() {
        return biSekreterTc;
    }

    public void setBiSekreterTc(int biSekreterTc) {
        this.biSekreterTc = biSekreterTc;
    }

    public Veteriner getVeterinerId() {
        return veterinerId;
    }

    public void setVeterinerId(Veteriner veterinerId) {
        this.veterinerId = veterinerId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Belediye> getBelediyeCollection() {
        return belediyeCollection;
    }

    public void setBelediyeCollection(Collection<Belediye> belediyeCollection) {
        this.belediyeCollection = belediyeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biSekreterId != null ? biSekreterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BilgiIslemSekreteri)) {
            return false;
        }
        BilgiIslemSekreteri other = (BilgiIslemSekreteri) object;
        if ((this.biSekreterId == null && other.biSekreterId != null) || (this.biSekreterId != null && !this.biSekreterId.equals(other.biSekreterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.entity.BilgiIslemSekreteri[ biSekreterId=" + biSekreterId + " ]";
    }
    
}
