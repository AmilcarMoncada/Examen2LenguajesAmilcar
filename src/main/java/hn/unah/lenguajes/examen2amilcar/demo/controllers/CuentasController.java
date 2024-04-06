package hn.unah.lenguajes.examen2amilcar.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen2amilcar.demo.entities.Cliente;
import hn.unah.lenguajes.examen2amilcar.demo.entities.Cuentas;
import hn.unah.lenguajes.examen2amilcar.demo.services.implementations.CuentasServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class CuentasController {

    @Autowired
    private CuentasServiceImpl cuentasServiceImpl;

    @PostMapping("/cuenta/crear")
    public String crearCuentas(@RequestBody Cuentas cuentas) {
        return this.cuentasServiceImpl.crearCuentas(cuentas);
    }

    @PutMapping("/cuenta/asociar/{dni}")
    public Cliente AsociarcuentaCliente(@PathVariable String dni, @RequestParam String numerocuenta) {
        return this.cuentasServiceImpl.AsociarCuentaCliente(dni, numerocuenta);
    }

    @GetMapping("/cuenta/obtenermovimientos")
    public Cuentas ObtenerMovimientosCuenta(@RequestParam String numeroCuenta) {
        return this.cuentasServiceImpl.ObtenerMovimientosCuenta(numeroCuenta);
    }

}
