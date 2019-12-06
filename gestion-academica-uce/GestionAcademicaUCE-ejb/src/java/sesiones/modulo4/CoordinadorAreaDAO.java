/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.AreaAcademica;
import java.util.List;
import javax.ejb.Local;
import entidades.CoordinadorArea;

/**
 *
 * @author VirtualW7
 */
@Local
public interface CoordinadorAreaDAO {

    void crear(CoordinadorArea ca);

    List<CoordinadorArea> listar();
    
    List<CoordinadorArea> listarId();
    
    AreaAcademica getArea(String us);
    
    CoordinadorArea getAreaCoordinador(int c);

}
