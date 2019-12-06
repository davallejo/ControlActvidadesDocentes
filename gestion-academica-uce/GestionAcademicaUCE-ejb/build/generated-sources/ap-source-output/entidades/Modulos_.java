package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modulos.class)
public abstract class Modulos_ {

	public static volatile ListAttribute<Modulos, Menu> menuList;
	public static volatile ListAttribute<Modulos, Roles> rolesList;
	public static volatile SingularAttribute<Modulos, Integer> id;
	public static volatile SingularAttribute<Modulos, String> nombre;
	public static volatile ListAttribute<Modulos, PerfMod> perfModList;
	public static volatile ListAttribute<Modulos, RolMod> rolModList;

}

