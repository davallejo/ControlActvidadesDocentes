package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleInformeAsignatura.class)
public abstract class DetalleInformeAsignatura_ {

	public static volatile SingularAttribute<DetalleInformeAsignatura, Integer> nPromovidos;
	public static volatile SingularAttribute<DetalleInformeAsignatura, Integer> nNoPromovidos;
	public static volatile SingularAttribute<DetalleInformeAsignatura, Float> porcentajeAprobados;
	public static volatile SingularAttribute<DetalleInformeAsignatura, String> curso;
	public static volatile SingularAttribute<DetalleInformeAsignatura, Integer> nDesertores;
	public static volatile SingularAttribute<DetalleInformeAsignatura, InformesAsignatura> codInformeAsignatura;
	public static volatile SingularAttribute<DetalleInformeAsignatura, Integer> id;
	public static volatile SingularAttribute<DetalleInformeAsignatura, Integer> totalEstudiantes;

}

