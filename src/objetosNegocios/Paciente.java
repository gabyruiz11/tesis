/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocios;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByFolioPaciente", query = "SELECT p FROM Paciente p WHERE p.folioPaciente = :folioPaciente")
    , @NamedQuery(name = "Paciente.findByEdadPaciente", query = "SELECT p FROM Paciente p WHERE p.edadPaciente = :edadPaciente")
    , @NamedQuery(name = "Paciente.findByConsumidorPaciente", query = "SELECT p FROM Paciente p WHERE p.consumidorPaciente = :consumidorPaciente")
    , @NamedQuery(name = "Paciente.findByCelularPaciente", query = "SELECT p FROM Paciente p WHERE p.celularPaciente = :celularPaciente")
    , @NamedQuery(name = "Paciente.findByLeerEscribirPaciente", query = "SELECT p FROM Paciente p WHERE p.leerEscribirPaciente = :leerEscribirPaciente")
    , @NamedQuery(name = "Paciente.findByOcupacionPaciente", query = "SELECT p FROM Paciente p WHERE p.ocupacionPaciente = :ocupacionPaciente")
    , @NamedQuery(name = "Paciente.findByTiempoOcupacionPaciente", query = "SELECT p FROM Paciente p WHERE p.tiempoOcupacionPaciente = :tiempoOcupacionPaciente")
    , @NamedQuery(name = "Paciente.findByTiempoDesempleoPaciente", query = "SELECT p FROM Paciente p WHERE p.tiempoDesempleoPaciente = :tiempoDesempleoPaciente")
    , @NamedQuery(name = "Paciente.findByEstadoCivilPaciente", query = "SELECT p FROM Paciente p WHERE p.estadoCivilPaciente = :estadoCivilPaciente")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "folioPaciente")
    private Integer folioPaciente;
    @Column(name = "edadPaciente")
    private Integer edadPaciente;
    @Column(name = "consumidorPaciente")
    private Short consumidorPaciente;
    @Column(name = "celularPaciente")
    private Integer celularPaciente;
    @Column(name = "leerEscribirPaciente")
    private Short leerEscribirPaciente;
    @Column(name = "ocupacionPaciente")
    private Integer ocupacionPaciente;
    @Column(name = "tiempoOcupacionPaciente")
    private Integer tiempoOcupacionPaciente;
    @Column(name = "tiempoDesempleoPaciente")
    private Integer tiempoDesempleoPaciente;
    @Column(name = "estadoCivilPaciente")
    private Integer estadoCivilPaciente;
    @OneToMany(mappedBy = "folioPaciente")
    private Collection<Prueba> pruebaCollection;

    public Paciente() {
    }

    public Paciente(Integer folioPaciente) {
        this.folioPaciente = folioPaciente;
    }

    public Integer getFolioPaciente() {
        return folioPaciente;
    }

    public void setFolioPaciente(Integer folioPaciente) {
        this.folioPaciente = folioPaciente;
    }

    public Integer getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(Integer edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public Short getConsumidorPaciente() {
        return consumidorPaciente;
    }

    public void setConsumidorPaciente(Short consumidorPaciente) {
        this.consumidorPaciente = consumidorPaciente;
    }

    public Integer getCelularPaciente() {
        return celularPaciente;
    }

    public void setCelularPaciente(Integer celularPaciente) {
        this.celularPaciente = celularPaciente;
    }

    public Short getLeerEscribirPaciente() {
        return leerEscribirPaciente;
    }

    public void setLeerEscribirPaciente(Short leerEscribirPaciente) {
        this.leerEscribirPaciente = leerEscribirPaciente;
    }

    public Integer getOcupacionPaciente() {
        return ocupacionPaciente;
    }

    public void setOcupacionPaciente(Integer ocupacionPaciente) {
        this.ocupacionPaciente = ocupacionPaciente;
    }

    public Integer getTiempoOcupacionPaciente() {
        return tiempoOcupacionPaciente;
    }

    public void setTiempoOcupacionPaciente(Integer tiempoOcupacionPaciente) {
        this.tiempoOcupacionPaciente = tiempoOcupacionPaciente;
    }

    public Integer getTiempoDesempleoPaciente() {
        return tiempoDesempleoPaciente;
    }

    public void setTiempoDesempleoPaciente(Integer tiempoDesempleoPaciente) {
        this.tiempoDesempleoPaciente = tiempoDesempleoPaciente;
    }

    public Integer getEstadoCivilPaciente() {
        return estadoCivilPaciente;
    }

    public void setEstadoCivilPaciente(Integer estadoCivilPaciente) {
        this.estadoCivilPaciente = estadoCivilPaciente;
    }

    @XmlTransient
    public Collection<Prueba> getPruebaCollection() {
        return pruebaCollection;
    }

    public void setPruebaCollection(Collection<Prueba> pruebaCollection) {
        this.pruebaCollection = pruebaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folioPaciente != null ? folioPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.folioPaciente == null && other.folioPaciente != null) || (this.folioPaciente != null && !this.folioPaciente.equals(other.folioPaciente))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "objetosNegocios.Paciente[ folioPaciente=" + folioPaciente + " ]";
    }
    */

    @Override
    public String toString() {
        return "Paciente{" + "folioPaciente = " + folioPaciente + ", edadPaciente=" + edadPaciente + ", consumidorPaciente=" + consumidorPaciente + ", celularPaciente=" + celularPaciente + ", leerEscribirPaciente=" + leerEscribirPaciente + ", ocupacionPaciente=" + ocupacionPaciente + ", tiempoOcupacionPaciente=" + tiempoOcupacionPaciente + ", tiempoDesempleoPaciente=" + tiempoDesempleoPaciente + ", estadoCivilPaciente=" + estadoCivilPaciente + '}';
    }
    
}
