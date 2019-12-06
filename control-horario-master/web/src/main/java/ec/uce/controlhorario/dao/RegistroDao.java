package ec.uce.controlhorario.dao;

import ec.uce.controlhorario.entidad.RegistroTimbre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author dacopanCM on 15/03/18.
 */
@Repository
public interface RegistroDao extends JpaRepository<RegistroTimbre, Integer> {

    List<RegistroTimbre> findAllByUsuarioIdAndFechaBetween(Integer usuarioId, Date inicio, Date fin);
}
