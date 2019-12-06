package ec.uce.controlhorario.entidad;

import lombok.Data;

import java.sql.Time;

@Data
public class HorarioVisual {

    private Integer id;
    private Periodo periodo;
    private Usuarios usuarios;
    private Time hora;

    private TipoCh actividad1;
    private CursoAula curso1;
    private Integer id1;


    private TipoCh actividad2;
    private CursoAula curso2;
    private Integer id2;

    private TipoCh actividad3;
    private CursoAula curso3;
    private Integer id3;

    private TipoCh actividad4;
    private CursoAula curso4;
    private Integer id4;

    private TipoCh actividad5;
    private CursoAula curso5;
    private Integer id5;

    private TipoCh actividad6;
    private CursoAula curso6;
    private Integer id6;
}
