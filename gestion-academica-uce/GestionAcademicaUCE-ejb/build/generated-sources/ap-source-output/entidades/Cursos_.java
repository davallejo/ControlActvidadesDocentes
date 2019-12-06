package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cursos.class)
public abstract class Cursos_ {

	public static volatile SingularAttribute<Cursos, Asignaturas> codAsignatura;
	public static volatile ListAttribute<Cursos, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Cursos, String> horario;
	public static volatile SingularAttribute<Cursos, String> nomenclatura;
	public static volatile SingularAttribute<Cursos, Paralelo> codParalelo;
	public static volatile SingularAttribute<Cursos, Usuarios> codDocente;
	public static volatile SingularAttribute<Cursos, Usuarios> codEstudiante;
	public static volatile SingularAttribute<Cursos, Periodo> codPeriodo;
	public static volatile SingularAttribute<Cursos, Long> id;

}

