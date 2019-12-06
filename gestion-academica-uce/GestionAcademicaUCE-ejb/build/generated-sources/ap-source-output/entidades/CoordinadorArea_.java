package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CoordinadorArea.class)
public abstract class CoordinadorArea_ {

	public static volatile ListAttribute<CoordinadorArea, CabeceraReunion> cabeceraReunionList;
	public static volatile SingularAttribute<CoordinadorArea, AreaAcademica> codArea;
	public static volatile ListAttribute<CoordinadorArea, ReporteArea> reporteAreaList;
	public static volatile SingularAttribute<CoordinadorArea, Periodo> codPeriodo;
	public static volatile SingularAttribute<CoordinadorArea, Integer> id;
	public static volatile SingularAttribute<CoordinadorArea, Usuarios> codCoordinador;

}

