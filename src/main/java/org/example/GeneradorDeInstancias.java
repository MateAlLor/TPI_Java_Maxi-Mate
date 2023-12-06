package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;
import org.example.repositorios.TecnicoRepositorio;

import java.util.ArrayList;
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


        // Inicializar Especialidades
        Especialidad esp_Windows = new Especialidad("Windows", "Especialidad sobre Windows");
        Especialidad esp_Ubuntu = new Especialidad("Linux Ubuntu", "Especialidad sobre Linux Ubuntu");
        Especialidad esp_MacOS = new Especialidad("MacOS", "Especialidad sobre Linux Debian");
        // Guardar Especialidades
        repoEspecialidad.guardarEspecialidad(esp_Windows); repoEspecialidad.guardarEspecialidad(esp_Ubuntu); repoEspecialidad.guardarEspecialidad(esp_MacOS);



        // Inicializar Tipos de Problema
        TipoProblema err_conexion = new TipoProblema("Problema de conexion", "Errores al establecer conexion", Boolean.FALSE);
        TipoProblema err_input = new TipoProblema("Problemas con dispositivos de entrada", "Errores al detectar y utilizar dispositivos de entrada", Boolean.FALSE);
        TipoProblema err_crash = new TipoProblema("Crasheos", "Cierres repentinos del programa/servicios", Boolean.TRUE);
        TipoProblema err_freeze = new TipoProblema("Congelamientos", "Congelamientos repentinos del programa/servicio", Boolean.TRUE);
        // Guardar Tipo Problemas
        repoTipoProblema.guardarTipoProblema(err_conexion);
        repoTipoProblema.guardarTipoProblema(err_input);
        repoTipoProblema.guardarTipoProblema(err_crash);
        repoTipoProblema.guardarTipoProblema(err_freeze);




        // TÉCNICOS
        // Técnico Oscar
        List<Especialidad> oscarEspecialidades = new ArrayList<>(); oscarEspecialidades.add(esp_Windows); oscarEspecialidades.add(esp_Ubuntu);
        List<EstimadoPorProblema> oscarEstimadoPorProblema = new ArrayList<>();
        oscarEstimadoPorProblema.add(new EstimadoPorProblema(err_conexion, 1));
        oscarEstimadoPorProblema.add(new EstimadoPorProblema(err_input, 2));
        oscarEstimadoPorProblema.add(new EstimadoPorProblema(err_crash, 20));
        oscarEstimadoPorProblema.add(new EstimadoPorProblema(err_freeze, 25));
        Tecnico tc_oscar = new Tecnico("Oscar", "Pérez", oscarEspecialidades, oscarEstimadoPorProblema, MedioContacto.Whatsapp, "354358684612");
        repoTecnico.guardarTecnico(tc_oscar);
        // Técnico Joaquin
        List<Especialidad> joaquinEspecialidades = new ArrayList<>(); joaquinEspecialidades.add(esp_MacOS);
        List<EstimadoPorProblema> joaquinEstimadoPorProblema = new ArrayList<>();
        joaquinEstimadoPorProblema.add(new EstimadoPorProblema(err_conexion, 3));
        joaquinEstimadoPorProblema.add(new EstimadoPorProblema(err_input, 5));
        joaquinEstimadoPorProblema.add(new EstimadoPorProblema(err_crash, 30));
        joaquinEstimadoPorProblema.add(new EstimadoPorProblema(err_freeze, 8));
        Tecnico tc_joaquin = new Tecnico("Joaquin", "Gómez", joaquinEspecialidades, joaquinEstimadoPorProblema, MedioContacto.Email, "JoaquinGomez@outlook.com");
        repoTecnico.guardarTecnico(tc_joaquin);
        // Técnico Lucas
        List<Especialidad> lucasEspecialidades = new ArrayList<>(); lucasEspecialidades.add(esp_MacOS);
        List<EstimadoPorProblema> lucasEstimadoPorProblema = new ArrayList<>();
        lucasEstimadoPorProblema.add(new EstimadoPorProblema(err_conexion, 3));
        lucasEstimadoPorProblema.add(new EstimadoPorProblema(err_input, 5));
        lucasEstimadoPorProblema.add(new EstimadoPorProblema(err_crash, 30));
        lucasEstimadoPorProblema.add(new EstimadoPorProblema(err_freeze, 8));
        Tecnico tc_lucas = new Tecnico("Lucas", "Paredes", lucasEspecialidades, lucasEstimadoPorProblema, MedioContacto.Email, "LucasParedes@gmail.com");
        repoTecnico.guardarTecnico(tc_lucas);
        // Técnico Catalina
        List<Especialidad> catalinaEspecialidades = new ArrayList<>(); catalinaEspecialidades.add(esp_MacOS);
        List<EstimadoPorProblema> catalinaEstimadoPorProblema = new ArrayList<>();
        catalinaEstimadoPorProblema.add(new EstimadoPorProblema(err_conexion, 3));
        catalinaEstimadoPorProblema.add(new EstimadoPorProblema(err_input, 5));
        catalinaEstimadoPorProblema.add(new EstimadoPorProblema(err_crash, 30));
        catalinaEstimadoPorProblema.add(new EstimadoPorProblema(err_freeze, 8));
        Tecnico tc_catalina = new Tecnico("Catalina", "Juarez", catalinaEspecialidades, catalinaEstimadoPorProblema, MedioContacto.Whatsapp, "354346125868");
        repoTecnico.guardarTecnico(tc_catalina);
        // Técnico Catalina
        List<Especialidad> luciaEspecialidades = new ArrayList<>(); luciaEspecialidades.add(esp_MacOS);
        List<EstimadoPorProblema> luciaEstimadoPorProblema = new ArrayList<>();
        luciaEstimadoPorProblema.add(new EstimadoPorProblema(err_conexion, 3));
        luciaEstimadoPorProblema.add(new EstimadoPorProblema(err_input, 5));
        luciaEstimadoPorProblema.add(new EstimadoPorProblema(err_crash, 30));
        luciaEstimadoPorProblema.add(new EstimadoPorProblema(err_freeze, 8));
        Tecnico tc_lucia = new Tecnico("Lucia", "Ferreyra", luciaEspecialidades, luciaEstimadoPorProblema, MedioContacto.Email, "CatalinaF@gmail.com");
        repoTecnico.guardarTecnico(tc_lucia);


        // Inicializar Servicios
        Servicio srv_Skype = new Servicio("Skype", "Servicio de videollamadas");
        Servicio srv_Photoshop = new Servicio("Photoshop", "Programa de edición");
        Servicio srv_Zoom = new Servicio("Zoom", "Servicio de conferencias");
        repoServicio.guardarServicio(srv_Skype); repoServicio.guardarServicio(srv_Photoshop); repoServicio.guardarServicio(srv_Zoom);


        // Inicializar Clientes
        List<Servicio> cl_pepe_srv = new ArrayList<>(); cl_pepe_srv.add(srv_Skype); cl_pepe_srv.add(srv_Zoom);
        Cliente cl_pepe = new Cliente("Pepe Juarez", "888888888888", cl_pepe_srv, "Pepe@gmail.com");
        List<Servicio> cl_juan_srv = new ArrayList<>(); cl_juan_srv.add(srv_Photoshop); cl_juan_srv.add(srv_Zoom);
        Cliente cl_juan = new Cliente("Juan Perez", "888888888889", cl_juan_srv, "Juan@gmail.com");
        List<Servicio> cl_felipe_srv = new ArrayList<>(); cl_felipe_srv.add(srv_Photoshop); cl_felipe_srv.add(srv_Skype);
        Cliente cl_felipe = new Cliente("Felipe Lopez", "888888888887", cl_felipe_srv, "Felipe@gmail.com");
        // Guardarlos en la base de datos
        repoCliente.guardarCliente(cl_pepe);
        repoCliente.guardarCliente(cl_juan);
        repoCliente.guardarCliente(cl_felipe);

        System.out.println("Mostrando los Servicios de cada cliente: ");


        // Inicializar Incidentes
        Incidente inc_ConnectError = new Incidente("Connect Error", "Error al intentar establecer conexión con Skype", cl_pepe, esp_Windows, err_conexion, srv_Skype);
        repoIncidente.guardarIncidente(inc_ConnectError);

        Incidente inc_Disconect = new Incidente("Error conection to server", "Desconexión de la llamada", cl_felipe, esp_Ubuntu, err_conexion, srv_Skype);
        repoIncidente.guardarIncidente(inc_Disconect);

        Incidente inc_CrashService = new Incidente("Crash Service", "Cierre repentino del programa", cl_juan, esp_MacOS, err_crash, srv_Photoshop);
        repoIncidente.guardarIncidente(inc_CrashService);

        Incidente inc_Freeze = new Incidente("Freeze", "Congelamiento de pantalla", cl_felipe, esp_MacOS, err_freeze, srv_Skype);
        repoIncidente.guardarIncidente(inc_Freeze);

        Incidente inc_NoConection = new Incidente("No Conection", "Error al inicializar la conexión", cl_pepe, esp_Windows, err_conexion, srv_Skype);
        repoIncidente.guardarIncidente(inc_NoConection);

        Incidente inc_ConectionLost = new Incidente("Se ha perdido la conexión con el servidor", "Desconexión de la llamada", cl_felipe, esp_Ubuntu, err_conexion, srv_Zoom);
        repoIncidente.guardarIncidente(inc_ConectionLost);
        Incidente inc_SkypNoResponse = new Incidente("Skype no response", "Skype deja de responder", cl_juan, esp_MacOS, err_crash, srv_Photoshop);
        repoIncidente.guardarIncidente(inc_SkypNoResponse);
        Incidente inc_CPUUsageLimit = new Incidente("CPU Usage Limit", "Se sobrepasó el límite de uso del CPU", cl_felipe, esp_MacOS, err_freeze, srv_Skype);
        repoIncidente.guardarIncidente(inc_CPUUsageLimit);

        repoServicio.actualizarServicio(srv_Photoshop);
        repoServicio.actualizarServicio(srv_Skype);
        repoServicio.actualizarServicio(srv_Zoom);

        // Mostrar técnicos Disponibles
        List<Tecnico> tecnicosDisponibles = repoTecnico.getTecnicosDisponibles();
        System.out.println("Los técnicos disponibles son: ");
        for (Tecnico tec : tecnicosDisponibles){
            System.out.println("    -" + tec.getNombre() + " " + tec.getApellido());
        }

        // Asignar Técnico Joaquin (No va a permitirlo)
        inc_ConnectError.asignarTecnico(tc_joaquin);


        // Asignar Técnico Oscar
        inc_ConnectError.asignarTecnico(tc_oscar); repoIncidente.actualizarIncidente(inc_ConnectError); repoTecnico.actualizarTecnico(tc_oscar);

        // Oscar resuelve el Incidente
        tc_oscar.marcarIncidenteTerminado(inc_ConnectError); repoIncidente.actualizarIncidente(inc_ConnectError);

        // Mostrar reporte de tecnicos e incidentes
        repoTecnico.mostrarTecnicosEIncidentes();

        // Mostrar Técnico con más Incidentes respueltos en los últimos N días
        repoTecnico.tecnicoMasIncidentesTotales(5);

        //Mostrar Técnico con más Incidentes respueltos en los últimos N días de X especialidad
        repoTecnico.tecnicoMasIncidentesDeEspecialidad(5, esp_MacOS);
    }
}
