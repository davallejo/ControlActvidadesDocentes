package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tramite.class)
public abstract class Tramite_ {

	public static volatile SingularAttribute<Tramite, Integer> id;
	public static volatile SingularAttribute<Tramite, String> keyPagina;
	public static volatile SingularAttribute<Tramite, String> nombre;
	public static volatile ListAttribute<Tramite, Formulario> formularioList;

}

