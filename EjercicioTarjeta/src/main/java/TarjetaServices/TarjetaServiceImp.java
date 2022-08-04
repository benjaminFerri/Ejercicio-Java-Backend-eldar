package TarjetaServices;

import Exceptions.TarjetaNotFoundException;
import Repositories.TarjetaRepository;
import Entities.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;


public class TarjetaServiceImp implements TarjetaService{
    @Autowired
    TarjetaRepository tarjetaRepository;

    @Override
    public Tarjeta findTarjetaBynroTarjeta(Integer nroTarjeta) {
        Tarjeta r = tarjetaRepository.findBynroTarjeta(nroTarjeta);
        if (!r.equals(null)){
            return r;
        }
        throw new TarjetaNotFoundException("No existe una tarjeta con el numero "+ nroTarjeta);
    }
}
