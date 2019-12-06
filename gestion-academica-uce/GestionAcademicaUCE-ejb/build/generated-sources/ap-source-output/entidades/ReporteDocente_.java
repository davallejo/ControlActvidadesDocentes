package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReporteDocente.class)
public abstract class ReporteDocente_ {

	public static volatile SingularAttribute<ReporteDocente, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<ReporteDocente, Date> fecha;
	public static volatile SingularAttribute<ReporteDocente, String> curso;
	public static volatile SingularAttribute<ReporteDocente, Usuarios> codDocente;
	public static volatile SingularAttribute<ReporteDocente, Semestre> codSemestre;
	public static volatile SingularAttribute<ReporteDocente, Periodo> codPeriodo;
	public static volatile SingularAttribute<ReporteDocente, Integer> id;
	public static volatile ListAttribute<ReporteDocente, DetalleReporteDocente> detalleReporteDocenteList;

}

