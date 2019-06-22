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
@Table(name = "stopsignal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stopsignal.findAll", query = "SELECT s FROM Stopsignal s")
    , @NamedQuery(name = "Stopsignal.findByIdStopSignal", query = "SELECT s FROM Stopsignal s WHERE s.idStopSignal = :idStopSignal")
    , @NamedQuery(name = "Stopsignal.findByTiempoTotal", query = "SELECT s FROM Stopsignal s WHERE s.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Stopsignal.findByTiempoTotalCongruentes", query = "SELECT s FROM Stopsignal s WHERE s.tiempoTotalCongruentes = :tiempoTotalCongruentes")
    , @NamedQuery(name = "Stopsignal.findByTiempoTotalIncongruentes", query = "SELECT s FROM Stopsignal s WHERE s.tiempoTotalIncongruentes = :tiempoTotalIncongruentes")
    , @NamedQuery(name = "Stopsignal.findByCantidadErrores", query = "SELECT s FROM Stopsignal s WHERE s.cantidadErrores = :cantidadErrores")
    , @NamedQuery(name = "Stopsignal.findByCantidadAciertos", query = "SELECT s FROM Stopsignal s WHERE s.cantidadAciertos = :cantidadAciertos")
    , @NamedQuery(name = "Stopsignal.findByES", query = "SELECT s FROM Stopsignal s WHERE s.eS = :eS")
    , @NamedQuery(name = "Stopsignal.findByESA", query = "SELECT s FROM Stopsignal s WHERE s.eSA = :eSA")})
public class Stopsignal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStopSignal")
    private Integer idStopSignal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoTotal")
    private Double tiempoTotal;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stopSignalidStopSignal")
    private Collection<Set1> set1Collection;

    public Stopsignal() {
    }

    public Stopsignal(Integer idStopSignal) {
        this.idStopSignal = idStopSignal;
    }

    public Integer getIdStopSignal() {
        return idStopSignal;
    }

    public void setIdStopSignal(Integer idStopSignal) {
        this.idStopSignal = idStopSignal;
    }

    public Double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
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
        hash += (idStopSignal != null ? idStopSignal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stopsignal)) {
            return false;
        }
        Stopsignal other = (Stopsignal) object;
        if ((this.idStopSignal == null && other.idStopSignal != null) || (this.idStopSignal != null && !this.idStopSignal.equals(other.idStopSignal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocios.Stopsignal[ idStopSignal=" + idStopSignal + " ]";
    }
    
}
