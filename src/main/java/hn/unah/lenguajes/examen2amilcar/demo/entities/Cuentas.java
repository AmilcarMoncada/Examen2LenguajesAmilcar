package hn.unah.lenguajes.examen2amilcar.demo.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuentas")
public class Cuentas {

    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente clientes;

    private Double saldo;

    @Column(name = "fechaapertura")
    private LocalDate fechaApertura = LocalDate.now();

    private Boolean estado = true;

    private Boolean sobregiro;

    @JsonManagedReference
    @OneToMany(mappedBy = "cuenta")
    private List<Movimientos> movimientos;

}
