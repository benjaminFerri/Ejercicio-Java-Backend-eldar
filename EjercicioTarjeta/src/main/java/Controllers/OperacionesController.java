package Controllers;

import OperacionServices.OperacionService;
import common.EntityToDtoConverter;
import DTO.OperacionResponse;
import Entities.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacionesController {

    @Autowired
    private OperacionService operacionService;

    @Autowired
    private EntityToDtoConverter entityToDtoConverter;

    @GetMapping("/operacion/valida/{idOperacion}")
    public ResponseEntity<String> isOperacionValida(@PathVariable(value="idOperacion")Integer idOperacion){
        if(operacionService.findById(idOperacion).getImporte()<1000F){
            return new ResponseEntity<>("La operacion es valida", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("La operacion no es valida", HttpStatus.OK);
        }
    }

    @GetMapping("/operacion/tasa/{idOperacion}")
    public ResponseEntity<OperacionResponse> calcularTasaOperacion(@PathVariable(value="idOperacion")Integer idOperacion){
        Operacion operacion = operacionService.findById(idOperacion);
        OperacionResponse aux = new OperacionResponse();
        if(operacion.getTarjeta().getMarca()=="VISA"){
            aux.setMarca(operacion.getTarjeta().getMarca());
            aux.setImporte(operacion.getImporte());
            Integer anio =  operacion.getFecha().getYear() ;
            Integer mes = operacion.getFecha().getMonthValue();
            Float tasa = anio.floatValue()/mes.floatValue();
            aux.setTasa(tasa);

        }else if(operacion.getTarjeta().getMarca()=="NARA"){
            aux.setMarca(operacion.getTarjeta().getMarca());
            aux.setImporte(operacion.getImporte());
            Float tasa = operacion.getFecha().getDayOfMonth() / 0.5F;
            aux.setTasa(tasa);
        }else{
            aux.setMarca(operacion.getTarjeta().getMarca());
            aux.setImporte(operacion.getImporte());
            Float tasa = operacion.getFecha().getMonthValue() / 0.1F;
            aux.setTasa(tasa);
        }
        return new ResponseEntity<>(aux, HttpStatus.OK);
    }
}
