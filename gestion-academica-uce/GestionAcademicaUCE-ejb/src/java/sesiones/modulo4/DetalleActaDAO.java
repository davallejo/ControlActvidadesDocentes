/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import java.util.List;
import javax.ejb.Local;
import entidades.DetalleActa;

/**
 *
 * @author VirtualW7
 */
public interface DetalleActaDAO {
    
    void crear(DetalleActa detalleActa);
    
    List<DetalleActa> listar();
    
}
