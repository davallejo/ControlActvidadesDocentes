package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bibliografia.class)
public abstract class Bibliografia_ {

	public static volatile SingularAttribute<Bibliografia, String> descripcion;
	public static volatile SingularAttribute<Bibliografia, String> bibliotecaVirtual;
	public static volatile SingularAttribute<Bibliografia, String> tipo1;
	public static volatile SingularAttribute<Bibliografia, String> tipo2;
	public static volatile SingularAttribute<Bibliografia, Integer> id;
	public static volatile ListAttribute<Bibliografia, SilaboBibliografia> silaboBibliografiaList;
	public static volatile SingularAttribute<Bibliografia, Boolean> disponibilidadUce;

}

