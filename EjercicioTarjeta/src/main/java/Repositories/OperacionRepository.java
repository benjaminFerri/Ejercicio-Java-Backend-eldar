package Repositories;

import Entities.Operacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

}
