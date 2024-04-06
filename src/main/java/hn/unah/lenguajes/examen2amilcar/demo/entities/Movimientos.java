package hn.unah.lenguajes.examen2amilcar.demo.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movimientos")
public class Movimientos {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovimiento")
    private int idMovimiento;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "numerocuenta", referencedColumnName = "numerocuenta")
    private Cuentas cuenta;

    @Column(name="tipomovimiento")
    private char tipoMovimiento;

    private Double monto;

    @Column(name="fechamovimiento")
    private LocalDate fechaMovimiento;

}
