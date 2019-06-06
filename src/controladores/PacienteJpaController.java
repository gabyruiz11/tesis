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
import objetosNegocio.Prueba;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import objetosNegocio.Paciente;

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
        if (paciente.getPruebaList() == null) {
            paciente.setPruebaList(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Prueba> attachedPruebaList = new ArrayList<Prueba>();
            for (Prueba pruebaListPruebaToAttach : paciente.getPruebaList()) {
                pruebaListPruebaToAttach = em.getReference(pruebaListPruebaToAttach.getClass(), pruebaListPruebaToAttach.getIdPrueba());
                attachedPruebaList.add(pruebaListPruebaToAttach);
            }
            paciente.setPruebaList(attachedPruebaList);
            em.persist(paciente);
            for (Prueba pruebaListPrueba : paciente.getPruebaList()) {
                Paciente oldFolioPacienteOfPruebaListPrueba = pruebaListPrueba.getFolioPaciente();
                pruebaListPrueba.setFolioPaciente(paciente);
                pruebaListPrueba = em.merge(pruebaListPrueba);
                if (oldFolioPacienteOfPruebaListPrueba != null) {
                    oldFolioPacienteOfPruebaListPrueba.getPruebaList().remove(pruebaListPrueba);
                    oldFolioPacienteOfPruebaListPrueba = em.merge(oldFolioPacienteOfPruebaListPrueba);
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
            List<Prueba> pruebaListOld = persistentPaciente.getPruebaList();
            List<Prueba> pruebaListNew = paciente.getPruebaList();
            List<Prueba> attachedPruebaListNew = new ArrayList<Prueba>();
            for (Prueba pruebaListNewPruebaToAttach : pruebaListNew) {
                pruebaListNewPruebaToAttach = em.getReference(pruebaListNewPruebaToAttach.getClass(), pruebaListNewPruebaToAttach.getIdPrueba());
                attachedPruebaListNew.add(pruebaListNewPruebaToAttach);
            }
            pruebaListNew = attachedPruebaListNew;
            paciente.setPruebaList(pruebaListNew);
            paciente = em.merge(paciente);
            for (Prueba pruebaListOldPrueba : pruebaListOld) {
                if (!pruebaListNew.contains(pruebaListOldPrueba)) {
                    pruebaListOldPrueba.setFolioPaciente(null);
                    pruebaListOldPrueba = em.merge(pruebaListOldPrueba);
                }
            }
            for (Prueba pruebaListNewPrueba : pruebaListNew) {
                if (!pruebaListOld.contains(pruebaListNewPrueba)) {
                    Paciente oldFolioPacienteOfPruebaListNewPrueba = pruebaListNewPrueba.getFolioPaciente();
                    pruebaListNewPrueba.setFolioPaciente(paciente);
                    pruebaListNewPrueba = em.merge(pruebaListNewPrueba);
                    if (oldFolioPacienteOfPruebaListNewPrueba != null && !oldFolioPacienteOfPruebaListNewPrueba.equals(paciente)) {
                        oldFolioPacienteOfPruebaListNewPrueba.getPruebaList().remove(pruebaListNewPrueba);
                        oldFolioPacienteOfPruebaListNewPrueba = em.merge(oldFolioPacienteOfPruebaListNewPrueba);
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
            List<Prueba> pruebaList = paciente.getPruebaList();
            for (Prueba pruebaListPrueba : pruebaList) {
                pruebaListPrueba.setFolioPaciente(null);
                pruebaListPrueba = em.merge(pruebaListPrueba);
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
