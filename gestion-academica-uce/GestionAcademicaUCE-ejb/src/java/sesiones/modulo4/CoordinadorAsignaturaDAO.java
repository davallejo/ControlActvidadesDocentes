/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.Asignaturas;
import java.util.List;
import javax.ejb.Local;
import entidades.CoordinadorAsignatura;

/**
 *
 * @author VirtualW7
 */
public interface CoordinadorAsignaturaDAO {
    
    void crear(CoordinadorAsignatura coordinadorAsignatura);
    
    List<CoordinadorAsignatura> listar(int c);
    
    List<CoordinadorAsignatura> listarId();
    
    Asignaturas getAsignatura (String us);
    
    CoordinadorAsignatura getAsignaturaCoordinador(int c);
    
}
