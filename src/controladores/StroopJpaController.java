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
import objetosNegocio.Stroop;

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
        if (stroop.getSetpruebasList() == null) {
            stroop.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : stroop.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            stroop.setSetpruebasList(attachedSetpruebasList);
            em.persist(stroop);
            for (Setpruebas setpruebasListSetpruebas : stroop.getSetpruebasList()) {
                Stroop oldStroopidStroopOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getStroopidStroop();
                setpruebasListSetpruebas.setStroopidStroop(stroop);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldStroopidStroopOfSetpruebasListSetpruebas != null) {
                    oldStroopidStroopOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldStroopidStroopOfSetpruebasListSetpruebas = em.merge(oldStroopidStroopOfSetpruebasListSetpruebas);
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
            List<Setpruebas> setpruebasListOld = persistentStroop.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = stroop.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its stroopidStroop field is not nullable.");
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
            stroop.setSetpruebasList(setpruebasListNew);
            stroop = em.merge(stroop);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Stroop oldStroopidStroopOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getStroopidStroop();
                    setpruebasListNewSetpruebas.setStroopidStroop(stroop);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldStroopidStroopOfSetpruebasListNewSetpruebas != null && !oldStroopidStroopOfSetpruebasListNewSetpruebas.equals(stroop)) {
                        oldStroopidStroopOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldStroopidStroopOfSetpruebasListNewSetpruebas = em.merge(oldStroopidStroopOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = stroop.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Stroop (" + stroop + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable stroopidStroop field.");
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
