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
import objetosNegocio.Usuario;

/**
 *
 * @author David Hermosillo
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getPruebaList() == null) {
            usuario.setPruebaList(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Prueba> attachedPruebaList = new ArrayList<Prueba>();
            for (Prueba pruebaListPruebaToAttach : usuario.getPruebaList()) {
                pruebaListPruebaToAttach = em.getReference(pruebaListPruebaToAttach.getClass(), pruebaListPruebaToAttach.getIdPrueba());
                attachedPruebaList.add(pruebaListPruebaToAttach);
            }
            usuario.setPruebaList(attachedPruebaList);
            em.persist(usuario);
            for (Prueba pruebaListPrueba : usuario.getPruebaList()) {
                Usuario oldIdUsuarioOfPruebaListPrueba = pruebaListPrueba.getIdUsuario();
                pruebaListPrueba.setIdUsuario(usuario);
                pruebaListPrueba = em.merge(pruebaListPrueba);
                if (oldIdUsuarioOfPruebaListPrueba != null) {
                    oldIdUsuarioOfPruebaListPrueba.getPruebaList().remove(pruebaListPrueba);
                    oldIdUsuarioOfPruebaListPrueba = em.merge(oldIdUsuarioOfPruebaListPrueba);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            List<Prueba> pruebaListOld = persistentUsuario.getPruebaList();
            List<Prueba> pruebaListNew = usuario.getPruebaList();
            List<Prueba> attachedPruebaListNew = new ArrayList<Prueba>();
            for (Prueba pruebaListNewPruebaToAttach : pruebaListNew) {
                pruebaListNewPruebaToAttach = em.getReference(pruebaListNewPruebaToAttach.getClass(), pruebaListNewPruebaToAttach.getIdPrueba());
                attachedPruebaListNew.add(pruebaListNewPruebaToAttach);
            }
            pruebaListNew = attachedPruebaListNew;
            usuario.setPruebaList(pruebaListNew);
            usuario = em.merge(usuario);
            for (Prueba pruebaListOldPrueba : pruebaListOld) {
                if (!pruebaListNew.contains(pruebaListOldPrueba)) {
                    pruebaListOldPrueba.setIdUsuario(null);
                    pruebaListOldPrueba = em.merge(pruebaListOldPrueba);
                }
            }
            for (Prueba pruebaListNewPrueba : pruebaListNew) {
                if (!pruebaListOld.contains(pruebaListNewPrueba)) {
                    Usuario oldIdUsuarioOfPruebaListNewPrueba = pruebaListNewPrueba.getIdUsuario();
                    pruebaListNewPrueba.setIdUsuario(usuario);
                    pruebaListNewPrueba = em.merge(pruebaListNewPrueba);
                    if (oldIdUsuarioOfPruebaListNewPrueba != null && !oldIdUsuarioOfPruebaListNewPrueba.equals(usuario)) {
                        oldIdUsuarioOfPruebaListNewPrueba.getPruebaList().remove(pruebaListNewPrueba);
                        oldIdUsuarioOfPruebaListNewPrueba = em.merge(oldIdUsuarioOfPruebaListNewPrueba);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Prueba> pruebaList = usuario.getPruebaList();
            for (Prueba pruebaListPrueba : pruebaList) {
                pruebaListPrueba.setIdUsuario(null);
                pruebaListPrueba = em.merge(pruebaListPrueba);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
