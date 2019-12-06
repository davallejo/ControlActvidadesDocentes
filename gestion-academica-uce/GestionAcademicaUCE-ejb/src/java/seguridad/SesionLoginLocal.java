/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import entidades.Usuarios;
import javax.ejb.Local;
/**
 *
 * @author  Willian Bermeo
 * @version 1.0
 */
@Local
public interface SesionLoginLocal {

    void metodoPrueba();

    Usuarios loginUsuario(String correo, String pass);

}
