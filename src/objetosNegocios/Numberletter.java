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
@Table(name = "numberletter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numberletter.findAll", query = "SELECT n FROM Numberletter n")
    , @NamedQuery(name = "Numberletter.findByIdNumberLetter", query = "SELECT n FROM Numberletter n WHERE n.idNumberLetter = :idNumberLetter")
    , @NamedQuery(name = "Numberletter.findByTiempoLetras", query = "SELECT n FROM Numberletter n WHERE n.tiempoLetras = :tiempoLetras")
    , @NamedQuery(name = "Numberletter.findByTiempoNumeros", query = "SELECT n FROM Numberletter n WHERE n.tiempoNumeros = :tiempoNumeros")
    , @NamedQuery(name = "Numberletter.findByTiempoAlternado", query = "SELECT n FROM Numberletter n WHERE n.tiempoAlternado = :tiempoAlternado")
    , @NamedQuery(name = "Numberletter.findByTiempoTotal", query = "SELECT n FROM Numberletter n WHERE n.tiempoTotal = :tiempoTotal")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalTotal", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalTotal = :shiftingGlobalTotal")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalTotal", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalTotal = :shiftingLocalTotal")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalTotalCorrectas = :shiftingGlobalTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalTotalCorrectas = :shiftingLocalTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByCorrectasLetras", query = "SELECT n FROM Numberletter n WHERE n.correctasLetras = :correctasLetras")
    , @NamedQuery(name = "Numberletter.findByCorrectasNumeros", query = "SELECT n FROM Numberletter n WHERE n.correctasNumeros = :correctasNumeros")
    , @NamedQuery(name = "Numberletter.findByCorrectasAlternado", query = "SELECT n FROM Numberletter n WHERE n.correctasAlternado = :correctasAlternado")
    , @NamedQuery(name = "Numberletter.findByCorrectasTotales", query = "SELECT n FROM Numberletter n WHERE n.correctasTotales = :correctasTotales")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalReaccionCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalReaccionCorrectas = :shiftingGlobalReaccionCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalReaccionCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalReaccionCorrectas = :shiftingLocalReaccionCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalPorcentajeCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalPorcentajeCorrectas = :shiftingGlobalPorcentajeCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalPorcentajeCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalPorcentajeCorrectas = :shiftingLocalPorcentajeCorrectas")
    , @NamedQuery(name = "Numberletter.findByIncorrectasLetras", query = "SELECT n FROM Numberletter n WHERE n.incorrectasLetras = :incorrectasLetras")
    , @NamedQuery(name = "Numberletter.findByIncorrectasNumeros", query = "SELECT n FROM Numberletter n WHERE n.incorrectasNumeros = :incorrectasNumeros")
    , @NamedQuery(name = "Numberletter.findByIncorrectasAlternado", query = "SELECT n FROM Numberletter n WHERE n.incorrectasAlternado = :incorrectasAlternado")
    , @NamedQuery(name = "Numberletter.findByIncorrectasTotales", query = "SELECT n FROM Numberletter n WHERE n.incorrectasTotales = :incorrectasTotales")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasLetras", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasLetras = :omisionesNulasLetras")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasNumeros", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasNumeros = :omisionesNulasNumeros")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasAlternado", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasAlternado = :omisionesNulasAlternado")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasTotales", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasTotales = :omisionesNulasTotales")
    , @NamedQuery(name = "Numberletter.findByTiempoTotalLetras", query = "SELECT n FROM Numberletter n WHERE n.tiempoTotalLetras = :tiempoTotalLetras")
    , @NamedQuery(name = "Numberletter.findByTiempoTotalNumeros", query = "SELECT n FROM Numberletter n WHERE n.tiempoTotalNumeros = :tiempoTotalNumeros")
    , @NamedQuery(name = "Numberletter.findByTiempoTotalAlternado", query = "SELECT n FROM Numberletter n WHERE n.tiempoTotalAlternado = :tiempoTotalAlternado")
    , @NamedQuery(name = "Numberletter.findByTiempoTotalTarea", query = "SELECT n FROM Numberletter n WHERE n.tiempoTotalTarea = :tiempoTotalTarea")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalTiempoTotal", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalTiempoTotal = :shiftingGlobalTiempoTotal")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalTiempoTotal", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalTiempoTotal = :shiftingLocalTiempoTotal")
    , @NamedQuery(name = "Numberletter.findByTiempoReaccionCorrectasLetras", query = "SELECT n FROM Numberletter n WHERE n.tiempoReaccionCorrectasLetras = :tiempoReaccionCorrectasLetras")
    , @NamedQuery(name = "Numberletter.findByTiempoReaccionCorrectasNumeros", query = "SELECT n FROM Numberletter n WHERE n.tiempoReaccionCorrectasNumeros = :tiempoReaccionCorrectasNumeros")
    , @NamedQuery(name = "Numberletter.findByTiempoReaccionCorrectasAlternado", query = "SELECT n FROM Numberletter n WHERE n.tiempoReaccionCorrectasAlternado = :tiempoReaccionCorrectasAlternado")
    , @NamedQuery(name = "Numberletter.findByTiempoReaccionCorrectasTotales", query = "SELECT n FROM Numberletter n WHERE n.tiempoReaccionCorrectasTotales = :tiempoReaccionCorrectasTotales")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalTiempoTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalTiempoTotalCorrectas = :shiftingGlobalTiempoTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalTiempoTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalTiempoTotalCorrectas = :shiftingLocalTiempoTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByCorrectasTotalesLetras", query = "SELECT n FROM Numberletter n WHERE n.correctasTotalesLetras = :correctasTotalesLetras")
    , @NamedQuery(name = "Numberletter.findByCorrectasTotalesNumeros", query = "SELECT n FROM Numberletter n WHERE n.correctasTotalesNumeros = :correctasTotalesNumeros")
    , @NamedQuery(name = "Numberletter.findByCorrectasTotalesAlternado", query = "SELECT n FROM Numberletter n WHERE n.correctasTotalesAlternado = :correctasTotalesAlternado")
    , @NamedQuery(name = "Numberletter.findByCorrectasTotalesTarea", query = "SELECT n FROM Numberletter n WHERE n.correctasTotalesTarea = :correctasTotalesTarea")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalTiempoReaccionCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalTiempoReaccionCorrectas = :shiftingGlobalTiempoReaccionCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalTiempoReaccionCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalTiempoReaccionCorrectas = :shiftingLocalTiempoReaccionCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingGlobalPorcentajeTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingGlobalPorcentajeTotalCorrectas = :shiftingGlobalPorcentajeTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByShiftingLocalPorcentajeTotalCorrectas", query = "SELECT n FROM Numberletter n WHERE n.shiftingLocalPorcentajeTotalCorrectas = :shiftingLocalPorcentajeTotalCorrectas")
    , @NamedQuery(name = "Numberletter.findByIncorrectasTotalesLetras", query = "SELECT n FROM Numberletter n WHERE n.incorrectasTotalesLetras = :incorrectasTotalesLetras")
    , @NamedQuery(name = "Numberletter.findByIncorrectasTotalesNumeros", query = "SELECT n FROM Numberletter n WHERE n.incorrectasTotalesNumeros = :incorrectasTotalesNumeros")
    , @NamedQuery(name = "Numberletter.findByIncorrectasTotalesAlternado", query = "SELECT n FROM Numberletter n WHERE n.incorrectasTotalesAlternado = :incorrectasTotalesAlternado")
    , @NamedQuery(name = "Numberletter.findByIncorrectasTotalesTarea", query = "SELECT n FROM Numberletter n WHERE n.incorrectasTotalesTarea = :incorrectasTotalesTarea")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasTotalesLetras", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasTotalesLetras = :omisionesNulasTotalesLetras")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasTotalesNumeros", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasTotalesNumeros = :omisionesNulasTotalesNumeros")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasTotalesAlternado", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasTotalesAlternado = :omisionesNulasTotalesAlternado")
    , @NamedQuery(name = "Numberletter.findByOmisionesNulasTotalesTarea", query = "SELECT n FROM Numberletter n WHERE n.omisionesNulasTotalesTarea = :omisionesNulasTotalesTarea")})
public class Numberletter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idNumberLetter")
    private Integer idNumberLetter;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoLetras")
    private Double tiempoLetras;
    @Column(name = "tiempoNumeros")
    private Double tiempoNumeros;
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
    @Column(name = "correctasLetras")
    private Integer correctasLetras;
    @Column(name = "correctasNumeros")
    private Integer correctasNumeros;
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
    @Column(name = "incorrectasLetras")
    private Integer incorrectasLetras;
    @Column(name = "incorrectasNumeros")
    private Integer incorrectasNumeros;
    @Column(name = "incorrectasAlternado")
    private Integer incorrectasAlternado;
    @Column(name = "incorrectasTotales")
    private Integer incorrectasTotales;
    @Column(name = "omisionesNulasLetras")
    private Integer omisionesNulasLetras;
    @Column(name = "omisionesNulasNumeros")
    private Integer omisionesNulasNumeros;
    @Column(name = "omisionesNulasAlternado")
    private Integer omisionesNulasAlternado;
    @Column(name = "omisionesNulasTotales")
    private Integer omisionesNulasTotales;
    @Column(name = "tiempoTotalLetras")
    private Double tiempoTotalLetras;
    @Column(name = "tiempoTotalNumeros")
    private Double tiempoTotalNumeros;
    @Column(name = "tiempoTotalAlternado")
    private Double tiempoTotalAlternado;
    @Column(name = "tiempoTotalTarea")
    private Double tiempoTotalTarea;
    @Column(name = "shiftingGlobalTiempoTotal")
    private Double shiftingGlobalTiempoTotal;
    @Column(name = "shiftingLocalTiempoTotal")
    private Double shiftingLocalTiempoTotal;
    @Column(name = "tiempoReaccionCorrectasLetras")
    private Double tiempoReaccionCorrectasLetras;
    @Column(name = "tiempoReaccionCorrectasNumeros")
    private Double tiempoReaccionCorrectasNumeros;
    @Column(name = "tiempoReaccionCorrectasAlternado")
    private Double tiempoReaccionCorrectasAlternado;
    @Column(name = "tiempoReaccionCorrectasTotales")
    private Double tiempoReaccionCorrectasTotales;
    @Column(name = "shiftingGlobalTiempoTotalCorrectas")
    private Double shiftingGlobalTiempoTotalCorrectas;
    @Column(name = "shiftingLocalTiempoTotalCorrectas")
    private Double shiftingLocalTiempoTotalCorrectas;
    @Column(name = "correctasTotalesLetras")
    private Integer correctasTotalesLetras;
    @Column(name = "correctasTotalesNumeros")
    private Integer correctasTotalesNumeros;
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
    @Column(name = "incorrectasTotalesLetras")
    private Integer incorrectasTotalesLetras;
    @Column(name = "incorrectasTotalesNumeros")
    private Integer incorrectasTotalesNumeros;
    @Column(name = "incorrectasTotalesAlternado")
    private Integer incorrectasTotalesAlternado;
    @Column(name = "incorrectasTotalesTarea")
    private Integer incorrectasTotalesTarea;
    @Column(name = "omisionesNulasTotalesLetras")
    private Integer omisionesNulasTotalesLetras;
    @Column(name = "omisionesNulasTotalesNumeros")
    private Integer omisionesNulasTotalesNumeros;
    @Column(name = "omisionesNulasTotalesAlternado")
    private Integer omisionesNulasTotalesAlternado;
    @Column(name = "omisionesNulasTotalesTarea")
    private Integer omisionesNulasTotalesTarea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numberLetteridNumberLetter")
    private Collection<Set1> set1Collection;

    public Numberletter() {
    }

    public Numberletter(Integer idNumberLetter) {
        this.idNumberLetter = idNumberLetter;
    }

    public Integer getIdNumberLetter() {
        return idNumberLetter;
    }

    public void setIdNumberLetter(Integer idNumberLetter) {
        this.idNumberLetter = idNumberLetter;
    }

    public Double getTiempoLetras() {
        return tiempoLetras;
    }

    public void setTiempoLetras(Double tiempoLetras) {
        this.tiempoLetras = tiempoLetras;
    }

    public Double getTiempoNumeros() {
        return tiempoNumeros;
    }

    public void setTiempoNumeros(Double tiempoNumeros) {
        this.tiempoNumeros = tiempoNumeros;
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

    public Integer getCorrectasLetras() {
        return correctasLetras;
    }

    public void setCorrectasLetras(Integer correctasLetras) {
        this.correctasLetras = correctasLetras;
    }

    public Integer getCorrectasNumeros() {
        return correctasNumeros;
    }

    public void setCorrectasNumeros(Integer correctasNumeros) {
        this.correctasNumeros = correctasNumeros;
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

    public Integer getIncorrectasLetras() {
        return incorrectasLetras;
    }

    public void setIncorrectasLetras(Integer incorrectasLetras) {
        this.incorrectasLetras = incorrectasLetras;
    }

    public Integer getIncorrectasNumeros() {
        return incorrectasNumeros;
    }

    public void setIncorrectasNumeros(Integer incorrectasNumeros) {
        this.incorrectasNumeros = incorrectasNumeros;
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

    public Integer getOmisionesNulasLetras() {
        return omisionesNulasLetras;
    }

    public void setOmisionesNulasLetras(Integer omisionesNulasLetras) {
        this.omisionesNulasLetras = omisionesNulasLetras;
    }

    public Integer getOmisionesNulasNumeros() {
        return omisionesNulasNumeros;
    }

    public void setOmisionesNulasNumeros(Integer omisionesNulasNumeros) {
        this.omisionesNulasNumeros = omisionesNulasNumeros;
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

    public Double getTiempoTotalLetras() {
        return tiempoTotalLetras;
    }

    public void setTiempoTotalLetras(Double tiempoTotalLetras) {
        this.tiempoTotalLetras = tiempoTotalLetras;
    }

    public Double getTiempoTotalNumeros() {
        return tiempoTotalNumeros;
    }

    public void setTiempoTotalNumeros(Double tiempoTotalNumeros) {
        this.tiempoTotalNumeros = tiempoTotalNumeros;
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

    public Double getTiempoReaccionCorrectasLetras() {
        return tiempoReaccionCorrectasLetras;
    }

    public void setTiempoReaccionCorrectasLetras(Double tiempoReaccionCorrectasLetras) {
        this.tiempoReaccionCorrectasLetras = tiempoReaccionCorrectasLetras;
    }

    public Double getTiempoReaccionCorrectasNumeros() {
        return tiempoReaccionCorrectasNumeros;
    }

    public void setTiempoReaccionCorrectasNumeros(Double tiempoReaccionCorrectasNumeros) {
        this.tiempoReaccionCorrectasNumeros = tiempoReaccionCorrectasNumeros;
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

    public Integer getCorrectasTotalesLetras() {
        return correctasTotalesLetras;
    }

    public void setCorrectasTotalesLetras(Integer correctasTotalesLetras) {
        this.correctasTotalesLetras = correctasTotalesLetras;
    }

    public Integer getCorrectasTotalesNumeros() {
        return correctasTotalesNumeros;
    }

    public void setCorrectasTotalesNumeros(Integer correctasTotalesNumeros) {
        this.correctasTotalesNumeros = correctasTotalesNumeros;
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

    public Integer getIncorrectasTotalesLetras() {
        return incorrectasTotalesLetras;
    }

    public void setIncorrectasTotalesLetras(Integer incorrectasTotalesLetras) {
        this.incorrectasTotalesLetras = incorrectasTotalesLetras;
    }

    public Integer getIncorrectasTotalesNumeros() {
        return incorrectasTotalesNumeros;
    }

    public void setIncorrectasTotalesNumeros(Integer incorrectasTotalesNumeros) {
        this.incorrectasTotalesNumeros = incorrectasTotalesNumeros;
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

    public Integer getOmisionesNulasTotalesLetras() {
        return omisionesNulasTotalesLetras;
    }

    public void setOmisionesNulasTotalesLetras(Integer omisionesNulasTotalesLetras) {
        this.omisionesNulasTotalesLetras = omisionesNulasTotalesLetras;
    }

    public Integer getOmisionesNulasTotalesNumeros() {
        return omisionesNulasTotalesNumeros;
    }

    public void setOmisionesNulasTotalesNumeros(Integer omisionesNulasTotalesNumeros) {
        this.omisionesNulasTotalesNumeros = omisionesNulasTotalesNumeros;
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
        hash += (idNumberLetter != null ? idNumberLetter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numberletter)) {
            return false;
        }
        Numberletter other = (Numberletter) object;
        if ((this.idNumberLetter == null && other.idNumberLetter != null) || (this.idNumberLetter != null && !this.idNumberLetter.equals(other.idNumberLetter))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "objetosNegocios.Numberletter[ idNumberLetter=" + idNumberLetter + " ]";
    }
    */

    @Override
    public String toString() {
        return "Numberletter{" + "idNumberLetter=" + idNumberLetter + ", tiempoLetras=" + tiempoLetras + ", tiempoNumeros=" + tiempoNumeros + ", tiempoAlternado=" + tiempoAlternado + ", tiempoTotal=" + tiempoTotal + ", shiftingGlobalTotal=" + shiftingGlobalTotal + ", shiftingLocalTotal=" + shiftingLocalTotal + ", shiftingGlobalTotalCorrectas=" + shiftingGlobalTotalCorrectas + ", shiftingLocalTotalCorrectas=" + shiftingLocalTotalCorrectas + ", correctasLetras=" + correctasLetras + ", correctasNumeros=" + correctasNumeros + ", correctasAlternado=" + correctasAlternado + ", correctasTotales=" + correctasTotales + ", shiftingGlobalReaccionCorrectas=" + shiftingGlobalReaccionCorrectas + ", shiftingLocalReaccionCorrectas=" + shiftingLocalReaccionCorrectas + ", shiftingGlobalPorcentajeCorrectas=" + shiftingGlobalPorcentajeCorrectas + ", shiftingLocalPorcentajeCorrectas=" + shiftingLocalPorcentajeCorrectas + ", incorrectasLetras=" + incorrectasLetras + ", incorrectasNumeros=" + incorrectasNumeros + ", incorrectasAlternado=" + incorrectasAlternado + ", incorrectasTotales=" + incorrectasTotales + ", omisionesNulasLetras=" + omisionesNulasLetras + ", omisionesNulasNumeros=" + omisionesNulasNumeros + ", omisionesNulasAlternado=" + omisionesNulasAlternado + ", omisionesNulasTotales=" + omisionesNulasTotales + ", tiempoTotalLetras=" + tiempoTotalLetras + ", tiempoTotalNumeros=" + tiempoTotalNumeros + ", tiempoTotalAlternado=" + tiempoTotalAlternado + ", tiempoTotalTarea=" + tiempoTotalTarea + ", shiftingGlobalTiempoTotal=" + shiftingGlobalTiempoTotal + ", shiftingLocalTiempoTotal=" + shiftingLocalTiempoTotal + ", tiempoReaccionCorrectasLetras=" + tiempoReaccionCorrectasLetras + ", tiempoReaccionCorrectasNumeros=" + tiempoReaccionCorrectasNumeros + ", tiempoReaccionCorrectasAlternado=" + tiempoReaccionCorrectasAlternado + ", tiempoReaccionCorrectasTotales=" + tiempoReaccionCorrectasTotales + ", shiftingGlobalTiempoTotalCorrectas=" + shiftingGlobalTiempoTotalCorrectas + ", shiftingLocalTiempoTotalCorrectas=" + shiftingLocalTiempoTotalCorrectas + ", correctasTotalesLetras=" + correctasTotalesLetras + ", correctasTotalesNumeros=" + correctasTotalesNumeros + ", correctasTotalesAlternado=" + correctasTotalesAlternado + ", correctasTotalesTarea=" + correctasTotalesTarea + ", shiftingGlobalTiempoReaccionCorrectas=" + shiftingGlobalTiempoReaccionCorrectas + ", shiftingLocalTiempoReaccionCorrectas=" + shiftingLocalTiempoReaccionCorrectas + ", shiftingGlobalPorcentajeTotalCorrectas=" + shiftingGlobalPorcentajeTotalCorrectas + ", shiftingLocalPorcentajeTotalCorrectas=" + shiftingLocalPorcentajeTotalCorrectas + ", incorrectasTotalesLetras=" + incorrectasTotalesLetras + ", incorrectasTotalesNumeros=" + incorrectasTotalesNumeros + ", incorrectasTotalesAlternado=" + incorrectasTotalesAlternado + ", incorrectasTotalesTarea=" + incorrectasTotalesTarea + ", omisionesNulasTotalesLetras=" + omisionesNulasTotalesLetras + ", omisionesNulasTotalesNumeros=" + omisionesNulasTotalesNumeros + ", omisionesNulasTotalesAlternado=" + omisionesNulasTotalesAlternado + ", omisionesNulasTotalesTarea=" + omisionesNulasTotalesTarea + ", set1Collection=" + set1Collection + '}';
    }
    
    
    
}
