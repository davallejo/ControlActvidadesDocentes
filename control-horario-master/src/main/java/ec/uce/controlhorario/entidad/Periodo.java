package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "periodo")
public class Periodo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 6, scale = 0)
    Integer id;

    @Column(name = "NOMBRE", length = 80)
    String nombre;

    @Column(name = "INICIO", length = 7)
    Date inicio;

    @Column(name = "FIN", length = 7)
    Date fin;

}
