package entidades;

import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HorarioActividades.class)
public abstract class HorarioActividades_ {

	public static volatile SingularAttribute<HorarioActividades, Time> horaFin;
	public static volatile SingularAttribute<HorarioActividades, CursoAula> idCursoAula;
	public static volatile SingularAttribute<HorarioActividades, Usuarios> idUsuario;
	public static volatile SingularAttribute<HorarioActividades, Periodo> idPeriodo;
	public static volatile SingularAttribute<HorarioActividades, TipoCh> idTipoch;
	public static volatile SingularAttribute<HorarioActividades, Integer> id;
	public static volatile SingularAttribute<HorarioActividades, Integer> dia;
	public static volatile SingularAttribute<HorarioActividades, Time> horaInicio;

}

