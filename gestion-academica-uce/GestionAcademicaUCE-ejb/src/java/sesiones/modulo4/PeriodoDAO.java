

package sesiones.modulo4;

import java.util.List;
import javax.ejb.Local;
import entidades.Periodo;

/**
 *
 * @author VirtualW7
 */
@Local
public interface PeriodoDAO {
    
    void crear(Periodo periodo);
    
    List<Periodo> listar();
    
}
