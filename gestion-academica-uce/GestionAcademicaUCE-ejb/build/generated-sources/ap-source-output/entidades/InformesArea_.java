package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InformesArea.class)
public abstract class InformesArea_ {

	public static volatile SingularAttribute<InformesArea, Date> fecha;
	public static volatile SingularAttribute<InformesArea, AreaAcademica> codArea;
	public static volatile SingularAttribute<InformesArea, String> observaciones;
	public static volatile ListAttribute<InformesArea, DetalleInformeArea> detalleInformeAreaList;
	public static volatile SingularAttribute<InformesArea, Periodo> codPeriodo;
	public static volatile SingularAttribute<InformesArea, Integer> id;
	public static volatile SingularAttribute<InformesArea, Usuarios> codCoordinador;

}

