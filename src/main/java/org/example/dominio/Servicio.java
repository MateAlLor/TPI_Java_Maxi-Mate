package org.example.dominio;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String nombre;
    String descripcion;

    @OneToMany
    List<Incidente> incidentes;

    public Servicio() {
    }
    ;
    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incidentes = new ArrayList<>();
    }

    public void addIncidente(Incidente incidente){
        this.incidentes.add(incidente);
    }

    public void darDeAltaPorServicioYProblema(TipoProblema tipoProblema){
        List<Incidente> incidentesACerrar = this.incidentes.stream().filter(incidente -> incidente.getEstadoIncidente().equals(Estado.Abierto)
                &&
                incidente.getTipoProblema().equals(tipoProblema)
                ).toList();

        incidentesACerrar.forEach(Incidente::cerrarIncidente);
    }

}
