package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SeguimientoSilabo.class)
public abstract class SeguimientoSilabo_ {

	public static volatile SingularAttribute<SeguimientoSilabo, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<SeguimientoSilabo, Usuarios> codDocente;
	public static volatile SingularAttribute<SeguimientoSilabo, Usuarios> codEstudiante;
	public static volatile SingularAttribute<SeguimientoSilabo, Date> fechaDocente;
	public static volatile SingularAttribute<SeguimientoSilabo, String> observacionesEstudiante;
	public static volatile SingularAttribute<SeguimientoSilabo, Date> horaInicio;
	public static volatile SingularAttribute<SeguimientoSilabo, String> estadoContenido;
	public static volatile SingularAttribute<SeguimientoSilabo, Date> horaFin;
	public static volatile SingularAttribute<SeguimientoSilabo, Aula> codAula;
	public static volatile SingularAttribute<SeguimientoSilabo, Silabos> codSilabo;
	public static volatile SingularAttribute<SeguimientoSilabo, Cursos> codCurso;
	public static volatile SingularAttribute<SeguimientoSilabo, Boolean> confirmacionEstudiante;
	public static volatile SingularAttribute<SeguimientoSilabo, Periodo> codPeriodo;
	public static volatile SingularAttribute<SeguimientoSilabo, Long> id;
	public static volatile SingularAttribute<SeguimientoSilabo, Contenidos> codContenido;
	public static volatile SingularAttribute<SeguimientoSilabo, Unidades> codUnidad;
	public static volatile SingularAttribute<SeguimientoSilabo, String> observacionDocente;
	public static volatile SingularAttribute<SeguimientoSilabo, Date> fechaEstudiante;

}

