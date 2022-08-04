package DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperacionResponse {

    private Float importe;
    private Float tasa;
    private String marca;
}
