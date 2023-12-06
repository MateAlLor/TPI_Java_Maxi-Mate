package org.example.dominio;

import lombok.Data;
import org.example.repositorios.ServicioRepositorio;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Incidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String titulo;
    String descripcion;

    LocalDateTime fechaInicio;
    LocalDateTime fechaFinal;

    @Enumerated(EnumType.STRING)
    Estado estadoIncidente;

    @ManyToOne
    Cliente cliente;

    @ManyToOne
    Especialidad especialidad;

    @ManyToOne
    TipoProblema tipoProblema;


    Integer horasMaximas;


    public Incidente() {
    }

    ;

    public Incidente(String titulo, String descripcion, Cliente cliente, Especialidad especialidad, TipoProblema tipoProblema, Servicio servicio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fechaInicio = LocalDateTime.now();
        this.estadoIncidente = Estado.Abierto;
        this.especialidad = especialidad;
        this.tipoProblema = tipoProblema;
        servicio.addIncidente(this);
    }

    public void asignarTecnico(Tecnico tecnico) {
        if (tecnico.addIncidente(this)) {
            this.estadoIncidente = Estado.EnProceso;
            tecnico.enviar_mensaje("Hola! " + tecnico.nombre + " " + tecnico.apellido + " se te asignó el incidente: " + this.titulo);
            for (EstimadoPorProblema estimado : tecnico.estimadoPorProblema) {
                if (estimado.tipoProblema.equals(this.tipoProblema)) {
                    System.out.println("El tiempo estimado de resolución del problema es de " + estimado.horasEstimadas + " horas");
                    break;
                }
            }
        }
    }

    public void cerrarIncidente() {
        this.estadoIncidente = Estado.Cerrado;
        this.fechaFinal = LocalDateTime.now();
        cliente.enviar_mensaje("Hola! " + cliente.razon_social + ". Se ha resuelto el incidente: " + this.titulo);
    }

    public void asignarHorasMaximas(Integer horas) {
        if (this.tipoProblema.esComplejo) {
            this.horasMaximas = horas;
        } else {
            System.out.println("El problema no es complejo, no se pueden añadir horas máximas");
        }
    }


    public boolean fueResueltoEnLosUltimosNDia(int cantDias) {
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaInicio = fechaActual.minusDays(cantDias);
        return getFechaFinal().isAfter(fechaInicio);
    }

    public Integer calcularTiempoResolucion(){
        Long resultado = 0L;
        if(this.estadoIncidente.equals(Estado.Cerrado)){
            Duration duration = Duration.between(this.getFechaInicio(), this.getFechaFinal());
            resultado = duration.getSeconds();
        }else{
            System.out.println("El incidente no ha sido resuelto");
        }
        return resultado.intValue();
    }
}
