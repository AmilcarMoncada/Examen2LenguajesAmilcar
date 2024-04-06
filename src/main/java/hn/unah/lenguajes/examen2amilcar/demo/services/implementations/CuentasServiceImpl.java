package hn.unah.lenguajes.examen2amilcar.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Movimientos;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.ClienteRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.CuentasRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.DireccionRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.MovimientosRepository;
import hn.unah.lenguajes.examen2amilcar.demo.services.CuentasService;

@Service
public class CuentasServiceImpl implements CuentasService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public String crearCuentas(Cuentas cuenta) {
        if (cuenta.getSaldo() <= 500) {
            return "Debe ingresar un saldo mayor a 500 para aperturar su cuenta";
        }
        Cuentas cuentaGuardar = this.cuentasRepository.save(cuenta);
        if (this.cuentasRepository.existsById(cuentaGuardar.getNumeroCuenta()) == false) {
            List<Movimientos> listaMovimientos = cuentaGuardar.getMovimientos();
            for (Movimientos movimiento : listaMovimientos) {
                movimiento.setCuenta(cuentaGuardar);
                this.movimientosRepository.save(movimiento);
            }
            this.cuentasRepository.save(cuentaGuardar);
            return "Cuenta creada correctamente";
        }
        return "Ya existe ese numero de cuenta";
    }

    @Override
    public Cliente AsociarCuentaCliente(String dni, String numerocuenta) {
        if (this.clienteRepository.existsById(dni)) {
            if (this.cuentasRepository.existsById(dni)) {
                Cliente clienteAsociar = this.clienteRepository.findById(dni).get();
                Cuentas cuentaAsociar = this.cuentasRepository.findById(numerocuenta).get();
                if (cuentaAsociar.getClientes() != null) {
                    return null;
                }
                clienteAsociar.getCuentas().add(cuentaAsociar);
                this.clienteRepository.save(clienteAsociar);
                return clienteAsociar;
            }
        }
        return null;
    }

    @Override
    public Cuentas ObtenerMovimientosCuenta(String numerocuenta) {
        Cuentas cuentaAsignada = this.cuentasRepository.findById(numerocuenta).get();
        return cuentaAsignada;
    }

}
