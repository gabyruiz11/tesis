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
import objetosNegocio.Plusminus;

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
        if (plusminus.getSetpruebasList() == null) {
            plusminus.setSetpruebasList(new ArrayList<Setpruebas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setpruebas> attachedSetpruebasList = new ArrayList<Setpruebas>();
            for (Setpruebas setpruebasListSetpruebasToAttach : plusminus.getSetpruebasList()) {
                setpruebasListSetpruebasToAttach = em.getReference(setpruebasListSetpruebasToAttach.getClass(), setpruebasListSetpruebasToAttach.getIdSet());
                attachedSetpruebasList.add(setpruebasListSetpruebasToAttach);
            }
            plusminus.setSetpruebasList(attachedSetpruebasList);
            em.persist(plusminus);
            for (Setpruebas setpruebasListSetpruebas : plusminus.getSetpruebasList()) {
                Plusminus oldPlusMinusidPlusMinusOfSetpruebasListSetpruebas = setpruebasListSetpruebas.getPlusMinusidPlusMinus();
                setpruebasListSetpruebas.setPlusMinusidPlusMinus(plusminus);
                setpruebasListSetpruebas = em.merge(setpruebasListSetpruebas);
                if (oldPlusMinusidPlusMinusOfSetpruebasListSetpruebas != null) {
                    oldPlusMinusidPlusMinusOfSetpruebasListSetpruebas.getSetpruebasList().remove(setpruebasListSetpruebas);
                    oldPlusMinusidPlusMinusOfSetpruebasListSetpruebas = em.merge(oldPlusMinusidPlusMinusOfSetpruebasListSetpruebas);
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
            List<Setpruebas> setpruebasListOld = persistentPlusminus.getSetpruebasList();
            List<Setpruebas> setpruebasListNew = plusminus.getSetpruebasList();
            List<String> illegalOrphanMessages = null;
            for (Setpruebas setpruebasListOldSetpruebas : setpruebasListOld) {
                if (!setpruebasListNew.contains(setpruebasListOldSetpruebas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Setpruebas " + setpruebasListOldSetpruebas + " since its plusMinusidPlusMinus field is not nullable.");
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
            plusminus.setSetpruebasList(setpruebasListNew);
            plusminus = em.merge(plusminus);
            for (Setpruebas setpruebasListNewSetpruebas : setpruebasListNew) {
                if (!setpruebasListOld.contains(setpruebasListNewSetpruebas)) {
                    Plusminus oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas = setpruebasListNewSetpruebas.getPlusMinusidPlusMinus();
                    setpruebasListNewSetpruebas.setPlusMinusidPlusMinus(plusminus);
                    setpruebasListNewSetpruebas = em.merge(setpruebasListNewSetpruebas);
                    if (oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas != null && !oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas.equals(plusminus)) {
                        oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas.getSetpruebasList().remove(setpruebasListNewSetpruebas);
                        oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas = em.merge(oldPlusMinusidPlusMinusOfSetpruebasListNewSetpruebas);
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
            List<Setpruebas> setpruebasListOrphanCheck = plusminus.getSetpruebasList();
            for (Setpruebas setpruebasListOrphanCheckSetpruebas : setpruebasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Plusminus (" + plusminus + ") cannot be destroyed since the Setpruebas " + setpruebasListOrphanCheckSetpruebas + " in its setpruebasList field has a non-nullable plusMinusidPlusMinus field.");
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
