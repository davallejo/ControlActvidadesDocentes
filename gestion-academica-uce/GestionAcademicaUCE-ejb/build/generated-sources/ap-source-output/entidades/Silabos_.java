package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Silabos.class)
public abstract class Silabos_ {

	public static volatile SingularAttribute<Silabos, String> bibliografiaVirtual;
	public static volatile SingularAttribute<Silabos, Integer> nhPracticas;
	public static volatile ListAttribute<Silabos, SeguimientoSilabo> seguimientoSilaboList;
	public static volatile SingularAttribute<Silabos, String> perfilDocenteProf;
	public static volatile SingularAttribute<Silabos, Integer> nhPresencial;
	public static volatile SingularAttribute<Silabos, Boolean> vigente;
	public static volatile SingularAttribute<Silabos, Integer> evalPractica2h;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosInd2h;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosGrup2h;
	public static volatile SingularAttribute<Silabos, String> perfilDocenteAcadem;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosIntegrador1h;
	public static volatile SingularAttribute<Silabos, String> descripPerfilDocente;
	public static volatile SingularAttribute<Silabos, Integer> nhtVirtual;
	public static volatile SingularAttribute<Silabos, Date> fechaAprobacion;
	public static volatile SingularAttribute<Silabos, Integer> evalAutonomo1h;
	public static volatile SingularAttribute<Silabos, Integer> id;
	public static volatile SingularAttribute<Silabos, Integer> nhtPresencial;
	public static volatile SingularAttribute<Silabos, Boolean> revisionDc;
	public static volatile SingularAttribute<Silabos, Asignaturas> codAsignatura;
	public static volatile ListAttribute<Silabos, Unidades> unidadesList;
	public static volatile SingularAttribute<Silabos, Boolean> aprobado;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosInd1h;
	public static volatile SingularAttribute<Silabos, Integer> evalPractica1h;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosIntegrador2h;
	public static volatile SingularAttribute<Silabos, Integer> evalTrabajosGrup1h;
	public static volatile SingularAttribute<Silabos, String> bibliografia;
	public static volatile SingularAttribute<Silabos, Boolean> revisionDocentes;
	public static volatile SingularAttribute<Silabos, Date> fechaRevision;
	public static volatile SingularAttribute<Silabos, String> observaciones;
	public static volatile SingularAttribute<Silabos, Integer> evalAutonomo2h;
	public static volatile SingularAttribute<Silabos, Periodo> codPeriodo;
	public static volatile SingularAttribute<Silabos, Evaluacion> codEvaluacion;
	public static volatile ListAttribute<Silabos, SilaboBibliografia> silaboBibliografiaList;
	public static volatile SingularAttribute<Silabos, Boolean> revisionCa;
	public static volatile SingularAttribute<Silabos, Date> fechaElaboracion;

}

