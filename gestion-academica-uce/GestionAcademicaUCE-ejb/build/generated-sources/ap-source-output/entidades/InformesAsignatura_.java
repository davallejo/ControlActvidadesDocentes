package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InformesAsignatura.class)
public abstract class InformesAsignatura_ {

	public static volatile SingularAttribute<InformesAsignatura, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<InformesAsignatura, Date> fecha;
	public static volatile SingularAttribute<InformesAsignatura, Semestre> codSemestre;
	public static volatile SingularAttribute<InformesAsignatura, String> observaciones;
	public static volatile SingularAttribute<InformesAsignatura, Periodo> codPeriodo;
	public static volatile ListAttribute<InformesAsignatura, DetalleInformeAsignatura> detalleInformeAsignaturaList;
	public static volatile SingularAttribute<InformesAsignatura, Integer> id;
	public static volatile SingularAttribute<InformesAsignatura, Usuarios> codCoordinador;

}

