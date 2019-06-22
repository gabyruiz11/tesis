/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocios.Paciente;
import objetosNegocios.Prueba;
import objetosNegocios.Usuario;
import objetosNegocios.Set1;

/**
 *
 * @author David Hermosillo
 */
public class PruebaJpaController implements Serializable {

    public PruebaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prueba prueba) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente folioPaciente = prueba.getFolioPaciente();
            if (folioPaciente != null) {
                folioPaciente = em.getReference(folioPaciente.getClass(), folioPaciente.getFolioPaciente());
                prueba.setFolioPaciente(folioPaciente);
            }
            Usuario idUsuario = prueba.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                prueba.setIdUsuario(idUsuario);
            }
            Set1 setidSet = prueba.getSetidSet();
            if (setidSet != null) {
                setidSet = em.getReference(setidSet.getClass(), setidSet.getIdSet());
                prueba.setSetidSet(setidSet);
            }
            em.persist(prueba);
            if (folioPaciente != null) {
                folioPaciente.getPruebaCollection().add(prueba);
                folioPaciente = em.merge(folioPaciente);
            }
            if (idUsuario != null) {
                idUsuario.getPruebaCollection().add(prueba);
                idUsuario = em.merge(idUsuario);
            }
            if (setidSet != null) {
                setidSet.getPruebaCollection().add(prueba);
                setidSet = em.merge(setidSet);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prueba prueba) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prueba persistentPrueba = em.find(Prueba.class, prueba.getIdPrueba());
            Paciente folioPacienteOld = persistentPrueba.getFolioPaciente();
            Paciente folioPacienteNew = prueba.getFolioPaciente();
            Usuario idUsuarioOld = persistentPrueba.getIdUsuario();
            Usuario idUsuarioNew = prueba.getIdUsuario();
            Set1 setidSetOld = persistentPrueba.getSetidSet();
            Set1 setidSetNew = prueba.getSetidSet();
            if (folioPacienteNew != null) {
                folioPacienteNew = em.getReference(folioPacienteNew.getClass(), folioPacienteNew.getFolioPaciente());
                prueba.setFolioPaciente(folioPacienteNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                prueba.setIdUsuario(idUsuarioNew);
            }
            if (setidSetNew != null) {
                setidSetNew = em.getReference(setidSetNew.getClass(), setidSetNew.getIdSet());
                prueba.setSetidSet(setidSetNew);
            }
            prueba = em.merge(prueba);
            if (folioPacienteOld != null && !folioPacienteOld.equals(folioPacienteNew)) {
                folioPacienteOld.getPruebaCollection().remove(prueba);
                folioPacienteOld = em.merge(folioPacienteOld);
            }
            if (folioPacienteNew != null && !folioPacienteNew.equals(folioPacienteOld)) {
                folioPacienteNew.getPruebaCollection().add(prueba);
                folioPacienteNew = em.merge(folioPacienteNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getPruebaCollection().remove(prueba);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getPruebaCollection().add(prueba);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (setidSetOld != null && !setidSetOld.equals(setidSetNew)) {
                setidSetOld.getPruebaCollection().remove(prueba);
                setidSetOld = em.merge(setidSetOld);
            }
            if (setidSetNew != null && !setidSetNew.equals(setidSetOld)) {
                setidSetNew.getPruebaCollection().add(prueba);
                setidSetNew = em.merge(setidSetNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = prueba.getIdPrueba();
                if (findPrueba(id) == null) {
                    throw new NonexistentEntityException("The prueba with id " + id + " no longer exists.");
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
            Prueba prueba;
            try {
                prueba = em.getReference(Prueba.class, id);
                prueba.getIdPrueba();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prueba with id " + id + " no longer exists.", enfe);
            }
            Paciente folioPaciente = prueba.getFolioPaciente();
            if (folioPaciente != null) {
                folioPaciente.getPruebaCollection().remove(prueba);
                folioPaciente = em.merge(folioPaciente);
            }
            Usuario idUsuario = prueba.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getPruebaCollection().remove(prueba);
                idUsuario = em.merge(idUsuario);
            }
            Set1 setidSet = prueba.getSetidSet();
            if (setidSet != null) {
                setidSet.getPruebaCollection().remove(prueba);
                setidSet = em.merge(setidSet);
            }
            em.remove(prueba);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prueba> findPruebaEntities() {
        return findPruebaEntities(true, -1, -1);
    }

    public List<Prueba> findPruebaEntities(int maxResults, int firstResult) {
        return findPruebaEntities(false, maxResults, firstResult);
    }

    private List<Prueba> findPruebaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prueba.class));
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

    public Prueba findPrueba(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prueba.class, id);
        } finally {
            em.close();
        }
    }

    public int getPruebaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prueba> rt = cq.from(Prueba.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
