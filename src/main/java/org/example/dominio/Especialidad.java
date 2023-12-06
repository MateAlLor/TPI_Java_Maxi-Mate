package org.example.dominio;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Especialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String nombreEsp;
    String descripcionEsp;

    public Especialidad() {
    }

    ;
    public Especialidad(String nombreEsp, String descripcionEsp) {
        this.nombreEsp = nombreEsp;
        this.descripcionEsp = descripcionEsp;
    }
}
