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
@Table(name = "plusminus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plusminus.findAll", query = "SELECT p FROM Plusminus p")
    , @NamedQuery(name = "Plusminus.findByIdPlusMinus", query = "SELECT p FROM Plusminus p WHERE p.idPlusMinus = :idPlusMinus")
    , @NamedQuery(name = "Plusminus.findByTiempoSuma", query = "SELECT p FROM Plusminus p WHERE p.tiempoSuma = :tiempoSuma")
    , @NamedQuery(name = "Plusminus.findByTiempoResta", query = "SELECT p FROM Plusminus p WHERE p.tiempoResta = :tiempoResta")
    , @NamedQuery(name = "Plusminus.findByTiempoAlternado", query = "SELECT p FROM Plusminus p WHERE p.tiempoAlternado = :tiempoAlternado")
    , @NamedQuery(name = "Plusminus.findByTiempoTotal", query = "SELECT p FROM Plusminus p WHERE p.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Plusminus.findByShiftingTotal", query = "SELECT p FROM Plusminus p WHERE p.shiftingTotal = :shiftingTotal")
    , @NamedQuery(name = "Plusminus.findByRespuestasSuma", query = "SELECT p FROM Plusminus p WHERE p.respuestasSuma = :respuestasSuma")
    , @NamedQuery(name = "Plusminus.findByRespuestasResta", query = "SELECT p FROM Plusminus p WHERE p.respuestasResta = :respuestasResta")
    , @NamedQuery(name = "Plusminus.findByRespuestasAlternado", query = "SELECT p FROM Plusminus p WHERE p.respuestasAlternado = :respuestasAlternado")
    , @NamedQuery(name = "Plusminus.findByRespuestasTotales", query = "SELECT p FROM Plusminus p WHERE p.respuestasTotales = :respuestasTotales")
    , @NamedQuery(name = "Plusminus.findByRespuestasCorrectasSuma", query = "SELECT p FROM Plusminus p WHERE p.respuestasCorrectasSuma = :respuestasCorrectasSuma")
    , @NamedQuery(name = "Plusminus.findByRespuestasCorrectasResta", query = "SELECT p FROM Plusminus p WHERE p.respuestasCorrectasResta = :respuestasCorrectasResta")
    , @NamedQuery(name = "Plusminus.findByRespuestasCorrectasAlternado", query = "SELECT p FROM Plusminus p WHERE p.respuestasCorrectasAlternado = :respuestasCorrectasAlternado")
    , @NamedQuery(name = "Plusminus.findByRespuestasCorrectasTotales", query = "SELECT p FROM Plusminus p WHERE p.respuestasCorrectasTotales = :respuestasCorrectasTotales")
    , @NamedQuery(name = "Plusminus.findByReaccionPromedioSuma", query = "SELECT p FROM Plusminus p WHERE p.reaccionPromedioSuma = :reaccionPromedioSuma")
    , @NamedQuery(name = "Plusminus.findByReaccionPromedioResta", query = "SELECT p FROM Plusminus p WHERE p.reaccionPromedioResta = :reaccionPromedioResta")
    , @NamedQuery(name = "Plusminus.findByReaccionPromedioAlternado", query = "SELECT p FROM Plusminus p WHERE p.reaccionPromedioAlternado = :reaccionPromedioAlternado")
    , @NamedQuery(name = "Plusminus.findByReaccionPromedioTotal", query = "SELECT p FROM Plusminus p WHERE p.reaccionPromedioTotal = :reaccionPromedioTotal")
    , @NamedQuery(name = "Plusminus.findByShiftingReaccionPromedio", query = "SELECT p FROM Plusminus p WHERE p.shiftingReaccionPromedio = :shiftingReaccionPromedio")
    , @NamedQuery(name = "Plusminus.findByRespuestasIncorrectasSuma", query = "SELECT p FROM Plusminus p WHERE p.respuestasIncorrectasSuma = :respuestasIncorrectasSuma")
    , @NamedQuery(name = "Plusminus.findByRespuestasIncorrectasResta", query = "SELECT p FROM Plusminus p WHERE p.respuestasIncorrectasResta = :respuestasIncorrectasResta")
    , @NamedQuery(name = "Plusminus.findByRespuestasIncorrectasAlternado", query = "SELECT p FROM Plusminus p WHERE p.respuestasIncorrectasAlternado = :respuestasIncorrectasAlternado")
    , @NamedQuery(name = "Plusminus.findByRespuestasIncorrectasTotales", query = "SELECT p FROM Plusminus p WHERE p.respuestasIncorrectasTotales = :respuestasIncorrectasTotales")
    , @NamedQuery(name = "Plusminus.findByPorcentajeCorrectasSumar", query = "SELECT p FROM Plusminus p WHERE p.porcentajeCorrectasSumar = :porcentajeCorrectasSumar")
    , @NamedQuery(name = "Plusminus.findByPorcentajeCorrectasRestar", query = "SELECT p FROM Plusminus p WHERE p.porcentajeCorrectasRestar = :porcentajeCorrectasRestar")
    , @NamedQuery(name = "Plusminus.findByPorcentajeCorrectasAlternado", query = "SELECT p FROM Plusminus p WHERE p.porcentajeCorrectasAlternado = :porcentajeCorrectasAlternado")
    , @NamedQuery(name = "Plusminus.findByPorcentajeCorrectasTotal", query = "SELECT p FROM Plusminus p WHERE p.porcentajeCorrectasTotal = :porcentajeCorrectasTotal")
    , @NamedQuery(name = "Plusminus.findByShiftingRespuestasCorrectasTotales", query = "SELECT p FROM Plusminus p WHERE p.shiftingRespuestasCorrectasTotales = :shiftingRespuestasCorrectasTotales")
    , @NamedQuery(name = "Plusminus.findByPorcentajeRelacionSumar", query = "SELECT p FROM Plusminus p WHERE p.porcentajeRelacionSumar = :porcentajeRelacionSumar")
    , @NamedQuery(name = "Plusminus.findByPorcentajeRelacionRestar", query = "SELECT p FROM Plusminus p WHERE p.porcentajeRelacionRestar = :porcentajeRelacionRestar")
    , @NamedQuery(name = "Plusminus.findByPorcentajeRelacionAlternado", query = "SELECT p FROM Plusminus p WHERE p.porcentajeRelacionAlternado = :porcentajeRelacionAlternado")
    , @NamedQuery(name = "Plusminus.findByPorcentajeRelacionTotal", query = "SELECT p FROM Plusminus p WHERE p.porcentajeRelacionTotal = :porcentajeRelacionTotal")
    , @NamedQuery(name = "Plusminus.findByShiftingRelacionIndividual", query = "SELECT p FROM Plusminus p WHERE p.shiftingRelacionIndividual = :shiftingRelacionIndividual")
    , @NamedQuery(name = "Plusminus.findByNoRespondidasSumar", query = "SELECT p FROM Plusminus p WHERE p.noRespondidasSumar = :noRespondidasSumar")
    , @NamedQuery(name = "Plusminus.findByNoRespondidasRestar", query = "SELECT p FROM Plusminus p WHERE p.noRespondidasRestar = :noRespondidasRestar")
    , @NamedQuery(name = "Plusminus.findByNoRespondidasAlternado", query = "SELECT p FROM Plusminus p WHERE p.noRespondidasAlternado = :noRespondidasAlternado")
    , @NamedQuery(name = "Plusminus.findByNoRespondidasTotales", query = "SELECT p FROM Plusminus p WHERE p.noRespondidasTotales = :noRespondidasTotales")})
public class Plusminus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPlusMinus")
    private Integer idPlusMinus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoSuma")
    private Double tiempoSuma;
    @Column(name = "tiempoResta")
    private Double tiempoResta;
    @Basic(optional = false)
    @Column(name = "tiempoAlternado")
    private double tiempoAlternado;
    @Column(name = "tiempoTotal")
    private Double tiempoTotal;
    @Column(name = "shiftingTotal")
    private Double shiftingTotal;
    @Column(name = "respuestasSuma")
    private Integer respuestasSuma;
    @Column(name = "respuestasResta")
    private Integer respuestasResta;
    @Column(name = "respuestasAlternado")
    private Integer respuestasAlternado;
    @Column(name = "respuestasTotales")
    private Integer respuestasTotales;
    @Column(name = "respuestasCorrectasSuma")
    private Integer respuestasCorrectasSuma;
    @Column(name = "respuestasCorrectasResta")
    private Integer respuestasCorrectasResta;
    @Column(name = "respuestasCorrectasAlternado")
    private Integer respuestasCorrectasAlternado;
    @Column(name = "respuestasCorrectasTotales")
    private Integer respuestasCorrectasTotales;
    @Column(name = "reaccionPromedioSuma")
    private Double reaccionPromedioSuma;
    @Column(name = "reaccionPromedioResta")
    private Double reaccionPromedioResta;
    @Column(name = "reaccionPromedioAlternado")
    private Double reaccionPromedioAlternado;
    @Column(name = "reaccionPromedioTotal")
    private Double reaccionPromedioTotal;
    @Column(name = "shiftingReaccionPromedio")
    private Double shiftingReaccionPromedio;
    @Column(name = "respuestasIncorrectasSuma")
    private Integer respuestasIncorrectasSuma;
    @Column(name = "respuestasIncorrectasResta")
    private Integer respuestasIncorrectasResta;
    @Column(name = "respuestasIncorrectasAlternado")
    private Integer respuestasIncorrectasAlternado;
    @Column(name = "respuestasIncorrectasTotales")
    private Integer respuestasIncorrectasTotales;
    @Column(name = "porcentajeCorrectasSumar")
    private Double porcentajeCorrectasSumar;
    @Column(name = "porcentajeCorrectasRestar")
    private Double porcentajeCorrectasRestar;
    @Column(name = "porcentajeCorrectasAlternado")
    private Double porcentajeCorrectasAlternado;
    @Column(name = "porcentajeCorrectasTotal")
    private Double porcentajeCorrectasTotal;
    @Column(name = "shiftingRespuestasCorrectasTotales")
    private Double shiftingRespuestasCorrectasTotales;
    @Column(name = "porcentajeRelacionSumar")
    private Double porcentajeRelacionSumar;
    @Column(name = "porcentajeRelacionRestar")
    private Double porcentajeRelacionRestar;
    @Column(name = "porcentajeRelacionAlternado")
    private Double porcentajeRelacionAlternado;
    @Column(name = "porcentajeRelacionTotal")
    private Double porcentajeRelacionTotal;
    @Column(name = "shiftingRelacionIndividual")
    private Double shiftingRelacionIndividual;
    @Column(name = "noRespondidasSumar")
    private Integer noRespondidasSumar;
    @Column(name = "noRespondidasRestar")
    private Integer noRespondidasRestar;
    @Column(name = "noRespondidasAlternado")
    private Integer noRespondidasAlternado;
    @Column(name = "noRespondidasTotales")
    private Integer noRespondidasTotales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plusMinusidPlusMinus")
    private Collection<Set1> set1Collection;

    public Plusminus() {
    }

    public Plusminus(Integer idPlusMinus) {
        this.idPlusMinus = idPlusMinus;
    }

    public Plusminus(Integer idPlusMinus, double tiempoAlternado) {
        this.idPlusMinus = idPlusMinus;
        this.tiempoAlternado = tiempoAlternado;
    }

    public Integer getIdPlusMinus() {
        return idPlusMinus;
    }

    public void setIdPlusMinus(Integer idPlusMinus) {
        this.idPlusMinus = idPlusMinus;
    }

    public Double getTiempoSuma() {
        return tiempoSuma;
    }

    public void setTiempoSuma(Double tiempoSuma) {
        this.tiempoSuma = tiempoSuma;
    }

    public Double getTiempoResta() {
        return tiempoResta;
    }

    public void setTiempoResta(Double tiempoResta) {
        this.tiempoResta = tiempoResta;
    }

    public double getTiempoAlternado() {
        return tiempoAlternado;
    }

    public void setTiempoAlternado(double tiempoAlternado) {
        this.tiempoAlternado = tiempoAlternado;
    }

    public Double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public Double getShiftingTotal() {
        return shiftingTotal;
    }

    public void setShiftingTotal(Double shiftingTotal) {
        this.shiftingTotal = shiftingTotal;
    }

    public Integer getRespuestasSuma() {
        return respuestasSuma;
    }

    public void setRespuestasSuma(Integer respuestasSuma) {
        this.respuestasSuma = respuestasSuma;
    }

    public Integer getRespuestasResta() {
        return respuestasResta;
    }

    public void setRespuestasResta(Integer respuestasResta) {
        this.respuestasResta = respuestasResta;
    }

    public Integer getRespuestasAlternado() {
        return respuestasAlternado;
    }

    public void setRespuestasAlternado(Integer respuestasAlternado) {
        this.respuestasAlternado = respuestasAlternado;
    }

    public Integer getRespuestasTotales() {
        return respuestasTotales;
    }

    public void setRespuestasTotales(Integer respuestasTotales) {
        this.respuestasTotales = respuestasTotales;
    }

    public Integer getRespuestasCorrectasSuma() {
        return respuestasCorrectasSuma;
    }

    public void setRespuestasCorrectasSuma(Integer respuestasCorrectasSuma) {
        this.respuestasCorrectasSuma = respuestasCorrectasSuma;
    }

    public Integer getRespuestasCorrectasResta() {
        return respuestasCorrectasResta;
    }

    public void setRespuestasCorrectasResta(Integer respuestasCorrectasResta) {
        this.respuestasCorrectasResta = respuestasCorrectasResta;
    }

    public Integer getRespuestasCorrectasAlternado() {
        return respuestasCorrectasAlternado;
    }

    public void setRespuestasCorrectasAlternado(Integer respuestasCorrectasAlternado) {
        this.respuestasCorrectasAlternado = respuestasCorrectasAlternado;
    }

    public Integer getRespuestasCorrectasTotales() {
        return respuestasCorrectasTotales;
    }

    public void setRespuestasCorrectasTotales(Integer respuestasCorrectasTotales) {
        this.respuestasCorrectasTotales = respuestasCorrectasTotales;
    }

    public Double getReaccionPromedioSuma() {
        return reaccionPromedioSuma;
    }

    public void setReaccionPromedioSuma(Double reaccionPromedioSuma) {
        this.reaccionPromedioSuma = reaccionPromedioSuma;
    }

    public Double getReaccionPromedioResta() {
        return reaccionPromedioResta;
    }

    public void setReaccionPromedioResta(Double reaccionPromedioResta) {
        this.reaccionPromedioResta = reaccionPromedioResta;
    }

    public Double getReaccionPromedioAlternado() {
        return reaccionPromedioAlternado;
    }

    public void setReaccionPromedioAlternado(Double reaccionPromedioAlternado) {
        this.reaccionPromedioAlternado = reaccionPromedioAlternado;
    }

    public Double getReaccionPromedioTotal() {
        return reaccionPromedioTotal;
    }

    public void setReaccionPromedioTotal(Double reaccionPromedioTotal) {
        this.reaccionPromedioTotal = reaccionPromedioTotal;
    }

    public Double getShiftingReaccionPromedio() {
        return shiftingReaccionPromedio;
    }

    public void setShiftingReaccionPromedio(Double shiftingReaccionPromedio) {
        this.shiftingReaccionPromedio = shiftingReaccionPromedio;
    }

    public Integer getRespuestasIncorrectasSuma() {
        return respuestasIncorrectasSuma;
    }

    public void setRespuestasIncorrectasSuma(Integer respuestasIncorrectasSuma) {
        this.respuestasIncorrectasSuma = respuestasIncorrectasSuma;
    }

    public Integer getRespuestasIncorrectasResta() {
        return respuestasIncorrectasResta;
    }

    public void setRespuestasIncorrectasResta(Integer respuestasIncorrectasResta) {
        this.respuestasIncorrectasResta = respuestasIncorrectasResta;
    }

    public Integer getRespuestasIncorrectasAlternado() {
        return respuestasIncorrectasAlternado;
    }

    public void setRespuestasIncorrectasAlternado(Integer respuestasIncorrectasAlternado) {
        this.respuestasIncorrectasAlternado = respuestasIncorrectasAlternado;
    }

    public Integer getRespuestasIncorrectasTotales() {
        return respuestasIncorrectasTotales;
    }

    public void setRespuestasIncorrectasTotales(Integer respuestasIncorrectasTotales) {
        this.respuestasIncorrectasTotales = respuestasIncorrectasTotales;
    }

    public Double getPorcentajeCorrectasSumar() {
        return porcentajeCorrectasSumar;
    }

    public void setPorcentajeCorrectasSumar(Double porcentajeCorrectasSumar) {
        this.porcentajeCorrectasSumar = porcentajeCorrectasSumar;
    }

    public Double getPorcentajeCorrectasRestar() {
        return porcentajeCorrectasRestar;
    }

    public void setPorcentajeCorrectasRestar(Double porcentajeCorrectasRestar) {
        this.porcentajeCorrectasRestar = porcentajeCorrectasRestar;
    }

    public Double getPorcentajeCorrectasAlternado() {
        return porcentajeCorrectasAlternado;
    }

    public void setPorcentajeCorrectasAlternado(Double porcentajeCorrectasAlternado) {
        this.porcentajeCorrectasAlternado = porcentajeCorrectasAlternado;
    }

    public Double getPorcentajeCorrectasTotal() {
        return porcentajeCorrectasTotal;
    }

    public void setPorcentajeCorrectasTotal(Double porcentajeCorrectasTotal) {
        this.porcentajeCorrectasTotal = porcentajeCorrectasTotal;
    }

    public Double getShiftingRespuestasCorrectasTotales() {
        return shiftingRespuestasCorrectasTotales;
    }

    public void setShiftingRespuestasCorrectasTotales(Double shiftingRespuestasCorrectasTotales) {
        this.shiftingRespuestasCorrectasTotales = shiftingRespuestasCorrectasTotales;
    }

    public Double getPorcentajeRelacionSumar() {
        return porcentajeRelacionSumar;
    }

    public void setPorcentajeRelacionSumar(Double porcentajeRelacionSumar) {
        this.porcentajeRelacionSumar = porcentajeRelacionSumar;
    }

    public Double getPorcentajeRelacionRestar() {
        return porcentajeRelacionRestar;
    }

    public void setPorcentajeRelacionRestar(Double porcentajeRelacionRestar) {
        this.porcentajeRelacionRestar = porcentajeRelacionRestar;
    }

    public Double getPorcentajeRelacionAlternado() {
        return porcentajeRelacionAlternado;
    }

    public void setPorcentajeRelacionAlternado(Double porcentajeRelacionAlternado) {
        this.porcentajeRelacionAlternado = porcentajeRelacionAlternado;
    }

    public Double getPorcentajeRelacionTotal() {
        return porcentajeRelacionTotal;
    }

    public void setPorcentajeRelacionTotal(Double porcentajeRelacionTotal) {
        this.porcentajeRelacionTotal = porcentajeRelacionTotal;
    }

    public Double getShiftingRelacionIndividual() {
        return shiftingRelacionIndividual;
    }

    public void setShiftingRelacionIndividual(Double shiftingRelacionIndividual) {
        this.shiftingRelacionIndividual = shiftingRelacionIndividual;
    }

    public Integer getNoRespondidasSumar() {
        return noRespondidasSumar;
    }

    public void setNoRespondidasSumar(Integer noRespondidasSumar) {
        this.noRespondidasSumar = noRespondidasSumar;
    }

    public Integer getNoRespondidasRestar() {
        return noRespondidasRestar;
    }

    public void setNoRespondidasRestar(Integer noRespondidasRestar) {
        this.noRespondidasRestar = noRespondidasRestar;
    }

    public Integer getNoRespondidasAlternado() {
        return noRespondidasAlternado;
    }

    public void setNoRespondidasAlternado(Integer noRespondidasAlternado) {
        this.noRespondidasAlternado = noRespondidasAlternado;
    }

    public Integer getNoRespondidasTotales() {
        return noRespondidasTotales;
    }

    public void setNoRespondidasTotales(Integer noRespondidasTotales) {
        this.noRespondidasTotales = noRespondidasTotales;
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
        hash += (idPlusMinus != null ? idPlusMinus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plusminus)) {
            return false;
        }
        Plusminus other = (Plusminus) object;
        if ((this.idPlusMinus == null && other.idPlusMinus != null) || (this.idPlusMinus != null && !this.idPlusMinus.equals(other.idPlusMinus))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "objetosNegocios.Plusminus[ idPlusMinus=" + idPlusMinus + " ]";
    }
    */

    @Override
    public String toString() {
        return "Plusminus{" + "idPlusMinus=" + idPlusMinus + ", tiempoSuma=" + tiempoSuma + ", tiempoResta=" + tiempoResta + ", tiempoAlternado=" + tiempoAlternado + ", tiempoTotal=" + tiempoTotal + ", shiftingTotal=" + shiftingTotal + ", respuestasSuma=" + respuestasSuma + ", respuestasResta=" + respuestasResta + ", respuestasAlternado=" + respuestasAlternado + ", respuestasTotales=" + respuestasTotales + ", respuestasCorrectasSuma=" + respuestasCorrectasSuma + ", respuestasCorrectasResta=" + respuestasCorrectasResta + ", respuestasCorrectasAlternado=" + respuestasCorrectasAlternado + ", respuestasCorrectasTotales=" + respuestasCorrectasTotales + ", reaccionPromedioSuma=" + reaccionPromedioSuma + ", reaccionPromedioResta=" + reaccionPromedioResta + ", reaccionPromedioAlternado=" + reaccionPromedioAlternado + ", reaccionPromedioTotal=" + reaccionPromedioTotal + ", shiftingReaccionPromedio=" + shiftingReaccionPromedio + ", respuestasIncorrectasSuma=" + respuestasIncorrectasSuma + ", respuestasIncorrectasResta=" + respuestasIncorrectasResta + ", respuestasIncorrectasAlternado=" + respuestasIncorrectasAlternado + ", respuestasIncorrectasTotales=" + respuestasIncorrectasTotales + ", porcentajeCorrectasSumar=" + porcentajeCorrectasSumar + ", porcentajeCorrectasRestar=" + porcentajeCorrectasRestar + ", porcentajeCorrectasAlternado=" + porcentajeCorrectasAlternado + ", porcentajeCorrectasTotal=" + porcentajeCorrectasTotal + ", shiftingRespuestasCorrectasTotales=" + shiftingRespuestasCorrectasTotales + ", porcentajeRelacionSumar=" + porcentajeRelacionSumar + ", porcentajeRelacionRestar=" + porcentajeRelacionRestar + ", porcentajeRelacionAlternado=" + porcentajeRelacionAlternado + ", porcentajeRelacionTotal=" + porcentajeRelacionTotal + ", shiftingRelacionIndividual=" + shiftingRelacionIndividual + ", noRespondidasSumar=" + noRespondidasSumar + ", noRespondidasRestar=" + noRespondidasRestar + ", noRespondidasAlternado=" + noRespondidasAlternado + ", noRespondidasTotales=" + noRespondidasTotales + ", set1Collection=" + set1Collection + '}';
    }
    
    
    
}
