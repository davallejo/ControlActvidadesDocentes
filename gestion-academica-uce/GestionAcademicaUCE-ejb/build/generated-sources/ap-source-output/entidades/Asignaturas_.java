package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Asignaturas.class)
public abstract class Asignaturas_ {

	public static volatile SingularAttribute<Asignaturas, String> descripcion;
	public static volatile ListAttribute<Asignaturas, CoRequisitos> coRequisitosList1;
	public static volatile ListAttribute<Asignaturas, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Asignaturas, String> tipoAsignatura;
	public static volatile SingularAttribute<Asignaturas, String> resultadosAprendizaje;
	public static volatile ListAttribute<Asignaturas, Silabos> silabosList;
	public static volatile SingularAttribute<Asignaturas, String> objetivoGeneral;
	public static volatile ListAttribute<Asignaturas, InformesAsignatura> informesAsignaturaList;
	public static volatile SingularAttribute<Asignaturas, String> nombre;
	public static volatile SingularAttribute<Asignaturas, Integer> codSilabo;
	public static volatile SingularAttribute<Asignaturas, Carreras> codCarrera;
	public static volatile ListAttribute<Asignaturas, CoordinadorAsignatura> coordinadorAsignaturaList;
	public static volatile ListAttribute<Asignaturas, Cursos> cursosList;
	public static volatile SingularAttribute<Asignaturas, Integer> id;
	public static volatile ListAttribute<Asignaturas, PreRequisitos> preRequisitosList;
	public static volatile SingularAttribute<Asignaturas, String> codigo;
	public static volatile ListAttribute<Asignaturas, DetalleCh> detalleChList;
	public static volatile ListAttribute<Asignaturas, DetalleInformeArea> detalleInformeAreaList;
	public static volatile ListAttribute<Asignaturas, PreRequisitos> preRequisitosList1;
	public static volatile SingularAttribute<Asignaturas, String> objetivosEspecificos;
	public static volatile SingularAttribute<Asignaturas, String> unidadCurricular;
	public static volatile ListAttribute<Asignaturas, Formulario> formularioList;
	public static volatile ListAttribute<Asignaturas, AsignaturaDocente> asignaturaDocenteList;
	public static volatile SingularAttribute<Asignaturas, AreaAcademica> codArea;
	public static volatile SingularAttribute<Asignaturas, Semestre> codSemestre;
	public static volatile SingularAttribute<Asignaturas, Integer> creditos;
	public static volatile SingularAttribute<Asignaturas, String> contribucionFormacionProf;
	public static volatile ListAttribute<Asignaturas, CoRequisitos> coRequisitosList;
	public static volatile ListAttribute<Asignaturas, ReporteDocente> reporteDocenteList;

}

