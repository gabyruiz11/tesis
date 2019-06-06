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
import objetosNegocio.Numberletter;

/**
 *
 * @author David Hermosillo
 */
public class NumberletterJpaController implements Serializable {

    public NumberletterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Numberletter numberletter) {
        if (numberletter.getSetpruebasList() == null) {
            numberletter.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : numberletter.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            numberletter.setSetpruebasList(attachedSetpruebasList);
            em.persist(numberletter);
            for (Setpruebas setpruebasListSetpruebas : numberletter.getSetpruebasList()) {
                Numberletter oldNumberLetteridNumberLetterOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getNumberLetteridNumberLetter();
                setpruebasListSetpruebas.setNumberLetteridNumberLetter(numberletter);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldNumberLetteridNumberLetterOfSetpruebasListSetpruebas != null) {
                    oldNumberLetteridNumberLetterOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldNumberLetteridNumberLetterOfSetpruebasListSetpruebas = em.merge(oldNumberLetteridNumberLetterOfSetpruebasListSetpruebas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Numberletter numberletter) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Numberletter persistentNumberletter = em.find(Numberletter.class, numberletter.getIdNumberLetter());
            List<Setpruebas> setpruebasListOld = persistentNumberletter.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = numberletter.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its numberLetteridNumberLetter field is not nullable.");
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
            numberletter.setSetpruebasList(setpruebasListNew);
            numberletter = em.merge(numberletter);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Numberletter oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getNumberLetteridNumberLetter();
                    setpruebasListNewSetpruebas.setNumberLetteridNumberLetter(numberletter);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas != null && !oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas.equals(numberletter)) {
                        oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas = em.merge(oldNumberLetteridNumberLetterOfSetpruebasListNewSetpruebas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = numberletter.getIdNumberLetter();
                if (findNumberletter(id) == null) {
                    throw new NonexistentEntityException("The numberletter with id " + id + " no longer exists.");
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
            Numberletter numberletter;
            try {
                numberletter = em.getReference(Numberletter.class, id);
                numberletter.getIdNumberLetter();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The numberletter with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Setpruebas> setpruebasListOrphanCheck = numberletter.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Numberletter (" + numberletter + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable numberLetteridNumberLetter field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(numberletter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Numberletter> findNumberletterEntities() {
        return findNumberletterEntities(true, -1, -1);
    }

    public List<Numberletter> findNumberletterEntities(int maxResults, int firstResult) {
        return findNumberletterEntities(false, maxResults, firstResult);
    }

    private List<Numberletter> findNumberletterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Numberletter.class));
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

    public Numberletter findNumberletter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Numberletter.class, id);
        } finally {
            em.close();
        }
    }

    public int getNumberletterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Numberletter> rt = cq.from(Numberletter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
