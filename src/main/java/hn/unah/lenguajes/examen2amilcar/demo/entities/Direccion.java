package hn.unah.lenguajes.examen2amilcar.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion")
    private int idDireccion;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;

    private String estado;

    private String ciudad;

    private String calle;

}
