package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Unidades.class)
public abstract class Unidades_ {

	public static volatile ListAttribute<Unidades, Contenidos> contenidosList;
	public static volatile ListAttribute<Unidades, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Unidades, Integer> nhTutoriasVirtual;
	public static volatile SingularAttribute<Unidades, String> evidAprendizaje;
	public static volatile SingularAttribute<Unidades, Integer> nhTutoriaPresencial;
	public static volatile SingularAttribute<Unidades, Integer> nhAprendizajeTeorico;
	public static volatile SingularAttribute<Unidades, String> resAprendizaje;
	public static volatile SingularAttribute<Unidades, Integer> nhPracticasLab;
	public static volatile SingularAttribute<Unidades, String> nombre;
	public static volatile SingularAttribute<Unidades, String> objetivo;
	public static volatile SingularAttribute<Unidades, Integer> nhTrabajoAutonomo;
	public static volatile SingularAttribute<Unidades, Silabos> codSilabo;
	public static volatile SingularAttribute<Unidades, String> recursosDidactivos;
	public static volatile SingularAttribute<Unidades, Integer> numeral;
	public static volatile SingularAttribute<Unidades, Integer> id;
	public static volatile SingularAttribute<Unidades, String> metodologiaAprendizaje;
	public static volatile SingularAttribute<Unidades, Double> porcentaje;

}

