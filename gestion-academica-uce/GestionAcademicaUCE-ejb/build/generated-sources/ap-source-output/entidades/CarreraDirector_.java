package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarreraDirector.class)
public abstract class CarreraDirector_ {

	public static volatile SingularAttribute<CarreraDirector, Date> fechaInicio;
	public static volatile SingularAttribute<CarreraDirector, Carreras> codCarrera;
	public static volatile SingularAttribute<CarreraDirector, Periodo> codPeriodo;
	public static volatile SingularAttribute<CarreraDirector, Integer> id;
	public static volatile SingularAttribute<CarreraDirector, Date> fechaFin;
	public static volatile SingularAttribute<CarreraDirector, Usuarios> codDirector;

}

