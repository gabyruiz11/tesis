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
@Table(name = "keeptrack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keeptrack.findAll", query = "SELECT k FROM Keeptrack k")
    , @NamedQuery(name = "Keeptrack.findByIdKeepTrack", query = "SELECT k FROM Keeptrack k WHERE k.idKeepTrack = :idKeepTrack")
    , @NamedQuery(name = "Keeptrack.findBySeriesCompletamenteRecordadas", query = "SELECT k FROM Keeptrack k WHERE k.seriesCompletamenteRecordadas = :seriesCompletamenteRecordadas")
    , @NamedQuery(name = "Keeptrack.findBySeriesErrores", query = "SELECT k FROM Keeptrack k WHERE k.seriesErrores = :seriesErrores")
    , @NamedQuery(name = "Keeptrack.findBySeriesOmisiones", query = "SELECT k FROM Keeptrack k WHERE k.seriesOmisiones = :seriesOmisiones")
    , @NamedQuery(name = "Keeptrack.findByTiempoTotal", query = "SELECT k FROM Keeptrack k WHERE k.tiempoTotal = :tiempoTotal")})
public class Keeptrack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKeepTrack")
    private Integer idKeepTrack;
    @Column(name = "seriesCompletamenteRecordadas")
    private Integer seriesCompletamenteRecordadas;
    @Column(name = "seriesErrores")
    private Integer seriesErrores;
    @Column(name = "seriesOmisiones")
    private Integer seriesOmisiones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoTotal")
    private Double tiempoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keepTrackidKeepTrack")
    private List<Setpruebas> setpruebasList;

    public Keeptrack() {
    }

    public Keeptrack(Integer idKeepTrack) {
        this.idKeepTrack = idKeepTrack;
    }

    public Integer getIdKeepTrack() {
        return idKeepTrack;
    }

    public void setIdKeepTrack(Integer idKeepTrack) {
        this.idKeepTrack = idKeepTrack;
    }

    public Integer getSeriesCompletamenteRecordadas() {
        return seriesCompletamenteRecordadas;
    }

    public void setSeriesCompletamenteRecordadas(Integer seriesCompletamenteRecordadas) {
        this.seriesCompletamenteRecordadas = seriesCompletamenteRecordadas;
    }

    public Integer getSeriesErrores() {
        return seriesErrores;
    }

    public void setSeriesErrores(Integer seriesErrores) {
        this.seriesErrores = seriesErrores;
    }

    public Integer getSeriesOmisiones() {
        return seriesOmisiones;
    }

    public void setSeriesOmisiones(Integer seriesOmisiones) {
        this.seriesOmisiones = seriesOmisiones;
    }

    public Double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
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
        hash += (idKeepTrack != null ? idKeepTrack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keeptrack)) {
            return false;
        }
        Keeptrack other = (Keeptrack) object;
        if ((this.idKeepTrack == null && other.idKeepTrack != null) || (this.idKeepTrack != null && !this.idKeepTrack.equals(other.idKeepTrack))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Keeptrack[ idKeepTrack=" + idKeepTrack + " ]";
    }
    
}
