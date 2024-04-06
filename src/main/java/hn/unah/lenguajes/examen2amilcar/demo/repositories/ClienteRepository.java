package hn.unah.lenguajes.examen2amilcar.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{
    
}
