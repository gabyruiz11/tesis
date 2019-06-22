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
import objetosNegocios.Plusminus;

/**
 *
 * @author David Hermosillo
 */
public class PlusminusJpaController implements Serializable {

    public PlusminusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Plusminus plusminus) throws PreexistingEntityException, Exception {
        if (plusminus.getSet1Collection() == null) {
            plusminus.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : plusminus.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            plusminus.setSet1Collection(attachedSet1Collection);
            em.persist(plusminus);
            for (Set1 set1CollectionSet1 : plusminus.getSet1Collection()) {
                Plusminus oldPlusMinusidPlusMinusOfSet1CollectionSet1 = set1CollectionSet1.getPlusMinusidPlusMinus();
                set1CollectionSet1.setPlusMinusidPlusMinus(plusminus);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldPlusMinusidPlusMinusOfSet1CollectionSet1 != null) {
                    oldPlusMinusidPlusMinusOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldPlusMinusidPlusMinusOfSet1CollectionSet1 = em.merge(oldPlusMinusidPlusMinusOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPlusminus(plusminus.getIdPlusMinus()) != null) {
                throw new PreexistingEntityException("Plusminus " + plusminus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Plusminus plusminus) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Plusminus persistentPlusminus = em.find(Plusminus.class, plusminus.getIdPlusMinus());
            Collection<Set1> set1CollectionOld = persistentPlusminus.getSet1Collection();
            Collection<Set1> set1CollectionNew = plusminus.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its plusMinusidPlusMinus field is not nullable.");
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
            plusminus.setSet1Collection(set1CollectionNew);
            plusminus = em.merge(plusminus);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Plusminus oldPlusMinusidPlusMinusOfSet1CollectionNewSet1 = set1CollectionNewSet1.getPlusMinusidPlusMinus();
                    set1CollectionNewSet1.setPlusMinusidPlusMinus(plusminus);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldPlusMinusidPlusMinusOfSet1CollectionNewSet1 != null && !oldPlusMinusidPlusMinusOfSet1CollectionNewSet1.equals(plusminus)) {
                        oldPlusMinusidPlusMinusOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldPlusMinusidPlusMinusOfSet1CollectionNewSet1 = em.merge(oldPlusMinusidPlusMinusOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = plusminus.getIdPlusMinus();
                if (findPlusminus(id) == null) {
                    throw new NonexistentEntityException("The plusminus with id " + id + " no longer exists.");
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
            Plusminus plusminus;
            try {
                plusminus = em.getReference(Plusminus.class, id);
                plusminus.getIdPlusMinus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The plusminus with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = plusminus.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Plusminus (" + plusminus + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable plusMinusidPlusMinus field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(plusminus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Plusminus> findPlusminusEntities() {
        return findPlusminusEntities(true, -1, -1);
    }

    public List<Plusminus> findPlusminusEntities(int maxResults, int firstResult) {
        return findPlusminusEntities(false, maxResults, firstResult);
    }

    private List<Plusminus> findPlusminusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Plusminus.class));
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

    public Plusminus findPlusminus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Plusminus.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlusminusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Plusminus> rt = cq.from(Plusminus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
