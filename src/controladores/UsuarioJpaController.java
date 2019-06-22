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
import objetosNegocios.Usuario;

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
        if (usuario.getPruebaCollection() == null) {
            usuario.setPruebaCollection(new ArrayList<Prueba>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Prueba> attachedPruebaCollection = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionPruebaToAttach : usuario.getPruebaCollection()) {
                pruebaCollectionPruebaToAttach = em.getReference(pruebaCollectionPruebaToAttach.getClass(), pruebaCollectionPruebaToAttach.getIdPrueba());
                attachedPruebaCollection.add(pruebaCollectionPruebaToAttach);
            }
            usuario.setPruebaCollection(attachedPruebaCollection);
            em.persist(usuario);
            for (Prueba pruebaCollectionPrueba : usuario.getPruebaCollection()) {
                Usuario oldIdUsuarioOfPruebaCollectionPrueba = pruebaCollectionPrueba.getIdUsuario();
                pruebaCollectionPrueba.setIdUsuario(usuario);
                pruebaCollectionPrueba = em.merge(pruebaCollectionPrueba);
                if (oldIdUsuarioOfPruebaCollectionPrueba != null) {
                    oldIdUsuarioOfPruebaCollectionPrueba.getPruebaCollection().remove(pruebaCollectionPrueba);
                    oldIdUsuarioOfPruebaCollectionPrueba = em.merge(oldIdUsuarioOfPruebaCollectionPrueba);
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
            Collection<Prueba> pruebaCollectionOld = persistentUsuario.getPruebaCollection();
            Collection<Prueba> pruebaCollectionNew = usuario.getPruebaCollection();
            Collection<Prueba> attachedPruebaCollectionNew = new ArrayList<Prueba>();
            for (Prueba pruebaCollectionNewPruebaToAttach : pruebaCollectionNew) {
                pruebaCollectionNewPruebaToAttach = em.getReference(pruebaCollectionNewPruebaToAttach.getClass(), pruebaCollectionNewPruebaToAttach.getIdPrueba());
                attachedPruebaCollectionNew.add(pruebaCollectionNewPruebaToAttach);
            }
            pruebaCollectionNew = attachedPruebaCollectionNew;
            usuario.setPruebaCollection(pruebaCollectionNew);
            usuario = em.merge(usuario);
            for (Prueba pruebaCollectionOldPrueba : pruebaCollectionOld) {
                if (!pruebaCollectionNew.contains(pruebaCollectionOldPrueba)) {
                    pruebaCollectionOldPrueba.setIdUsuario(null);
                    pruebaCollectionOldPrueba = em.merge(pruebaCollectionOldPrueba);
                }
            }
            for (Prueba pruebaCollectionNewPrueba : pruebaCollectionNew) {
                if (!pruebaCollectionOld.contains(pruebaCollectionNewPrueba)) {
                    Usuario oldIdUsuarioOfPruebaCollectionNewPrueba = pruebaCollectionNewPrueba.getIdUsuario();
                    pruebaCollectionNewPrueba.setIdUsuario(usuario);
                    pruebaCollectionNewPrueba = em.merge(pruebaCollectionNewPrueba);
                    if (oldIdUsuarioOfPruebaCollectionNewPrueba != null && !oldIdUsuarioOfPruebaCollectionNewPrueba.equals(usuario)) {
                        oldIdUsuarioOfPruebaCollectionNewPrueba.getPruebaCollection().remove(pruebaCollectionNewPrueba);
                        oldIdUsuarioOfPruebaCollectionNewPrueba = em.merge(oldIdUsuarioOfPruebaCollectionNewPrueba);
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
            Collection<Prueba> pruebaCollection = usuario.getPruebaCollection();
            for (Prueba pruebaCollectionPrueba : pruebaCollection) {
                pruebaCollectionPrueba.setIdUsuario(null);
                pruebaCollectionPrueba = em.merge(pruebaCollectionPrueba);
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
