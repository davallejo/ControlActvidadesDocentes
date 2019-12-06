package ec.uce.controlhorario.dao;

import ec.uce.controlhorario.entidad.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dacopanCM on 15/03/18.
 */
@Repository
public interface HorarioDao extends JpaRepository<Horario, Integer> {

    List<Horario> findAllByPeriodoIdAndUsuariosId(Integer periodoId, String usuarioId);
}
