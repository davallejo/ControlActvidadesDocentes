package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author dacopanCM on 15/03/18.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registro_biometrico")
public class RegistroTimbre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 6, scale = 0)
    Integer id;

    Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuarios usuario;
}
