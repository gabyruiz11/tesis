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
import objetosNegocio.Setpruebas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocio.Lettermemory;

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
        if (lettermemory.getSetpruebasList() == null) {
            lettermemory.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : lettermemory.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            lettermemory.setSetpruebasList(attachedSetpruebasList);
            em.persist(lettermemory);
            for (Setpruebas setpruebasListSetpruebas : lettermemory.getSetpruebasList()) {
                Lettermemory oldLetterMemoryidLetterMemoryOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getLetterMemoryidLetterMemory();
                setpruebasListSetpruebas.setLetterMemoryidLetterMemory(lettermemory);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldLetterMemoryidLetterMemoryOfSetpruebasListSetpruebas != null) {
                    oldLetterMemoryidLetterMemoryOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldLetterMemoryidLetterMemoryOfSetpruebasListSetpruebas = em.merge(oldLetterMemoryidLetterMemoryOfSetpruebasListSetpruebas);
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
            List<Setpruebas> setpruebasListOld = persistentLettermemory.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = lettermemory.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its letterMemoryidLetterMemory field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Setpruebas> attachedSetpruebasListNew = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListNewSetpruebasToAttach : setpruebasListNew) {
                setpruebasListNewSetpruebasToAttach = em.getReference(setpruebasListNewSetpruebasToAttach.getClass(), setpruebasListNewSetpruebasToAttach.getIdSet());
                attachedSetpruebasListNew.add(setpruebasListNewSetpruebasToAttach);
            }
            setpruebasListNew = attachedSetpruebasListNew;
            lettermemory.setSetpruebasList(setpruebasListNew);
            lettermemory = em.merge(lettermemory);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Lettermemory oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getLetterMemoryidLetterMemory();
                    setpruebasListNewSetpruebas.setLetterMemoryidLetterMemory(lettermemory);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas != null && !oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas.equals(lettermemory)) {
                        oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas = em.merge(oldLetterMemoryidLetterMemoryOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = lettermemory.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Lettermemory (" + lettermemory + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable letterMemoryidLetterMemory field.");
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
