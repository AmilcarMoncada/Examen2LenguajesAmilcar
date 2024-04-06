package hn.unah.lenguajes.examen2amilcar.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.Integer;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer> {

}
