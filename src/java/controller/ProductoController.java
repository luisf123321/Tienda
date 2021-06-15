/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import dao.IDaoProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import models.Categoria;
import models.Producto;

/**
 *
 * @author luis
 */


@Stateless
public class ProductoController implements IDaoProducto {

    
    UserTransaction transaction;

    public ProductoController() {
    }
    
    public ProductoController(UserTransaction utx, EntityManagerFactory emf) throws NamingException {
        this.transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");       
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Producto> getProductos() {
        return findProductoEntities(true, -1, -1);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public String createProducto(Producto producto) throws RollbackFailureException, Exception {
        EntityManager em = null;
        String message = "";
        try {
            transaction.begin();
            em = getEntityManager();
            Categoria idcategoria = producto.getIdcategoria();
            if (idcategoria != null) {
                idcategoria = em.getReference(idcategoria.getClass(), idcategoria.getId());
                producto.setIdcategoria(idcategoria);
            }
            em.persist(producto);
            if (idcategoria != null) {
                idcategoria.getProductoList().add(producto);
                idcategoria = em.merge(idcategoria);
            }
            transaction.commit();
            message = "ok";
        } catch (Exception ex) {
            try {
                message="error create";
                transaction.rollback();
            } catch (Exception re) {
                message = "error roll back";
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return message;
    }
    @Override
    public Producto getProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }
    
    /**
     *
     * @param id
     * @return
     * @throws NonexistentEntityException
     * @throws RollbackFailureException
     * @throws Exception
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public String deleteProducto(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        String message = "";
        System.out.println(id);
        try {
            transaction.begin();
            em = getEntityManager();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getId();
            } catch (EntityNotFoundException enfe) {
                message = "no existe producto";
                System.out.println(message);
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Categoria idcategoria = producto.getIdcategoria();
            if (idcategoria != null) {
                idcategoria.getProductoList().remove(producto);
                idcategoria = em.merge(idcategoria);
            }
            em.remove(producto);
            transaction.commit();
            message = "ok";
        } catch (Exception ex) {
            try {
                message = "error eliminar producto";
                transaction.rollback();
            } catch (Exception re) {
                message = "error roll back producto";
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return message;
    }
    
    public String getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return (q.getSingleResult()).toString();
        } finally {
            em.close();
        }
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Producto updateProducto(Producto producto) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();
            Producto persistentProducto = em.find(Producto.class, producto.getId());
            Categoria idcategoriaOld = persistentProducto.getIdcategoria();
            Categoria idcategoriaNew = producto.getIdcategoria();
            if (idcategoriaNew != null) {
                idcategoriaNew = em.getReference(idcategoriaNew.getClass(), idcategoriaNew.getId());
                producto.setIdcategoria(idcategoriaNew);
            }
            producto = em.merge(producto);
            if (idcategoriaOld != null && !idcategoriaOld.equals(idcategoriaNew)) {
                idcategoriaOld.getProductoList().remove(producto);
                idcategoriaOld = em.merge(idcategoriaOld);
            }
            if (idcategoriaNew != null && !idcategoriaNew.equals(idcategoriaOld)) {
                idcategoriaNew.getProductoList().add(producto);
                idcategoriaNew = em.merge(idcategoriaNew);
            }
            transaction.commit();
        } catch (Exception ex) {
            try {
                transaction.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getId();
                if (getProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return producto;
    }
    
}
