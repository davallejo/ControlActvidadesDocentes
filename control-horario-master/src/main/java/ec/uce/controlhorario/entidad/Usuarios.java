package ec.uce.controlhorario.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuarios {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 6, scale = 0)
    private String id;

    @Column(name = "USER_NAME", length = 80)
    private String userName;

    @Column(name = "NOMBRE_P", length = 80)
    private String nombreP;

    @Column(name = "APELLIDO_P", length = 80)
    private String apellidoP;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_perfiles",
            joinColumns = @JoinColumn(
                    name = "cod_usuario", referencedColumnName = "id",table =  "usuarios"),
            inverseJoinColumns = @JoinColumn(
                    name = "cod_perfil", referencedColumnName = "id",table =  "perfiles"))
    private Set<Perfiles> perfiles = new HashSet<>(0);
}
