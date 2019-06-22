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
import objetosNegocios.Numberletter;

/**
 *
 * @author David Hermosillo
 */
public class NumberletterJpaController implements Serializable {

    public NumberletterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Numberletter numberletter) throws PreexistingEntityException, Exception {
        if (numberletter.getSet1Collection() == null) {
            numberletter.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : numberletter.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            numberletter.setSet1Collection(attachedSet1Collection);
            em.persist(numberletter);
            for (Set1 set1CollectionSet1 : numberletter.getSet1Collection()) {
                Numberletter oldNumberLetteridNumberLetterOfSet1CollectionSet1 = set1CollectionSet1.getNumberLetteridNumberLetter();
                set1CollectionSet1.setNumberLetteridNumberLetter(numberletter);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldNumberLetteridNumberLetterOfSet1CollectionSet1 != null) {
                    oldNumberLetteridNumberLetterOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldNumberLetteridNumberLetterOfSet1CollectionSet1 = em.merge(oldNumberLetteridNumberLetterOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNumberletter(numberletter.getIdNumberLetter()) != null) {
                throw new PreexistingEntityException("Numberletter " + numberletter + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Numberletter numberletter) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Numberletter persistentNumberletter = em.find(Numberletter.class, numberletter.getIdNumberLetter());
            Collection<Set1> set1CollectionOld = persistentNumberletter.getSet1Collection();
            Collection<Set1> set1CollectionNew = numberletter.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its numberLetteridNumberLetter field is not nullable.");
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
            numberletter.setSet1Collection(set1CollectionNew);
            numberletter = em.merge(numberletter);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Numberletter oldNumberLetteridNumberLetterOfSet1CollectionNewSet1 = set1CollectionNewSet1.getNumberLetteridNumberLetter();
                    set1CollectionNewSet1.setNumberLetteridNumberLetter(numberletter);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldNumberLetteridNumberLetterOfSet1CollectionNewSet1 != null && !oldNumberLetteridNumberLetterOfSet1CollectionNewSet1.equals(numberletter)) {
                        oldNumberLetteridNumberLetterOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldNumberLetteridNumberLetterOfSet1CollectionNewSet1 = em.merge(oldNumberLetteridNumberLetterOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = numberletter.getIdNumberLetter();
                if (findNumberletter(id) == null) {
                    throw new NonexistentEntityException("The numberletter with id " + id + " no longer exists.");
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
            Numberletter numberletter;
            try {
                numberletter = em.getReference(Numberletter.class, id);
                numberletter.getIdNumberLetter();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The numberletter with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = numberletter.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Numberletter (" + numberletter + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable numberLetteridNumberLetter field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(numberletter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Numberletter> findNumberletterEntities() {
        return findNumberletterEntities(true, -1, -1);
    }

    public List<Numberletter> findNumberletterEntities(int maxResults, int firstResult) {
        return findNumberletterEntities(false, maxResults, firstResult);
    }

    private List<Numberletter> findNumberletterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Numberletter.class));
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

    public Numberletter findNumberletter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Numberletter.class, id);
        } finally {
            em.close();
        }
    }

    public int getNumberletterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Numberletter> rt = cq.from(Numberletter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
