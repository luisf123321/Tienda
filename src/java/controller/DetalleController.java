/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import dao.IDaoDetalle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import models.Detallescompra;
import models.Factura;



 
@Stateless
public class DetalleController implements IDaoDetalle {
    
    UserTransaction transaction;
    
    private EntityManagerFactory emf;

    public DetalleController() {
    }

    public DetalleController(EntityManagerFactory emf) throws NamingException {
        this.transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");       
        this.emf = emf;
    }    
    
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Detallescompra> getDetalles() {
        List<Detallescompra> detalle = new ArrayList<>();
	EntityManager em = getEntityManager();
        try {
            
            
	    Query query = em.createQuery( "SELECT d FROM Detallescompra d");
	    List<Detallescompra> list=(List<Detallescompra>)query.getResultList( );
            if(list==null){
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }else{
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }
            for (Detallescompra dt:list){
                Detallescompra dtc = new Detallescompra();
                dtc.setId(dt.getId());
                dtc.setCantidad(dt.getCantidad());
                dtc.setValor(dt.getValor());
                dtc.setIdproducto(dt.getIdproducto());
                detalle.add(dtc);
                
            }
            
        }catch(Exception e){
           
        }finally{
           if (em != null) {
                em.close();
           }
        }        
        return detalle;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallescompra createDetalle(Detallescompra detalle) throws RollbackFailureException, Exception {
        
        EntityManager em = null;
        String message = "";
        try {
            transaction.begin();
            em = getEntityManager();            
            em.persist(detalle);            
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
        return detalle;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallescompra getDetalle(int id) {
        System.out.println(id);
        Detallescompra detalle = new Detallescompra();
	EntityManager em = getEntityManager();
        try {
            
            
	    Query query = em.createQuery( "SELECT d FROM Detallescompra d WHERE d.id ="+id);
	    List<Detallescompra> list=(List<Detallescompra>)query.getResultList( );
            if(list==null){
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }else{
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }
            for (Detallescompra dt:list){
                Detallescompra dtc = new Detallescompra();
                dtc.setId(dt.getId());
                dtc.setCantidad(dt.getCantidad());
                dtc.setValor(dt.getValor());
                dtc.setIdproducto(dt.getIdproducto());
                detalle = dtc;
                
            }
            
        }catch(Exception e){
           
        }finally{
           if (em != null) {
                em.close();
           }
        }        
        return detalle;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteDetalle(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        EntityManager em = null;
        String message = "";
        System.out.println(id);
        try {
            transaction.begin();
            em = getEntityManager();
            Detallescompra detalle;
            try {
                detalle = em.getReference(Detallescompra.class, id);
                detalle.getId();
            } catch (EntityNotFoundException enfe) {
                message = "no existe detalle";
                System.out.println(message);
                throw new NonexistentEntityException("el detalle " + id + " no existe.", enfe);
            }            
            em.remove(detalle);
            transaction.commit();
            message = "ok";
        } catch (Exception ex) {
            try {
                message = "error eliminar detalle";
                transaction.rollback();
            } catch (Exception re) {
                message = "error roll back detalle";
                throw new RollbackFailureException("error eliminando detalle", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return message;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallescompra updateDetalle(Detallescompra detalle) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();            
            detalle = em.merge(detalle);            
            transaction.commit();
        } catch (Exception ex) {
            try {
                transaction.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("error rollback", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalle.getId();
                if (getDetalle(id) == null) {
                    throw new NonexistentEntityException("el detalle " + id + " no existe");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return detalle;
    }   
    
    
}
