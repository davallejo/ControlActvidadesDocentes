package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleActaAs.class)
public abstract class DetalleActaAs_ {

	public static volatile SingularAttribute<DetalleActaAs, Date> fecha;
	public static volatile SingularAttribute<DetalleActaAs, CabeceraReunionAs> idReunion;
	public static volatile SingularAttribute<DetalleActaAs, Integer> idDetalle;
	public static volatile SingularAttribute<DetalleActaAs, Boolean> asistencia;
	public static volatile SingularAttribute<DetalleActaAs, byte[]> anexos;
	public static volatile SingularAttribute<DetalleActaAs, String> observaciones;
	public static volatile SingularAttribute<DetalleActaAs, byte[]> firmaCoordinador;

}

