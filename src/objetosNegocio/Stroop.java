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
@Table(name = "stroop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stroop.findAll", query = "SELECT s FROM Stroop s")
    , @NamedQuery(name = "Stroop.findByIdStroop", query = "SELECT s FROM Stroop s WHERE s.idStroop = :idStroop")
    , @NamedQuery(name = "Stroop.findByTiempoTotal", query = "SELECT s FROM Stroop s WHERE s.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Stroop.findByTiempoTotalNeutrales", query = "SELECT s FROM Stroop s WHERE s.tiempoTotalNeutrales = :tiempoTotalNeutrales")
    , @NamedQuery(name = "Stroop.findByTiempoTotalCongruentes", query = "SELECT s FROM Stroop s WHERE s.tiempoTotalCongruentes = :tiempoTotalCongruentes")
    , @NamedQuery(name = "Stroop.findByTiempoTotalIncongruentes", query = "SELECT s FROM Stroop s WHERE s.tiempoTotalIncongruentes = :tiempoTotalIncongruentes")
    , @NamedQuery(name = "Stroop.findByCantidadErrores", query = "SELECT s FROM Stroop s WHERE s.cantidadErrores = :cantidadErrores")
    , @NamedQuery(name = "Stroop.findByCantidadAciertos", query = "SELECT s FROM Stroop s WHERE s.cantidadAciertos = :cantidadAciertos")
    , @NamedQuery(name = "Stroop.findByES", query = "SELECT s FROM Stroop s WHERE s.eS = :eS")
    , @NamedQuery(name = "Stroop.findByESA", query = "SELECT s FROM Stroop s WHERE s.eSA = :eSA")})
public class Stroop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStroop")
    private Integer idStroop;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stroopidStroop")
    private List<Setpruebas> setpruebasList;

    public Stroop() {
    }

    public Stroop(Integer idStroop) {
        this.idStroop = idStroop;
    }

    public Integer getIdStroop() {
        return idStroop;
    }

    public void setIdStroop(Integer idStroop) {
        this.idStroop = idStroop;
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
    public List<Setpruebas> getSetpruebasList() {
        return setpruebasList;
    }

    public void setSetpruebasList(List<Setpruebas> setpruebasList) {
        this.setpruebasList = setpruebasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStroop != null ? idStroop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stroop)) {
            return false;
        }
        Stroop other = (Stroop) object;
        if ((this.idStroop == null && other.idStroop != null) || (this.idStroop != null && !this.idStroop.equals(other.idStroop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Stroop[ idStroop=" + idStroop + " ]";
    }
    
}
