package ec.uce.controlhorario.dao;

import ec.uce.controlhorario.entidad.Perfiles;
import ec.uce.controlhorario.entidad.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoDao extends JpaRepository<Periodo, Integer> {
}
