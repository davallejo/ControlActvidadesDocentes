package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proyectos.class)
public abstract class Proyectos_ {

	public static volatile SingularAttribute<Proyectos, String> descripcion;
	public static volatile ListAttribute<Proyectos, DetalleProyecto> detalleProyectoList;
	public static volatile SingularAttribute<Proyectos, Date> fechaInicial;
	public static volatile ListAttribute<Proyectos, DetalleCh> detalleChList;
	public static volatile SingularAttribute<Proyectos, Date> fechaFinal;
	public static volatile SingularAttribute<Proyectos, Periodo> codPeriodo;
	public static volatile SingularAttribute<Proyectos, Integer> id;
	public static volatile SingularAttribute<Proyectos, String> nombre;
	public static volatile SingularAttribute<Proyectos, Usuarios> codTutor;

}

