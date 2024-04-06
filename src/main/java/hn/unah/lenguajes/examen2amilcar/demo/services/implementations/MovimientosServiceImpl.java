package hn.unah.lenguajes.examen2amilcar.demo.services.implementations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2amilcar.demo.dtos.MovimientosDTO;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Movimientos;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.ClienteRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.CuentasRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.DireccionRepository;
import hn.unah.lenguajes.examen2amilcar.demo.repositories.MovimientosRepository;
import hn.unah.lenguajes.examen2amilcar.demo.services.MovimientosService;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public Movimientos crearMovimiento(MovimientosDTO movimiento) {
        if (this.cuentasRepository.existsById(movimiento.getNumeroCuenta())) {
            Cuentas cuentaMovimiento = this.cuentasRepository.findById(movimiento.getNumeroCuenta()).get();
            if (cuentaMovimiento.getEstado()) {
                Double SaldoActual = cuentaMovimiento.getSaldo();
                if (movimiento.getTipoMovimiento() == 'C') {
                    cuentaMovimiento.setSaldo(SaldoActual + movimiento.getMonto());
                }
                if (movimiento.getTipoMovimiento() == 'D') {
                    if (SaldoActual > 0) {
                        if (cuentaMovimiento.getSobregiro()) {
                            cuentaMovimiento.setSaldo(SaldoActual - movimiento.getMonto());
                        }
                    }
                }
            }
            Movimientos nuevoMovimientos = new Movimientos();
            nuevoMovimientos.setCuenta(cuentaMovimiento);
            nuevoMovimientos.setTipoMovimiento(movimiento.getTipoMovimiento());
            nuevoMovimientos.setMonto(movimiento.getMonto());
            nuevoMovimientos.setFechaMovimiento(LocalDate.now());
            return this.movimientosRepository.save(nuevoMovimientos);
        }
        return null;
    }

}
