package hn.unah.lenguajes.examen2amilcar.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Movimientos;

@Repository
public interface MovimientosRepository extends CrudRepository<Movimientos, Integer> {

}
