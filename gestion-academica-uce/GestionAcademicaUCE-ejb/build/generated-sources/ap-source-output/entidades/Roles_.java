package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Roles.class)
public abstract class Roles_ {

	public static volatile ListAttribute<Roles, RolUsuario> rolUsuarioList;
	public static volatile SingularAttribute<Roles, Modulos> codModulo;
	public static volatile SingularAttribute<Roles, Integer> id;
	public static volatile SingularAttribute<Roles, String> nombre;
	public static volatile ListAttribute<Roles, RolMod> rolModList;

}

