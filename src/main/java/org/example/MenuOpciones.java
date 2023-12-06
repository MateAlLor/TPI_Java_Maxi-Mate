package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuOpciones {

    ClienteRespositorio repoCliente = new ClienteRespositorio();
    EspecialidadRepositorio repoEspecialidad = new EspecialidadRepositorio();
    EstimadoPorProblemaRepositorio repoEstimadoxProblema= new EstimadoPorProblemaRepositorio();
    IncidenteRepositorio repoIncidente = new IncidenteRepositorio();
    ServicioRepositorio repoServicio = new ServicioRepositorio();
    TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
    TipoProblemaRepositorio repoTipoProblema = new TipoProblemaRepositorio();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -2;
        while (opcion != -1) {
            String menuTextoInicial = "" +
                    "╔═══════════════════════════════════════════════════╗\n" +
                    "║              Menú de Opciones                     ║\n" +
                    "╠═══════════════════════════════════════════════════╣\n" +
                    "║         Generar clases necesarias                 ║\n" +
                    "║1-Añadir Servicio                                  ║\n" +
                    "║2-Añadir Especialidad                              ║\n" +
                    "║3-Añadir Cliente                                   ║\n" +
                    "║4-Añadir Tipos de Problema                         ║\n" +
                    "║5-Añadir Técnico                                   ║\n" +
                    "╠═══════════════════════════════════════════════════╣\n" +
                    "║           Manejo de Incidentes                    ║\n" +
                    "║6-Reportar Nuevo Incidente                         ║\n" +
                    "║7-Asignar colchón de horas estimadas               ║\n" +
                    "║8-Asignar Técnico a Incidente                      ║\n" +
                    "║9-Cerrar Incidente                                 ║\n" +
                    "╠═══════════════════════════════════════════════════╣\n" +
                    "║            Requerimientos                         ║\n" +
                    "║10-Reporte Incidentes por Técnico                  ║\n" +
                    "║11-Dar de alta conjunto de problemas               ║\n" +
                    "║12-Técnico con más incidentes resueltos en 'n' días║\n" +
                    "║13-Anterior pero filtrado por especialidad         ║\n" +
                    "║14-Técnico más rápido                              ║\n" +
                    "╠═══════════════════════════════════════════════════╣\n" +
                    "║(-1)-Salir                                         ║\n" +
                    "╚═══════════════════════════════════════════════════╝\n" +
                    "Ingrese una opción: ";
            System.out.println(menuTextoInicial);
            opcion = scanner.nextInt(); scanner.nextLine();
            System.out.println("La opción ingresada es: " + opcion);
            switch (opcion) {
                case 1:
                    this.anadirServicio(scanner);
                    break;
                case 2:
                    this.anadirEspecialidad(scanner);
                    break;
                case 3:
                    this.anadirCliente(scanner);
                    break;
                case 4:
                    this.anadirTipoProblema(scanner);
                    break;
                case 5:
                    this.anadirTecnico(scanner);
                    break;
                case 6:
                    this.reportarIncidente(scanner);
                    break;
                case 7:
                    this.asignarHorasMaximasAIncidente(scanner);
                    break;
                case 8:
                    this.asignarTecnicoAIncidente(scanner);
                    break;
                case 9:
                    this.cerrarIncidente(scanner);
                    break;
                case 10:
                    repoTecnico.mostrarTecnicosEIncidentes();
                    break;
                case 11:
                    // AGREGAR
                    break;
                case 12:
                    this.tecnicoMasIncidentesNDias(scanner);
                    break;
                case 13:
                    this.tecnicoMasIncidentesNDiasEspecialidad(scanner);
                    break;
                case 14:
                    repoTecnico.tecnicoMasRapido();
                    break;

            }
        }
        scanner.close();
    }

    private void anadirCliente(Scanner scanner) {
        List<Servicio> servicios = repoServicio.getServicio();

        System.out.println("Ingrese una razón social: ");
        //scanner.nextLine();
        String cl_razon_social = scanner.nextLine();

        System.out.println("Ingrese un cuit: ");
        String cl_cuit = scanner.nextLine();

        System.out.println("Ingrese un contacto: ");
        String cl_contacto = scanner.nextLine();

        this.mostrarServicios(servicios);
        List<Integer> indexServicios = new ArrayList<>();

        Integer opcion = -2;

        while (opcion != -1){
            System.out.println("Ingrese un servicio o '-1' para finalizar: ");
            opcion = scanner.nextInt();
            if (opcion != -1) {
                while (opcion < 0 || opcion >= servicios.size()) {
                    System.out.println("Ingrese una opción válida: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                }
                indexServicios.add(opcion);
            }
        }

        List<Servicio> serviciosCliente = new ArrayList<>();
        for (Integer index : indexServicios){
            serviciosCliente.add(servicios.get(index));
        }

        Cliente newCliente = new Cliente(cl_razon_social, cl_cuit, serviciosCliente, cl_contacto);
        repoCliente.guardarCliente(newCliente);

    }

    private void anadirServicio(Scanner scanner){
        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese una descripcion: ");
        String descripcion = scanner.nextLine();
        Servicio newServicio = new Servicio(nombre, descripcion);
        repoServicio.guardarServicio(newServicio);
    }

    private void anadirEspecialidad(Scanner scanner){
        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese una descripcion: ");
        String descripcion = scanner.nextLine();
        Especialidad newEspecialidad = new Especialidad(nombre, descripcion);
        repoEspecialidad.guardarEspecialidad(newEspecialidad);
    }

    private void anadirTipoProblema(Scanner scanner){
        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese una descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.println("El problema es complejo?: 0=No, 1=Si");
        int opcion = scanner.nextInt();
        while(opcion != 0 && opcion != 1){
            System.out.println("Ingrese una opción válida");
            opcion = scanner.nextInt();
        }
        scanner.nextLine();
        Boolean complejo = null;
        if (opcion==1){
            complejo = Boolean.TRUE;
        }else{
            complejo = Boolean.FALSE;
        }

        TipoProblema newTipoProblema = new TipoProblema(nombre, descripcion, complejo);
        repoTipoProblema.guardarTipoProblema(newTipoProblema);
    }

    private void anadirTecnico(Scanner scanner){
        List<Especialidad> especialidadList = repoEspecialidad.getEspecialidad();
        List<TipoProblema> tipoProblemaList = repoTipoProblema.getTipoProblema();

        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = scanner.nextLine();

        // Ingresar medio de contacto
        System.out.println("Ingrese un medio de contacto: 1=Whatsapp, 2=Email");
        int opcion = scanner.nextInt();
        while(opcion != 1 && opcion != 2){
            System.out.println("Ingrese una opción válida");
            opcion = scanner.nextInt();
        }
        scanner.nextLine();
        MedioContacto medioContacto = null;
        if (opcion==1){
            medioContacto = MedioContacto.Whatsapp;
        }else{
            medioContacto = MedioContacto.Email;
        }

        System.out.println("Ingrese un contacto: ");
        String contacto = scanner.nextLine();

        // Seleccionar especialidades
        Integer cont = 0;
        for(Especialidad esp : especialidadList){
            System.out.println(cont + "-" + esp.getNombreEsp());
            cont += 1;
        }

        List<Integer> indexEspecialidades = new ArrayList<>();


        Integer opcionEsp = -2;

        while (opcionEsp != -1){
            System.out.println("Ingrese una especialidad o '-1' para finalizar: ");
            opcionEsp = scanner.nextInt();
            if (opcionEsp != -1) {
                while (opcionEsp < 0 || opcionEsp >= cont) {
                    System.out.println("Ingrese una opción válida: ");
                    opcionEsp = scanner.nextInt();
                    scanner.nextLine();

                }
                indexEspecialidades.add(opcionEsp);
            }
        }
        List<Especialidad> tecnicoEspecialidades = new ArrayList<>();
        for (Integer index : indexEspecialidades){
            tecnicoEspecialidades.add(especialidadList.get(index));
        }

        List<EstimadoPorProblema> tecnicoEstimadosXProblema = new ArrayList<>();
        // Añadir estimados por problema
        for (TipoProblema tipoProblema : tipoProblemaList){
            System.out.println("Ingrese una cantidad de horas para el problema: " + tipoProblema.getNombre());
            Integer cant_horas = scanner.nextInt(); scanner.nextLine();
            tecnicoEstimadosXProblema.add(new EstimadoPorProblema(tipoProblema, cant_horas));
        }

        Tecnico newTecnico = new Tecnico(nombre, apellido, tecnicoEspecialidades, tecnicoEstimadosXProblema, medioContacto, contacto);
        repoTecnico.guardarTecnico(newTecnico);
    }

    private void reportarIncidente(Scanner scanner){
        List<Cliente> clienteList = repoCliente.getClientes();
        List<Especialidad> especialidadList = repoEspecialidad.getEspecialidad();
        List<TipoProblema> tipoProblemaList = repoTipoProblema.getTipoProblema();
        List<Servicio> servicioList = repoServicio.getServicio();

        System.out.println("Ingrese un título: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese una descripción: ");
        String descripcion = scanner.nextLine();

        // Obtener Cliente
        this.mostrarClientes(clienteList);

        System.out.println("Qué cliente reportó el incidente?");
        Integer index_client = scanner.nextInt(); scanner.nextLine();
        while (index_client < 0 || index_client >= clienteList.size()){
            System.out.println("Opción no válida. Ingrese otra: ");
            index_client = scanner.nextInt(); scanner.nextLine();
        }
        Cliente inc_cliente = clienteList.get(index_client);


        // Obtener Servicio
        this.mostrarServicios(servicioList);

        System.out.println("En cuál servicio ocurrió el incidente?");
        Integer index_service = scanner.nextInt(); scanner.nextLine();
        while (index_service < 0 || index_service >= servicioList.size()){
            System.out.println("Opción no válida. Ingrese otra: ");
            index_service = scanner.nextInt(); scanner.nextLine();
        }
        Servicio inc_servicio = servicioList.get(index_service);

        // Obtener Tipo de Problema
        System.out.println("Qué tipo de problema es el incidente?");
        this.mostrarTipoProblemas(tipoProblemaList);

        Integer index_tipo_problema = scanner.nextInt(); scanner.nextLine();
        while (index_tipo_problema < 0 || index_tipo_problema >= tipoProblemaList.size()){
            System.out.println("Opción no válida. Ingrese otra: ");
            index_tipo_problema = scanner.nextInt(); scanner.nextLine();
        }
        TipoProblema inc_tipo_problema = tipoProblemaList.get(index_tipo_problema);

        // Obtener Especialidades
        this.mostrarEspecialidades(especialidadList);

        System.out.println("Qué especialidad aborda el incidente?");

        Integer index_especialidad = this.seleccionarOpcion(scanner, especialidadList.size());

        Especialidad inc_especialidad = especialidadList.get(index_especialidad);

        // Generar Incidente
        Incidente newIncidente = new Incidente(titulo, descripcion, inc_cliente, inc_especialidad, inc_tipo_problema, inc_servicio);
        repoIncidente.guardarIncidente(newIncidente);
        repoServicio.actualizarServicio(inc_servicio);

    }

    private void asignarTecnicoAIncidente(Scanner scanner){
        List<Incidente> incidenteList = repoIncidente.getIncidentes();
        List<Tecnico> tecnicoList = repoTecnico.getTecnicos();

        List<Incidente> incidentesPendientes = incidenteList.stream()
                .filter(incidente -> incidente.getEstadoIncidente().equals(Estado.Abierto)).toList();
        System.out.println("Seleccione un incidente:");
        this.mostrarIncidentes(incidentesPendientes);
        Integer indexInc = this.seleccionarOpcion(scanner, incidentesPendientes.size());
        Incidente incidente = incidentesPendientes.get(indexInc);

        System.out.println("Seleccione un técnico para asignar al incidente");
        this.mostrarTecnico(tecnicoList);
        Integer indexTec = this.seleccionarOpcion(scanner, tecnicoList.size());
        Tecnico tecnico = tecnicoList.get(indexTec);

        incidente.asignarTecnico(tecnico);
        repoTecnico.actualizarTecnico(tecnico);
        repoIncidente.actualizarIncidente(incidente);

    }

    private void asignarHorasMaximasAIncidente(Scanner scanner){
        List<Incidente> incidenteList = repoIncidente.getIncidentes();
        System.out.println("Seleccione un incidente:");
        this.mostrarIncidentes(incidenteList);
        Integer indexInc = this.seleccionarOpcion(scanner, incidenteList.size());
        Incidente incidente = incidenteList.get(indexInc);

        System.out.println("Ingrese la cantidad de horas máximas:");
        Integer cant_horas = scanner.nextInt(); scanner.nextLine();

        incidente.asignarHorasMaximas(cant_horas);
        repoIncidente.actualizarIncidente(incidente);
    }

    private void cerrarIncidente(Scanner scanner){
        List<Incidente> incidenteList = repoIncidente.getIncidentes();
        List<Incidente> incidentesEnProceso = incidenteList.stream().filter(incidente -> incidente.getEstadoIncidente().equals(Estado.EnProceso)).toList();
        mostrarIncidentes(incidentesEnProceso);
        Integer incIndex = seleccionarOpcion(scanner, incidentesEnProceso.size());

        Incidente incidente = incidentesEnProceso.get(incIndex);
        incidente.cerrarIncidente();
        repoIncidente.actualizarIncidente(incidente);
    }

    private void tecnicoMasIncidentesNDias(Scanner scanner){
        System.out.println("Ingrese una cantidad de días: ");
        Integer ndias = scanner.nextInt(); scanner.nextLine();
        String texto = repoTecnico.tecnicoMasIncidentesTotales(ndias);
        System.out.println(texto);
    }

    private void tecnicoMasIncidentesNDiasEspecialidad(Scanner scanner){
        List<Especialidad> especialidadList = repoEspecialidad.getEspecialidad();

        System.out.println("Ingrese una cantidad de días: ");
        Integer ndias = scanner.nextInt(); scanner.nextLine();

        System.out.println("Seleccione una especialidad");
        this.mostrarEspecialidades(especialidadList);
        Integer indexEsp = seleccionarOpcion(scanner, especialidadList.size());
        Especialidad especialidad = especialidadList.get(indexEsp);

        repoTecnico.tecnicoMasIncidentesDeEspecialidad(ndias, especialidad);

    }

    // Mostrar Listados (Lo más conveniente es implementar un método en cada repositorio que reciba una lista, y se llame igual para todos)
    private void mostrarServicios(List<Servicio> servicioList){
        System.out.println("Lista de Servicios");
        Integer cont = 0;
        for(Servicio sv : servicioList){
            System.out.println(cont+"-"+sv.getNombre());
            cont += 1;
        }
    }

    private void mostrarClientes(List<Cliente> clienteList){
        System.out.println("Lista de Clientes");
        Integer cont = 0;
        for(Cliente cl : clienteList){
            System.out.println(cont+"-"+cl.getRazon_social());
            cont += 1;
        }
    }

    private void mostrarTipoProblemas(List<TipoProblema> tipoProblemaList){
        System.out.println("Lista de Tipos de Problema");
        Integer cont = 0;
        for(TipoProblema tp : tipoProblemaList){
            System.out.println(cont+"-"+tp.getNombre());
            cont += 1;
        }
    }

    private void mostrarEspecialidades(List<Especialidad> especialidadList){
        System.out.println("Lista de Especialidades");
        Integer cont = 0;
        for(Especialidad esp : especialidadList){
            System.out.println(cont+"-"+esp.getNombreEsp());
            cont += 1;
        }
    }

    private void mostrarTecnico(List<Tecnico> tecnicoList){
        System.out.println("Lista de Técnicos");
        Integer cont = 0;
        for(Tecnico tec : tecnicoList){
            System.out.println(cont+"-"+tec.getNombre()+" "+tec.getApellido());
            cont += 1;
        }
    }

    private void mostrarIncidentes(List<Incidente> incidenteList){
        System.out.println("Lista de Incidentes");
        Integer cont = 0;
        for(Incidente inc : incidenteList){
            System.out.println(cont+"-"+inc.getTitulo());
            cont += 1;
        }
    }

    private Integer seleccionarOpcion(Scanner scanner, Integer max){
        System.out.println("Seleccione una opción");
        Integer index = scanner.nextInt(); scanner.nextLine();
        while (index < 0 || index >= max){
            System.out.println("Opción no válida. Ingrese otra: ");
            index = scanner.nextInt(); scanner.nextLine();
        }
        return index;
    }
}
