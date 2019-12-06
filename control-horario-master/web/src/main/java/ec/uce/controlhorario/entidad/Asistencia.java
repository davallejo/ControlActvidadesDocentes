package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author dacopanCM on 15/03/18.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asistencia {
    private String actividad;
    private LocalDate date;
    private LocalTime ingreso;
    private LocalTime salida;
    private String estado;// normal  |  atrazo entrada   |   salida anticipada  |   Falta
    private int estadoNum;//  0      |      1            |          2           |      3
    private int mes;//
    private long minutosAtrazo;
    private long minutosSalida;

}
