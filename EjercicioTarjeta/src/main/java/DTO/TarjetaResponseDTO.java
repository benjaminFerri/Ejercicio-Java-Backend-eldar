package DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaResponseDTO {

    private Integer idTarjeta;
    private String marca;
    private int nroTarjeta;
    private LocalDate fechaVencimiento;
}