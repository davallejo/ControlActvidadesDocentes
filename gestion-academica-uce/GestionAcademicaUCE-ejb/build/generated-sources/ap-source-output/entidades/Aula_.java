package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aula.class)
public abstract class Aula_ {

	public static volatile ListAttribute<Aula, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Aula, String> nomenclatura;
	public static volatile ListAttribute<Aula, DetalleCh> detalleChList;
	public static volatile SingularAttribute<Aula, Integer> id;

}

