package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AreaAcademica.class)
public abstract class AreaAcademica_ {

	public static volatile ListAttribute<AreaAcademica, CoordinadorArea> coordinadorAreaList;
	public static volatile ListAttribute<AreaAcademica, InformesArea> informesAreaList;
	public static volatile SingularAttribute<AreaAcademica, Integer> id;
	public static volatile ListAttribute<AreaAcademica, Asignaturas> asignaturasList;
	public static volatile SingularAttribute<AreaAcademica, String> nombre;

}

