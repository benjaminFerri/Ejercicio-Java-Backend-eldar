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
public class Tarjeta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarjeta;
    private String marca;
    private int nroTarjeta;
    @ManyToOne
    @JoinColumn(name = "idCardholder")
    private Cardholder cardholder;
    private LocalDate fechaVencimiento;
}
