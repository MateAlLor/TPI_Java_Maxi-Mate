package org.example.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Cliente implements Serializable, Notificador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String razon_social;
    String cuit;
    String contacto;
    @ManyToMany
    List<Servicio> servicios;

    // Constructores
    public Cliente() {
    }
    ;
    public Cliente(String razon_social, String cuit, List<Servicio> servicios, String contacto) {
        this.razon_social = razon_social;
        this.cuit = cuit;
        this.servicios = servicios;
        this.contacto = contacto;
    }
    public void mostrarServiciosDelCliente(){
        System.out.println("Los servicios del cliente " + razon_social + " son:");
        for(Servicio serv : servicios){
            System.out.println("    -" + serv.getNombre());
        }
    }

    @Override
    public void enviar_mensaje(String mensaje) {
        System.out.println("Receptor del mensaje: " + this.razon_social + "| correo: " + this.contacto + "| Texto: " + mensaje);
    }
}
