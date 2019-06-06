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
import objetosNegocio.Tonemonotoring;

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
        if (tonemonotoring.getSetpruebasList() == null) {
            tonemonotoring.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : tonemonotoring.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            tonemonotoring.setSetpruebasList(attachedSetpruebasList);
            em.persist(tonemonotoring);
            for (Setpruebas setpruebasListSetpruebas : tonemonotoring.getSetpruebasList()) {
                Tonemonotoring oldToneMonotoringidToneMonotoringOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getToneMonotoringidToneMonotoring();
                setpruebasListSetpruebas.setToneMonotoringidToneMonotoring(tonemonotoring);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldToneMonotoringidToneMonotoringOfSetpruebasListSetpruebas != null) {
                    oldToneMonotoringidToneMonotoringOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldToneMonotoringidToneMonotoringOfSetpruebasListSetpruebas = em.merge(oldToneMonotoringidToneMonotoringOfSetpruebasListSetpruebas);
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
            List<Setpruebas> setpruebasListOld = persistentTonemonotoring.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = tonemonotoring.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its toneMonotoringidToneMonotoring field is not nullable.");
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
            tonemonotoring.setSetpruebasList(setpruebasListNew);
            tonemonotoring = em.merge(tonemonotoring);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Tonemonotoring oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getToneMonotoringidToneMonotoring();
                    setpruebasListNewSetpruebas.setToneMonotoringidToneMonotoring(tonemonotoring);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas != null && !oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas.equals(tonemonotoring)) {
                        oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas = em.merge(oldToneMonotoringidToneMonotoringOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = tonemonotoring.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tonemonotoring (" + tonemonotoring + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable toneMonotoringidToneMonotoring field.");
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
