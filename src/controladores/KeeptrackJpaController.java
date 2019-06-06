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
import objetosNegocio.Keeptrack;

/**
 *1.2
 * @author David Hermosillo
 */
public class KeeptrackJpaController implements Serializable {

    public KeeptrackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Keeptrack keeptrack) {
        if (keeptrack.getSetpruebasList() == null) {
            keeptrack.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : keeptrack.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            keeptrack.setSetpruebasList(attachedSetpruebasList);
            em.persist(keeptrack);
            for (Setpruebas setpruebasListSetpruebas : keeptrack.getSetpruebasList()) {
                Keeptrack oldKeepTrackidKeepTrackOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getKeepTrackidKeepTrack();
                setpruebasListSetpruebas.setKeepTrackidKeepTrack(keeptrack);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldKeepTrackidKeepTrackOfSetpruebasListSetpruebas != null) {
                    oldKeepTrackidKeepTrackOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldKeepTrackidKeepTrackOfSetpruebasListSetpruebas = em.merge(oldKeepTrackidKeepTrackOfSetpruebasListSetpruebas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Keeptrack keeptrack) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Keeptrack persistentKeeptrack = em.find(Keeptrack.class, keeptrack.getIdKeepTrack());
            List<Setpruebas> setpruebasListOld = persistentKeeptrack.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = keeptrack.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its keepTrackidKeepTrack field is not nullable.");
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
            keeptrack.setSetpruebasList(setpruebasListNew);
            keeptrack = em.merge(keeptrack);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Keeptrack oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getKeepTrackidKeepTrack();
                    setpruebasListNewSetpruebas.setKeepTrackidKeepTrack(keeptrack);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas != null && !oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas.equals(keeptrack)) {
                        oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas = em.merge(oldKeepTrackidKeepTrackOfSetpruebasListNewSetpruebas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = keeptrack.getIdKeepTrack();
                if (findKeeptrack(id) == null) {
                    throw new NonexistentEntityException("The keeptrack with id " + id + " no longer exists.");
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
            Keeptrack keeptrack;
            try {
                keeptrack = em.getReference(Keeptrack.class, id);
                keeptrack.getIdKeepTrack();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The keeptrack with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Setpruebas> setpruebasListOrphanCheck = keeptrack.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Keeptrack (" + keeptrack + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable keepTrackidKeepTrack field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(keeptrack);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Keeptrack> findKeeptrackEntities() {
        return findKeeptrackEntities(true, -1, -1);
    }

    public List<Keeptrack> findKeeptrackEntities(int maxResults, int firstResult) {
        return findKeeptrackEntities(false, maxResults, firstResult);
    }

    private List<Keeptrack> findKeeptrackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Keeptrack.class));
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

    public Keeptrack findKeeptrack(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Keeptrack.class, id);
        } finally {
            em.close();
        }
    }

    public int getKeeptrackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Keeptrack> rt = cq.from(Keeptrack.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
