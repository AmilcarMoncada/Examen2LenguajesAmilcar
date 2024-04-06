package hn.unah.lenguajes.examen2amilcar.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;

@Repository
public interface CuentasRepository extends CrudRepository<Cuentas, String>{
    
}
