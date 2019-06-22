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
@Table(name = "simon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simon.findAll", query = "SELECT s FROM Simon s")
    , @NamedQuery(name = "Simon.findByIdSimon", query = "SELECT s FROM Simon s WHERE s.idSimon = :idSimon")
    , @NamedQuery(name = "Simon.findByTiempoTotal", query = "SELECT s FROM Simon s WHERE s.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Simon.findByTiempoTotalNeutrales", query = "SELECT s FROM Simon s WHERE s.tiempoTotalNeutrales = :tiempoTotalNeutrales")
    , @NamedQuery(name = "Simon.findByTiempoTotalCongruentes", query = "SELECT s FROM Simon s WHERE s.tiempoTotalCongruentes = :tiempoTotalCongruentes")
    , @NamedQuery(name = "Simon.findByTiempoTotalIncongruentes", query = "SELECT s FROM Simon s WHERE s.tiempoTotalIncongruentes = :tiempoTotalIncongruentes")
    , @NamedQuery(name = "Simon.findByCantidadErrores", query = "SELECT s FROM Simon s WHERE s.cantidadErrores = :cantidadErrores")
    , @NamedQuery(name = "Simon.findByCantidadAciertos", query = "SELECT s FROM Simon s WHERE s.cantidadAciertos = :cantidadAciertos")
    , @NamedQuery(name = "Simon.findByES", query = "SELECT s FROM Simon s WHERE s.eS = :eS")
    , @NamedQuery(name = "Simon.findByESA", query = "SELECT s FROM Simon s WHERE s.eSA = :eSA")})
public class Simon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSimon")
    private Integer idSimon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoTotal")
    private Double tiempoTotal;
    @Column(name = "tiempoTotalNeutrales")
    private Double tiempoTotalNeutrales;
    @Column(name = "tiempoTotalCongruentes")
    private Double tiempoTotalCongruentes;
    @Column(name = "tiempoTotalIncongruentes")
    private Double tiempoTotalIncongruentes;
    @Column(name = "cantidadErrores")
    private Integer cantidadErrores;
    @Column(name = "cantidadAciertos")
    private Integer cantidadAciertos;
    @Column(name = "eS")
    private Double eS;
    @Column(name = "eSA")
    private Double eSA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "simonidSimon")
    private Collection<Set1> set1Collection;

    public Simon() {
    }

    public Simon(Integer idSimon) {
        this.idSimon = idSimon;
    }

    public Integer getIdSimon() {
        return idSimon;
    }

    public void setIdSimon(Integer idSimon) {
        this.idSimon = idSimon;
    }

    public Double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public Double getTiempoTotalNeutrales() {
        return tiempoTotalNeutrales;
    }

    public void setTiempoTotalNeutrales(Double tiempoTotalNeutrales) {
        this.tiempoTotalNeutrales = tiempoTotalNeutrales;
    }

    public Double getTiempoTotalCongruentes() {
        return tiempoTotalCongruentes;
    }

    public void setTiempoTotalCongruentes(Double tiempoTotalCongruentes) {
        this.tiempoTotalCongruentes = tiempoTotalCongruentes;
    }

    public Double getTiempoTotalIncongruentes() {
        return tiempoTotalIncongruentes;
    }

    public void setTiempoTotalIncongruentes(Double tiempoTotalIncongruentes) {
        this.tiempoTotalIncongruentes = tiempoTotalIncongruentes;
    }

    public Integer getCantidadErrores() {
        return cantidadErrores;
    }

    public void setCantidadErrores(Integer cantidadErrores) {
        this.cantidadErrores = cantidadErrores;
    }

    public Integer getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void setCantidadAciertos(Integer cantidadAciertos) {
        this.cantidadAciertos = cantidadAciertos;
    }

    public Double getES() {
        return eS;
    }

    public void setES(Double eS) {
        this.eS = eS;
    }

    public Double getESA() {
        return eSA;
    }

    public void setESA(Double eSA) {
        this.eSA = eSA;
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
        hash += (idSimon != null ? idSimon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simon)) {
            return false;
        }
        Simon other = (Simon) object;
        if ((this.idSimon == null && other.idSimon != null) || (this.idSimon != null && !this.idSimon.equals(other.idSimon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocios.Simon[ idSimon=" + idSimon + " ]";
    }
    
}
