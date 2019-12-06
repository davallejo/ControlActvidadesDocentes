package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleInformeArea.class)
public abstract class DetalleInformeArea_ {

	public static volatile SingularAttribute<DetalleInformeArea, Integer> nUnidadesEstudiadas;
	public static volatile SingularAttribute<DetalleInformeArea, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<DetalleInformeArea, Usuarios> codDocente;
	public static volatile SingularAttribute<DetalleInformeArea, Semestre> codSemestre;
	public static volatile SingularAttribute<DetalleInformeArea, Integer> id;
	public static volatile SingularAttribute<DetalleInformeArea, Float> porcentajeSilabo;
	public static volatile SingularAttribute<DetalleInformeArea, InformesArea> codInformeArea;

}

