package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notificaciones.class)
public abstract class Notificaciones_ {

	public static volatile SingularAttribute<Notificaciones, String> descripcion;
	public static volatile SingularAttribute<Notificaciones, Date> fecha;
	public static volatile SingularAttribute<Notificaciones, Boolean> estado;
	public static volatile SingularAttribute<Notificaciones, Usuarios> codUsuarioEmisor;
	public static volatile SingularAttribute<Notificaciones, Usuarios> codUsuarioReceptor;
	public static volatile SingularAttribute<Notificaciones, String> adjunto;
	public static volatile SingularAttribute<Notificaciones, String> titulo;
	public static volatile SingularAttribute<Notificaciones, String> modTarea;
	public static volatile SingularAttribute<Notificaciones, Long> id;

}

