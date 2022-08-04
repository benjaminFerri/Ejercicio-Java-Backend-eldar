package Controllers;

import common.EntityToDtoConverter;
import DTO.TarjetaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import TarjetaServices.TarjetaService;

import java.time.LocalDate;

@RestController
public class TarjetasController {

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private EntityToDtoConverter entityToDtoConverter;

    @GetMapping("/tarjeta/{nroTarjeta}")
    public ResponseEntity<TarjetaResponseDTO> getTarjetaByNrotarjeta(@PathVariable(value="nroTarjeta")Integer nroTarjeta){
        return new ResponseEntity<>(entityToDtoConverter.convertTarjetaToTarjetaResponseDTO(tarjetaService.findTarjetaBynroTarjeta(nroTarjeta)), HttpStatus.OK);
    }

    @GetMapping("/tarjeta/valida/{nroTarjeta}")
    public ResponseEntity<String> isTarjetaValida(@PathVariable(value="nroTarjeta")Integer nroTarjeta){
        if(tarjetaService.findTarjetaBynroTarjeta(nroTarjeta).getFechaVencimiento().isAfter(LocalDate.now())){
            return new ResponseEntity<>("La tarjeta es valida", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("La tarjeta no es valida", HttpStatus.OK);
        }
    }

    @GetMapping("/tarjeta/equal/{nroTarjeta}/{nroTarjeta1}")
    public ResponseEntity<String> areEqualsTarjeta(@PathVariable(value="nroTarjeta")Integer nroTarjeta,@PathVariable(value = "nroTarjeta1") Integer nroTarjeta1){
        if(tarjetaService.findTarjetaBynroTarjeta(nroTarjeta).equals(tarjetaService.findTarjetaBynroTarjeta(nroTarjeta1))){
            return new ResponseEntity<>("Las tarjetas son iguales", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("La tarjetas son distintas", HttpStatus.OK);
        }
    }

}
