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
import objetosNegocios.Globallocal;
import objetosNegocios.Keeptrack;
import objetosNegocios.Lettermemory;
import objetosNegocios.Numberletter;
import objetosNegocios.Plusminus;
import objetosNegocios.Simon;
import objetosNegocios.Stopsignal;
import objetosNegocios.Stroop;
import objetosNegocios.Tonemonotoring;
import objetosNegocios.Prueba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocios.Set1;

/**
 *
 * @author David Hermosillo
 */
public class Set1JpaController implements Serializable {

    public Set1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Set1 set1) throws PreexistingEntityException, Exception {
        if (set1.getPruebaCollection() == null) {
            set1.setPruebaCollection(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Globallocal globalLocalidGlobalLocal = set1.getGlobalLocalidGlobalLocal();
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal = em.getReference(globalLocalidGlobalLocal.getClass(), globalLocalidGlobalLocal.getIdGlobalLocal());
                set1.setGlobalLocalidGlobalLocal(globalLocalidGlobalLocal);
            }
            Keeptrack keepTrackidKeepTrack = set1.getKeepTrackidKeepTrack();
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack = em.getReference(keepTrackidKeepTrack.getClass(), keepTrackidKeepTrack.getIdKeepTrack());
                set1.setKeepTrackidKeepTrack(keepTrackidKeepTrack);
            }
            Lettermemory letterMemoryidLetterMemory = set1.getLetterMemoryidLetterMemory();
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory = em.getReference(letterMemoryidLetterMemory.getClass(), letterMemoryidLetterMemory.getIdLetterMemory());
                set1.setLetterMemoryidLetterMemory(letterMemoryidLetterMemory);
            }
            Numberletter numberLetteridNumberLetter = set1.getNumberLetteridNumberLetter();
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter = em.getReference(numberLetteridNumberLetter.getClass(), numberLetteridNumberLetter.getIdNumberLetter());
                set1.setNumberLetteridNumberLetter(numberLetteridNumberLetter);
            }
            Plusminus plusMinusidPlusMinus = set1.getPlusMinusidPlusMinus();
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus = em.getReference(plusMinusidPlusMinus.getClass(), plusMinusidPlusMinus.getIdPlusMinus());
                set1.setPlusMinusidPlusMinus(plusMinusidPlusMinus);
            }
            Simon simonidSimon = set1.getSimonidSimon();
            if (simonidSimon != null) {
                simonidSimon = em.getReference(simonidSimon.getClass(), simonidSimon.getIdSimon());
                set1.setSimonidSimon(simonidSimon);
            }
            Stopsignal stopSignalidStopSignal = set1.getStopSignalidStopSignal();
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal = em.getReference(stopSignalidStopSignal.getClass(), stopSignalidStopSignal.getIdStopSignal());
                set1.setStopSignalidStopSignal(stopSignalidStopSignal);
            }
            Stroop stroopidStroop = set1.getStroopidStroop();
            if (stroopidStroop != null) {
                stroopidStroop = em.getReference(stroopidStroop.getClass(), stroopidStroop.getIdStroop());
                set1.setStroopidStroop(stroopidStroop);
            }
            Tonemonotoring toneMonotoringidToneMonotoring = set1.getToneMonotoringidToneMonotoring();
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring = em.getReference(toneMonotoringidToneMonotoring.getClass(), toneMonotoringidToneMonotoring.getIdToneMonotoring());
                set1.setToneMonotoringidToneMonotoring(toneMonotoringidToneMonotoring);
            }
            Collection<Prueba> attachedPruebaCollection = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionPruebaToAttach : set1.getPruebaCollection()) {
                pruebaCollectionPruebaToAttach = em.getReference(pruebaCollectionPruebaToAttach.getClass(), pruebaCollectionPruebaToAttach.getIdPrueba());
                attachedPruebaCollection.add(pruebaCollectionPruebaToAttach);
            }
            set1.setPruebaCollection(attachedPruebaCollection);
            em.persist(set1);
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal.getSet1Collection().add(set1);
                globalLocalidGlobalLocal = em.merge(globalLocalidGlobalLocal);
            }
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack.getSet1Collection().add(set1);
                keepTrackidKeepTrack = em.merge(keepTrackidKeepTrack);
            }
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory.getSet1Collection().add(set1);
                letterMemoryidLetterMemory = em.merge(letterMemoryidLetterMemory);
            }
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter.getSet1Collection().add(set1);
                numberLetteridNumberLetter = em.merge(numberLetteridNumberLetter);
            }
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus.getSet1Collection().add(set1);
                plusMinusidPlusMinus = em.merge(plusMinusidPlusMinus);
            }
            if (simonidSimon != null) {
                simonidSimon.getSet1Collection().add(set1);
                simonidSimon = em.merge(simonidSimon);
            }
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal.getSet1Collection().add(set1);
                stopSignalidStopSignal = em.merge(stopSignalidStopSignal);
            }
            if (stroopidStroop != null) {
                stroopidStroop.getSet1Collection().add(set1);
                stroopidStroop = em.merge(stroopidStroop);
            }
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring.getSet1Collection().add(set1);
                toneMonotoringidToneMonotoring = em.merge(toneMonotoringidToneMonotoring);
            }
            for (Prueba pruebaCollectionPrueba : set1.getPruebaCollection()) {
                Set1 oldSetidSetOfPruebaCollectionPrueba = pruebaCollectionPrueba.getSetidSet();
                pruebaCollectionPrueba.setSetidSet(set1);
                pruebaCollectionPrueba = em.merge(pruebaCollectionPrueba);
                if (oldSetidSetOfPruebaCollectionPrueba != null) {
                    oldSetidSetOfPruebaCollectionPrueba.getPruebaCollection().remove(pruebaCollectionPrueba);
                    oldSetidSetOfPruebaCollectionPrueba = em.merge(oldSetidSetOfPruebaCollectionPrueba);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSet1(set1.getIdSet()) != null) {
                throw new PreexistingEntityException("Set1 " + set1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Set1 set1) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set1 persistentSet1 = em.find(Set1.class, set1.getIdSet());
            Globallocal globalLocalidGlobalLocalOld = persistentSet1.getGlobalLocalidGlobalLocal();
            Globallocal globalLocalidGlobalLocalNew = set1.getGlobalLocalidGlobalLocal();
            Keeptrack keepTrackidKeepTrackOld = persistentSet1.getKeepTrackidKeepTrack();
            Keeptrack keepTrackidKeepTrackNew = set1.getKeepTrackidKeepTrack();
            Lettermemory letterMemoryidLetterMemoryOld = persistentSet1.getLetterMemoryidLetterMemory();
            Lettermemory letterMemoryidLetterMemoryNew = set1.getLetterMemoryidLetterMemory();
            Numberletter numberLetteridNumberLetterOld = persistentSet1.getNumberLetteridNumberLetter();
            Numberletter numberLetteridNumberLetterNew = set1.getNumberLetteridNumberLetter();
            Plusminus plusMinusidPlusMinusOld = persistentSet1.getPlusMinusidPlusMinus();
            Plusminus plusMinusidPlusMinusNew = set1.getPlusMinusidPlusMinus();
            Simon simonidSimonOld = persistentSet1.getSimonidSimon();
            Simon simonidSimonNew = set1.getSimonidSimon();
            Stopsignal stopSignalidStopSignalOld = persistentSet1.getStopSignalidStopSignal();
            Stopsignal stopSignalidStopSignalNew = set1.getStopSignalidStopSignal();
            Stroop stroopidStroopOld = persistentSet1.getStroopidStroop();
            Stroop stroopidStroopNew = set1.getStroopidStroop();
            Tonemonotoring toneMonotoringidToneMonotoringOld = persistentSet1.getToneMonotoringidToneMonotoring();
            Tonemonotoring toneMonotoringidToneMonotoringNew = set1.getToneMonotoringidToneMonotoring();
            Collection<Prueba> pruebaCollectionOld = persistentSet1.getPruebaCollection();
            Collection<Prueba> pruebaCollectionNew = set1.getPruebaCollection();
            List<String> illegalOrphanMessages = null;
            for (Prueba pruebaCollectionOldPrueba : pruebaCollectionOld) {
                if (!pruebaCollectionNew.contains(pruebaCollectionOldPrueba)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Prueba " + pruebaCollectionOldPrueba + " since its setidSet field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (globalLocalidGlobalLocalNew != null) {
                globalLocalidGlobalLocalNew = em.getReference(globalLocalidGlobalLocalNew.getClass(), globalLocalidGlobalLocalNew.getIdGlobalLocal());
                set1.setGlobalLocalidGlobalLocal(globalLocalidGlobalLocalNew);
            }
            if (keepTrackidKeepTrackNew != null) {
                keepTrackidKeepTrackNew = em.getReference(keepTrackidKeepTrackNew.getClass(), keepTrackidKeepTrackNew.getIdKeepTrack());
                set1.setKeepTrackidKeepTrack(keepTrackidKeepTrackNew);
            }
            if (letterMemoryidLetterMemoryNew != null) {
                letterMemoryidLetterMemoryNew = em.getReference(letterMemoryidLetterMemoryNew.getClass(), letterMemoryidLetterMemoryNew.getIdLetterMemory());
                set1.setLetterMemoryidLetterMemory(letterMemoryidLetterMemoryNew);
            }
            if (numberLetteridNumberLetterNew != null) {
                numberLetteridNumberLetterNew = em.getReference(numberLetteridNumberLetterNew.getClass(), numberLetteridNumberLetterNew.getIdNumberLetter());
                set1.setNumberLetteridNumberLetter(numberLetteridNumberLetterNew);
            }
            if (plusMinusidPlusMinusNew != null) {
                plusMinusidPlusMinusNew = em.getReference(plusMinusidPlusMinusNew.getClass(), plusMinusidPlusMinusNew.getIdPlusMinus());
                set1.setPlusMinusidPlusMinus(plusMinusidPlusMinusNew);
            }
            if (simonidSimonNew != null) {
                simonidSimonNew = em.getReference(simonidSimonNew.getClass(), simonidSimonNew.getIdSimon());
                set1.setSimonidSimon(simonidSimonNew);
            }
            if (stopSignalidStopSignalNew != null) {
                stopSignalidStopSignalNew = em.getReference(stopSignalidStopSignalNew.getClass(), stopSignalidStopSignalNew.getIdStopSignal());
                set1.setStopSignalidStopSignal(stopSignalidStopSignalNew);
            }
            if (stroopidStroopNew != null) {
                stroopidStroopNew = em.getReference(stroopidStroopNew.getClass(), stroopidStroopNew.getIdStroop());
                set1.setStroopidStroop(stroopidStroopNew);
            }
            if (toneMonotoringidToneMonotoringNew != null) {
                toneMonotoringidToneMonotoringNew = em.getReference(toneMonotoringidToneMonotoringNew.getClass(), toneMonotoringidToneMonotoringNew.getIdToneMonotoring());
                set1.setToneMonotoringidToneMonotoring(toneMonotoringidToneMonotoringNew);
            }
            Collection<Prueba> attachedPruebaCollectionNew = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionNewPruebaToAttach : pruebaCollectionNew) {
                pruebaCollectionNewPruebaToAttach = em.getReference(pruebaCollectionNewPruebaToAttach.getClass(), pruebaCollectionNewPruebaToAttach.getIdPrueba());
                attachedPruebaCollectionNew.add(pruebaCollectionNewPruebaToAttach);
            }
            pruebaCollectionNew = attachedPruebaCollectionNew;
            set1.setPruebaCollection(pruebaCollectionNew);
            set1 = em.merge(set1);
            if (globalLocalidGlobalLocalOld != null && !globalLocalidGlobalLocalOld.equals(globalLocalidGlobalLocalNew)) {
                globalLocalidGlobalLocalOld.getSet1Collection().remove(set1);
                globalLocalidGlobalLocalOld = em.merge(globalLocalidGlobalLocalOld);
            }
            if (globalLocalidGlobalLocalNew != null && !globalLocalidGlobalLocalNew.equals(globalLocalidGlobalLocalOld)) {
                globalLocalidGlobalLocalNew.getSet1Collection().add(set1);
                globalLocalidGlobalLocalNew = em.merge(globalLocalidGlobalLocalNew);
            }
            if (keepTrackidKeepTrackOld != null && !keepTrackidKeepTrackOld.equals(keepTrackidKeepTrackNew)) {
                keepTrackidKeepTrackOld.getSet1Collection().remove(set1);
                keepTrackidKeepTrackOld = em.merge(keepTrackidKeepTrackOld);
            }
            if (keepTrackidKeepTrackNew != null && !keepTrackidKeepTrackNew.equals(keepTrackidKeepTrackOld)) {
                keepTrackidKeepTrackNew.getSet1Collection().add(set1);
                keepTrackidKeepTrackNew = em.merge(keepTrackidKeepTrackNew);
            }
            if (letterMemoryidLetterMemoryOld != null && !letterMemoryidLetterMemoryOld.equals(letterMemoryidLetterMemoryNew)) {
                letterMemoryidLetterMemoryOld.getSet1Collection().remove(set1);
                letterMemoryidLetterMemoryOld = em.merge(letterMemoryidLetterMemoryOld);
            }
            if (letterMemoryidLetterMemoryNew != null && !letterMemoryidLetterMemoryNew.equals(letterMemoryidLetterMemoryOld)) {
                letterMemoryidLetterMemoryNew.getSet1Collection().add(set1);
                letterMemoryidLetterMemoryNew = em.merge(letterMemoryidLetterMemoryNew);
            }
            if (numberLetteridNumberLetterOld != null && !numberLetteridNumberLetterOld.equals(numberLetteridNumberLetterNew)) {
                numberLetteridNumberLetterOld.getSet1Collection().remove(set1);
                numberLetteridNumberLetterOld = em.merge(numberLetteridNumberLetterOld);
            }
            if (numberLetteridNumberLetterNew != null && !numberLetteridNumberLetterNew.equals(numberLetteridNumberLetterOld)) {
                numberLetteridNumberLetterNew.getSet1Collection().add(set1);
                numberLetteridNumberLetterNew = em.merge(numberLetteridNumberLetterNew);
            }
            if (plusMinusidPlusMinusOld != null && !plusMinusidPlusMinusOld.equals(plusMinusidPlusMinusNew)) {
                plusMinusidPlusMinusOld.getSet1Collection().remove(set1);
                plusMinusidPlusMinusOld = em.merge(plusMinusidPlusMinusOld);
            }
            if (plusMinusidPlusMinusNew != null && !plusMinusidPlusMinusNew.equals(plusMinusidPlusMinusOld)) {
                plusMinusidPlusMinusNew.getSet1Collection().add(set1);
                plusMinusidPlusMinusNew = em.merge(plusMinusidPlusMinusNew);
            }
            if (simonidSimonOld != null && !simonidSimonOld.equals(simonidSimonNew)) {
                simonidSimonOld.getSet1Collection().remove(set1);
                simonidSimonOld = em.merge(simonidSimonOld);
            }
            if (simonidSimonNew != null && !simonidSimonNew.equals(simonidSimonOld)) {
                simonidSimonNew.getSet1Collection().add(set1);
                simonidSimonNew = em.merge(simonidSimonNew);
            }
            if (stopSignalidStopSignalOld != null && !stopSignalidStopSignalOld.equals(stopSignalidStopSignalNew)) {
                stopSignalidStopSignalOld.getSet1Collection().remove(set1);
                stopSignalidStopSignalOld = em.merge(stopSignalidStopSignalOld);
            }
            if (stopSignalidStopSignalNew != null && !stopSignalidStopSignalNew.equals(stopSignalidStopSignalOld)) {
                stopSignalidStopSignalNew.getSet1Collection().add(set1);
                stopSignalidStopSignalNew = em.merge(stopSignalidStopSignalNew);
            }
            if (stroopidStroopOld != null && !stroopidStroopOld.equals(stroopidStroopNew)) {
                stroopidStroopOld.getSet1Collection().remove(set1);
                stroopidStroopOld = em.merge(stroopidStroopOld);
            }
            if (stroopidStroopNew != null && !stroopidStroopNew.equals(stroopidStroopOld)) {
                stroopidStroopNew.getSet1Collection().add(set1);
                stroopidStroopNew = em.merge(stroopidStroopNew);
            }
            if (toneMonotoringidToneMonotoringOld != null && !toneMonotoringidToneMonotoringOld.equals(toneMonotoringidToneMonotoringNew)) {
                toneMonotoringidToneMonotoringOld.getSet1Collection().remove(set1);
                toneMonotoringidToneMonotoringOld = em.merge(toneMonotoringidToneMonotoringOld);
            }
            if (toneMonotoringidToneMonotoringNew != null && !toneMonotoringidToneMonotoringNew.equals(toneMonotoringidToneMonotoringOld)) {
                toneMonotoringidToneMonotoringNew.getSet1Collection().add(set1);
                toneMonotoringidToneMonotoringNew = em.merge(toneMonotoringidToneMonotoringNew);
            }
            for (Prueba pruebaCollectionNewPrueba : pruebaCollectionNew) {
                if (!pruebaCollectionOld.contains(pruebaCollectionNewPrueba)) {
                    Set1 oldSetidSetOfPruebaCollectionNewPrueba = pruebaCollectionNewPrueba.getSetidSet();
                    pruebaCollectionNewPrueba.setSetidSet(set1);
                    pruebaCollectionNewPrueba = em.merge(pruebaCollectionNewPrueba);
                    if (oldSetidSetOfPruebaCollectionNewPrueba != null && !oldSetidSetOfPruebaCollectionNewPrueba.equals(set1)) {
                        oldSetidSetOfPruebaCollectionNewPrueba.getPruebaCollection().remove(pruebaCollectionNewPrueba);
                        oldSetidSetOfPruebaCollectionNewPrueba = em.merge(oldSetidSetOfPruebaCollectionNewPrueba);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = set1.getIdSet();
                if (findSet1(id) == null) {
                    throw new NonexistentEntityException("The set1 with id " + id + " no longer exists.");
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
            Set1 set1;
            try {
                set1 = em.getReference(Set1.class, id);
                set1.getIdSet();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The set1 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Prueba> pruebaCollectionOrphanCheck = set1.getPruebaCollection();
            for (Prueba pruebaCollectionOrphanCheckPrueba : pruebaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Set1 (" + set1 + ") cannot be destroyed since the Prueba " + pruebaCollectionOrphanCheckPrueba + " in its pruebaCollection field has a non-nullable setidSet field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Globallocal globalLocalidGlobalLocal = set1.getGlobalLocalidGlobalLocal();
            if (globalLocalidGlobalLocal != null) {
                globalLocalidGlobalLocal.getSet1Collection().remove(set1);
                globalLocalidGlobalLocal = em.merge(globalLocalidGlobalLocal);
            }
            Keeptrack keepTrackidKeepTrack = set1.getKeepTrackidKeepTrack();
            if (keepTrackidKeepTrack != null) {
                keepTrackidKeepTrack.getSet1Collection().remove(set1);
                keepTrackidKeepTrack = em.merge(keepTrackidKeepTrack);
            }
            Lettermemory letterMemoryidLetterMemory = set1.getLetterMemoryidLetterMemory();
            if (letterMemoryidLetterMemory != null) {
                letterMemoryidLetterMemory.getSet1Collection().remove(set1);
                letterMemoryidLetterMemory = em.merge(letterMemoryidLetterMemory);
            }
            Numberletter numberLetteridNumberLetter = set1.getNumberLetteridNumberLetter();
            if (numberLetteridNumberLetter != null) {
                numberLetteridNumberLetter.getSet1Collection().remove(set1);
                numberLetteridNumberLetter = em.merge(numberLetteridNumberLetter);
            }
            Plusminus plusMinusidPlusMinus = set1.getPlusMinusidPlusMinus();
            if (plusMinusidPlusMinus != null) {
                plusMinusidPlusMinus.getSet1Collection().remove(set1);
                plusMinusidPlusMinus = em.merge(plusMinusidPlusMinus);
            }
            Simon simonidSimon = set1.getSimonidSimon();
            if (simonidSimon != null) {
                simonidSimon.getSet1Collection().remove(set1);
                simonidSimon = em.merge(simonidSimon);
            }
            Stopsignal stopSignalidStopSignal = set1.getStopSignalidStopSignal();
            if (stopSignalidStopSignal != null) {
                stopSignalidStopSignal.getSet1Collection().remove(set1);
                stopSignalidStopSignal = em.merge(stopSignalidStopSignal);
            }
            Stroop stroopidStroop = set1.getStroopidStroop();
            if (stroopidStroop != null) {
                stroopidStroop.getSet1Collection().remove(set1);
                stroopidStroop = em.merge(stroopidStroop);
            }
            Tonemonotoring toneMonotoringidToneMonotoring = set1.getToneMonotoringidToneMonotoring();
            if (toneMonotoringidToneMonotoring != null) {
                toneMonotoringidToneMonotoring.getSet1Collection().remove(set1);
                toneMonotoringidToneMonotoring = em.merge(toneMonotoringidToneMonotoring);
            }
            em.remove(set1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Set1> findSet1Entities() {
        return findSet1Entities(true, -1, -1);
    }

    public List<Set1> findSet1Entities(int maxResults, int firstResult) {
        return findSet1Entities(false, maxResults, firstResult);
    }

    private List<Set1> findSet1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Set1.class));
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

    public Set1 findSet1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Set1.class, id);
        } finally {
            em.close();
        }
    }

    public int getSet1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Set1> rt = cq.from(Set1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
