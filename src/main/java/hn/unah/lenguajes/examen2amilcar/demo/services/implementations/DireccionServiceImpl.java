package hn.unah.lenguajes.examen2amilcar.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Direccion;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.ClienteRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.CuentasRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.DireccionRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.MovimientosRepository;
import hn.unah.lenguajes.examen2amilcar.demo.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public Direccion CrearDireccion(Direccion direccion, String dni) {
        if (this.clienteRepository.existsById(dni)) {
            Direccion nuevaDireccion = this.direccionRepository.save(direccion);
            Cliente cliente = this.clienteRepository.findById(dni).get();
            nuevaDireccion.setCliente(cliente);
            return this.direccionRepository.save(nuevaDireccion);
        }
        return null;
    }

}
