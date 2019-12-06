package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

/**
 * @author dacopanCM on 15/03/18.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HORARIO")
public class Horario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 6, scale = 0)
    private Integer id;

    @Column(name = "HORA_INICIO", length = 7)
    private Time horaInicio;

    @Column(name = "HORA_FIN", length = 7)
    private Time horaFin;

    private int dia;

    private String curso;

    @ManyToOne
    @JoinColumn(name = "id_tipoch")
    private TipoCh actividad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;


    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private Periodo periodo;
}
