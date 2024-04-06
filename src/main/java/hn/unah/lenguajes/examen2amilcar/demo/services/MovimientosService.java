package hn.unah.lenguajes.examen2amilcar.demo.services;

import hn.unah.lenguajes.examen2amilcar.demo.dtos.MovimientosDTO;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Movimientos;

public interface MovimientosService {

    public Movimientos crearMovimiento(MovimientosDTO movimiento);

}
