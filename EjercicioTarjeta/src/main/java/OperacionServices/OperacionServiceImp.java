package OperacionServices;

import Exceptions.OperacionNotFoundException;
import Repositories.OperacionRepository;
import Entities.Operacion;
import org.springframework.beans.factory.annotation.Autowired;



public class OperacionServiceImp implements OperacionService {
    @Autowired
    OperacionRepository operacionRepository;


    @Override
    public Operacion findById(Integer idOperacion) {
        if(operacionRepository.findById(idOperacion).isPresent()){
            return operacionRepository.findById(idOperacion).get();
        }else{
            throw new OperacionNotFoundException("No existe una operacion con el numero "+ idOperacion);
        }
    }
}
