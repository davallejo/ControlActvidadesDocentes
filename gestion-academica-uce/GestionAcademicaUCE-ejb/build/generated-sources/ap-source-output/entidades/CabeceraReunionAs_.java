package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CabeceraReunionAs.class)
public abstract class CabeceraReunionAs_ {

	public static volatile SingularAttribute<CabeceraReunionAs, Integer> idReunion;
	public static volatile ListAttribute<CabeceraReunionAs, DetalleActaAs> detalleActaAsList;
	public static volatile SingularAttribute<CabeceraReunionAs, CoordinadorAsignatura> idCoordinadorAsignatura;
	public static volatile SingularAttribute<CabeceraReunionAs, Periodo> idPeriodo;
	public static volatile ListAttribute<CabeceraReunionAs, DetalleReunionAs> detalleReunionAsList;

}

