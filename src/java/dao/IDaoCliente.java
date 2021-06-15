/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Cliente;
import models.Producto;

/**
 *
 * @author luis
 */
public interface IDaoCliente {
    
    public List<Cliente> getClientes();
    public String createCliente(Cliente cliente) throws RollbackFailureException, Exception;
    public Cliente getCliente(Integer id);
    public String deleteCliente(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Cliente updateCliente(Cliente cliente) throws NonexistentEntityException, RollbackFailureException, Exception;
    
    
}
