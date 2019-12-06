package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleActa.class)
public abstract class DetalleActa_ {

	public static volatile SingularAttribute<DetalleActa, Date> fecha;
	public static volatile SingularAttribute<DetalleActa, CabeceraReunion> idReunion;
	public static volatile SingularAttribute<DetalleActa, Integer> idDetalle;
	public static volatile SingularAttribute<DetalleActa, Boolean> asistencia;
	public static volatile SingularAttribute<DetalleActa, byte[]> anexos;
	public static volatile SingularAttribute<DetalleActa, String> observaciones;
	public static volatile SingularAttribute<DetalleActa, byte[]> firmaCoordinador;

}

