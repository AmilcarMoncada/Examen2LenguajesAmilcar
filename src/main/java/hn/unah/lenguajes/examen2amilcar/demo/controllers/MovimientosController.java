package hn.unah.lenguajes.examen2amilcar.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen2amilcar.demo.dtos.MovimientosDTO;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Movimientos;
import hn.unah.lenguajes.examen2amilcar.demo.services.implementations.MovimientosServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class MovimientosController {
    
@Autowired
private MovimientosServiceImpl movimientosServiceImpl;


    @PostMapping("/movimiento/crear")
    public Movimientos  crear(@RequestBody MovimientosDTO movimientos) {
        return this.movimientosServiceImpl.crearMovimiento(movimientos);
    }
    
}
