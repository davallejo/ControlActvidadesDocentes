package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuarios.class)
public abstract class Usuarios_ {

	public static volatile SingularAttribute<Usuarios, Boolean> estado;
	public static volatile ListAttribute<Usuarios, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Usuarios, String> userPic;
	public static volatile ListAttribute<Usuarios, InformesArea> informesAreaList;
	public static volatile SingularAttribute<Usuarios, String> apellidoP;
	public static volatile SingularAttribute<Usuarios, String> correoInst;
	public static volatile ListAttribute<Usuarios, CarreraDirector> carreraDirectorList;
	public static volatile ListAttribute<Usuarios, InformesAsignatura> informesAsignaturaList;
	public static volatile SingularAttribute<Usuarios, String> userFirma;
	public static volatile ListAttribute<Usuarios, HorarioActividades> horarioActividadesList;
	public static volatile ListAttribute<Usuarios, UsuariosPerfiles> usuariosPerfilesList;
	public static volatile ListAttribute<Usuarios, Proyectos> proyectosList;
	public static volatile ListAttribute<Usuarios, CoordinadorAsignatura> coordinadorAsignaturaList;
	public static volatile SingularAttribute<Usuarios, String> correoPers;
	public static volatile ListAttribute<Usuarios, Cursos> cursosList;
	public static volatile SingularAttribute<Usuarios, String> apellidoM;
	public static volatile SingularAttribute<Usuarios, String> id;
	public static volatile SingularAttribute<Usuarios, String> telefono;
	public static volatile SingularAttribute<Usuarios, String> nombreP;
	public static volatile ListAttribute<Usuarios, RolUsuario> rolUsuarioList;
	public static volatile ListAttribute<Usuarios, DetalleCh> detalleChList;
	public static volatile SingularAttribute<Usuarios, String> userPass;
	public static volatile ListAttribute<Usuarios, DetalleInformeArea> detalleInformeAreaList;
	public static volatile SingularAttribute<Usuarios, String> userName;
	public static volatile SingularAttribute<Usuarios, String> nombreS;
	public static volatile ListAttribute<Usuarios, Cursos> cursosList1;
	public static volatile ListAttribute<Usuarios, Formulario> formularioList;
	public static volatile ListAttribute<Usuarios, CoordinadorArea> coordinadorAreaList;
	public static volatile ListAttribute<Usuarios, ConfiguracionesCh> configuracionesChList;
	public static volatile ListAttribute<Usuarios, AsignaturaDocente> asignaturaDocenteList;
	public static volatile ListAttribute<Usuarios, Notificaciones> notificacionesList;
	public static volatile ListAttribute<Usuarios, RegistroBiometrico> registroBiometricoList;
	public static volatile ListAttribute<Usuarios, SeguimientoSilabo> seguimientoSilaboList1;
	public static volatile ListAttribute<Usuarios, Notificaciones> notificacionesList1;
	public static volatile ListAttribute<Usuarios, CargaHoraria> cargaHorariaList;
	public static volatile ListAttribute<Usuarios, ReporteDocente> reporteDocenteList;

}

