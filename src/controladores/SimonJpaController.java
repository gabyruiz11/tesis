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
import objetosNegocio.Setpruebas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocio.Simon;

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
        if (simon.getSetpruebasList() == null) {
            simon.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : simon.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            simon.setSetpruebasList(attachedSetpruebasList);
            em.persist(simon);
            for (Setpruebas setpruebasListSetpruebas : simon.getSetpruebasList()) {
                Simon oldSimonidSimonOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getSimonidSimon();
                setpruebasListSetpruebas.setSimonidSimon(simon);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldSimonidSimonOfSetpruebasListSetpruebas != null) {
                    oldSimonidSimonOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldSimonidSimonOfSetpruebasListSetpruebas = em.merge(oldSimonidSimonOfSetpruebasListSetpruebas);
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
            List<Setpruebas> setpruebasListOld = persistentSimon.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = simon.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its simonidSimon field is not nullable.");
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
            simon.setSetpruebasList(setpruebasListNew);
            simon = em.merge(simon);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Simon oldSimonidSimonOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getSimonidSimon();
                    setpruebasListNewSetpruebas.setSimonidSimon(simon);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldSimonidSimonOfSetpruebasListNewSetpruebas != null && !oldSimonidSimonOfSetpruebasListNewSetpruebas.equals(simon)) {
                        oldSimonidSimonOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldSimonidSimonOfSetpruebasListNewSetpruebas = em.merge(oldSimonidSimonOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = simon.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Simon (" + simon + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable simonidSimon field.");
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
