package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CoordinadorAsignatura.class)
public abstract class CoordinadorAsignatura_ {

	public static volatile SingularAttribute<CoordinadorAsignatura, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<CoordinadorAsignatura, Periodo> codPeriodo;
	public static volatile SingularAttribute<CoordinadorAsignatura, Integer> id;
	public static volatile ListAttribute<CoordinadorAsignatura, CabeceraReunionAs> cabeceraReunionAsList;
	public static volatile SingularAttribute<CoordinadorAsignatura, Usuarios> codCoordinador;

}

