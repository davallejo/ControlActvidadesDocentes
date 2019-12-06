/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.RolUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author VirtualW7
 */
@Local
public interface RolUsuarioDAO {

    void crear(RolUsuario ru);

    List<RolUsuario> listar();

    List<RolUsuario> listarId();

}
