/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo1;

import entidades.HorarioActividades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alex
 */
@Local
public interface HorarioDao {

    void create(HorarioActividades horarioActividades);

    void edit(HorarioActividades horarioActividades);

    void remove(HorarioActividades horarioActividades);

    HorarioActividades find(Object id);

    List<HorarioActividades> findAll();

    List<HorarioActividades> findRange(int[] range);

    int count();

    List<HorarioActividades> findAllByPeriodoIdAndUsuariosId(Integer periodoId, String usuarioId);

    void deleteFromUser(String usuarioId);

}
