package hn.unah.lenguajes.examen2amilcar.demo.dtos;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MovimientosDTO {
    private String numeroCuenta;

    private char tipoMovimiento;

    private Double monto;
}
