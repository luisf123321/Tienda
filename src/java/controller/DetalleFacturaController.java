/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import dao.IDaoDetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import models.Detallefactura;


/**
 *
 * @author luis
 */
public class DetalleFacturaController implements IDaoDetalleFactura {
    
    
    UserTransaction transaction;
    
    private EntityManagerFactory emf;

    public DetalleFacturaController() {
    }

    public DetalleFacturaController(EntityManagerFactory emf) throws NamingException {
        this.transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");       
        this.emf = emf;
    }    
    
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Detallefactura> getDetalleFacturas() {
        
        List<Detallefactura> detalle = new ArrayList<>();
	EntityManager em = getEntityManager();
        try {
            
            
	    Query query = em.createQuery( "SELECT d FROM Detallefactura d");
	    List<Detallefactura> list=(List<Detallefactura>)query.getResultList( );
            if(list==null){
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }else{
                System.out.println("***************************++");
                System.out.println("nullllllllllllllllllllllllllll");
            }
            for (Detallefactura dtf:list){
                Detallefactura dtfa = new Detallefactura();
                dtfa.setId(dtf.getId());
                dtfa.setIddetalle(dtf.getIddetalle());
                dtfa.setIdfactura(dtf.getIdfactura());               
                detalle.add(dtfa);                
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
    public Detallefactura createDetalleFactura(Detallefactura detallefactura) throws RollbackFailureException, Exception {
        EntityManager em = null;
        String message = "";
        try {
            transaction.begin();
            em = getEntityManager();            
            em.persist(detallefactura);            
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
        return detallefactura;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallefactura getDetalleFactura(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteDetalleFactura(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallefactura updateDetalleFactura() throws NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
