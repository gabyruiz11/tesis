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
import objetosNegocios.Tonemonotoring;

/**
 *
 * @author David Hermosillo
 */
public class TonemonotoringJpaController implements Serializable {

    public TonemonotoringJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tonemonotoring tonemonotoring) {
        if (tonemonotoring.getSet1Collection() == null) {
            tonemonotoring.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : tonemonotoring.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            tonemonotoring.setSet1Collection(attachedSet1Collection);
            em.persist(tonemonotoring);
            for (Set1 set1CollectionSet1 : tonemonotoring.getSet1Collection()) {
                Tonemonotoring oldToneMonotoringidToneMonotoringOfSet1CollectionSet1 = set1CollectionSet1.getToneMonotoringidToneMonotoring();
                set1CollectionSet1.setToneMonotoringidToneMonotoring(tonemonotoring);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldToneMonotoringidToneMonotoringOfSet1CollectionSet1 != null) {
                    oldToneMonotoringidToneMonotoringOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldToneMonotoringidToneMonotoringOfSet1CollectionSet1 = em.merge(oldToneMonotoringidToneMonotoringOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tonemonotoring tonemonotoring) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tonemonotoring persistentTonemonotoring = em.find(Tonemonotoring.class, tonemonotoring.getIdToneMonotoring());
            Collection<Set1> set1CollectionOld = persistentTonemonotoring.getSet1Collection();
            Collection<Set1> set1CollectionNew = tonemonotoring.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its toneMonotoringidToneMonotoring field is not nullable.");
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
            tonemonotoring.setSet1Collection(set1CollectionNew);
            tonemonotoring = em.merge(tonemonotoring);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Tonemonotoring oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1 = set1CollectionNewSet1.getToneMonotoringidToneMonotoring();
                    set1CollectionNewSet1.setToneMonotoringidToneMonotoring(tonemonotoring);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1 != null && !oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1.equals(tonemonotoring)) {
                        oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1 = em.merge(oldToneMonotoringidToneMonotoringOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tonemonotoring.getIdToneMonotoring();
                if (findTonemonotoring(id) == null) {
                    throw new NonexistentEntityException("The tonemonotoring with id " + id + " no longer exists.");
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
            Tonemonotoring tonemonotoring;
            try {
                tonemonotoring = em.getReference(Tonemonotoring.class, id);
                tonemonotoring.getIdToneMonotoring();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tonemonotoring with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = tonemonotoring.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tonemonotoring (" + tonemonotoring + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable toneMonotoringidToneMonotoring field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tonemonotoring);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tonemonotoring> findTonemonotoringEntities() {
        return findTonemonotoringEntities(true, -1, -1);
    }

    public List<Tonemonotoring> findTonemonotoringEntities(int maxResults, int firstResult) {
        return findTonemonotoringEntities(false, maxResults, firstResult);
    }

    private List<Tonemonotoring> findTonemonotoringEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tonemonotoring.class));
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

    public Tonemonotoring findTonemonotoring(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tonemonotoring.class, id);
        } finally {
            em.close();
        }
    }

    public int getTonemonotoringCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tonemonotoring> rt = cq.from(Tonemonotoring.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
