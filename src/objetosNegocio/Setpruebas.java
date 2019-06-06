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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "setpruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setpruebas.findAll", query = "SELECT s FROM Setpruebas s")
    , @NamedQuery(name = "Setpruebas.findByIdSet", query = "SELECT s FROM Setpruebas s WHERE s.idSet = :idSet")})
public class Setpruebas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSet")
    private Integer idSet;
    @JoinColumn(name = "GlobalLocal_idGlobalLocal", referencedColumnName = "idGlobalLocal")
    @ManyToOne(optional = false)
    private Globallocal globalLocalidGlobalLocal;
    @JoinColumn(name = "KeepTrack_idKeepTrack", referencedColumnName = "idKeepTrack")
    @ManyToOne(optional = false)
    private Keeptrack keepTrackidKeepTrack;
    @JoinColumn(name = "LetterMemory_idLetterMemory", referencedColumnName = "idLetterMemory")
    @ManyToOne(optional = false)
    private Lettermemory letterMemoryidLetterMemory;
    @JoinColumn(name = "NumberLetter_idNumberLetter", referencedColumnName = "idNumberLetter")
    @ManyToOne(optional = false)
    private Numberletter numberLetteridNumberLetter;
    @JoinColumn(name = "PlusMinus_idPlusMinus", referencedColumnName = "idPlusMinus")
    @ManyToOne(optional = false)
    private Plusminus plusMinusidPlusMinus;
    @JoinColumn(name = "Simon_idSimon", referencedColumnName = "idSimon")
    @ManyToOne(optional = false)
    private Simon simonidSimon;
    @JoinColumn(name = "StopSignal_idStopSignal", referencedColumnName = "idStopSignal")
    @ManyToOne(optional = false)
    private Stopsignal stopSignalidStopSignal;
    @JoinColumn(name = "Stroop_idStroop", referencedColumnName = "idStroop")
    @ManyToOne(optional = false)
    private Stroop stroopidStroop;
    @JoinColumn(name = "ToneMonotoring_idToneMonotoring", referencedColumnName = "idToneMonotoring")
    @ManyToOne(optional = false)
    private Tonemonotoring toneMonotoringidToneMonotoring;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setidSet")
    private List<Prueba> pruebaList;

    public Setpruebas() {
    }

    public Setpruebas(Integer idSet) {
        this.idSet = idSet;
    }

    public Integer getIdSet() {
        return idSet;
    }

    public void setIdSet(Integer idSet) {
        this.idSet = idSet;
    }

    public Globallocal getGlobalLocalidGlobalLocal() {
        return globalLocalidGlobalLocal;
    }

    public void setGlobalLocalidGlobalLocal(Globallocal globalLocalidGlobalLocal) {
        this.globalLocalidGlobalLocal = globalLocalidGlobalLocal;
    }

    public Keeptrack getKeepTrackidKeepTrack() {
        return keepTrackidKeepTrack;
    }

    public void setKeepTrackidKeepTrack(Keeptrack keepTrackidKeepTrack) {
        this.keepTrackidKeepTrack = keepTrackidKeepTrack;
    }

    public Lettermemory getLetterMemoryidLetterMemory() {
        return letterMemoryidLetterMemory;
    }

    public void setLetterMemoryidLetterMemory(Lettermemory letterMemoryidLetterMemory) {
        this.letterMemoryidLetterMemory = letterMemoryidLetterMemory;
    }

    public Numberletter getNumberLetteridNumberLetter() {
        return numberLetteridNumberLetter;
    }

    public void setNumberLetteridNumberLetter(Numberletter numberLetteridNumberLetter) {
        this.numberLetteridNumberLetter = numberLetteridNumberLetter;
    }

    public Plusminus getPlusMinusidPlusMinus() {
        return plusMinusidPlusMinus;
    }

    public void setPlusMinusidPlusMinus(Plusminus plusMinusidPlusMinus) {
        this.plusMinusidPlusMinus = plusMinusidPlusMinus;
    }

    public Simon getSimonidSimon() {
        return simonidSimon;
    }

    public void setSimonidSimon(Simon simonidSimon) {
        this.simonidSimon = simonidSimon;
    }

    public Stopsignal getStopSignalidStopSignal() {
        return stopSignalidStopSignal;
    }

    public void setStopSignalidStopSignal(Stopsignal stopSignalidStopSignal) {
        this.stopSignalidStopSignal = stopSignalidStopSignal;
    }

    public Stroop getStroopidStroop() {
        return stroopidStroop;
    }

    public void setStroopidStroop(Stroop stroopidStroop) {
        this.stroopidStroop = stroopidStroop;
    }

    public Tonemonotoring getToneMonotoringidToneMonotoring() {
        return toneMonotoringidToneMonotoring;
    }

    public void setToneMonotoringidToneMonotoring(Tonemonotoring toneMonotoringidToneMonotoring) {
        this.toneMonotoringidToneMonotoring = toneMonotoringidToneMonotoring;
    }

    @XmlTransient
    public List<Prueba> getPruebaList() {
        return pruebaList;
    }

    public void setPruebaList(List<Prueba> pruebaList) {
        this.pruebaList = pruebaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSet != null ? idSet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setpruebas)) {
            return false;
        }
        Setpruebas other = (Setpruebas) object;
        if ((this.idSet == null && other.idSet != null) || (this.idSet != null && !this.idSet.equals(other.idSet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Setpruebas[ idSet=" + idSet + " ]";
    }
    
}
