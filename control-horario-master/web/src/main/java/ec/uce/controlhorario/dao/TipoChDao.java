package ec.uce.controlhorario.dao;

import ec.uce.controlhorario.entidad.TipoCh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dacopanCM on 15/03/18.
 */
@Repository
public interface TipoChDao extends JpaRepository<TipoCh, Integer> {
}
