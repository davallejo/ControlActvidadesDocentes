package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CargaHoraria.class)
public abstract class CargaHoraria_ {

	public static volatile SingularAttribute<CargaHoraria, Date> horaFin;
	public static volatile SingularAttribute<CargaHoraria, Date> fecha;
	public static volatile SingularAttribute<CargaHoraria, Date> horaInicial;
	public static volatile SingularAttribute<CargaHoraria, String> tema;
	public static volatile SingularAttribute<CargaHoraria, String> horario;
	public static volatile ListAttribute<CargaHoraria, DetalleCh> detalleChList;
	public static volatile SingularAttribute<CargaHoraria, Usuarios> codDocente;
	public static volatile SingularAttribute<CargaHoraria, TipoCh> codTipoCh;
	public static volatile SingularAttribute<CargaHoraria, Integer> id;

}

