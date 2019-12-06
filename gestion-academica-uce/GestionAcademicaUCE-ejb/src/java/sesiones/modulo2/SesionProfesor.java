/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.fupd
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pochini
 */
@Stateful
public class SesionProfesor implements SesionProfesorLocal {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    @Override
    public void metodoPrueba() {

        try {
            em.createNamedQuery("Roles.findAll", Roles.class).getResultList();
            System.out.println(":::::::::::::::::::::::::.LOGIN EXITO:::::::::::::::::::::");

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.LOGIN FAIL:::::::::::::::::::::" + e);

        }
    }

    @Override
    public List<Roles> getRoles() {
        try {
            System.out.println(":::::::::::::::::::::::::.RECUPERACION DE ROLES EXITO:::::::::::::::::::::");
            return em.createNamedQuery("Roles.findAll", Roles.class).getResultList();

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.RECUPERAR ROLES FAIL:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public List<Perfiles> getPerfiles() {
        try {
            System.out.println(":::::::::::::::::::::::::.RECUPERACION DE PERFILES EXITO:::::::::::::::::::::");
            return em.createNamedQuery("Perfiles.findAll", Perfiles.class).getResultList();

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.RECUPERAR PERFILES FAIL:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Usuarios loginUsuario(String correo, String pass) {
        try {
            Usuarios u = em.createNamedQuery("Usuarios.findByLogin", Usuarios.class).setParameter("correoInst", correo)
                    .setParameter("pass", pass).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.LOGIN EXITO:::::::::::::::::::::");

            return u;
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.LOGIN FAIL:::::::::::::::::::::" + e);
            return null;
        }

    }

    @Override
    public List<Aula> obtenerAulas() {

        List<Aula> aulas = null;
        try {
            aulas = em.createNamedQuery("Aula.findAll", Aula.class).getResultList();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + aulas.size());
            return aulas;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return aulas;
        }

    }

    @Override
    public List<Asignaturas> obtenerAsignaturtas() {
        List<Asignaturas> asignaturas = null;
        try {
            asignaturas = em.createNamedQuery("Asignaturas.findAll", Asignaturas.class).getResultList();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + asignaturas.size());
            return asignaturas;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return asignaturas;
        }
    }

    @Override
    public List<Semestre> obtenerSemestres() {
        List<Semestre> semestres;
        semestres = new ArrayList<>();
        try {
            semestres = em.createNamedQuery("Semestre.findAll", Semestre.class).getResultList();
            System.out.println(":::::::::::::::::::::::::.consulta de semestres exito:::::::::::::::::::::" + semestres);
            return semestres;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.semestres fail:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public TipoCh obtenerTipoCh(int codigo) {
        TipoCh tipoch;
        try {
            tipoch = em.createNamedQuery("TipoCh.findById", TipoCh.class).setParameter("id", codigo).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + tipoch.getNombre());
            return tipoch;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Asignaturas obtenerCodMateriaPorNombre(String nombre_materia) {
        Asignaturas asignatura;
        try {
            asignatura = em.createNamedQuery("Asignaturas.findByNombre", Asignaturas.class).setParameter("nombre", nombre_materia).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + asignatura.getNombre());
            return asignatura;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Aula obtenerCodAulaPornombre(String nombre_aula) {
        Aula aula;
        try {
            aula = em.createNamedQuery("Aula.findByNomenclatura", Aula.class).setParameter("nomenclatura", nombre_aula).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + aula.getNomenclatura());
            return aula;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Cursos obtenerCursoPorId(int codigo_curso) {
        Cursos curso;
        try {
            curso = em.createNamedQuery("Cursos.findById", Cursos.class).setParameter("id", codigo_curso).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::" + curso.getNomenclatura());
            return curso;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public boolean guardarDatosCargaHoraria(DetalleCh detalleCh) {
        try {
            em.persist(detalleCh);
            return true;
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.fail guradando DetalleCh:::::::::::::::::::::" + e);
            return false;
        }
    }

    @Override
    public boolean guardarCargaHoraria(CargaHoraria cargahoraria) {
        try {
            em.persist(cargahoraria);
            return true;
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.nno se guardo la carga horaria:::::::::::::::::::::" + e);
            return false;
        }
    }

    @Override
    public List<Proyectos> obtenerProyectos() {

        try {
            List<Proyectos> proyectos;
            proyectos = em.createNamedQuery("Proyectos.findAll", Proyectos.class).getResultList();
            return proyectos;
        } catch (Exception e) {
            System.out.println(" ERROR >>--------------> " + e);
            return null;
        }

    }

    @Override
    public Usuarios getUsuario(String codUsuario) {
        Usuarios usuario;
        try {

            usuario = em.createNamedQuery("Usuarios.findById", Usuarios.class).setParameter("id", codUsuario).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.exito recuperar usuario:::::::::::::::::::::" + usuario.getUserName());
            return usuario;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.fail recuperar usuario:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Proyectos getProyectoByNombre(String nombre_proyecto) {
        Proyectos proy;
        try {
            proy = em.createNamedQuery("Proyectos.findByNombre", Proyectos.class).setParameter("nombre", nombre_proyecto).getSingleResult();
            return proy;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.fail recuperar pryecto por nombre:::::::::::::::::::::-----" + e);
            return null;
        }
    }

    @Override
    public boolean guardarNuevoUsuario(Usuarios usuario) {
        try {
            em.persist(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("...................." + e);
            return false;
        }
    }

    @Override
    public List<Usuarios> obtenerListaProfesores(int tipo) {
        List<Usuarios> usuarios;
        try {
            usuarios = em.createNamedQuery("Usuarios.findAll", Usuarios.class).getResultList();

            System.out.println(":::::::::::::::::::::::::SE HAN RECUPERADO LOS USUARIOS BIEN.:::::::::::::::::::::");

            return usuarios;
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.ERROR AL RECUPERAR TODOS LOS USUARIOS:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public Proyectos obtenerProyectoPorId(int cod) {
        Proyectos pro;
        try {
            pro = em.createNamedQuery("Proyectos.findById", Proyectos.class).setParameter("id", cod).getSingleResult();

            System.out.println(":::::::::::::::::::::::::SE HAN RECUPERADO PROYECTO POR ID.:::::::::::::::::::::");

            return pro;
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.ERROR AL RECUPERAR PROYECTO POR ID:::::::::::::::::::::" + e);
            return null;
        }
    }

    @Override
    public boolean crearProyecto(Proyectos proy) {
        try {
            em.persist(proy);
            return true;
        } catch (Exception e) {
            System.out.println("......error al crear proyecto.............." + e);
            return false;
        }
    }

    @Override
    public boolean eliminarProyecto(int cod) {
        Proyectos pro_eli = this.obtenerProyectoPorId(cod);
        try {
            em.remove(pro_eli);
            System.out.println("......proyecto eliminado ..............");
            return true;
        } catch (Exception e) {
            System.out.println("......error al eliminar proyecto.............." + e);
            return false;
        }
    }

    @Override
    public Usuarios getUsuarioByCorreo(String correo) {
        Usuarios u;
        try {
            u = em.createNamedQuery("Usuarios.findByCorreoInst", Usuarios.class).setParameter("correoInst", correo).getSingleResult();
            System.out.println("......SE A ENCONTRADO UN USUARIO CON EE CORREO..............");
            return u;
        } catch (Exception e) {
            System.out.println("......SE A PRODUCIDO UNA EXCEPCION CORREO.............." + e);
            return null;
        }
    }

    @Override
    public List<CargaHoraria> getCargaEspecifica(Usuarios usuario, TipoCh tipo) {
        List<CargaHoraria> cargas;
        try {
            cargas = em.createNamedQuery("CargaHoraria.findCargaHorariaEsp", CargaHoraria.class).setParameter("ci", usuario)
                    .setParameter("tipo", tipo).getResultList();
            System.out.println("......SE A ENCONTRADO UN ARREGLO DE CARGAS HORARIAS ESPECIFICAS..............");
            return cargas;
        } catch (Exception e) {
            System.out.println("......NO ....SE A ENCONTRADO UN ARREGLO DE CARGAS HORARIAS ESPECIFICAS.............." + e);
            return null;
        }
    }

    @Override
    public List<TipoCh> getTiposCh() {
        try {
            return em.createNamedQuery("TipoCh.findAll", TipoCh.class).getResultList();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR LOS TIPOS DE CARGA DE USUARIO.............." + e);
            return null;
        }
    }

    @Override
    public TipoCh getTipoChByNombre(String nombreCh) {
        try {
            System.out.println("------------------------------------->AQUI");
            return em.createNamedQuery("TipoCh.findByNombre", TipoCh.class).setParameter("nombre", nombreCh).getSingleResult();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR EL TIPO DE CARGA HORARIA POR EL NOMBRE.............." + e);
            return null;
        }
    }

    @Override
    public List<CargaHoraria> obtenerCargasPorTipoYFecha(TipoCh tipo, Date fecha) {
        try {
            System.out.println("----------------------------->ENTRO EN LA CONSULTA CARGAS GENERAL************");
            return em.createNamedQuery("CargaHoraria.findByTipoYFecha", CargaHoraria.class)
                    .setParameter("tipoCarga", tipo).setParameter("fecha", fecha).getResultList();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR LA LISTA DE CARGA HORARIA POR TIPO Y FECHA.............." + e);
            return null;
        }
    }

    @Override
    public List<Horario> getHorarioById(Horario horario) {
        try {
            return em.createNamedQuery("Horario.findByCodigoHorario", Horario.class)
                    .setParameter("codigoHorario", horario.getIdHorario()).getResultList();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR LA LISTA DE HORARIOS.............." + e);
            return null;
        }
    }

    @Override
    public List<CargaHoraria> getTodasCargarPorFechayUsuario(TipoCh tipo, Date fecha, Usuarios user) {
        try {
            System.out.println("-----------------LOS PARAMETROS SON----------------------" + tipo + "---" + fecha + "---" + user);
            return em.createNamedQuery("CargaHoraria.findByTipoYFechaYUser", CargaHoraria.class)
                    .setParameter("tipoCarga", tipo).setParameter("fecha", fecha)
                    .setParameter("ci", user).getResultList();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR LA LISTA DE CARGA HORARIA POR TIPO Y FECHA Y USUARIO.............." + e);
            return null;
        }
    }

    @Override
    public Semestre getSemestreById(int id) {
        try {
            return em.createNamedQuery("Semestre.findById", Semestre.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println("......NO ....SE A PODIDO RECUPERAR EL SEMESTRE POR ID.............." + e);
            return null;
        }
    }

    @Override
    public Boolean upDateCargaHoria(CargaHoraria carga) {
        try {
            System.out.println(".cargar llego ." + carga);

            em.merge(carga);
            em.merge(carga.getDetalleChList().get(0));
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO ACTUALIZAR LA CARGAHORARIA*******************" + e);
            return false;
        }
    }

    @Override
    public Confi obternerConfiguracionGeneral(int id) {
        try {
            Confi configuracionHoras;
            configuracionHoras = em.createNamedQuery("Confi.findById", Confi.class).setParameter("id", id).getSingleResult();
            return configuracionHoras;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LA CONFIGURACION DE HORAS*******************" + e);
            return null;
        }
    }

    @Override
    public List<Asignaturas> getMaterias() {
        try {

            return em.createNamedQuery("Asignaturas.findAll", Asignaturas.class).getResultList();

        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LAS MATERIAS*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean guardarConfiguracionGeneralHoras(Confi confi) {
        try {

            em.merge(confi);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO GUARDAR LA CONFIGURACION*******************" + e);
            return false;
        }
    }

    @Override
    public Boolean eliminarMateriaPorNombre(String asignatura) {
        try {

            System.out.println("nombre A eliminar ------> " + asignatura);
            Asignaturas a = this.obtenerMateriaPorNombre(asignatura);
            em.remove(a);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO ELIMINAR LA MATERIA POR NOMBRE*******************" + e);
            return false;
        }
    }

    @Override
    public Asignaturas obtenerMateriaPorNombre(String nombre_asignatura) {
        try {
            System.out.println("");
            return em.createNamedQuery("Asignaturas.findByNombre", Asignaturas.class).setParameter("nombre", nombre_asignatura)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LA ASIGNATURA*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean guardarMateria(Asignaturas materia) {
        try {

            em.persist(materia);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO GUARDAR LA MATERIA*******************" + e);
            return false;
        }
    }

    @Override
    public List<AreaAcademica> obtenerAreasAcademicas() {
        try {

            return em.createNamedQuery("AreaAcademica.findAll", AreaAcademica.class).getResultList();

        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LAS AREAS ACADEMICAS*******************" + e);
            return null;
        }
    }

    @Override
    public List<Carreras> obtenerCarreras() {
        try {

            return em.createNamedQuery("Carreras.findAll", Carreras.class).getResultList();

        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LAS CARRERAS*******************" + e);
            return null;
        }
    }

    @Override
    public List<Silabos> obtenerSilabos() {
        try {

            return em.createNamedQuery("Silabos.findAll", Silabos.class).getResultList();

        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LOS SILABOS*******************" + e);
            return null;
        }
    }

    @Override
    public List<Semestre> ObtenerSemestres() {
        try {

            return em.createNamedQuery("Semestre.findAll", Semestre.class).getResultList();

        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LOS SEMESTRES*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean guardarCarrera(Carreras carrera) {
        try {

            em.persist(carrera);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO GUARDAR LA CARRERA*******************" + e);
            return false;
        }
    }

    @Override
    public Facultades obtenerFacultadPorId(int id) {
        try {

            return em.createNamedQuery("Facultades.findById", Facultades.class).setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LA FACULTAD*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean eliminarCarrera(String nombre) {
        try {
            System.out.println("ENTRO A ELIMINAR CARRERA " + nombre);
            Carreras c = em.createNamedQuery("Carreras.findByNombre", Carreras.class).setParameter("nombre", nombre)
                    .getSingleResult();
            System.out.println("CARRERA A ELIMINAR  " + c.getNombre() + " -- " + c.getId());
            em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO BORRAR LA CARRERA*******************" + e);
            return false;
        }
    }

    @Override
    public Carreras obtenerCarreraPorNombre(String nombre) {
        try {
            System.out.println("NOMBRE CONSULTADO -----> " + nombre);
            return em.createNamedQuery("Carreras.findByNombre", Carreras.class).setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LA CARRERA POR NOMBRE*******************" + e);
            return null;
        }
    }

    @Override
    public AreaAcademica obtenerAreaPorNombre(String nombre) {
        try {

            return em.createNamedQuery("AreaAcademica.findByNombre", AreaAcademica.class).setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR EL AREA ACADEMICA POR NOMBRE*******************" + e);
            return null;
        }
    }

    @Override
    public Silabos obtenerSilaboPorId(int id) {
        try {

            return em.createNamedQuery("Silabos.findById", Silabos.class).setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR EL SILABO POR NOMBRE*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean eliminarProyectoPorNombre(String nombre) {
        try {
            Proyectos p = em.createNamedQuery("Proyectos.findByNombre", Proyectos.class).setParameter("nombre", nombre)
                    .getSingleResult();
            em.remove(p);
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR EL SILABO POR NOMBRE*******************" + e);
            return false;
        }
    }

    @Override
    public List<Cursos> getCursosAsignatura() {
        return null;
    }

    @Override
    public void actualizarUsuario(Usuarios usuario) {

        try {
            em.merge(usuario);
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO ACTUALIZAR EL USARIO*******************" + e);

        }
    }

    @Override
    public List<Paralelo> obtenerParalelos() {
        try {
            return em.createNamedQuery("Paralelo.findAll", Paralelo.class).getResultList();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LOS PARALELOS*******************" + e);
            return null;
        }
    }

    @Override
    public List<Periodo> obtenerPeriodos() {
        try {
            return em.createNamedQuery("Periodo.findAll", Periodo.class).getResultList();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR LOS PARIODOS*******************" + e);
            return null;
        }
    }

    @Override
    public Boolean borrarCurso(Cursos curso) {
        try {
            Query q = em.createNativeQuery("DELETE FROM Cursos WHERE id= ?");
            q.setParameter(1, curso.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO ELIMINAR EL CURSO*******************" + e);
            return false;
        }
    }

    @Override
    public Periodo getPeriodoActual() {
        try {
            return em.createNamedQuery("Periodo.findByActivo", Periodo.class).
                    setParameter("activo", true).getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR EL PERIODO ACTIVO*******************" + e);
            return null;
        }

    }

    @Override
    public Proyectos obtenerProyectoPorNombre(String nombre) {

        try {
            return em.createNamedQuery("Proyectos.findByNombre", Proyectos.class).
                    setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO RECUPERAR EL PROYECTO POR NOMBRE*******************" + e);
            return null;
        }
    }

    @Override
    public void activarPeriodo(Periodo periodo) {
        try {
            //Query q1= em.createNativeQuery("UPDATE Periodo SET activo = FALSE");
            //q1.executeUpdate();

            Query query = em.createQuery("UPDATE Periodo SET activo = FALSE");
            query.executeUpdate();

//            List<Periodo> pers = em.createNamedQuery("PerfMod.findAll", Periodo.class).getResultList();
//            for (Periodo per : pers) {
//                per.setActivo(Boolean.FALSE);
//                System.out.println("testttt:: " + per.getActivo());
//                em.merge(per);
//            }
            periodo.setActivo(Boolean.TRUE);
            System.out.println("testttt:: " + periodo.getActivo());
            em.merge(periodo);
        } catch (Exception e) {
            System.out.println("testt PERIODO:::: " + e);
        }
    }

}
