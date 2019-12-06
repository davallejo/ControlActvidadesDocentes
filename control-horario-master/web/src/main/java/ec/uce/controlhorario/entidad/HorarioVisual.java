package ec.uce.controlhorario.entidad;

import lombok.Data;

import java.sql.Time;

/**
 * @author dacopanCM on 29/03/18.
 */
@Data
public class HorarioVisual {

    private Integer id;
    private Time hora;
    private Periodo periodo;
    private Usuarios usuarios;

    private TipoCh actividad1;
    private String curso1;
    private Integer id1;


    private TipoCh actividad2;
    private String curso2;
    private Integer id2;

    private TipoCh actividad3;
    private String curso3;
    private Integer id3;

    private TipoCh actividad4;
    private String curso4;
    private Integer id4;

    private TipoCh actividad5;
    private String curso5;
    private Integer id5;

    private TipoCh actividad6;
    private String curso6;
    private Integer id6;
}
