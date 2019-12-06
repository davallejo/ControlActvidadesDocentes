package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReporteArea.class)
public abstract class ReporteArea_ {

	public static volatile SingularAttribute<ReporteArea, CoordinadorArea> idCoordinadorArea;
	public static volatile SingularAttribute<ReporteArea, Periodo> idPeriodo;
	public static volatile SingularAttribute<ReporteArea, Integer> idReporte;
	public static volatile ListAttribute<ReporteArea, DetaleReporte> detaleReporteList;

}

