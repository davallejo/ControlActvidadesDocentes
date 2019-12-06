/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import java.util.List;
import javax.ejb.Local;
import entidades.DetalleReunionAs;

/**
 *
 * @author VirtualW7
 */
public interface DetalleReunionAsDAO {
    
     void crear(DetalleReunionAs periodo);
    
    List<DetalleReunionAs> listar();
    
    
}
