/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "lettermemory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lettermemory.findAll", query = "SELECT l FROM Lettermemory l")
    , @NamedQuery(name = "Lettermemory.findByIdLetterMemory", query = "SELECT l FROM Lettermemory l WHERE l.idLetterMemory = :idLetterMemory")
    , @NamedQuery(name = "Lettermemory.findByCorrectasOrden", query = "SELECT l FROM Lettermemory l WHERE l.correctasOrden = :correctasOrden")
    , @NamedQuery(name = "Lettermemory.findByIncorrectasOrden", query = "SELECT l FROM Lettermemory l WHERE l.incorrectasOrden = :incorrectasOrden")
    , @NamedQuery(name = "Lettermemory.findByCorrectasIdentidad", query = "SELECT l FROM Lettermemory l WHERE l.correctasIdentidad = :correctasIdentidad")
    , @NamedQuery(name = "Lettermemory.findByIncorrectasIdentidad", query = "SELECT l FROM Lettermemory l WHERE l.incorrectasIdentidad = :incorrectasIdentidad")})
public class Lettermemory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLetterMemory")
    private Integer idLetterMemory;
    @Column(name = "correctasOrden")
    private Integer correctasOrden;
    @Column(name = "incorrectasOrden")
    private Integer incorrectasOrden;
    @Column(name = "correctasIdentidad")
    private Integer correctasIdentidad;
    @Column(name = "incorrectasIdentidad")
    private Integer incorrectasIdentidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "letterMemoryidLetterMemory")
    private List<Setpruebas> setpruebasList;

    public Lettermemory() {
    }

    public Lettermemory(Integer idLetterMemory) {
        this.idLetterMemory = idLetterMemory;
    }

    public Integer getIdLetterMemory() {
        return idLetterMemory;
    }

    public void setIdLetterMemory(Integer idLetterMemory) {
        this.idLetterMemory = idLetterMemory;
    }

    public Integer getCorrectasOrden() {
        return correctasOrden;
    }

    public void setCorrectasOrden(Integer correctasOrden) {
        this.correctasOrden = correctasOrden;
    }

    public Integer getIncorrectasOrden() {
        return incorrectasOrden;
    }

    public void setIncorrectasOrden(Integer incorrectasOrden) {
        this.incorrectasOrden = incorrectasOrden;
    }

    public Integer getCorrectasIdentidad() {
        return correctasIdentidad;
    }

    public void setCorrectasIdentidad(Integer correctasIdentidad) {
        this.correctasIdentidad = correctasIdentidad;
    }

    public Integer getIncorrectasIdentidad() {
        return incorrectasIdentidad;
    }

    public void setIncorrectasIdentidad(Integer incorrectasIdentidad) {
        this.incorrectasIdentidad = incorrectasIdentidad;
    }

    @XmlTransient
    public List<Setpruebas> getSetpruebasList() {
        return setpruebasList;
    }

    public void setSetpruebasList(List<Setpruebas> setpruebasList) {
        this.setpruebasList = setpruebasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLetterMemory != null ? idLetterMemory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lettermemory)) {
            return false;
        }
        Lettermemory other = (Lettermemory) object;
        if ((this.idLetterMemory == null && other.idLetterMemory != null) || (this.idLetterMemory != null && !this.idLetterMemory.equals(other.idLetterMemory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Lettermemory[ idLetterMemory=" + idLetterMemory + " ]";
    }
    
}
