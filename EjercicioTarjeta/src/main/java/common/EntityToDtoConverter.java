package common;

import DTO.TarjetaResponseDTO;
import Entities.Tarjeta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TarjetaResponseDTO convertTarjetaToTarjetaResponseDTO(Tarjeta u){
        TarjetaResponseDTO tarjetaResponse = modelMapper.map(u,TarjetaResponseDTO.class);
        return tarjetaResponse;
    }


}
