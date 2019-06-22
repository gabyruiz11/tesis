/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocios;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David Hermosillo
 */
@Entity
@Table(name = "tonemonotoring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tonemonotoring.findAll", query = "SELECT t FROM Tonemonotoring t")
    , @NamedQuery(name = "Tonemonotoring.findByIdToneMonotoring", query = "SELECT t FROM Tonemonotoring t WHERE t.idToneMonotoring = :idToneMonotoring")
    , @NamedQuery(name = "Tonemonotoring.findByTonosCorrectos", query = "SELECT t FROM Tonemonotoring t WHERE t.tonosCorrectos = :tonosCorrectos")
    , @NamedQuery(name = "Tonemonotoring.findByTonosIncorrectos", query = "SELECT t FROM Tonemonotoring t WHERE t.tonosIncorrectos = :tonosIncorrectos")})
public class Tonemonotoring implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idToneMonotoring")
    private Integer idToneMonotoring;
    @Column(name = "tonosCorrectos")
    private Integer tonosCorrectos;
    @Column(name = "tonosIncorrectos")
    private Integer tonosIncorrectos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toneMonotoringidToneMonotoring")
    private Collection<Set1> set1Collection;

    public Tonemonotoring() {
    }

    public Tonemonotoring(Integer idToneMonotoring) {
        this.idToneMonotoring = idToneMonotoring;
    }

    public Integer getIdToneMonotoring() {
        return idToneMonotoring;
    }

    public void setIdToneMonotoring(Integer idToneMonotoring) {
        this.idToneMonotoring = idToneMonotoring;
    }

    public Integer getTonosCorrectos() {
        return tonosCorrectos;
    }

    public void setTonosCorrectos(Integer tonosCorrectos) {
        this.tonosCorrectos = tonosCorrectos;
    }

    public Integer getTonosIncorrectos() {
        return tonosIncorrectos;
    }

    public void setTonosIncorrectos(Integer tonosIncorrectos) {
        this.tonosIncorrectos = tonosIncorrectos;
    }

    @XmlTransient
    public Collection<Set1> getSet1Collection() {
        return set1Collection;
    }

    public void setSet1Collection(Collection<Set1> set1Collection) {
        this.set1Collection = set1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idToneMonotoring != null ? idToneMonotoring.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tonemonotoring)) {
            return false;
        }
        Tonemonotoring other = (Tonemonotoring) object;
        if ((this.idToneMonotoring == null && other.idToneMonotoring != null) || (this.idToneMonotoring != null && !this.idToneMonotoring.equals(other.idToneMonotoring))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocios.Tonemonotoring[ idToneMonotoring=" + idToneMonotoring + " ]";
    }
    
}
