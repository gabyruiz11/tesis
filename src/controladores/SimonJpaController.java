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
import objetosNegocios.Set1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocios.Simon;

/**
 *
 * @author David Hermosillo
 */
public class SimonJpaController implements Serializable {

    public SimonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Simon simon) throws PreexistingEntityException, Exception {
        if (simon.getSet1Collection() == null) {
            simon.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : simon.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            simon.setSet1Collection(attachedSet1Collection);
            em.persist(simon);
            for (Set1 set1CollectionSet1 : simon.getSet1Collection()) {
                Simon oldSimonidSimonOfSet1CollectionSet1 = set1CollectionSet1.getSimonidSimon();
                set1CollectionSet1.setSimonidSimon(simon);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldSimonidSimonOfSet1CollectionSet1 != null) {
                    oldSimonidSimonOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldSimonidSimonOfSet1CollectionSet1 = em.merge(oldSimonidSimonOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSimon(simon.getIdSimon()) != null) {
                throw new PreexistingEntityException("Simon " + simon + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Simon simon) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Simon persistentSimon = em.find(Simon.class, simon.getIdSimon());
            Collection<Set1> set1CollectionOld = persistentSimon.getSet1Collection();
            Collection<Set1> set1CollectionNew = simon.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its simonidSimon field is not nullable.");
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
            simon.setSet1Collection(set1CollectionNew);
            simon = em.merge(simon);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Simon oldSimonidSimonOfSet1CollectionNewSet1 = set1CollectionNewSet1.getSimonidSimon();
                    set1CollectionNewSet1.setSimonidSimon(simon);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldSimonidSimonOfSet1CollectionNewSet1 != null && !oldSimonidSimonOfSet1CollectionNewSet1.equals(simon)) {
                        oldSimonidSimonOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldSimonidSimonOfSet1CollectionNewSet1 = em.merge(oldSimonidSimonOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = simon.getIdSimon();
                if (findSimon(id) == null) {
                    throw new NonexistentEntityException("The simon with id " + id + " no longer exists.");
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
            Simon simon;
            try {
                simon = em.getReference(Simon.class, id);
                simon.getIdSimon();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The simon with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = simon.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Simon (" + simon + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable simonidSimon field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(simon);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Simon> findSimonEntities() {
        return findSimonEntities(true, -1, -1);
    }

    public List<Simon> findSimonEntities(int maxResults, int firstResult) {
        return findSimonEntities(false, maxResults, firstResult);
    }

    private List<Simon> findSimonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Simon.class));
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

    public Simon findSimon(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Simon.class, id);
        } finally {
            em.close();
        }
    }

    public int getSimonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Simon> rt = cq.from(Simon.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
