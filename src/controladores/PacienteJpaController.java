/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocios.Prueba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocios.Paciente;

/**
 *
 * @author David Hermosillo
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getPruebaCollection() == null) {
            paciente.setPruebaCollection(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Prueba> attachedPruebaCollection = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionPruebaToAttach : paciente.getPruebaCollection()) {
                pruebaCollectionPruebaToAttach = em.getReference(pruebaCollectionPruebaToAttach.getClass(), pruebaCollectionPruebaToAttach.getIdPrueba());
                attachedPruebaCollection.add(pruebaCollectionPruebaToAttach);
            }
            paciente.setPruebaCollection(attachedPruebaCollection);
            em.persist(paciente);
            for (Prueba pruebaCollectionPrueba : paciente.getPruebaCollection()) {
                Paciente oldFolioPacienteOfPruebaCollectionPrueba = pruebaCollectionPrueba.getFolioPaciente();
                pruebaCollectionPrueba.setFolioPaciente(paciente);
                pruebaCollectionPrueba = em.merge(pruebaCollectionPrueba);
                if (oldFolioPacienteOfPruebaCollectionPrueba != null) {
                    oldFolioPacienteOfPruebaCollectionPrueba.getPruebaCollection().remove(pruebaCollectionPrueba);
                    oldFolioPacienteOfPruebaCollectionPrueba = em.merge(oldFolioPacienteOfPruebaCollectionPrueba);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getFolioPaciente());
            Collection<Prueba> pruebaCollectionOld = persistentPaciente.getPruebaCollection();
            Collection<Prueba> pruebaCollectionNew = paciente.getPruebaCollection();
            Collection<Prueba> attachedPruebaCollectionNew = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionNewPruebaToAttach : pruebaCollectionNew) {
                pruebaCollectionNewPruebaToAttach = em.getReference(pruebaCollectionNewPruebaToAttach.getClass(), pruebaCollectionNewPruebaToAttach.getIdPrueba());
                attachedPruebaCollectionNew.add(pruebaCollectionNewPruebaToAttach);
            }
            pruebaCollectionNew = attachedPruebaCollectionNew;
            paciente.setPruebaCollection(pruebaCollectionNew);
            paciente = em.merge(paciente);
            for (Prueba pruebaCollectionOldPrueba : pruebaCollectionOld) {
                if (!pruebaCollectionNew.contains(pruebaCollectionOldPrueba)) {
                    pruebaCollectionOldPrueba.setFolioPaciente(null);
                    pruebaCollectionOldPrueba = em.merge(pruebaCollectionOldPrueba);
                }
            }
            for (Prueba pruebaCollectionNewPrueba : pruebaCollectionNew) {
                if (!pruebaCollectionOld.contains(pruebaCollectionNewPrueba)) {
                    Paciente oldFolioPacienteOfPruebaCollectionNewPrueba = pruebaCollectionNewPrueba.getFolioPaciente();
                    pruebaCollectionNewPrueba.setFolioPaciente(paciente);
                    pruebaCollectionNewPrueba = em.merge(pruebaCollectionNewPrueba);
                    if (oldFolioPacienteOfPruebaCollectionNewPrueba != null && !oldFolioPacienteOfPruebaCollectionNewPrueba.equals(paciente)) {
                        oldFolioPacienteOfPruebaCollectionNewPrueba.getPruebaCollection().remove(pruebaCollectionNewPrueba);
                        oldFolioPacienteOfPruebaCollectionNewPrueba = em.merge(oldFolioPacienteOfPruebaCollectionNewPrueba);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getFolioPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getFolioPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            Collection<Prueba> pruebaCollection = paciente.getPruebaCollection();
            for (Prueba pruebaCollectionPrueba : pruebaCollection) {
                pruebaCollectionPrueba.setFolioPaciente(null);
                pruebaCollectionPrueba = em.merge(pruebaCollectionPrueba);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
