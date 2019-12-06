package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleProyecto.class)
public abstract class DetalleProyecto_ {

	public static volatile SingularAttribute<DetalleProyecto, String> descripcionAvance;
	public static volatile SingularAttribute<DetalleProyecto, Float> avanceEstimado;
	public static volatile SingularAttribute<DetalleProyecto, String> evidencia;
	public static volatile SingularAttribute<DetalleProyecto, Float> avanceReal;
	public static volatile SingularAttribute<DetalleProyecto, Proyectos> codProyecto;
	public static volatile SingularAttribute<DetalleProyecto, Integer> id;

}

