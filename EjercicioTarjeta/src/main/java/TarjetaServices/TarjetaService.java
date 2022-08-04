package TarjetaServices;

import Exceptions.TarjetaNotFoundException;
import Entities.Tarjeta;

public interface TarjetaService {
    Tarjeta findTarjetaBynroTarjeta(Integer nroTarjeta) throws TarjetaNotFoundException;
}
