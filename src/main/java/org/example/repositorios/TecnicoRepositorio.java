package org.example.repositorios;

import org.example.dominio.Especialidad;
import org.example.dominio.Estado;
import org.example.dominio.Incidente;
import org.example.dominio.Tecnico;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TecnicoRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarTecnico(Tecnico nuevoTecnico) {
        session.beginTransaction();
        session.save(nuevoTecnico);
        session.getTransaction().commit();

    }

    public void actualizarTecnico(Tecnico unTecnico) {
        session.beginTransaction();
        session.saveOrUpdate(unTecnico);
        session.getTransaction().commit();
    }

    public void eliminarTecnico(Tecnico unTecnico) {
        session.beginTransaction();
        session.delete(unTecnico);
        session.getTransaction().commit();
    }

    public List<Tecnico> getTecnicos() {
        return session.createQuery("from Tecnico", Tecnico.class).list();
    }

    public List<Tecnico> getTecnicosDisponibles() {
        return session.createQuery("from Tecnico where disponible = :disponibilidad", Tecnico.class).setParameter("disponibilidad", Boolean.TRUE).list();
    }

    public void mostrarTecnicosEIncidentes() {
        List<Tecnico> tecnicos = this.getTecnicos();
        System.out.println("Reporte de Técnicos");
        for (Tecnico tec : tecnicos) {
            List<Incidente> tecIncidentes = tec.getIncidentes();
            String texto_mostrar = tec.getNombre() + " " + tec.getApellido() + "\n";
            for (Incidente inc : tecIncidentes) {
                texto_mostrar += "    -" + inc.getTitulo() + "| Estado: " + inc.getEstadoIncidente() + "\n";
            }
            System.out.println(texto_mostrar);
        }
    }

    public String tecnicoMasIncidentesTotales(Integer cantDias) {
        List<Tecnico> tecnicos = getTecnicos();
        Map<Tecnico, Integer> incidentesPorTecnico = tecnicos.stream()
                .collect(Collectors.toMap(
                        tecnico -> tecnico,
                        tecnico -> tecnico.getIncidentes().stream()
                                .filter(incidente -> incidente.getEstadoIncidente().equals(Estado.Cerrado)
                                        &&
                                        incidente.fueResueltoEnLosUltimosNDia(cantDias))
                                .toList().size()
                ));
        return incidentesPorTecnico.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .map(tecnico -> tecnico.getNombre() + " " + tecnico.getApellido() + " fue el técnico con más incidentes resueltos")
                .orElse("No hubo ningún técnico con incidentes resueltos");
    }


    public void tecnicoMasIncidentesDeEspecialidad(Integer cantDias, Especialidad espRequerida) {
        List<Tecnico> tecnicos = getTecnicos();
        Integer mayor = 0;
        Tecnico tecnicoElegido = null;
        LocalDateTime haceNDias = LocalDateTime.now().minusDays(cantDias);
        System.out.println("Analizando técnico con más incidentes resueltos en los últimos " + cantDias + " días de la especialidad " + espRequerida.getNombreEsp());
        for (Tecnico tec : tecnicos) {
            int contador = (int) tec.getIncidentes().stream()
                    .filter(inc -> inc.getEstadoIncidente().equals(Estado.Cerrado))
                    .filter(inc -> inc.getFechaFinal().isAfter(haceNDias))
                    .filter(inc -> inc.getEspecialidad().equals(espRequerida))
                    .count();
            if (contador > mayor) {
                tecnicoElegido = tec;
                mayor = contador;
            }
        }
        if (tecnicoElegido != null) {
            System.out.println(tecnicoElegido.getNombre() + " " + tecnicoElegido.getApellido() + " fue el técnico con más incidentes resueltos");
        } else {
            System.out.println("No hubo ningún técnico con incidentes resueltos de esta especialidad");
        }
    }
    public void tecnicoMasRapido(){
        List<Tecnico> tecnicosConIncidentes = getTecnicos().stream()
                .filter(tecnico -> !tecnico.getIncidentes().isEmpty()
                        &&
                        tecnico.getIncidentes().stream().anyMatch(incidente -> incidente.getEstadoIncidente().equals(Estado.Cerrado))).toList();


        Optional<Tecnico> tecnicoMasRapido = tecnicosConIncidentes.stream()
                .min(Comparator.comparingDouble(Tecnico::promedioTiempoIncidentes));

        tecnicoMasRapido.ifPresent(tecnico -> System.out.println("El técnico más rápido es: " + tecnico.getNombre() + " " + tecnico.getApellido()));

    }
}