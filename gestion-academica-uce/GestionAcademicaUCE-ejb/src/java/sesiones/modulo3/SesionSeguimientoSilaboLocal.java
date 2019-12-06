/**
 * Descripción de la clase: Implementacion de la Interfaz Local de Sesion del servicio en arquitectura
 *                          EJB para gestion del Seguimiento de Silabo
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br> *
 *
 */
package sesiones.modulo3;

import entidades.Asignaturas;
import entidades.Cursos;
import entidades.SeguimientoSilabo;
import entidades.Silabos;
import entidades.Usuarios;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SesionSeguimientoSilaboLocal {
    
    public Asignaturas obtenerAsignaturaPorId(int id);
    
    /*Selecciona los cursos disponibles actuales*/
    List<Cursos> obtenerCursosDisponibles();
        
    
    //----- METODOS DOCENTE ----- \\
    /*Selecciona los cursos que el docente logeado imparte en el periodo actual*/
    List<Cursos> obtenerCursosDocente(String us);    
    
    /*Obtiene el silabo correspondiente a la asignatura seleccionada*/
    public Silabos obtenerSilaboMateria(Asignaturas codAsign);
        
    /*Lista de temas tratados por docente y materia*/
    public List<SeguimientoSilabo> listaContenidosTratados(Usuarios dcnt, Asignaturas asg, Cursos crs);
    
    /*Guarda el tema dado por el docente para el seguimiento de silabo*/
    public void registrarSegSilabo(SeguimientoSilabo segSilabo);  
   
    
    // ----- METODOS ESTUDIANTE ----- \\
    /*Obtiene los cursos que el estudianet esta designado como presidente*/
    List<Cursos> obtenerCursosEstudiante(String us);
    
    /*Lista los items tratados de un silabo por estudiante*/
    public List<SeguimientoSilabo> listaSilabosEst(Long c, String est); 
    
    /*Realiza las modificaciones del siguimiento por parte del estudiante*/
    public void modificarSegSilabo(SeguimientoSilabo segSilaboEst);
    
    /*Lista los temas impartidos de un silabo que ya han sido confirmados por estudiante*/
    public List<SeguimientoSilabo> listaSilabosEstConfirm(Long c, String est);
    
    
    //----- METODOS DIRECTOR(A) ----- \\
    /*Obtiene la lista de usuarios de rol docente*/
    public List<Usuarios> listadoDocentes();
    
    //----- OTROS METODOS ------- \\
    /*Obtiene la lista de usuarios de rol estudiante*/
    public List<Usuarios> listadoEstudiantes();
    
    /*Actualizar la tabla de cursos*/
    void actualizarCursos(Cursos curso);
}
