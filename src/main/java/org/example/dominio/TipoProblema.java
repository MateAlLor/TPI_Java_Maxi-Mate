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
    Integer horasMaximas;
    Integer horasEstimadas;

    public TipoProblema() {
    }
    ;
    public TipoProblema(String nombre, String descripcion, Boolean esComplejo, Integer horasMaximas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esComplejo = esComplejo;
        this.horasMaximas = horasMaximas;
    }

    public void asignarHorasEstimadas(Integer horas){
        if(this.horasMaximas > horas){
            this.horasEstimadas = horas;
            System.out.println("Horas estimadas actualizadas correctamente");
        }else{
            System.out.println("La cantidad de horas estimadas debe ser menor a la cantidad de horas máximas");
        }
    }
}
