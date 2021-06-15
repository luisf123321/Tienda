/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Categoria;
import models.Cliente;
import models.Producto;

/**
 *
 * @author luis
 */
public interface IDaoCategoria {
    public List<Categoria> getcategorias();
    public String createCategoria(Categoria categoria) throws RollbackFailureException, Exception;
    public Categoria getCategoria(int id);
    public String deleteCategoria(int id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Categoria updateCategoria(Categoria categoria) throws NonexistentEntityException, RollbackFailureException, Exception;
    
}
