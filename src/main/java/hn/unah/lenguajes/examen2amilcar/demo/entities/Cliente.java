package hn.unah.lenguajes.examen2amilcar.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="cliente")
public class Cliente {
   
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    @OneToOne(mappedBy = "cliente")
    private Direccion direccion;

    @JsonManagedReference
    @OneToMany(mappedBy = "clientes")
    private List<Cuentas> cuentas;

}
