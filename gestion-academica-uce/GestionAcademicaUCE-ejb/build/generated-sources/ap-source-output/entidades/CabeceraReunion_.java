package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CabeceraReunion.class)
public abstract class CabeceraReunion_ {

	public static volatile SingularAttribute<CabeceraReunion, Integer> idReunion;
	public static volatile SingularAttribute<CabeceraReunion, CoordinadorArea> idCoordinadorArea;
	public static volatile SingularAttribute<CabeceraReunion, Periodo> idPeriodo;
	public static volatile ListAttribute<CabeceraReunion, DetalleActa> detalleActaList;
	public static volatile ListAttribute<CabeceraReunion, DetalleReunion> detalleReunionList;

}

