package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asistencia {
    private String actividad;
    private LocalDate date;
    private LocalTime ingreso;
    private LocalTime salida;
    private String estado;// normal  |  atrazo entrada   |   salida anticipada  |   Falta   |   entrada anticipada  |   extra   |   Sin salida  |   Sin entrada
    private int estadoNum;//  0      |      1            |          2           |      3    |           4           |     5     |       6       |       7
    private int mes;//
    private long minutosAtrazo;
    private long minutosSalida;
    private long minutosExtra;



}
