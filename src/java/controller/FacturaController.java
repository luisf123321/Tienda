/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import dao.IDaoFactura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import models.Categoria;
import models.Cliente;
import models.Detallefactura;
import models.Detallescompra;
import models.Empleado;
import models.Factura;
import models.Item;
import models.Producto;

/**
 *
 * @author luis
 */
public class FacturaController implements IDaoFactura {

    ProductoController productoController = lookupProductoControllerBean();
    
    UserTransaction transaction;
    
    private EntityManagerFactory emf;

    public FacturaController() {
    }

    public FacturaController(EntityManagerFactory emf) throws NamingException {
        this.transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");       
        this.emf = emf;
    }    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    

    @Override
    public List<Factura> getFacturas() {
        return findFacturaEntities(true,-1,-1);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    @Override
    public Factura createFactura(Factura factura) throws RollbackFailureException, Exception {
        
        EntityManager em = null;
        String message = "";
        try {
            transaction.begin();
            em = getEntityManager();            
            em.persist(factura);            
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
        return factura;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factura getFactura(int id) {
        
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteFactura(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        EntityManager em = null;
        String message = "";
        System.out.println(id);
        try {
            transaction.begin();
            em = getEntityManager();
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getId();
            } catch (EntityNotFoundException enfe) {
                message = "no existe factura";
                System.out.println(message);
                throw new NonexistentEntityException("la factura " + id + " no existe.", enfe);
            }            
            em.remove(factura);
            transaction.commit();
            message = "ok";
        } catch (Exception ex) {
            try {
                message = "error eliminar factura";
                transaction.rollback();
            } catch (Exception re) {
                message = "error roll back factura";
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
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
    public Factura updateFactura(Factura factura) throws NonexistentEntityException, RollbackFailureException, Exception {
        
        EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();            
            factura = em.merge(factura);            
            transaction.commit();
        } catch (Exception ex) {
            try {
                transaction.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getId();
                if (getFactura(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return factura;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String confirmarCompraEmpleado(HttpServletRequest request, int idpago) throws Exception{
        HttpSession session = request.getSession(false);
	ArrayList cart = (ArrayList) session.getAttribute("cart");
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Empleado emp = (Empleado) session.getAttribute("empleado");
        
        
        if (cart == null && cliente ==null && idpago==0) {
            return "error cliente o articulos o forma de pago";
	}
        
        DetalleController detalle = new DetalleController();
        
        double total=0; 
        for(int i=0;i<cart.size();i++){
            Item itemcar = (Item) cart.get(i);
            int idcar = itemcar.getIdproducto();
            int cantidadcar = itemcar.getCantidad();                       
            Producto idproducto = productoController.getProducto(idcar);            
            double valor = idproducto.getPrecio()*cantidadcar;           
            total = total +valor;
            
            
        }
        PagoController pagcon = new PagoController();
        Factura fac = new Factura();
        fac.setFecha(new Date());
        fac.setIdcliente(cliente);
        fac.setIdempleado(emp);
        fac.setIdpago(pagcon.getPago(idpago));
        fac.setTotal(total);
        createFactura(fac);
        
        DetalleFacturaController dfc = new DetalleFacturaController();
        for(int i=0;i<cart.size();i++){
            Item itemcar = (Item) cart.get(i);
            int idcar = itemcar.getIdproducto();
            int cantidadcar = itemcar.getCantidad();
            Producto idproducto = productoController.getProducto(idcar);
            Detallescompra detallecompra = new Detallescompra();
            detallecompra.setCantidad(cantidadcar);
            detallecompra.setIdproducto(idproducto);
            double valor = idproducto.getPrecio()*cantidadcar;
            detallecompra.setValor(valor);
            
            Detallefactura detallefactura = new Detallefactura();
            detallefactura.setDetallescompra(detallecompra);
            detallefactura.setIdfactura(fac);
            dfc.createDetalleFactura(detallefactura);
            
        }
        return "ok";
    }    

    private ProductoController lookupProductoControllerBean() {
        try {
            Context c = new InitialContext();
            return (ProductoController) c.lookup("java:global/Tienda/ProductoController!controller.ProductoController");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
     
    
}
