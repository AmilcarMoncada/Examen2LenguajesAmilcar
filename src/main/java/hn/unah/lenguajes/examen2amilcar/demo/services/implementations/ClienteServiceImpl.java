package hn.unah.lenguajes.examen2amilcar.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.ClienteRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.CuentasRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.DireccionRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.MovimientosRepository;
import hn.unah.lenguajes.examen2amilcar.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public Cliente CrearCliente(Cliente cliente) {
       if(this.clienteRepository.findById(cliente.getDni())==null){
       if(cliente.getCuentas()!=null){
       List<Cuentas> cuentasCliente=cliente.getCuentas();
       for (Cuentas cuenta : cuentasCliente) {
        cuenta.setClientes(cliente);
        this.cuentasRepository.save(cuenta);
       }
       return this.clienteRepository.save(cliente);
       }
    }
    return null;
    }

    @Override
    public List<Cliente> obtenerClientes() {
      return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorDni(String dni) {
       return this.clienteRepository.findById(dni).get();
    }
    
}
