package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleReunion.class)
public abstract class DetalleReunion_ {

	public static volatile SingularAttribute<DetalleReunion, String> horaFin;
	public static volatile SingularAttribute<DetalleReunion, Date> fecha;
	public static volatile SingularAttribute<DetalleReunion, CabeceraReunion> idReunion;
	public static volatile SingularAttribute<DetalleReunion, Integer> idDetalle;
	public static volatile SingularAttribute<DetalleReunion, String> asunto;
	public static volatile SingularAttribute<DetalleReunion, String> horaInicio;

}

