package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Semestre.class)
public abstract class Semestre_ {

	public static volatile ListAttribute<Semestre, DetalleCh> detalleChList;
	public static volatile ListAttribute<Semestre, DetalleInformeArea> detalleInformeAreaList;
	public static volatile SingularAttribute<Semestre, Integer> id;
	public static volatile ListAttribute<Semestre, Asignaturas> asignaturasList;
	public static volatile ListAttribute<Semestre, InformesAsignatura> informesAsignaturaList;
	public static volatile SingularAttribute<Semestre, String> nombre;
	public static volatile ListAttribute<Semestre, ReporteDocente> reporteDocenteList;

}

