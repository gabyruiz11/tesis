/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David Hermosillo
 */
@Entity
@Table(name = "prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p")
    , @NamedQuery(name = "Prueba.findByIdPrueba", query = "SELECT p FROM Prueba p WHERE p.idPrueba = :idPrueba")
    , @NamedQuery(name = "Prueba.findByFechaPrueba", query = "SELECT p FROM Prueba p WHERE p.fechaPrueba = :fechaPrueba")})
public class Prueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrueba")
    private Integer idPrueba;
    @Column(name = "fechaPrueba")
    @Temporal(TemporalType.DATE)
    private Date fechaPrueba;
    @JoinColumn(name = "folioPaciente", referencedColumnName = "folioPaciente")
    @ManyToOne
    private Paciente folioPaciente;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "Set_idSet", referencedColumnName = "idSet")
    @ManyToOne(optional = false)
    private Set1 setidSet;

    public Prueba() {
    }

    public Prueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Integer getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Date getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public Paciente getFolioPaciente() {
        return folioPaciente;
    }

    public void setFolioPaciente(Paciente folioPaciente) {
        this.folioPaciente = folioPaciente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Set1 getSetidSet() {
        return setidSet;
    }

    public void setSetidSet(Set1 setidSet) {
        this.setidSet = setidSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrueba != null ? idPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.idPrueba == null && other.idPrueba != null) || (this.idPrueba != null && !this.idPrueba.equals(other.idPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocios.Prueba[ idPrueba=" + idPrueba + " ]";
    }
    
}
