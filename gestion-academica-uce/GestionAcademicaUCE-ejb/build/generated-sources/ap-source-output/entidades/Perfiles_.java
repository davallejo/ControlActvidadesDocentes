package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfiles.class)
public abstract class Perfiles_ {

	public static volatile ListAttribute<Perfiles, UsuariosPerfiles> usuariosPerfilesList;
	public static volatile SingularAttribute<Perfiles, Integer> horaEstablecida;
	public static volatile SingularAttribute<Perfiles, Integer> id;
	public static volatile SingularAttribute<Perfiles, String> nombre;
	public static volatile ListAttribute<Perfiles, PerfMod> perfModList;

}

