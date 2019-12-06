package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoCh.class)
public abstract class TipoCh_ {

	public static volatile ListAttribute<TipoCh, HorarioActividades> horarioActividadesList;
	public static volatile SingularAttribute<TipoCh, Integer> id;
	public static volatile SingularAttribute<TipoCh, String> nombre;
	public static volatile ListAttribute<TipoCh, CargaHoraria> cargaHorariaList;

}

