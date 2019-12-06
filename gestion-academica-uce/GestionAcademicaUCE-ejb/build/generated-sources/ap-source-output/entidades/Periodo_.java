package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Periodo.class)
public abstract class Periodo_ {

	public static volatile ListAttribute<Periodo, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile ListAttribute<Periodo, InformesArea> informesAreaList;
	public static volatile ListAttribute<Periodo, Silabos> silabosList;
	public static volatile SingularAttribute<Periodo, Date> inicio;
	public static volatile SingularAttribute<Periodo, Date> fin;
	public static volatile ListAttribute<Periodo, CarreraDirector> carreraDirectorList;
	public static volatile ListAttribute<Periodo, InformesAsignatura> informesAsignaturaList;
	public static volatile SingularAttribute<Periodo, String> nombre;
	public static volatile ListAttribute<Periodo, HorarioActividades> horarioActividadesList;
	public static volatile SingularAttribute<Periodo, String> anioFin;
	public static volatile ListAttribute<Periodo, Proyectos> proyectosList;
	public static volatile ListAttribute<Periodo, CoordinadorAsignatura> coordinadorAsignaturaList;
	public static volatile SingularAttribute<Periodo, String> mesInicio;
	public static volatile ListAttribute<Periodo, Cursos> cursosList;
	public static volatile SingularAttribute<Periodo, Integer> id;
	public static volatile ListAttribute<Periodo, CabeceraReunionAs> cabeceraReunionAsList;
	public static volatile SingularAttribute<Periodo, String> anioInicio;
	public static volatile ListAttribute<Periodo, CabeceraReunion> cabeceraReunionList;
	public static volatile ListAttribute<Periodo, ReporteArea> reporteAreaList;
	public static volatile ListAttribute<Periodo, CoordinadorArea> coordinadorAreaList;
	public static volatile ListAttribute<Periodo, ConfiguracionesCh> configuracionesChList;
	public static volatile SingularAttribute<Periodo, String> mesFin;
	public static volatile ListAttribute<Periodo, AsignaturaDocente> asignaturaDocenteList;
	public static volatile SingularAttribute<Periodo, Boolean> activo;
	public static volatile ListAttribute<Periodo, ReporteDocente> reporteDocenteList;

}

