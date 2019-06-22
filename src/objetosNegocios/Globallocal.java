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
@Table(name = "globallocal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Globallocal.findAll", query = "SELECT g FROM Globallocal g")
    , @NamedQuery(name = "Globallocal.findByIdGlobalLocal", query = "SELECT g FROM Globallocal g WHERE g.idGlobalLocal = :idGlobalLocal")
    , @NamedQuery(name = "Globallocal.findByTiempoNegras", query = "SELECT g FROM Globallocal g WHERE g.tiempoNegras = :tiempoNegras")
    , @NamedQuery(name = "Globallocal.findByTiempoAzules", query = "SELECT g FROM Globallocal g WHERE g.tiempoAzules = :tiempoAzules")
    , @NamedQuery(name = "Globallocal.findByTiempoAlternado", query = "SELECT g FROM Globallocal g WHERE g.tiempoAlternado = :tiempoAlternado")
    , @NamedQuery(name = "Globallocal.findByTiempoTotal", query = "SELECT g FROM Globallocal g WHERE g.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalTotal", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalTotal = :shiftingGlobalTotal")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalTotal", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalTotal = :shiftingLocalTotal")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalTotalCorrectas = :shiftingGlobalTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalTotalCorrectas = :shiftingLocalTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByCorrectasNegras", query = "SELECT g FROM Globallocal g WHERE g.correctasNegras = :correctasNegras")
    , @NamedQuery(name = "Globallocal.findByCorrectasAzules", query = "SELECT g FROM Globallocal g WHERE g.correctasAzules = :correctasAzules")
    , @NamedQuery(name = "Globallocal.findByCorrectasAlternado", query = "SELECT g FROM Globallocal g WHERE g.correctasAlternado = :correctasAlternado")
    , @NamedQuery(name = "Globallocal.findByCorrectasTotales", query = "SELECT g FROM Globallocal g WHERE g.correctasTotales = :correctasTotales")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalReaccionCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalReaccionCorrectas = :shiftingGlobalReaccionCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalReaccionCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalReaccionCorrectas = :shiftingLocalReaccionCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalPorcentajeCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalPorcentajeCorrectas = :shiftingGlobalPorcentajeCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalPorcentajeCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalPorcentajeCorrectas = :shiftingLocalPorcentajeCorrectas")
    , @NamedQuery(name = "Globallocal.findByIncorrectasNegras", query = "SELECT g FROM Globallocal g WHERE g.incorrectasNegras = :incorrectasNegras")
    , @NamedQuery(name = "Globallocal.findByIncorrectasAzules", query = "SELECT g FROM Globallocal g WHERE g.incorrectasAzules = :incorrectasAzules")
    , @NamedQuery(name = "Globallocal.findByIncorrectasAlternado", query = "SELECT g FROM Globallocal g WHERE g.incorrectasAlternado = :incorrectasAlternado")
    , @NamedQuery(name = "Globallocal.findByIncorrectasTotales", query = "SELECT g FROM Globallocal g WHERE g.incorrectasTotales = :incorrectasTotales")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasNegras", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasNegras = :omisionesNulasNegras")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasAzules", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasAzules = :omisionesNulasAzules")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasAlternado", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasAlternado = :omisionesNulasAlternado")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasTotales", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasTotales = :omisionesNulasTotales")
    , @NamedQuery(name = "Globallocal.findByTiempoTotalNegras", query = "SELECT g FROM Globallocal g WHERE g.tiempoTotalNegras = :tiempoTotalNegras")
    , @NamedQuery(name = "Globallocal.findByTiempoTotalAzules", query = "SELECT g FROM Globallocal g WHERE g.tiempoTotalAzules = :tiempoTotalAzules")
    , @NamedQuery(name = "Globallocal.findByTiempoTotalAlternado", query = "SELECT g FROM Globallocal g WHERE g.tiempoTotalAlternado = :tiempoTotalAlternado")
    , @NamedQuery(name = "Globallocal.findByTiempoTotalTarea", query = "SELECT g FROM Globallocal g WHERE g.tiempoTotalTarea = :tiempoTotalTarea")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalTiempoTotal", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalTiempoTotal = :shiftingGlobalTiempoTotal")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalTiempoTotal", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalTiempoTotal = :shiftingLocalTiempoTotal")
    , @NamedQuery(name = "Globallocal.findByTiempoReaccionCorrectasNegras", query = "SELECT g FROM Globallocal g WHERE g.tiempoReaccionCorrectasNegras = :tiempoReaccionCorrectasNegras")
    , @NamedQuery(name = "Globallocal.findByTiempoReaccionCorrectasAzules", query = "SELECT g FROM Globallocal g WHERE g.tiempoReaccionCorrectasAzules = :tiempoReaccionCorrectasAzules")
    , @NamedQuery(name = "Globallocal.findByTiempoReaccionCorrectasAlternado", query = "SELECT g FROM Globallocal g WHERE g.tiempoReaccionCorrectasAlternado = :tiempoReaccionCorrectasAlternado")
    , @NamedQuery(name = "Globallocal.findByTiempoReaccionCorrectasTotales", query = "SELECT g FROM Globallocal g WHERE g.tiempoReaccionCorrectasTotales = :tiempoReaccionCorrectasTotales")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalTiempoTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalTiempoTotalCorrectas = :shiftingGlobalTiempoTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalTiempoTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalTiempoTotalCorrectas = :shiftingLocalTiempoTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByCorrectasTotalesNegras", query = "SELECT g FROM Globallocal g WHERE g.correctasTotalesNegras = :correctasTotalesNegras")
    , @NamedQuery(name = "Globallocal.findByCorrectasTotalesAzules", query = "SELECT g FROM Globallocal g WHERE g.correctasTotalesAzules = :correctasTotalesAzules")
    , @NamedQuery(name = "Globallocal.findByCorrectasTotalesAlternado", query = "SELECT g FROM Globallocal g WHERE g.correctasTotalesAlternado = :correctasTotalesAlternado")
    , @NamedQuery(name = "Globallocal.findByCorrectasTotalesTarea", query = "SELECT g FROM Globallocal g WHERE g.correctasTotalesTarea = :correctasTotalesTarea")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalTiempoReaccionCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalTiempoReaccionCorrectas = :shiftingGlobalTiempoReaccionCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalTiempoReaccionCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalTiempoReaccionCorrectas = :shiftingLocalTiempoReaccionCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingGlobalPorcentajeTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingGlobalPorcentajeTotalCorrectas = :shiftingGlobalPorcentajeTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByShiftingLocalPorcentajeTotalCorrectas", query = "SELECT g FROM Globallocal g WHERE g.shiftingLocalPorcentajeTotalCorrectas = :shiftingLocalPorcentajeTotalCorrectas")
    , @NamedQuery(name = "Globallocal.findByIncorrectasTotalesNegras", query = "SELECT g FROM Globallocal g WHERE g.incorrectasTotalesNegras = :incorrectasTotalesNegras")
    , @NamedQuery(name = "Globallocal.findByIncorrectasTotalesAzules", query = "SELECT g FROM Globallocal g WHERE g.incorrectasTotalesAzules = :incorrectasTotalesAzules")
    , @NamedQuery(name = "Globallocal.findByIncorrectasTotalesAlternado", query = "SELECT g FROM Globallocal g WHERE g.incorrectasTotalesAlternado = :incorrectasTotalesAlternado")
    , @NamedQuery(name = "Globallocal.findByIncorrectasTotalesTarea", query = "SELECT g FROM Globallocal g WHERE g.incorrectasTotalesTarea = :incorrectasTotalesTarea")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasTotalesNegras", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasTotalesNegras = :omisionesNulasTotalesNegras")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasTotalesAzules", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasTotalesAzules = :omisionesNulasTotalesAzules")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasTotalesAlternado", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasTotalesAlternado = :omisionesNulasTotalesAlternado")
    , @NamedQuery(name = "Globallocal.findByOmisionesNulasTotalesTarea", query = "SELECT g FROM Globallocal g WHERE g.omisionesNulasTotalesTarea = :omisionesNulasTotalesTarea")})
public class Globallocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idGlobalLocal")
    private Integer idGlobalLocal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoNegras")
    private Double tiempoNegras;
    @Column(name = "tiempoAzules")
    private Double tiempoAzules;
    @Column(name = "tiempoAlternado")
    private Double tiempoAlternado;
    @Column(name = "tiempoTotal")
    private Double tiempoTotal;
    @Column(name = "shiftingGlobalTotal")
    private Double shiftingGlobalTotal;
    @Column(name = "shiftingLocalTotal")
    private Double shiftingLocalTotal;
    @Column(name = "shiftingGlobalTotalCorrectas")
    private Double shiftingGlobalTotalCorrectas;
    @Column(name = "shiftingLocalTotalCorrectas")
    private Double shiftingLocalTotalCorrectas;
    @Column(name = "correctasNegras")
    private Integer correctasNegras;
    @Column(name = "correctasAzules")
    private Integer correctasAzules;
    @Column(name = "correctasAlternado")
    private Integer correctasAlternado;
    @Column(name = "correctasTotales")
    private Integer correctasTotales;
    @Column(name = "shiftingGlobalReaccionCorrectas")
    private Double shiftingGlobalReaccionCorrectas;
    @Column(name = "shiftingLocalReaccionCorrectas")
    private Double shiftingLocalReaccionCorrectas;
    @Column(name = "shiftingGlobalPorcentajeCorrectas")
    private Double shiftingGlobalPorcentajeCorrectas;
    @Column(name = "shiftingLocalPorcentajeCorrectas")
    private Double shiftingLocalPorcentajeCorrectas;
    @Column(name = "incorrectasNegras")
    private Integer incorrectasNegras;
    @Column(name = "incorrectasAzules")
    private Integer incorrectasAzules;
    @Column(name = "incorrectasAlternado")
    private Integer incorrectasAlternado;
    @Column(name = "incorrectasTotales")
    private Integer incorrectasTotales;
    @Column(name = "omisionesNulasNegras")
    private Integer omisionesNulasNegras;
    @Column(name = "omisionesNulasAzules")
    private Integer omisionesNulasAzules;
    @Column(name = "omisionesNulasAlternado")
    private Integer omisionesNulasAlternado;
    @Column(name = "omisionesNulasTotales")
    private Integer omisionesNulasTotales;
    @Column(name = "tiempoTotalNegras")
    private Double tiempoTotalNegras;
    @Column(name = "tiempoTotalAzules")
    private Double tiempoTotalAzules;
    @Column(name = "tiempoTotalAlternado")
    private Double tiempoTotalAlternado;
    @Column(name = "tiempoTotalTarea")
    private Double tiempoTotalTarea;
    @Column(name = "shiftingGlobalTiempoTotal")
    private Double shiftingGlobalTiempoTotal;
    @Column(name = "shiftingLocalTiempoTotal")
    private Double shiftingLocalTiempoTotal;
    @Column(name = "tiempoReaccionCorrectasNegras")
    private Double tiempoReaccionCorrectasNegras;
    @Column(name = "tiempoReaccionCorrectasAzules")
    private Double tiempoReaccionCorrectasAzules;
    @Column(name = "tiempoReaccionCorrectasAlternado")
    private Double tiempoReaccionCorrectasAlternado;
    @Column(name = "tiempoReaccionCorrectasTotales")
    private Double tiempoReaccionCorrectasTotales;
    @Column(name = "shiftingGlobalTiempoTotalCorrectas")
    private Double shiftingGlobalTiempoTotalCorrectas;
    @Column(name = "shiftingLocalTiempoTotalCorrectas")
    private Double shiftingLocalTiempoTotalCorrectas;
    @Column(name = "correctasTotalesNegras")
    private Integer correctasTotalesNegras;
    @Column(name = "correctasTotalesAzules")
    private Integer correctasTotalesAzules;
    @Column(name = "correctasTotalesAlternado")
    private Integer correctasTotalesAlternado;
    @Column(name = "correctasTotalesTarea")
    private Integer correctasTotalesTarea;
    @Column(name = "shiftingGlobalTiempoReaccionCorrectas")
    private Double shiftingGlobalTiempoReaccionCorrectas;
    @Column(name = "shiftingLocalTiempoReaccionCorrectas")
    private Double shiftingLocalTiempoReaccionCorrectas;
    @Column(name = "shiftingGlobalPorcentajeTotalCorrectas")
    private Double shiftingGlobalPorcentajeTotalCorrectas;
    @Column(name = "shiftingLocalPorcentajeTotalCorrectas")
    private Double shiftingLocalPorcentajeTotalCorrectas;
    @Column(name = "incorrectasTotalesNegras")
    private Integer incorrectasTotalesNegras;
    @Column(name = "incorrectasTotalesAzules")
    private Integer incorrectasTotalesAzules;
    @Column(name = "incorrectasTotalesAlternado")
    private Integer incorrectasTotalesAlternado;
    @Column(name = "incorrectasTotalesTarea")
    private Integer incorrectasTotalesTarea;
    @Column(name = "omisionesNulasTotalesNegras")
    private Integer omisionesNulasTotalesNegras;
    @Column(name = "omisionesNulasTotalesAzules")
    private Integer omisionesNulasTotalesAzules;
    @Column(name = "omisionesNulasTotalesAlternado")
    private Integer omisionesNulasTotalesAlternado;
    @Column(name = "omisionesNulasTotalesTarea")
    private Integer omisionesNulasTotalesTarea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalLocalidGlobalLocal")
    private Collection<Set1> set1Collection;

    public Globallocal() {
    }

    public Globallocal(Integer idGlobalLocal) {
        this.idGlobalLocal = idGlobalLocal;
    }

    public Integer getIdGlobalLocal() {
        return idGlobalLocal;
    }

    public void setIdGlobalLocal(Integer idGlobalLocal) {
        this.idGlobalLocal = idGlobalLocal;
    }

    public Double getTiempoNegras() {
        return tiempoNegras;
    }

    public void setTiempoNegras(Double tiempoNegras) {
        this.tiempoNegras = tiempoNegras;
    }

    public Double getTiempoAzules() {
        return tiempoAzules;
    }

    public void setTiempoAzules(Double tiempoAzules) {
        this.tiempoAzules = tiempoAzules;
    }

    public Double getTiempoAlternado() {
        return tiempoAlternado;
    }

    public void setTiempoAlternado(Double tiempoAlternado) {
        this.tiempoAlternado = tiempoAlternado;
    }

    public Double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public Double getShiftingGlobalTotal() {
        return shiftingGlobalTotal;
    }

    public void setShiftingGlobalTotal(Double shiftingGlobalTotal) {
        this.shiftingGlobalTotal = shiftingGlobalTotal;
    }

    public Double getShiftingLocalTotal() {
        return shiftingLocalTotal;
    }

    public void setShiftingLocalTotal(Double shiftingLocalTotal) {
        this.shiftingLocalTotal = shiftingLocalTotal;
    }

    public Double getShiftingGlobalTotalCorrectas() {
        return shiftingGlobalTotalCorrectas;
    }

    public void setShiftingGlobalTotalCorrectas(Double shiftingGlobalTotalCorrectas) {
        this.shiftingGlobalTotalCorrectas = shiftingGlobalTotalCorrectas;
    }

    public Double getShiftingLocalTotalCorrectas() {
        return shiftingLocalTotalCorrectas;
    }

    public void setShiftingLocalTotalCorrectas(Double shiftingLocalTotalCorrectas) {
        this.shiftingLocalTotalCorrectas = shiftingLocalTotalCorrectas;
    }

    public Integer getCorrectasNegras() {
        return correctasNegras;
    }

    public void setCorrectasNegras(Integer correctasNegras) {
        this.correctasNegras = correctasNegras;
    }

    public Integer getCorrectasAzules() {
        return correctasAzules;
    }

    public void setCorrectasAzules(Integer correctasAzules) {
        this.correctasAzules = correctasAzules;
    }

    public Integer getCorrectasAlternado() {
        return correctasAlternado;
    }

    public void setCorrectasAlternado(Integer correctasAlternado) {
        this.correctasAlternado = correctasAlternado;
    }

    public Integer getCorrectasTotales() {
        return correctasTotales;
    }

    public void setCorrectasTotales(Integer correctasTotales) {
        this.correctasTotales = correctasTotales;
    }

    public Double getShiftingGlobalReaccionCorrectas() {
        return shiftingGlobalReaccionCorrectas;
    }

    public void setShiftingGlobalReaccionCorrectas(Double shiftingGlobalReaccionCorrectas) {
        this.shiftingGlobalReaccionCorrectas = shiftingGlobalReaccionCorrectas;
    }

    public Double getShiftingLocalReaccionCorrectas() {
        return shiftingLocalReaccionCorrectas;
    }

    public void setShiftingLocalReaccionCorrectas(Double shiftingLocalReaccionCorrectas) {
        this.shiftingLocalReaccionCorrectas = shiftingLocalReaccionCorrectas;
    }

    public Double getShiftingGlobalPorcentajeCorrectas() {
        return shiftingGlobalPorcentajeCorrectas;
    }

    public void setShiftingGlobalPorcentajeCorrectas(Double shiftingGlobalPorcentajeCorrectas) {
        this.shiftingGlobalPorcentajeCorrectas = shiftingGlobalPorcentajeCorrectas;
    }

    public Double getShiftingLocalPorcentajeCorrectas() {
        return shiftingLocalPorcentajeCorrectas;
    }

    public void setShiftingLocalPorcentajeCorrectas(Double shiftingLocalPorcentajeCorrectas) {
        this.shiftingLocalPorcentajeCorrectas = shiftingLocalPorcentajeCorrectas;
    }

    public Integer getIncorrectasNegras() {
        return incorrectasNegras;
    }

    public void setIncorrectasNegras(Integer incorrectasNegras) {
        this.incorrectasNegras = incorrectasNegras;
    }

    public Integer getIncorrectasAzules() {
        return incorrectasAzules;
    }

    public void setIncorrectasAzules(Integer incorrectasAzules) {
        this.incorrectasAzules = incorrectasAzules;
    }

    public Integer getIncorrectasAlternado() {
        return incorrectasAlternado;
    }

    public void setIncorrectasAlternado(Integer incorrectasAlternado) {
        this.incorrectasAlternado = incorrectasAlternado;
    }

    public Integer getIncorrectasTotales() {
        return incorrectasTotales;
    }

    public void setIncorrectasTotales(Integer incorrectasTotales) {
        this.incorrectasTotales = incorrectasTotales;
    }

    public Integer getOmisionesNulasNegras() {
        return omisionesNulasNegras;
    }

    public void setOmisionesNulasNegras(Integer omisionesNulasNegras) {
        this.omisionesNulasNegras = omisionesNulasNegras;
    }

    public Integer getOmisionesNulasAzules() {
        return omisionesNulasAzules;
    }

    public void setOmisionesNulasAzules(Integer omisionesNulasAzules) {
        this.omisionesNulasAzules = omisionesNulasAzules;
    }

    public Integer getOmisionesNulasAlternado() {
        return omisionesNulasAlternado;
    }

    public void setOmisionesNulasAlternado(Integer omisionesNulasAlternado) {
        this.omisionesNulasAlternado = omisionesNulasAlternado;
    }

    public Integer getOmisionesNulasTotales() {
        return omisionesNulasTotales;
    }

    public void setOmisionesNulasTotales(Integer omisionesNulasTotales) {
        this.omisionesNulasTotales = omisionesNulasTotales;
    }

    public Double getTiempoTotalNegras() {
        return tiempoTotalNegras;
    }

    public void setTiempoTotalNegras(Double tiempoTotalNegras) {
        this.tiempoTotalNegras = tiempoTotalNegras;
    }

    public Double getTiempoTotalAzules() {
        return tiempoTotalAzules;
    }

    public void setTiempoTotalAzules(Double tiempoTotalAzules) {
        this.tiempoTotalAzules = tiempoTotalAzules;
    }

    public Double getTiempoTotalAlternado() {
        return tiempoTotalAlternado;
    }

    public void setTiempoTotalAlternado(Double tiempoTotalAlternado) {
        this.tiempoTotalAlternado = tiempoTotalAlternado;
    }

    public Double getTiempoTotalTarea() {
        return tiempoTotalTarea;
    }

    public void setTiempoTotalTarea(Double tiempoTotalTarea) {
        this.tiempoTotalTarea = tiempoTotalTarea;
    }

    public Double getShiftingGlobalTiempoTotal() {
        return shiftingGlobalTiempoTotal;
    }

    public void setShiftingGlobalTiempoTotal(Double shiftingGlobalTiempoTotal) {
        this.shiftingGlobalTiempoTotal = shiftingGlobalTiempoTotal;
    }

    public Double getShiftingLocalTiempoTotal() {
        return shiftingLocalTiempoTotal;
    }

    public void setShiftingLocalTiempoTotal(Double shiftingLocalTiempoTotal) {
        this.shiftingLocalTiempoTotal = shiftingLocalTiempoTotal;
    }

    public Double getTiempoReaccionCorrectasNegras() {
        return tiempoReaccionCorrectasNegras;
    }

    public void setTiempoReaccionCorrectasNegras(Double tiempoReaccionCorrectasNegras) {
        this.tiempoReaccionCorrectasNegras = tiempoReaccionCorrectasNegras;
    }

    public Double getTiempoReaccionCorrectasAzules() {
        return tiempoReaccionCorrectasAzules;
    }

    public void setTiempoReaccionCorrectasAzules(Double tiempoReaccionCorrectasAzules) {
        this.tiempoReaccionCorrectasAzules = tiempoReaccionCorrectasAzules;
    }

    public Double getTiempoReaccionCorrectasAlternado() {
        return tiempoReaccionCorrectasAlternado;
    }

    public void setTiempoReaccionCorrectasAlternado(Double tiempoReaccionCorrectasAlternado) {
        this.tiempoReaccionCorrectasAlternado = tiempoReaccionCorrectasAlternado;
    }

    public Double getTiempoReaccionCorrectasTotales() {
        return tiempoReaccionCorrectasTotales;
    }

    public void setTiempoReaccionCorrectasTotales(Double tiempoReaccionCorrectasTotales) {
        this.tiempoReaccionCorrectasTotales = tiempoReaccionCorrectasTotales;
    }

    public Double getShiftingGlobalTiempoTotalCorrectas() {
        return shiftingGlobalTiempoTotalCorrectas;
    }

    public void setShiftingGlobalTiempoTotalCorrectas(Double shiftingGlobalTiempoTotalCorrectas) {
        this.shiftingGlobalTiempoTotalCorrectas = shiftingGlobalTiempoTotalCorrectas;
    }

    public Double getShiftingLocalTiempoTotalCorrectas() {
        return shiftingLocalTiempoTotalCorrectas;
    }

    public void setShiftingLocalTiempoTotalCorrectas(Double shiftingLocalTiempoTotalCorrectas) {
        this.shiftingLocalTiempoTotalCorrectas = shiftingLocalTiempoTotalCorrectas;
    }

    public Integer getCorrectasTotalesNegras() {
        return correctasTotalesNegras;
    }

    public void setCorrectasTotalesNegras(Integer correctasTotalesNegras) {
        this.correctasTotalesNegras = correctasTotalesNegras;
    }

    public Integer getCorrectasTotalesAzules() {
        return correctasTotalesAzules;
    }

    public void setCorrectasTotalesAzules(Integer correctasTotalesAzules) {
        this.correctasTotalesAzules = correctasTotalesAzules;
    }

    public Integer getCorrectasTotalesAlternado() {
        return correctasTotalesAlternado;
    }

    public void setCorrectasTotalesAlternado(Integer correctasTotalesAlternado) {
        this.correctasTotalesAlternado = correctasTotalesAlternado;
    }

    public Integer getCorrectasTotalesTarea() {
        return correctasTotalesTarea;
    }

    public void setCorrectasTotalesTarea(Integer correctasTotalesTarea) {
        this.correctasTotalesTarea = correctasTotalesTarea;
    }

    public Double getShiftingGlobalTiempoReaccionCorrectas() {
        return shiftingGlobalTiempoReaccionCorrectas;
    }

    public void setShiftingGlobalTiempoReaccionCorrectas(Double shiftingGlobalTiempoReaccionCorrectas) {
        this.shiftingGlobalTiempoReaccionCorrectas = shiftingGlobalTiempoReaccionCorrectas;
    }

    public Double getShiftingLocalTiempoReaccionCorrectas() {
        return shiftingLocalTiempoReaccionCorrectas;
    }

    public void setShiftingLocalTiempoReaccionCorrectas(Double shiftingLocalTiempoReaccionCorrectas) {
        this.shiftingLocalTiempoReaccionCorrectas = shiftingLocalTiempoReaccionCorrectas;
    }

    public Double getShiftingGlobalPorcentajeTotalCorrectas() {
        return shiftingGlobalPorcentajeTotalCorrectas;
    }

    public void setShiftingGlobalPorcentajeTotalCorrectas(Double shiftingGlobalPorcentajeTotalCorrectas) {
        this.shiftingGlobalPorcentajeTotalCorrectas = shiftingGlobalPorcentajeTotalCorrectas;
    }

    public Double getShiftingLocalPorcentajeTotalCorrectas() {
        return shiftingLocalPorcentajeTotalCorrectas;
    }

    public void setShiftingLocalPorcentajeTotalCorrectas(Double shiftingLocalPorcentajeTotalCorrectas) {
        this.shiftingLocalPorcentajeTotalCorrectas = shiftingLocalPorcentajeTotalCorrectas;
    }

    public Integer getIncorrectasTotalesNegras() {
        return incorrectasTotalesNegras;
    }

    public void setIncorrectasTotalesNegras(Integer incorrectasTotalesNegras) {
        this.incorrectasTotalesNegras = incorrectasTotalesNegras;
    }

    public Integer getIncorrectasTotalesAzules() {
        return incorrectasTotalesAzules;
    }

    public void setIncorrectasTotalesAzules(Integer incorrectasTotalesAzules) {
        this.incorrectasTotalesAzules = incorrectasTotalesAzules;
    }

    public Integer getIncorrectasTotalesAlternado() {
        return incorrectasTotalesAlternado;
    }

    public void setIncorrectasTotalesAlternado(Integer incorrectasTotalesAlternado) {
        this.incorrectasTotalesAlternado = incorrectasTotalesAlternado;
    }

    public Integer getIncorrectasTotalesTarea() {
        return incorrectasTotalesTarea;
    }

    public void setIncorrectasTotalesTarea(Integer incorrectasTotalesTarea) {
        this.incorrectasTotalesTarea = incorrectasTotalesTarea;
    }

    public Integer getOmisionesNulasTotalesNegras() {
        return omisionesNulasTotalesNegras;
    }

    public void setOmisionesNulasTotalesNegras(Integer omisionesNulasTotalesNegras) {
        this.omisionesNulasTotalesNegras = omisionesNulasTotalesNegras;
    }

    public Integer getOmisionesNulasTotalesAzules() {
        return omisionesNulasTotalesAzules;
    }

    public void setOmisionesNulasTotalesAzules(Integer omisionesNulasTotalesAzules) {
        this.omisionesNulasTotalesAzules = omisionesNulasTotalesAzules;
    }

    public Integer getOmisionesNulasTotalesAlternado() {
        return omisionesNulasTotalesAlternado;
    }

    public void setOmisionesNulasTotalesAlternado(Integer omisionesNulasTotalesAlternado) {
        this.omisionesNulasTotalesAlternado = omisionesNulasTotalesAlternado;
    }

    public Integer getOmisionesNulasTotalesTarea() {
        return omisionesNulasTotalesTarea;
    }

    public void setOmisionesNulasTotalesTarea(Integer omisionesNulasTotalesTarea) {
        this.omisionesNulasTotalesTarea = omisionesNulasTotalesTarea;
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
        hash += (idGlobalLocal != null ? idGlobalLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Globallocal)) {
            return false;
        }
        Globallocal other = (Globallocal) object;
        if ((this.idGlobalLocal == null && other.idGlobalLocal != null) || (this.idGlobalLocal != null && !this.idGlobalLocal.equals(other.idGlobalLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocios.Globallocal[ idGlobalLocal=" + idGlobalLocal + " ]";
    }
    
}
