package Repositories;

import Entities.Tarjeta;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    Tarjeta findBynroTarjeta(Integer nroTarjeta);
}
