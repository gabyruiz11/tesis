/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocios.Set1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocios.Stopsignal;

/**
 *
 * @author David Hermosillo
 */
public class StopsignalJpaController implements Serializable {

    public StopsignalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stopsignal stopsignal) {
        if (stopsignal.getSet1Collection() == null) {
            stopsignal.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : stopsignal.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            stopsignal.setSet1Collection(attachedSet1Collection);
            em.persist(stopsignal);
            for (Set1 set1CollectionSet1 : stopsignal.getSet1Collection()) {
                Stopsignal oldStopSignalidStopSignalOfSet1CollectionSet1 = set1CollectionSet1.getStopSignalidStopSignal();
                set1CollectionSet1.setStopSignalidStopSignal(stopsignal);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldStopSignalidStopSignalOfSet1CollectionSet1 != null) {
                    oldStopSignalidStopSignalOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldStopSignalidStopSignalOfSet1CollectionSet1 = em.merge(oldStopSignalidStopSignalOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stopsignal stopsignal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Stopsignal persistentStopsignal = em.find(Stopsignal.class, stopsignal.getIdStopSignal());
            Collection<Set1> set1CollectionOld = persistentStopsignal.getSet1Collection();
            Collection<Set1> set1CollectionNew = stopsignal.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its stopSignalidStopSignal field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Set1> attachedSet1CollectionNew = new ArrayList<Set1>();
            for (Set1 set1CollectionNewSet1ToAttach : set1CollectionNew) {
                set1CollectionNewSet1ToAttach = em.getReference(set1CollectionNewSet1ToAttach.getClass(), set1CollectionNewSet1ToAttach.getIdSet());
                attachedSet1CollectionNew.add(set1CollectionNewSet1ToAttach);
            }
            set1CollectionNew = attachedSet1CollectionNew;
            stopsignal.setSet1Collection(set1CollectionNew);
            stopsignal = em.merge(stopsignal);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Stopsignal oldStopSignalidStopSignalOfSet1CollectionNewSet1 = set1CollectionNewSet1.getStopSignalidStopSignal();
                    set1CollectionNewSet1.setStopSignalidStopSignal(stopsignal);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldStopSignalidStopSignalOfSet1CollectionNewSet1 != null && !oldStopSignalidStopSignalOfSet1CollectionNewSet1.equals(stopsignal)) {
                        oldStopSignalidStopSignalOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldStopSignalidStopSignalOfSet1CollectionNewSet1 = em.merge(oldStopSignalidStopSignalOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stopsignal.getIdStopSignal();
                if (findStopsignal(id) == null) {
                    throw new NonexistentEntityException("The stopsignal with id " + id + " no longer exists.");
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
            Stopsignal stopsignal;
            try {
                stopsignal = em.getReference(Stopsignal.class, id);
                stopsignal.getIdStopSignal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stopsignal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = stopsignal.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Stopsignal (" + stopsignal + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable stopSignalidStopSignal field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(stopsignal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stopsignal> findStopsignalEntities() {
        return findStopsignalEntities(true, -1, -1);
    }

    public List<Stopsignal> findStopsignalEntities(int maxResults, int firstResult) {
        return findStopsignalEntities(false, maxResults, firstResult);
    }

    private List<Stopsignal> findStopsignalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stopsignal.class));
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

    public Stopsignal findStopsignal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stopsignal.class, id);
        } finally {
            em.close();
        }
    }

    public int getStopsignalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stopsignal> rt = cq.from(Stopsignal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
