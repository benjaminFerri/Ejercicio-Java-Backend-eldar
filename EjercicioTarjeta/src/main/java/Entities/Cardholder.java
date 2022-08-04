package Entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "cardholder")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cardholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCardholder;
    private String nombre;
    private String apellido;

}