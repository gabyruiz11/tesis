/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocio.Globallocal;
import objetosNegocio.Keeptrack;
import objetosNegocio.Lettermemory;
import objetosNegocio.Numberletter;
import objetosNegocio.Plusminus;
import objetosNegocio.Simon;
import objetosNegocio.Stopsignal;
import objetosNegocio.Stroop;
import objetosNegocio.Tonemonotoring;
import objetosNegocio.Prueba;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocio.Setpruebas;

/**
 *
 * @author David Hermosillo
 */
public class SetpruebasJpaController implements Serializable {

    public SetpruebasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Setpruebas setpruebas) throws PreexistingEntityException, Exception {
        if (setpruebas.getPruebaList() == null) {
            setpruebas.setPruebaList(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Globallocal globalLocalidGlobalLocal = setpruebas.getGlobalLocalidGlobalLocal();
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal = em.getReference(globalLocalidGlobalLocal.getClass(), globalLocalidGlobalLocal.getIdGlobalLocal());
                setpruebas.setGlobalLocalidGlobalLocal(globalLocalidGlobalLocal);
            }
            Keeptrack keepTrackidKeepTrack = setpruebas.getKeepTrackidKeepTrack();
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack = em.getReference(keepTrackidKeepTrack.getClass(), keepTrackidKeepTrack.getIdKeepTrack());
                setpruebas.setKeepTrackidKeepTrack(keepTrackidKeepTrack);
            }
            Lettermemory letterMemoryidLetterMemory = setpruebas.getLetterMemoryidLetterMemory();
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory = em.getReference(letterMemoryidLetterMemory.getClass(), letterMemoryidLetterMemory.getIdLetterMemory());
                setpruebas.setLetterMemoryidLetterMemory(letterMemoryidLetterMemory);
            }
            Numberletter numberLetteridNumberLetter = setpruebas.getNumberLetteridNumberLetter();
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter = em.getReference(numberLetteridNumberLetter.getClass(), numberLetteridNumberLetter.getIdNumberLetter());
                setpruebas.setNumberLetteridNumberLetter(numberLetteridNumberLetter);
            }
            Plusminus plusMinusidPlusMinus = setpruebas.getPlusMinusidPlusMinus();
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus = em.getReference(plusMinusidPlusMinus.getClass(), plusMinusidPlusMinus.getIdPlusMinus());
                setpruebas.setPlusMinusidPlusMinus(plusMinusidPlusMinus);
            }
            Simon simonidSimon = setpruebas.getSimonidSimon();
            if (simonidSimon != null) {
                simonidSimon = em.getReference(simonidSimon.getClass(), simonidSimon.getIdSimon());
                setpruebas.setSimonidSimon(simonidSimon);
            }
            Stopsignal stopSignalidStopSignal = setpruebas.getStopSignalidStopSignal();
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal = em.getReference(stopSignalidStopSignal.getClass(), stopSignalidStopSignal.getIdStopSignal());
                setpruebas.setStopSignalidStopSignal(stopSignalidStopSignal);
            }
            Stroop stroopidStroop = setpruebas.getStroopidStroop();
            if (stroopidStroop != null) {
                stroopidStroop = em.getReference(stroopidStroop.getClass(), stroopidStroop.getIdStroop());
                setpruebas.setStroopidStroop(stroopidStroop);
            }
            Tonemonotoring toneMonotoringidToneMonotoring = setpruebas.getToneMonotoringidToneMonotoring();
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring = em.getReference(toneMonotoringidToneMonotoring.getClass(), toneMonotoringidToneMonotoring.getIdToneMonotoring());
                setpruebas.setToneMonotoringidToneMonotoring(toneMonotoringidToneMonotoring);
            }
            List<Prueba> attachedPruebaList = new ArrayList<Prueba>();
            for (Prueba pruebaListPruebaToAttach : setpruebas.getPruebaList()) {
                pruebaListPruebaToAttach = em.getReference(pruebaListPruebaToAttach.getClass(), pruebaListPruebaToAttach.getIdPrueba());
                attachedPruebaList.add(pruebaListPruebaToAttach);
            }
            setpruebas.setPruebaList(attachedPruebaList);
            em.persist(setpruebas);
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal.getSetpruebasList().add(setpruebas);
                globalLocalidGlobalLocal = em.merge(globalLocalidGlobalLocal);
            }
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack.getSetpruebasList().add(setpruebas);
                keepTrackidKeepTrack = em.merge(keepTrackidKeepTrack);
            }
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory.getSetpruebasList().add(setpruebas);
                letterMemoryidLetterMemory = em.merge(letterMemoryidLetterMemory);
            }
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter.getSetpruebasList().add(setpruebas);
                numberLetteridNumberLetter = em.merge(numberLetteridNumberLetter);
            }
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus.getSetpruebasList().add(setpruebas);
                plusMinusidPlusMinus = em.merge(plusMinusidPlusMinus);
            }
            if (simonidSimon != null) {
                simonidSimon.getSetpruebasList().add(setpruebas);
                simonidSimon = em.merge(simonidSimon);
            }
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal.getSetpruebasList().add(setpruebas);
                stopSignalidStopSignal = em.merge(stopSignalidStopSignal);
            }
            if (stroopidStroop != null) {
                stroopidStroop.getSetpruebasList().add(setpruebas);
                stroopidStroop = em.merge(stroopidStroop);
            }
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring.getSetpruebasList().add(setpruebas);
                toneMonotoringidToneMonotoring = em.merge(toneMonotoringidToneMonotoring);
            }
            for (Prueba pruebaListPrueba : setpruebas.getPruebaList()) {
                Setpruebas oldSetidSetOfPruebaListPrueba = pruebaListPrueba.getSetidSet();
                pruebaListPrueba.setSetidSet(setpruebas);
                pruebaListPrueba = em.merge(pruebaListPrueba);
                if (oldSetidSetOfPruebaListPrueba != null) {
                    oldSetidSetOfPruebaListPrueba.getPruebaList().remove(pruebaListPrueba);
                    oldSetidSetOfPruebaListPrueba = em.merge(oldSetidSetOfPruebaListPrueba);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSetpruebas(setpruebas.getIdSet()) != null) {
                throw new PreexistingEntityException("Setpruebas " + setpruebas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Setpruebas setpruebas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setpruebas persistentSetpruebas = em.find(Setpruebas.class, setpruebas.getIdSet());
            Globallocal globalLocalidGlobalLocalOld = persistentSetpruebas.getGlobalLocalidGlobalLocal();
            Globallocal globalLocalidGlobalLocalNew = setpruebas.getGlobalLocalidGlobalLocal();
            Keeptrack keepTrackidKeepTrackOld = persistentSetpruebas.getKeepTrackidKeepTrack();
            Keeptrack keepTrackidKeepTrackNew = setpruebas.getKeepTrackidKeepTrack();
            Lettermemory letterMemoryidLetterMemoryOld = persistentSetpruebas.getLetterMemoryidLetterMemory();
            Lettermemory letterMemoryidLetterMemoryNew = setpruebas.getLetterMemoryidLetterMemory();
            Numberletter numberLetteridNumberLetterOld = persistentSetpruebas.getNumberLetteridNumberLetter();
            Numberletter numberLetteridNumberLetterNew = setpruebas.getNumberLetteridNumberLetter();
            Plusminus plusMinusidPlusMinusOld = persistentSetpruebas.getPlusMinusidPlusMinus();
            Plusminus plusMinusidPlusMinusNew = setpruebas.getPlusMinusidPlusMinus();
            Simon simonidSimonOld = persistentSetpruebas.getSimonidSimon();
            Simon simonidSimonNew = setpruebas.getSimonidSimon();
            Stopsignal stopSignalidStopSignalOld = persistentSetpruebas.getStopSignalidStopSignal();
            Stopsignal stopSignalidStopSignalNew = setpruebas.getStopSignalidStopSignal();
            Stroop stroopidStroopOld = persistentSetpruebas.getStroopidStroop();
            Stroop stroopidStroopNew = setpruebas.getStroopidStroop();
            Tonemonotoring toneMonotoringidToneMonotoringOld = persistentSetpruebas.getToneMonotoringidToneMonotoring();
            Tonemonotoring toneMonotoringidToneMonotoringNew = setpruebas.getToneMonotoringidToneMonotoring();
            List<Prueba> pruebaListOld = persistentSetpruebas.getPruebaList();
            List<Prueba> pruebaListNew = setpruebas.getPruebaList();
            List<String> illegalOrphanMessages = null;
            for (Prueba pruebaListOldPrueba : pruebaListOld) {
                if (!pruebaListNew.contains(pruebaListOldPrueba)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Prueba " + pruebaListOldPrueba + " since its setidSet field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (globalLocalidGlobalLocalNew != null) {
                globalLocalidGlobalLocalNew = em.getReference(globalLocalidGlobalLocalNew.getClass(), globalLocalidGlobalLocalNew.getIdGlobalLocal());
                setpruebas.setGlobalLocalidGlobalLocal(globalLocalidGlobalLocalNew);
            }
            if (keepTrackidKeepTrackNew != null) {
                keepTrackidKeepTrackNew = em.getReference(keepTrackidKeepTrackNew.getClass(), keepTrackidKeepTrackNew.getIdKeepTrack());
                setpruebas.setKeepTrackidKeepTrack(keepTrackidKeepTrackNew);
            }
            if (letterMemoryidLetterMemoryNew != null) {
                letterMemoryidLetterMemoryNew = em.getReference(letterMemoryidLetterMemoryNew.getClass(), letterMemoryidLetterMemoryNew.getIdLetterMemory());
                setpruebas.setLetterMemoryidLetterMemory(letterMemoryidLetterMemoryNew);
            }
            if (numberLetteridNumberLetterNew != null) {
                numberLetteridNumberLetterNew = em.getReference(numberLetteridNumberLetterNew.getClass(), numberLetteridNumberLetterNew.getIdNumberLetter());
                setpruebas.setNumberLetteridNumberLetter(numberLetteridNumberLetterNew);
            }
            if (plusMinusidPlusMinusNew != null) {
                plusMinusidPlusMinusNew = em.getReference(plusMinusidPlusMinusNew.getClass(), plusMinusidPlusMinusNew.getIdPlusMinus());
                setpruebas.setPlusMinusidPlusMinus(plusMinusidPlusMinusNew);
            }
            if (simonidSimonNew != null) {
                simonidSimonNew = em.getReference(simonidSimonNew.getClass(), simonidSimonNew.getIdSimon());
                setpruebas.setSimonidSimon(simonidSimonNew);
            }
            if (stopSignalidStopSignalNew != null) {
                stopSignalidStopSignalNew = em.getReference(stopSignalidStopSignalNew.getClass(), stopSignalidStopSignalNew.getIdStopSignal());
                setpruebas.setStopSignalidStopSignal(stopSignalidStopSignalNew);
            }
            if (stroopidStroopNew != null) {
                stroopidStroopNew = em.getReference(stroopidStroopNew.getClass(), stroopidStroopNew.getIdStroop());
                setpruebas.setStroopidStroop(stroopidStroopNew);
            }
            if (toneMonotoringidToneMonotoringNew != null) {
                toneMonotoringidToneMonotoringNew = em.getReference(toneMonotoringidToneMonotoringNew.getClass(), toneMonotoringidToneMonotoringNew.getIdToneMonotoring());
                setpruebas.setToneMonotoringidToneMonotoring(toneMonotoringidToneMonotoringNew);
            }
            List<Prueba> attachedPruebaListNew = new ArrayList<Prueba>();
            for (Prueba pruebaListNewPruebaToAttach : pruebaListNew) {
                pruebaListNewPruebaToAttach = em.getReference(pruebaListNewPruebaToAttach.getClass(), pruebaListNewPruebaToAttach.getIdPrueba());
                attachedPruebaListNew.add(pruebaListNewPruebaToAttach);
            }
            pruebaListNew = attachedPruebaListNew;
            setpruebas.setPruebaList(pruebaListNew);
            setpruebas = em.merge(setpruebas);
            if (globalLocalidGlobalLocalOld != null && !globalLocalidGlobalLocalOld.equals(globalLocalidGlobalLocalNew)) {
                globalLocalidGlobalLocalOld.getSetpruebasList().remove(setpruebas);
                globalLocalidGlobalLocalOld = em.merge(globalLocalidGlobalLocalOld);
            }
            if (globalLocalidGlobalLocalNew != null && !globalLocalidGlobalLocalNew.equals(globalLocalidGlobalLocalOld)) {
                globalLocalidGlobalLocalNew.getSetpruebasList().add(setpruebas);
                globalLocalidGlobalLocalNew = em.merge(globalLocalidGlobalLocalNew);
            }
            if (keepTrackidKeepTrackOld != null && !keepTrackidKeepTrackOld.equals(keepTrackidKeepTrackNew)) {
                keepTrackidKeepTrackOld.getSetpruebasList().remove(setpruebas);
                keepTrackidKeepTrackOld = em.merge(keepTrackidKeepTrackOld);
            }
            if (keepTrackidKeepTrackNew != null && !keepTrackidKeepTrackNew.equals(keepTrackidKeepTrackOld)) {
                keepTrackidKeepTrackNew.getSetpruebasList().add(setpruebas);
                keepTrackidKeepTrackNew = em.merge(keepTrackidKeepTrackNew);
            }
            if (letterMemoryidLetterMemoryOld != null && !letterMemoryidLetterMemoryOld.equals(letterMemoryidLetterMemoryNew)) {
                letterMemoryidLetterMemoryOld.getSetpruebasList().remove(setpruebas);
                letterMemoryidLetterMemoryOld = em.merge(letterMemoryidLetterMemoryOld);
            }
            if (letterMemoryidLetterMemoryNew != null && !letterMemoryidLetterMemoryNew.equals(letterMemoryidLetterMemoryOld)) {
                letterMemoryidLetterMemoryNew.getSetpruebasList().add(setpruebas);
                letterMemoryidLetterMemoryNew = em.merge(letterMemoryidLetterMemoryNew);
            }
            if (numberLetteridNumberLetterOld != null && !numberLetteridNumberLetterOld.equals(numberLetteridNumberLetterNew)) {
                numberLetteridNumberLetterOld.getSetpruebasList().remove(setpruebas);
                numberLetteridNumberLetterOld = em.merge(numberLetteridNumberLetterOld);
            }
            if (numberLetteridNumberLetterNew != null && !numberLetteridNumberLetterNew.equals(numberLetteridNumberLetterOld)) {
                numberLetteridNumberLetterNew.getSetpruebasList().add(setpruebas);
                numberLetteridNumberLetterNew = em.merge(numberLetteridNumberLetterNew);
            }
            if (plusMinusidPlusMinusOld != null && !plusMinusidPlusMinusOld.equals(plusMinusidPlusMinusNew)) {
                plusMinusidPlusMinusOld.getSetpruebasList().remove(setpruebas);
                plusMinusidPlusMinusOld = em.merge(plusMinusidPlusMinusOld);
            }
            if (plusMinusidPlusMinusNew != null && !plusMinusidPlusMinusNew.equals(plusMinusidPlusMinusOld)) {
                plusMinusidPlusMinusNew.getSetpruebasList().add(setpruebas);
                plusMinusidPlusMinusNew = em.merge(plusMinusidPlusMinusNew);
            }
            if (simonidSimonOld != null && !simonidSimonOld.equals(simonidSimonNew)) {
                simonidSimonOld.getSetpruebasList().remove(setpruebas);
                simonidSimonOld = em.merge(simonidSimonOld);
            }
            if (simonidSimonNew != null && !simonidSimonNew.equals(simonidSimonOld)) {
                simonidSimonNew.getSetpruebasList().add(setpruebas);
                simonidSimonNew = em.merge(simonidSimonNew);
            }
            if (stopSignalidStopSignalOld != null && !stopSignalidStopSignalOld.equals(stopSignalidStopSignalNew)) {
                stopSignalidStopSignalOld.getSetpruebasList().remove(setpruebas);
                stopSignalidStopSignalOld = em.merge(stopSignalidStopSignalOld);
            }
            if (stopSignalidStopSignalNew != null && !stopSignalidStopSignalNew.equals(stopSignalidStopSignalOld)) {
                stopSignalidStopSignalNew.getSetpruebasList().add(setpruebas);
                stopSignalidStopSignalNew = em.merge(stopSignalidStopSignalNew);
            }
            if (stroopidStroopOld != null && !stroopidStroopOld.equals(stroopidStroopNew)) {
                stroopidStroopOld.getSetpruebasList().remove(setpruebas);
                stroopidStroopOld = em.merge(stroopidStroopOld);
            }
            if (stroopidStroopNew != null && !stroopidStroopNew.equals(stroopidStroopOld)) {
                stroopidStroopNew.getSetpruebasList().add(setpruebas);
                stroopidStroopNew = em.merge(stroopidStroopNew);
            }
            if (toneMonotoringidToneMonotoringOld != null && !toneMonotoringidToneMonotoringOld.equals(toneMonotoringidToneMonotoringNew)) {
                toneMonotoringidToneMonotoringOld.getSetpruebasList().remove(setpruebas);
                toneMonotoringidToneMonotoringOld = em.merge(toneMonotoringidToneMonotoringOld);
            }
            if (toneMonotoringidToneMonotoringNew != null && !toneMonotoringidToneMonotoringNew.equals(toneMonotoringidToneMonotoringOld)) {
                toneMonotoringidToneMonotoringNew.getSetpruebasList().add(setpruebas);
                toneMonotoringidToneMonotoringNew = em.merge(toneMonotoringidToneMonotoringNew);
            }
            for (Prueba pruebaListNewPrueba : pruebaListNew) {
                if (!pruebaListOld.contains(pruebaListNewPrueba)) {
                    Setpruebas oldSetidSetOfPruebaListNewPrueba = pruebaListNewPrueba.getSetidSet();
                    pruebaListNewPrueba.setSetidSet(setpruebas);
                    pruebaListNewPrueba = em.merge(pruebaListNewPrueba);
                    if (oldSetidSetOfPruebaListNewPrueba != null && !oldSetidSetOfPruebaListNewPrueba.equals(setpruebas)) {
                        oldSetidSetOfPruebaListNewPrueba.getPruebaList().remove(pruebaListNewPrueba);
                        oldSetidSetOfPruebaListNewPrueba = em.merge(oldSetidSetOfPruebaListNewPrueba);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = setpruebas.getIdSet();
                if (findSetpruebas(id) == null) {
                    throw new NonexistentEntityException("The setpruebas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setpruebas setpruebas;
            try {
                setpruebas = em.getReference(Setpruebas.class, id);
                setpruebas.getIdSet();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The setpruebas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Prueba> pruebaListOrphanCheck = setpruebas.getPruebaList();
            for (Prueba pruebaListOrphanCheckPrueba : pruebaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setpruebas (" + setpruebas + ") cannot be destroyed since the Prueba " + pruebaListOrphanCheckPrueba + " in its pruebaList field has a non-nullable setidSet field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Globallocal globalLocalidGlobalLocal = setpruebas.getGlobalLocalidGlobalLocal();
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal.getSetpruebasList().remove(setpruebas);
                globalLocalidGlobalLocal = em.merge(globalLocalidGlobalLocal);
            }
            Keeptrack keepTrackidKeepTrack = setpruebas.getKeepTrackidKeepTrack();
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack.getSetpruebasList().remove(setpruebas);
                keepTrackidKeepTrack = em.merge(keepTrackidKeepTrack);
            }
            Lettermemory letterMemoryidLetterMemory = setpruebas.getLetterMemoryidLetterMemory();
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory.getSetpruebasList().remove(setpruebas);
                letterMemoryidLetterMemory = em.merge(letterMemoryidLetterMemory);
            }
            Numberletter numberLetteridNumberLetter = setpruebas.getNumberLetteridNumberLetter();
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter.getSetpruebasList().remove(setpruebas);
                numberLetteridNumberLetter = em.merge(numberLetteridNumberLetter);
            }
            Plusminus plusMinusidPlusMinus = setpruebas.getPlusMinusidPlusMinus();
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus.getSetpruebasList().remove(setpruebas);
                plusMinusidPlusMinus = em.merge(plusMinusidPlusMinus);
            }
            Simon simonidSimon = setpruebas.getSimonidSimon();
            if (simonidSimon != null) {
                simonidSimon.getSetpruebasList().remove(setpruebas);
                simonidSimon = em.merge(simonidSimon);
            }
            Stopsignal stopSignalidStopSignal = setpruebas.getStopSignalidStopSignal();
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal.getSetpruebasList().remove(setpruebas);
                stopSignalidStopSignal = em.merge(stopSignalidStopSignal);
            }
            Stroop stroopidStroop = setpruebas.getStroopidStroop();
            if (stroopidStroop != null) {
                stroopidStroop.getSetpruebasList().remove(setpruebas);
                stroopidStroop = em.merge(stroopidStroop);
            }
            Tonemonotoring toneMonotoringidToneMonotoring = setpruebas.getToneMonotoringidToneMonotoring();
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring.getSetpruebasList().remove(setpruebas);
                toneMonotoringidToneMonotoring = em.merge(toneMonotoringidToneMonotoring);
            }
            em.remove(setpruebas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Setpruebas> findSetpruebasEntities() {
        return findSetpruebasEntities(true, -1, -1);
    }

    public List<Setpruebas> findSetpruebasEntities(int maxResults, int firstResult) {
        return findSetpruebasEntities(false, maxResults, firstResult);
    }

    private List<Setpruebas> findSetpruebasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Setpruebas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Setpruebas findSetpruebas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Setpruebas.class, id);
        } finally {
            em.close();
        }
    }

    public int getSetpruebasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Setpruebas> rt = cq.from(Setpruebas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
