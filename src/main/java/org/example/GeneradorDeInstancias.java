package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;
import org.example.repositorios.TecnicoRepositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneradorDeInstancias {
    public void generarInstancias(){
        // Inicializar repositorios
        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
        EspecialidadRepositorio repoEspecialidad = new EspecialidadRepositorio();
        ServicioRepositorio repoServicio = new ServicioRepositorio();
        ClienteRespositorio repoCliente = new ClienteRespositorio();
        TipoProblemaRepositorio repoTipoProblema = new TipoProblemaRepositorio();
        EstimadoPorProblemaRepositorio repoEstimadoPorProblema = new EstimadoPorProblemaRepositorio();
        IncidenteRepositorio repoIncidente = new IncidenteRepositorio();

        // Inicializar Servicios
        Servicio srv_Skype = new Servicio("Skype", "Servicio de videollamadas"); repoServicio.guardarServicio(srv_Skype);
        Servicio srv_Whatsapp = new Servicio("Whatsapp", "Servicio de mensajería"); repoServicio.guardarServicio(srv_Whatsapp);
        Servicio srv_Discord = new Servicio("Discord", "Servicio de mensajería y llamada"); repoServicio.guardarServicio(srv_Discord);

        // Inicializar Especialidades
        Especialidad esp_Windows = new Especialidad("Windows", "Especialista en Windows"); repoEspecialidad.guardarEspecialidad(esp_Windows);
        Especialidad esp_Ubuntu = new Especialidad("Ubuntu", "Especialista en Linux Ubuntu"); repoEspecialidad.guardarEspecialidad(esp_Ubuntu);
        Especialidad esp_MacOS = new Especialidad("MacOS", "Especialista en MacOS"); repoEspecialidad.guardarEspecialidad(esp_MacOS);

        // Inicializar Clientes
        List<Servicio> servicios0 = Arrays.asList(srv_Discord, srv_Skype);
        List<Servicio> servicios1 = Arrays.asList(srv_Discord);
        List<Servicio> servicios2 = Arrays.asList(srv_Whatsapp, srv_Skype);

        Cliente cl_juan = new Cliente("Juan", "541861", servicios0, "Juan@gmail.com"); repoCliente.guardarCliente(cl_juan);
        Cliente cl_jorge = new Cliente("Jorge", "531881", servicios1, "Jorge@gmail.com"); repoCliente.guardarCliente(cl_jorge);
        Cliente cl_jeremias = new Cliente("Jeremias", "548961", servicios2, "Jere@gmail.com"); repoCliente.guardarCliente(cl_jeremias);

        // Inicializar Tipos de Problema
        TipoProblema tp_conexion = new TipoProblema("Conexion", "Problema de conexión", Boolean.FALSE, 50);
        TipoProblema tp_cierre = new TipoProblema("Cierre", "Cierre inesperado del servicio", Boolean.TRUE, 50);
        repoTipoProblema.guardarTipoProblema(tp_conexion); repoTipoProblema.guardarTipoProblema(tp_cierre);

        // Inicializar Técnico
        List<Especialidad> especialidades0 = Arrays.asList(esp_Windows);
        List<Especialidad> especialidades1 = Arrays.asList(esp_Ubuntu);
        List<Especialidad> especialidades2 = Arrays.asList(esp_MacOS);
        List<Especialidad> especialidades3 = Arrays.asList(esp_MacOS, esp_Ubuntu, esp_Windows);

        EstimadoPorProblema estimadoPorProblema00 = new EstimadoPorProblema(tp_conexion, 10); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema00);
        EstimadoPorProblema estimadoPorProblema01 = new EstimadoPorProblema(tp_cierre, 20); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema01);

        EstimadoPorProblema estimadoPorProblema10 = new EstimadoPorProblema(tp_conexion, 15); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema10);
        EstimadoPorProblema estimadoPorProblema11 = new EstimadoPorProblema(tp_cierre, 25); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema11);

        EstimadoPorProblema estimadoPorProblema20 = new EstimadoPorProblema(tp_conexion, 10); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema20);
        EstimadoPorProblema estimadoPorProblema21 = new EstimadoPorProblema(tp_cierre, 30); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema21);

        EstimadoPorProblema estimadoPorProblema30 = new EstimadoPorProblema(tp_conexion, 20); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema30);
        EstimadoPorProblema estimadoPorProblema31 = new EstimadoPorProblema(tp_cierre, 40); repoEstimadoPorProblema.guardarEstimadoPorProblema(estimadoPorProblema31);

        List<EstimadoPorProblema> estimadoPorProblemas0 = Arrays.asList(estimadoPorProblema00, estimadoPorProblema01);
        List<EstimadoPorProblema> estimadoPorProblemas1 = Arrays.asList(estimadoPorProblema10, estimadoPorProblema11);
        List<EstimadoPorProblema> estimadoPorProblemas2 = Arrays.asList(estimadoPorProblema20, estimadoPorProblema21);
        List<EstimadoPorProblema> estimadoPorProblemas3 = Arrays.asList(estimadoPorProblema30, estimadoPorProblema31);

        Tecnico tc_felipe = new Tecnico("Felipe", "Pérez", especialidades0, estimadoPorProblemas0, MedioContacto.Whatsapp, "5461651");
        Tecnico tc_federico = new Tecnico("Federico", "Gonzales", especialidades1, estimadoPorProblemas1, MedioContacto.Whatsapp, "5461651");
        Tecnico tc_gaston = new Tecnico("Gastón", "Juarez", especialidades2, estimadoPorProblemas2, MedioContacto.Email, "Gaston@gmail.com");
        Tecnico tc_gonzalo = new Tecnico("Gonzalo", "Gómez", especialidades3, estimadoPorProblemas3, MedioContacto.Email, "Gonzalo@gmail.com");
        repoTecnico.guardarTecnico(tc_felipe); repoTecnico.guardarTecnico(tc_federico); repoTecnico.guardarTecnico(tc_gaston); repoTecnico.guardarTecnico(tc_gonzalo);

        // Inicializar Incidentes
        Incidente incidente0 = new Incidente("Error de conexión 0", "Error de conexión", cl_juan, esp_Windows, tp_conexion, srv_Whatsapp);
        Incidente incidente1 = new Incidente("Error de conexión 1", "Error de conexión", cl_jeremias, esp_MacOS, tp_conexion, srv_Discord);
        Incidente incidente2 = new Incidente("Error de conexión 2", "Error de conexión", cl_juan, esp_Ubuntu, tp_conexion, srv_Skype);
        Incidente incidente3 = new Incidente("Error de conexión 3", "Error de conexión", cl_jeremias, esp_Windows, tp_conexion, srv_Whatsapp);
        Incidente incidente4 = new Incidente("Cierre Inesperado 0", "Cierre inesperado", cl_juan, esp_MacOS, tp_cierre, srv_Discord);
        Incidente incidente5 = new Incidente("Cierre Inesperado 1", "Cierre inesperado", cl_jeremias, esp_Ubuntu, tp_cierre, srv_Skype);
        Incidente incidente6 = new Incidente("Cierre Inesperado 2", "Cierre inesperado", cl_juan, esp_Windows, tp_cierre, srv_Skype);
        Incidente incidente7 = new Incidente("Cierre Inesperado 3", "Cierre inesperado", cl_jeremias, esp_Ubuntu, tp_cierre, srv_Discord);


        incidente0.setFechaInicio(LocalDateTime.of(2023, 12, 5, 15, 30));
        incidente1.setFechaInicio(LocalDateTime.of(2023, 12, 5, 2, 30));
        incidente2.setFechaInicio(LocalDateTime.of(2023, 12, 4, 20, 30));
        incidente3.setFechaInicio(LocalDateTime.of(2023, 12, 4, 22, 30));
        incidente4.setFechaInicio(LocalDateTime.of(2023, 12, 5, 20, 30));
        incidente5.setFechaInicio(LocalDateTime.of(2023, 12, 5, 8, 30));
        incidente6.setFechaInicio(LocalDateTime.of(2023, 12, 4, 18, 30));
        incidente7.setFechaInicio(LocalDateTime.of(2023, 12, 4, 15, 30));

        repoIncidente.guardarIncidente(incidente0);
        repoIncidente.guardarIncidente(incidente1);
        repoIncidente.guardarIncidente(incidente2);
        repoIncidente.guardarIncidente(incidente3);
        repoIncidente.guardarIncidente(incidente4);
        repoIncidente.guardarIncidente(incidente5);
        repoIncidente.guardarIncidente(incidente6);
        repoIncidente.guardarIncidente(incidente7);
    }


}
