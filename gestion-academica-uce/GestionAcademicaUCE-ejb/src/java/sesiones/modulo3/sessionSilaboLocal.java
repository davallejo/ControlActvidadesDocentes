/**
 * Descripción de la clase: Implementacion de la Interfaz Local de Sesion del servicio en arquitectura
 *                          EJB para gestion del Seguimiento de Silabo
 *
 * @author Diego Navarrete
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br>
 *
 *
 */
package sesiones.modulo3;

import entidades.AreaAcademica;
import entidades.Asignaturas;
import entidades.Carreras;
import entidades.Contenidos;
import entidades.Cursos;
import entidades.Facultades;
import entidades.Periodo;
import entidades.Semestre;
import entidades.Silabos;
import entidades.Unidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface sessionSilaboLocal {

    boolean insertarSilabos(Silabos silabo);

    void insertarAsignaturas(Asignaturas asignatura);

    List<Asignaturas> listarAsignatura();

    List<Carreras> listarCarreras();

    List<Facultades> listarFacultaders();

    List<AreaAcademica> listarAreaAcademica();

    List<Semestre> listarCursos();

    List<Periodo> listarPeriodo();

    List<Silabos> listarSilabo();

    List<Unidades> listarUnidades(Silabos cod);

    List<Contenidos> listarContenidos(Unidades cod);

    List<Silabos> listarSilaboAsignatura(int us, int cp);

    void insertarUnidades(Unidades unidades);

    void insertarContenidos(Contenidos contenido);

    void escogerAsignaturaSilabo(Asignaturas asigntura, Asignaturas asignaturaMod);

    void ModificarAsignatura(Asignaturas asignatura);

    void insertarSemestre(Semestre semestre);

    void insertarAreaAcademica(AreaAcademica areaAcademica);

    void registrarFacultad(Facultades facultad);

    void insertarCarrera(Carreras carrera);

    void insetarAsignatua(Asignaturas asignatura);

    void borrarSilabos(Silabos silabo);

    void modificarSilabos(Silabos silabo);
    
    void modificarUnidades(Unidades unidades);
    void modificarContenidos(Contenidos contenidos);
}
