package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleReunionAs.class)
public abstract class DetalleReunionAs_ {

	public static volatile SingularAttribute<DetalleReunionAs, String> horaFin;
	public static volatile SingularAttribute<DetalleReunionAs, Date> fecha;
	public static volatile SingularAttribute<DetalleReunionAs, CabeceraReunionAs> idReunion;
	public static volatile SingularAttribute<DetalleReunionAs, Integer> idDetalle;
	public static volatile SingularAttribute<DetalleReunionAs, String> asunto;
	public static volatile SingularAttribute<DetalleReunionAs, String> horaInicio;

}

