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
import objetosNegocios.Keeptrack;

/**
 *
 * @author David Hermosillo
 */
public class KeeptrackJpaController implements Serializable {

    public KeeptrackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Keeptrack keeptrack) {
        if (keeptrack.getSet1Collection() == null) {
            keeptrack.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : keeptrack.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            keeptrack.setSet1Collection(attachedSet1Collection);
            em.persist(keeptrack);
            for (Set1 set1CollectionSet1 : keeptrack.getSet1Collection()) {
                Keeptrack oldKeepTrackidKeepTrackOfSet1CollectionSet1 = set1CollectionSet1.getKeepTrackidKeepTrack();
                set1CollectionSet1.setKeepTrackidKeepTrack(keeptrack);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldKeepTrackidKeepTrackOfSet1CollectionSet1 != null) {
                    oldKeepTrackidKeepTrackOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldKeepTrackidKeepTrackOfSet1CollectionSet1 = em.merge(oldKeepTrackidKeepTrackOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Keeptrack keeptrack) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Keeptrack persistentKeeptrack = em.find(Keeptrack.class, keeptrack.getIdKeepTrack());
            Collection<Set1> set1CollectionOld = persistentKeeptrack.getSet1Collection();
            Collection<Set1> set1CollectionNew = keeptrack.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its keepTrackidKeepTrack field is not nullable.");
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
            keeptrack.setSet1Collection(set1CollectionNew);
            keeptrack = em.merge(keeptrack);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Keeptrack oldKeepTrackidKeepTrackOfSet1CollectionNewSet1 = set1CollectionNewSet1.getKeepTrackidKeepTrack();
                    set1CollectionNewSet1.setKeepTrackidKeepTrack(keeptrack);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldKeepTrackidKeepTrackOfSet1CollectionNewSet1 != null && !oldKeepTrackidKeepTrackOfSet1CollectionNewSet1.equals(keeptrack)) {
                        oldKeepTrackidKeepTrackOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldKeepTrackidKeepTrackOfSet1CollectionNewSet1 = em.merge(oldKeepTrackidKeepTrackOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = keeptrack.getIdKeepTrack();
                if (findKeeptrack(id) == null) {
                    throw new NonexistentEntityException("The keeptrack with id " + id + " no longer exists.");
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
            Keeptrack keeptrack;
            try {
                keeptrack = em.getReference(Keeptrack.class, id);
                keeptrack.getIdKeepTrack();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The keeptrack with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = keeptrack.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Keeptrack (" + keeptrack + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable keepTrackidKeepTrack field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(keeptrack);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Keeptrack> findKeeptrackEntities() {
        return findKeeptrackEntities(true, -1, -1);
    }

    public List<Keeptrack> findKeeptrackEntities(int maxResults, int firstResult) {
        return findKeeptrackEntities(false, maxResults, firstResult);
    }

    private List<Keeptrack> findKeeptrackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Keeptrack.class));
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

    public Keeptrack findKeeptrack(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Keeptrack.class, id);
        } finally {
            em.close();
        }
    }

    public int getKeeptrackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Keeptrack> rt = cq.from(Keeptrack.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
