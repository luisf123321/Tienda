/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.RollbackFailureException;
import dao.IDaoPago;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import models.Modopago;

/**
 *
 * @author luis
 */
public class PagoController implements IDaoPago {
    
    UserTransaction transaction;
    
    private EntityManagerFactory emf;
    
    public PagoController(EntityManagerFactory emf) throws NamingException {
        
        this.transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");       
        this.emf = emf;
    } 

    PagoController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    

    @Override
    public Modopago createPago(Modopago pago) throws RollbackFailureException, Exception {
        EntityManager em = null;
        String message = "";
        try {
            transaction.begin();
            em = getEntityManager();            
            em.persist(pago);            
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return pago;
    }

    @Override
    public Modopago getPago(int id) {
        
        EntityManager em = getEntityManager();
        try {
            return em.find(Modopago.class, id);
        } finally {
            em.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
