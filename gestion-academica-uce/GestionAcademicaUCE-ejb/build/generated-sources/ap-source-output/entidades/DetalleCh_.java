package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleCh.class)
public abstract class DetalleCh_ {

	public static volatile SingularAttribute<DetalleCh, Aula> codAula;
	public static volatile SingularAttribute<DetalleCh, String> evidencia;
	public static volatile SingularAttribute<DetalleCh, Proyectos> codProyecto;
	public static volatile SingularAttribute<DetalleCh, Usuarios> codEstudiante;
	public static volatile SingularAttribute<DetalleCh, Semestre> codCurso;
	public static volatile SingularAttribute<DetalleCh, CargaHoraria> codCargaHoraria;
	public static volatile SingularAttribute<DetalleCh, Integer> id;
	public static volatile SingularAttribute<DetalleCh, Asignaturas> codMateria;
	public static volatile SingularAttribute<DetalleCh, String> observacion;
	public static volatile SingularAttribute<DetalleCh, String> actividad;
	public static volatile SingularAttribute<DetalleCh, String> tutor;

}

