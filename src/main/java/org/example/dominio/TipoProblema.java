package org.example.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class TipoProblema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String nombre;
    String descripcion;
    Boolean esComplejo;

    public TipoProblema() {
    }
    ;
    public TipoProblema(String nombre, String descripcion, Boolean esComplejo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esComplejo = esComplejo;
    }
}
