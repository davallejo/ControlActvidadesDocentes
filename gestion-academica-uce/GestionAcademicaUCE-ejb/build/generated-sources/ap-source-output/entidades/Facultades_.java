package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facultades.class)
public abstract class Facultades_ {

	public static volatile SingularAttribute<Facultades, String> vision;
	public static volatile SingularAttribute<Facultades, Integer> id;
	public static volatile SingularAttribute<Facultades, String> mision;
	public static volatile SingularAttribute<Facultades, String> nombre;
	public static volatile ListAttribute<Facultades, Carreras> carrerasList;

}

