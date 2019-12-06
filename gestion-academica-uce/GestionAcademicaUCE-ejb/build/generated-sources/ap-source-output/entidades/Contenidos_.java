package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contenidos.class)
public abstract class Contenidos_ {

	public static volatile SingularAttribute<Contenidos, Integer> nItem;
	public static volatile SingularAttribute<Contenidos, String> descripcion;
	public static volatile SingularAttribute<Contenidos, String> mecanismosEval;
	public static volatile ListAttribute<Contenidos, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Contenidos, Integer> sesion;
	public static volatile SingularAttribute<Contenidos, Date> horaClase;
	public static volatile SingularAttribute<Contenidos, Integer> id;
	public static volatile SingularAttribute<Contenidos, Double> porcentaje;
	public static volatile SingularAttribute<Contenidos, String> actividades;
	public static volatile SingularAttribute<Contenidos, Unidades> codUnidad;

}

