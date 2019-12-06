package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AsignaturaDocente.class)
public abstract class AsignaturaDocente_ {

	public static volatile SingularAttribute<AsignaturaDocente, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<AsignaturaDocente, Usuarios> codDocente;
	public static volatile SingularAttribute<AsignaturaDocente, Periodo> codPeriodo;
	public static volatile SingularAttribute<AsignaturaDocente, Integer> id;

}

