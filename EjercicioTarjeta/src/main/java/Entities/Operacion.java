package Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarjetas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperacion;

    private Float importe;
    @ManyToOne
    @JoinColumn(name = "idTarjeta")
    private Tarjeta tarjeta;
    private LocalDate fecha;
}
