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
import objetosNegocio.Stopsignal;

/**
 *
 * @author David Hermosillo
 */
public class StopsignalJpaController implements Serializable {

    public StopsignalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stopsignal stopsignal) {
        if (stopsignal.getSetpruebasList() == null) {
            stopsignal.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : stopsignal.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            stopsignal.setSetpruebasList(attachedSetpruebasList);
            em.persist(stopsignal);
            for (Setpruebas setpruebasListSetpruebas : stopsignal.getSetpruebasList()) {
                Stopsignal oldStopSignalidStopSignalOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getStopSignalidStopSignal();
                setpruebasListSetpruebas.setStopSignalidStopSignal(stopsignal);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldStopSignalidStopSignalOfSetpruebasListSetpruebas != null) {
                    oldStopSignalidStopSignalOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldStopSignalidStopSignalOfSetpruebasListSetpruebas = em.merge(oldStopSignalidStopSignalOfSetpruebasListSetpruebas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stopsignal stopsignal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Stopsignal persistentStopsignal = em.find(Stopsignal.class, stopsignal.getIdStopSignal());
            List<Setpruebas> setpruebasListOld = persistentStopsignal.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = stopsignal.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its stopSignalidStopSignal field is not nullable.");
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
            stopsignal.setSetpruebasList(setpruebasListNew);
            stopsignal = em.merge(stopsignal);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Stopsignal oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getStopSignalidStopSignal();
                    setpruebasListNewSetpruebas.setStopSignalidStopSignal(stopsignal);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas != null && !oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas.equals(stopsignal)) {
                        oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas = em.merge(oldStopSignalidStopSignalOfSetpruebasListNewSetpruebas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stopsignal.getIdStopSignal();
                if (findStopsignal(id) == null) {
                    throw new NonexistentEntityException("The stopsignal with id " + id + " no longer exists.");
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
            Stopsignal stopsignal;
            try {
                stopsignal = em.getReference(Stopsignal.class, id);
                stopsignal.getIdStopSignal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stopsignal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Setpruebas> setpruebasListOrphanCheck = stopsignal.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Stopsignal (" + stopsignal + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable stopSignalidStopSignal field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(stopsignal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stopsignal> findStopsignalEntities() {
        return findStopsignalEntities(true, -1, -1);
    }

    public List<Stopsignal> findStopsignalEntities(int maxResults, int firstResult) {
        return findStopsignalEntities(false, maxResults, firstResult);
    }

    private List<Stopsignal> findStopsignalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stopsignal.class));
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

    public Stopsignal findStopsignal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stopsignal.class, id);
        } finally {
            em.close();
        }
    }

    public int getStopsignalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stopsignal> rt = cq.from(Stopsignal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
