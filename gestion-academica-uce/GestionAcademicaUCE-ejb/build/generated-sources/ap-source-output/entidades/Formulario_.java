package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Formulario.class)
public abstract class Formulario_ {

	public static volatile SingularAttribute<Formulario, Asignaturas> codAsignatura;
	public static volatile SingularAttribute<Formulario, Boolean> estado;
	public static volatile SingularAttribute<Formulario, Date> fechaClase;
	public static volatile SingularAttribute<Formulario, Carreras> codCarrera;
	public static volatile SingularAttribute<Formulario, String> documento;
	public static volatile SingularAttribute<Formulario, Integer> idFormulario;
	public static volatile SingularAttribute<Formulario, Usuarios> codSolicitante;
	public static volatile SingularAttribute<Formulario, String> razon;
	public static volatile SingularAttribute<Formulario, String> observacion;
	public static volatile SingularAttribute<Formulario, Tramite> codTramite;
	public static volatile SingularAttribute<Formulario, Date> fechaFormulario;

}

