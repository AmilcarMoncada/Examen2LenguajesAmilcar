package hn.unah.lenguajes.examen2amilcar.demo.services;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;

public interface CuentasService {

    public String crearCuentas(Cuentas cuenta);

    public Cliente AsociarCuentaCliente(String dni, String numerocuenta);

    public Cuentas ObtenerMovimientosCuenta(String numerocuenta);

}
