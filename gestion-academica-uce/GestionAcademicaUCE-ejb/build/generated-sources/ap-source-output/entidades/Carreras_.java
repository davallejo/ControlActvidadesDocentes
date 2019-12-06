package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Carreras.class)
public abstract class Carreras_ {

	public static volatile SingularAttribute<Carreras, String> vision;
	public static volatile SingularAttribute<Carreras, Facultades> codFacultad;
	public static volatile SingularAttribute<Carreras, String> perfilEgreso;
	public static volatile SingularAttribute<Carreras, Integer> id;
	public static volatile ListAttribute<Carreras, Asignaturas> asignaturasList;
	public static volatile ListAttribute<Carreras, CarreraDirector> carreraDirectorList;
	public static volatile SingularAttribute<Carreras, String> mision;
	public static volatile SingularAttribute<Carreras, String> nombre;
	public static volatile ListAttribute<Carreras, Formulario> formularioList;

}

