package sesiones.modulo4;

import java.util.List;
import javax.ejb.Local;
import entidades.AsignaturaDocente;


/**
 *
 * @author VirtualW7
 */
@Local
public interface AsigDocDAO {
    
    void crear(AsignaturaDocente asigDoc);
    
    List<AsignaturaDocente> listar();
    
}
