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
import objetosNegocios.Stroop;

/**
 *
 * @author David Hermosillo
 */
public class StroopJpaController implements Serializable {

    public StroopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stroop stroop) {
        if (stroop.getSet1Collection() == null) {
            stroop.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : stroop.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            stroop.setSet1Collection(attachedSet1Collection);
            em.persist(stroop);
            for (Set1 set1CollectionSet1 : stroop.getSet1Collection()) {
                Stroop oldStroopidStroopOfSet1CollectionSet1 = set1CollectionSet1.getStroopidStroop();
                set1CollectionSet1.setStroopidStroop(stroop);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldStroopidStroopOfSet1CollectionSet1 != null) {
                    oldStroopidStroopOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldStroopidStroopOfSet1CollectionSet1 = em.merge(oldStroopidStroopOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stroop stroop) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Stroop persistentStroop = em.find(Stroop.class, stroop.getIdStroop());
            Collection<Set1> set1CollectionOld = persistentStroop.getSet1Collection();
            Collection<Set1> set1CollectionNew = stroop.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its stroopidStroop field is not nullable.");
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
            stroop.setSet1Collection(set1CollectionNew);
            stroop = em.merge(stroop);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Stroop oldStroopidStroopOfSet1CollectionNewSet1 = set1CollectionNewSet1.getStroopidStroop();
                    set1CollectionNewSet1.setStroopidStroop(stroop);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldStroopidStroopOfSet1CollectionNewSet1 != null && !oldStroopidStroopOfSet1CollectionNewSet1.equals(stroop)) {
                        oldStroopidStroopOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldStroopidStroopOfSet1CollectionNewSet1 = em.merge(oldStroopidStroopOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stroop.getIdStroop();
                if (findStroop(id) == null) {
                    throw new NonexistentEntityException("The stroop with id " + id + " no longer exists.");
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
            Stroop stroop;
            try {
                stroop = em.getReference(Stroop.class, id);
                stroop.getIdStroop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stroop with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = stroop.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Stroop (" + stroop + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable stroopidStroop field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(stroop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stroop> findStroopEntities() {
        return findStroopEntities(true, -1, -1);
    }

    public List<Stroop> findStroopEntities(int maxResults, int firstResult) {
        return findStroopEntities(false, maxResults, firstResult);
    }

    private List<Stroop> findStroopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stroop.class));
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

    public Stroop findStroop(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stroop.class, id);
        } finally {
            em.close();
        }
    }

    public int getStroopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stroop> rt = cq.from(Stroop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
