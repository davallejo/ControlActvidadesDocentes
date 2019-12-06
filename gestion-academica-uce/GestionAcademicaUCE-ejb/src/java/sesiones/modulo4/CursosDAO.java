/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.Asignaturas;
import entidades.Cursos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author D4N13L
 */
@Local
public interface CursosDAO {
    List<Cursos> listar(Asignaturas codAsign);
}
