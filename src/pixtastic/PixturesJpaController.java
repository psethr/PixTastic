/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixtastic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pixtastic.exceptions.NonexistentEntityException;

/**
 *
 * @author Rachel
 */
public class PixturesJpaController implements Serializable {

    public PixturesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pixtures pixtures) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pixusers pixuser = pixtures.getPixuser();
            if (pixuser != null) {
                pixuser = em.getReference(pixuser.getClass(), pixuser.getId());
                pixtures.setPixuser(pixuser);
            }
            em.persist(pixtures);
            if (pixuser != null) {
                pixuser.getPixturesCollection().add(pixtures);
                pixuser = em.merge(pixuser);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pixtures pixtures) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pixtures persistentPixtures = em.find(Pixtures.class, pixtures.getId());
            Pixusers pixuserOld = persistentPixtures.getPixuser();
            Pixusers pixuserNew = pixtures.getPixuser();
            if (pixuserNew != null) {
                pixuserNew = em.getReference(pixuserNew.getClass(), pixuserNew.getId());
                pixtures.setPixuser(pixuserNew);
            }
            pixtures = em.merge(pixtures);
            if (pixuserOld != null && !pixuserOld.equals(pixuserNew)) {
                pixuserOld.getPixturesCollection().remove(pixtures);
                pixuserOld = em.merge(pixuserOld);
            }
            if (pixuserNew != null && !pixuserNew.equals(pixuserOld)) {
                pixuserNew.getPixturesCollection().add(pixtures);
                pixuserNew = em.merge(pixuserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pixtures.getId();
                if (findPixtures(id) == null) {
                    throw new NonexistentEntityException("The pixtures with id " + id + " no longer exists.");
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
            Pixtures pixtures;
            try {
                pixtures = em.getReference(Pixtures.class, id);
                pixtures.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pixtures with id " + id + " no longer exists.", enfe);
            }
            Pixusers pixuser = pixtures.getPixuser();
            if (pixuser != null) {
                pixuser.getPixturesCollection().remove(pixtures);
                pixuser = em.merge(pixuser);
            }
            em.remove(pixtures);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pixtures> findPixturesEntities() {
        return findPixturesEntities(true, -1, -1);
    }

    public List<Pixtures> findPixturesEntities(int maxResults, int firstResult) {
        return findPixturesEntities(false, maxResults, firstResult);
    }

    private List<Pixtures> findPixturesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pixtures.class));
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

    public Pixtures findPixtures(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pixtures.class, id);
        } finally {
            em.close();
        }
    }

    public int getPixturesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pixtures> rt = cq.from(Pixtures.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
