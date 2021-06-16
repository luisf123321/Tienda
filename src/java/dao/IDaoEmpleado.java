/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Empleado;

/**
 *
 * @author luis
 */
public interface IDaoEmpleado {
    
    public List<Empleado> getEmpleado();
    public Empleado createEmpleado(Empleado empleado) throws RollbackFailureException, Exception;
    public Empleado getEmpleado(int id);
    public String deleteEmpleado(int id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Empleado updateEmpleado() throws NonexistentEntityException, RollbackFailureException, Exception;
     
}
