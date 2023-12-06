package org.example.dominio;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tecnico implements Serializable, Notificador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String nombre;
    String apellido;
    Boolean disponible;
    String contacto;
    @Enumerated(EnumType.STRING)
    MedioContacto medioContacto;
    @ManyToMany (cascade = CascadeType.ALL)
    List<Especialidad> especialidades;
    @OneToMany
    List<Incidente> incidentes;
    @OneToMany (cascade = CascadeType.ALL)
    List<EstimadoPorProblema> estimadoPorProblema;

    public Tecnico() {
    }

    ;
    public Tecnico(String nombre, String apellido, List<Especialidad> especialidades, List<EstimadoPorProblema> estimadoPorProblema, MedioContacto medioContacto, String contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.disponible = Boolean.TRUE;
        this.especialidades = especialidades;
        this.incidentes = new ArrayList<>();
        this.estimadoPorProblema = estimadoPorProblema;
        this.medioContacto = medioContacto;
        this.contacto = contacto;
    }

    public Boolean addIncidente(Incidente incidente){
        Especialidad esp_incidente = incidente.getEspecialidad();
        if(this.especialidades.stream().anyMatch(esp -> esp.equals(esp_incidente))){
            this.incidentes.add(incidente);
            return Boolean.TRUE;
        }else{
            System.out.println("Este técnico no está especializado para resolver el incidente");
            return Boolean.FALSE;
        }
    }

    @Override
    public void enviar_mensaje(String mensaje) {
        switch (this.medioContacto){
            case Whatsapp -> System.out.println("Receptor: " + this.nombre + " " + this.apellido + " al teléfono: " + this.contacto + "| Mensaje: " + mensaje);
            case Email -> System.out.println("Receptor: " + this.nombre + " " + this.apellido + " al correo: " + this.contacto + "| Mensaje: " + mensaje);
        }
    }
    public void marcarIncidenteTerminado(Incidente incidente){
        incidente.cerrarIncidente();
    }

    public Double promedioTiempoIncidentes(){
        List<Incidente> incidentesResueltos = this.getIncidentes().stream()
                .filter(incidente -> incidente.estadoIncidente.equals(Estado.Cerrado)).toList();

        if (incidentesResueltos.isEmpty()){
            return 0.0;
        }else{
            Integer tiempoIncidentes = incidentesResueltos.stream()
                    .mapToInt(Incidente::calcularTiempoResolucion).sum();
            Double promedio = (double) (tiempoIncidentes/incidentesResueltos.size());
            return promedio;
        }
    }
}
