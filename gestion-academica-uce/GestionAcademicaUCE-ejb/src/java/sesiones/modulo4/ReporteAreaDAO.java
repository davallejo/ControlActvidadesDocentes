/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import java.util.List;
import javax.ejb.Local;
import entidades.ReporteArea;

/**
 *
 * @author VirtualW7
 */
@Local
public interface ReporteAreaDAO {
    
    void crear(ReporteArea reporteArea);
    
    List<ReporteArea> listar();
    
}
