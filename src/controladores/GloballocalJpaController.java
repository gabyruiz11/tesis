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
import objetosNegocio.Globallocal;
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

    public void create(Globallocal globallocal) {
        if (globallocal.getSetpruebasList() == null) {
            globallocal.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : globallocal.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            globallocal.setSetpruebasList(attachedSetpruebasList);
            em.persist(globallocal);
            for (Setpruebas setpruebasListSetpruebas : globallocal.getSetpruebasList()) {
                Globallocal oldGlobalLocalidGlobalLocalOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getGlobalLocalidGlobalLocal();
                setpruebasListSetpruebas.setGlobalLocalidGlobalLocal(globallocal);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldGlobalLocalidGlobalLocalOfSetpruebasListSetpruebas != null) {
                    oldGlobalLocalidGlobalLocalOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldGlobalLocalidGlobalLocalOfSetpruebasListSetpruebas = em.merge(oldGlobalLocalidGlobalLocalOfSetpruebasListSetpruebas);
                }
            }
            em.getTransaction().commit();
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
            List<Setpruebas> setpruebasListOld = persistentGloballocal.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = globallocal.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its globalLocalidGlobalLocal field is not nullable.");
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
            globallocal.setSetpruebasList(setpruebasListNew);
            globallocal = em.merge(globallocal);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Globallocal oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getGlobalLocalidGlobalLocal();
                    setpruebasListNewSetpruebas.setGlobalLocalidGlobalLocal(globallocal);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas != null && !oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas.equals(globallocal)) {
                        oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas = em.merge(oldGlobalLocalidGlobalLocalOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = globallocal.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Globallocal (" + globallocal + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable globalLocalidGlobalLocal field.");
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
