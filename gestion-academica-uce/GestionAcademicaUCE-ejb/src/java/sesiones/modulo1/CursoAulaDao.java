/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo1;

import entidades.CursoAula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alex
 */
@Local
public interface CursoAulaDao {

    void create(CursoAula cursoAula);

    void edit(CursoAula cursoAula);

    void remove(CursoAula cursoAula);

    CursoAula find(Object id);

    List<CursoAula> findAll();
    
    List<CursoAula> findAllAulasByOrder();

    List<CursoAula> findRange(int[] range);

    int count();
    
}
