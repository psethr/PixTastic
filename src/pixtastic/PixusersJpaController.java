/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixtastic;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pixtastic.exceptions.NonexistentEntityException;

/**
 *
 * @author Rachel
 */
public class PixusersJpaController implements Serializable {

    public PixusersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pixusers pixusers) {
        if (pixusers.getPixturesCollection() == null) {
            pixusers.setPixturesCollection(new ArrayList<Pixtures>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pixtures> attachedPixturesCollection = new ArrayList<Pixtures>();
            for (Pixtures pixturesCollectionPixturesToAttach : pixusers.getPixturesCollection()) {
                pixturesCollectionPixturesToAttach = em.getReference(pixturesCollectionPixturesToAttach.getClass(), pixturesCollectionPixturesToAttach.getId());
                attachedPixturesCollection.add(pixturesCollectionPixturesToAttach);
            }
            pixusers.setPixturesCollection(attachedPixturesCollection);
            em.persist(pixusers);
            for (Pixtures pixturesCollectionPixtures : pixusers.getPixturesCollection()) {
                Pixusers oldPixuserOfPixturesCollectionPixtures = pixturesCollectionPixtures.getPixuser();
                pixturesCollectionPixtures.setPixuser(pixusers);
                pixturesCollectionPixtures = em.merge(pixturesCollectionPixtures);
                if (oldPixuserOfPixturesCollectionPixtures != null) {
                    oldPixuserOfPixturesCollectionPixtures.getPixturesCollection().remove(pixturesCollectionPixtures);
                    oldPixuserOfPixturesCollectionPixtures = em.merge(oldPixuserOfPixturesCollectionPixtures);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pixusers pixusers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pixusers persistentPixusers = em.find(Pixusers.class, pixusers.getId());
            Collection<Pixtures> pixturesCollectionOld = persistentPixusers.getPixturesCollection();
            Collection<Pixtures> pixturesCollectionNew = pixusers.getPixturesCollection();
            Collection<Pixtures> attachedPixturesCollectionNew = new ArrayList<Pixtures>();
            for (Pixtures pixturesCollectionNewPixturesToAttach : pixturesCollectionNew) {
                pixturesCollectionNewPixturesToAttach = em.getReference(pixturesCollectionNewPixturesToAttach.getClass(), pixturesCollectionNewPixturesToAttach.getId());
                attachedPixturesCollectionNew.add(pixturesCollectionNewPixturesToAttach);
            }
            pixturesCollectionNew = attachedPixturesCollectionNew;
            pixusers.setPixturesCollection(pixturesCollectionNew);
            pixusers = em.merge(pixusers);
            for (Pixtures pixturesCollectionOldPixtures : pixturesCollectionOld) {
                if (!pixturesCollectionNew.contains(pixturesCollectionOldPixtures)) {
                    pixturesCollectionOldPixtures.setPixuser(null);
                    pixturesCollectionOldPixtures = em.merge(pixturesCollectionOldPixtures);
                }
            }
            for (Pixtures pixturesCollectionNewPixtures : pixturesCollectionNew) {
                if (!pixturesCollectionOld.contains(pixturesCollectionNewPixtures)) {
                    Pixusers oldPixuserOfPixturesCollectionNewPixtures = pixturesCollectionNewPixtures.getPixuser();
                    pixturesCollectionNewPixtures.setPixuser(pixusers);
                    pixturesCollectionNewPixtures = em.merge(pixturesCollectionNewPixtures);
                    if (oldPixuserOfPixturesCollectionNewPixtures != null && !oldPixuserOfPixturesCollectionNewPixtures.equals(pixusers)) {
                        oldPixuserOfPixturesCollectionNewPixtures.getPixturesCollection().remove(pixturesCollectionNewPixtures);
                        oldPixuserOfPixturesCollectionNewPixtures = em.merge(oldPixuserOfPixturesCollectionNewPixtures);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pixusers.getId();
                if (findPixusers(id) == null) {
                    throw new NonexistentEntityException("The pixusers with id " + id + " no longer exists.");
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
            Pixusers pixusers;
            try {
                pixusers = em.getReference(Pixusers.class, id);
                pixusers.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pixusers with id " + id + " no longer exists.", enfe);
            }
            Collection<Pixtures> pixturesCollection = pixusers.getPixturesCollection();
            for (Pixtures pixturesCollectionPixtures : pixturesCollection) {
                pixturesCollectionPixtures.setPixuser(null);
                pixturesCollectionPixtures = em.merge(pixturesCollectionPixtures);
            }
            em.remove(pixusers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pixusers> findPixusersEntities() {
        return findPixusersEntities(true, -1, -1);
    }

    public List<Pixusers> findPixusersEntities(int maxResults, int firstResult) {
        return findPixusersEntities(false, maxResults, firstResult);
    }

    private List<Pixusers> findPixusersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pixusers.class));
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

    public Pixusers findPixusers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pixusers.class, id);
        } finally {
            em.close();
        }
    }

    public int getPixusersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pixusers> rt = cq.from(Pixusers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
