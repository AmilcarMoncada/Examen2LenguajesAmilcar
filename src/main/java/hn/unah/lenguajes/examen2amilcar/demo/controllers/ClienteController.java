package hn.unah.lenguajes.examen2amilcar.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.services.implementations.ClienteServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente/crear")
    public Cliente CrearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.CrearCliente(cliente);
    }

    @GetMapping("/cliente/obtenertodos")
    public List<Cliente> obtenerClientes() {
        return this.clienteServiceImpl.obtenerClientes();
    }

    @GetMapping("/cliente/obtener/{dni}")
    public Cliente obtenerClientes(@PathVariable String dni) {
        return this.clienteServiceImpl.obtenerClientePorDni(dni);
    }

}
