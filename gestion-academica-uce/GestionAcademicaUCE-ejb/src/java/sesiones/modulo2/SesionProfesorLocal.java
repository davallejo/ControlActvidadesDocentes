/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo2;


import entidades.AreaAcademica;
import entidades.Asignaturas;
import entidades.Aula;
import entidades.CargaHoraria;
import entidades.Carreras;
import entidades.Confi;
import entidades.Cursos;
import entidades.DetalleCh;
import entidades.Facultades;
import entidades.Horario;
import entidades.Paralelo;
import entidades.Perfiles;
import entidades.Periodo;
import entidades.Proyectos;
import entidades.Roles;
import entidades.Semestre;
import entidades.Silabos;
import entidades.TipoCh;
import entidades.Usuarios;
import java.util.Date;
import javax.ejb.Local;
import java.util.List;
/**
 *
 * @author pochini
 */
@Local
public interface SesionProfesorLocal {

    void metodoPrueba();

    Usuarios loginUsuario(String correo, String pass);

    List<Aula> obtenerAulas();

    List<Asignaturas> obtenerAsignaturtas();

    List<Semestre> obtenerSemestres();

    TipoCh obtenerTipoCh(int codigo);

    Asignaturas obtenerCodMateriaPorNombre(String nombre_materia);

    Aula obtenerCodAulaPornombre(String nombre_aula);

    Cursos obtenerCursoPorId(int codigo_curso);

    boolean guardarDatosCargaHoraria(DetalleCh DetalleCh);

    boolean guardarCargaHoraria(CargaHoraria cargahoraria);

    List<Proyectos> obtenerProyectos();

    Usuarios getUsuario(String codUsuario);

    Proyectos getProyectoByNombre(String nombre_proyecto);

    boolean guardarNuevoUsuario(Usuarios usuario);

    List<Usuarios> obtenerListaProfesores(int tipo);

    boolean crearProyecto(Proyectos proy);

    boolean eliminarProyecto(int cod);

    Proyectos obtenerProyectoPorId(int cod);

    Usuarios getUsuarioByCorreo(String correo);

    List<Roles> getRoles();

    List<Perfiles> getPerfiles();

    List<CargaHoraria> getCargaEspecifica(Usuarios usuario, TipoCh tipo);

    List<TipoCh> getTiposCh();

    TipoCh getTipoChByNombre(String nombreCh);

    List<CargaHoraria> obtenerCargasPorTipoYFecha(TipoCh tipo, Date fecha);

    List<Horario> getHorarioById(Horario horario);

    List<CargaHoraria> getTodasCargarPorFechayUsuario(TipoCh tipo, Date fecha,Usuarios user);

    Semestre getSemestreById(int id);

    Boolean upDateCargaHoria(CargaHoraria carga);

    Confi obternerConfiguracionGeneral(int id);

    List<Asignaturas> getMaterias();

    Boolean guardarConfiguracionGeneralHoras(Confi confi);

    Boolean eliminarMateriaPorNombre(String asignatura);

    Asignaturas obtenerMateriaPorNombre(String nombre_asignatura);

    Boolean guardarMateria(Asignaturas materia);

    List<AreaAcademica> obtenerAreasAcademicas();

    List<Carreras> obtenerCarreras();

    List<Silabos> obtenerSilabos();

    List<Semestre> ObtenerSemestres();

    Boolean guardarCarrera(Carreras carrera);

    Facultades obtenerFacultadPorId(int id);

    Boolean eliminarCarrera(String carrera);

    Carreras obtenerCarreraPorNombre(String nombre);

    AreaAcademica obtenerAreaPorNombre(String nombre);

    Silabos obtenerSilaboPorId(int id);

    Boolean eliminarProyectoPorNombre(String nombre);

    List<Cursos> getCursosAsignatura();

    void actualizarUsuario(Usuarios usuario);

    List<Paralelo> obtenerParalelos();

    List<Periodo> obtenerPeriodos();

    Boolean borrarCurso(Cursos curso);

    Periodo getPeriodoActual();

    Proyectos obtenerProyectoPorNombre(String nombre);

    void activarPeriodo(Periodo periodo);
    
    
    
}
