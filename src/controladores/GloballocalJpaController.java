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
import objetosNegocios.Globallocal;

/**
 *
 * @author David Hermosillo
 */
public class GloballocalJpaController implements Serializable {

    public GloballocalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Globallocal globallocal) throws PreexistingEntityException, Exception {
        if (globallocal.getSet1Collection() == null) {
            globallocal.setSet1Collection(new ArrayList<Set1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Set1> attachedSet1Collection = new ArrayList<Set1>();
            for (Set1 set1CollectionSet1ToAttach : globallocal.getSet1Collection()) {
                set1CollectionSet1ToAttach = em.getReference(set1CollectionSet1ToAttach.getClass(), set1CollectionSet1ToAttach.getIdSet());
                attachedSet1Collection.add(set1CollectionSet1ToAttach);
            }
            globallocal.setSet1Collection(attachedSet1Collection);
            em.persist(globallocal);
            for (Set1 set1CollectionSet1 : globallocal.getSet1Collection()) {
                Globallocal oldGlobalLocalidGlobalLocalOfSet1CollectionSet1 = set1CollectionSet1.getGlobalLocalidGlobalLocal();
                set1CollectionSet1.setGlobalLocalidGlobalLocal(globallocal);
                set1CollectionSet1 = em.merge(set1CollectionSet1);
                if (oldGlobalLocalidGlobalLocalOfSet1CollectionSet1 != null) {
                    oldGlobalLocalidGlobalLocalOfSet1CollectionSet1.getSet1Collection().remove(set1CollectionSet1);
                    oldGlobalLocalidGlobalLocalOfSet1CollectionSet1 = em.merge(oldGlobalLocalidGlobalLocalOfSet1CollectionSet1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGloballocal(globallocal.getIdGlobalLocal()) != null) {
                throw new PreexistingEntityException("Globallocal " + globallocal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Globallocal globallocal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Globallocal persistentGloballocal = em.find(Globallocal.class, globallocal.getIdGlobalLocal());
            Collection<Set1> set1CollectionOld = persistentGloballocal.getSet1Collection();
            Collection<Set1> set1CollectionNew = globallocal.getSet1Collection();
            List<String> illegalOrphanMessages = null;
            for (Set1 set1CollectionOldSet1 : set1CollectionOld) {
                if (!set1CollectionNew.contains(set1CollectionOldSet1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Set1 " + set1CollectionOldSet1 + " since its globalLocalidGlobalLocal field is not nullable.");
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
            globallocal.setSet1Collection(set1CollectionNew);
            globallocal = em.merge(globallocal);
            for (Set1 set1CollectionNewSet1 : set1CollectionNew) {
                if (!set1CollectionOld.contains(set1CollectionNewSet1)) {
                    Globallocal oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1 = set1CollectionNewSet1.getGlobalLocalidGlobalLocal();
                    set1CollectionNewSet1.setGlobalLocalidGlobalLocal(globallocal);
                    set1CollectionNewSet1 = em.merge(set1CollectionNewSet1);
                    if (oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1 != null && !oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1.equals(globallocal)) {
                        oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1.getSet1Collection().remove(set1CollectionNewSet1);
                        oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1 = em.merge(oldGlobalLocalidGlobalLocalOfSet1CollectionNewSet1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = globallocal.getIdGlobalLocal();
                if (findGloballocal(id) == null) {
                    throw new NonexistentEntityException("The globallocal with id " + id + " no longer exists.");
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
            Globallocal globallocal;
            try {
                globallocal = em.getReference(Globallocal.class, id);
                globallocal.getIdGlobalLocal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The globallocal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Set1> set1CollectionOrphanCheck = globallocal.getSet1Collection();
            for (Set1 set1CollectionOrphanCheckSet1 : set1CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Globallocal (" + globallocal + ") cannot be destroyed since the Set1 " + set1CollectionOrphanCheckSet1 + " in its set1Collection field has a non-nullable globalLocalidGlobalLocal field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(globallocal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Globallocal> findGloballocalEntities() {
        return findGloballocalEntities(true, -1, -1);
    }

    public List<Globallocal> findGloballocalEntities(int maxResults, int firstResult) {
        return findGloballocalEntities(false, maxResults, firstResult);
    }

    private List<Globallocal> findGloballocalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Globallocal.class));
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

    public Globallocal findGloballocal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Globallocal.class, id);
        } finally {
            em.close();
        }
    }

    public int getGloballocalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Globallocal> rt = cq.from(Globallocal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
