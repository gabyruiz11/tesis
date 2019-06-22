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
import objetosNegocios.Lettermemory;

/**
 *
 * @author David Hermosillo
 */
public class LettermemoryJpaController implements Serializable {

    public LettermemoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lettermemory lettermemory) {
        if (lettermemory.getSet1Collection() == null) {
            lettermemory.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : lettermemory.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            lettermemory.setSet1Collection(attachedSet1Collection);
            em.persist(lettermemory);
            for (Set1 set1CollectionSet1 : lettermemory.getSet1Collection()) {
                Lettermemory oldLetterMemoryidLetterMemoryOfSet1CollectionSet1 = set1CollectionSet1.getLetterMemoryidLetterMemory();
                set1CollectionSet1.setLetterMemoryidLetterMemory(lettermemory);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldLetterMemoryidLetterMemoryOfSet1CollectionSet1 != null) {
                    oldLetterMemoryidLetterMemoryOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldLetterMemoryidLetterMemoryOfSet1CollectionSet1 = em.merge(oldLetterMemoryidLetterMemoryOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lettermemory lettermemory) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lettermemory persistentLettermemory = em.find(Lettermemory.class, lettermemory.getIdLetterMemory());
            Collection<Set1> set1CollectionOld = persistentLettermemory.getSet1Collection();
            Collection<Set1> set1CollectionNew = lettermemory.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its letterMemoryidLetterMemory field is not nullable.");
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
            lettermemory.setSet1Collection(set1CollectionNew);
            lettermemory = em.merge(lettermemory);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Lettermemory oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1 = set1CollectionNewSet1.getLetterMemoryidLetterMemory();
                    set1CollectionNewSet1.setLetterMemoryidLetterMemory(lettermemory);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1 != null && !oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1.equals(lettermemory)) {
                        oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1 = em.merge(oldLetterMemoryidLetterMemoryOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lettermemory.getIdLetterMemory();
                if (findLettermemory(id) == null) {
                    throw new NonexistentEntityException("The lettermemory with id " + id + " no longer exists.");
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
            Lettermemory lettermemory;
            try {
                lettermemory = em.getReference(Lettermemory.class, id);
                lettermemory.getIdLetterMemory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lettermemory with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = lettermemory.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Lettermemory (" + lettermemory + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable letterMemoryidLetterMemory field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(lettermemory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lettermemory> findLettermemoryEntities() {
        return findLettermemoryEntities(true, -1, -1);
    }

    public List<Lettermemory> findLettermemoryEntities(int maxResults, int firstResult) {
        return findLettermemoryEntities(false, maxResults, firstResult);
    }

    private List<Lettermemory> findLettermemoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lettermemory.class));
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

    public Lettermemory findLettermemory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lettermemory.class, id);
        } finally {
            em.close();
        }
    }

    public int getLettermemoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lettermemory> rt = cq.from(Lettermemory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
