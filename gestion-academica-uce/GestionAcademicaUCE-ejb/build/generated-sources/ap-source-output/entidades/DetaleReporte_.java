package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetaleReporte.class)
public abstract class DetaleReporte_ {

	public static volatile SingularAttribute<DetaleReporte, Float> porcentajeSilabus;
	public static volatile SingularAttribute<DetaleReporte, Integer> idDetalle;
	public static volatile SingularAttribute<DetaleReporte, Integer> unidades;
	public static volatile SingularAttribute<DetaleReporte, String> observaciones;
	public static volatile SingularAttribute<DetaleReporte, ReporteArea> idReporte;

}

