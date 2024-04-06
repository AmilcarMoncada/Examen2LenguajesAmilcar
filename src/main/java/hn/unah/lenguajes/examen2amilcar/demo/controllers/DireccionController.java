package hn.unah.lenguajes.examen2amilcar.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Direccion;
import hn.unah.lenguajes.examen2amilcar.demo.services.implementations.DireccionServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear/{dni}")
    public Direccion CrearDireccion(@RequestBody Direccion direccion, @PathVariable String dni) {
        return this.direccionServiceImpl.CrearDireccion(direccion, dni);
    }

}
