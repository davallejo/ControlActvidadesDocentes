package ec.uce.controlhorario.dao;

import ec.uce.controlhorario.entidad.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuarios, String> {
}
