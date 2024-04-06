package hn.unah.lenguajes.examen2amilcar.demo.services;

import java.util.List;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;

public interface ClienteService {
    
    public Cliente CrearCliente (Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente obtenerClientePorDni(String dni);
}
